package learning.projects.spring_backend.util;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtils {
	@Value("${jwt.secret}")
	private String secret;
	private Key secretKey;
	@Value("${jwt.issuer}")
	private String issuer;
	
	public String generateToken(Map<String,String> claims) {
		return Jwts.builder().claims(claims).issuer(issuer).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis()+60*60*1000)).signWith(getKey()).compact();
	}
	
	public String getClaim(String token, String claimName) {
		return Jwts.parser().build().parseSignedClaims(token).getPayload().get(claimName, String.class);
	}
	
	public Claims getClaims(String token) {
		return Jwts.parser().build().parseSignedClaims(token).getPayload();
	}
	
	private Key getKey() {
		if(secretKey != null) 
			return secretKey;
		secretKey = Keys.hmacShaKeyFor(Base64.getEncoder().encode(secret.getBytes()));
		return secretKey;
	}

}
