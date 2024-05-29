package learning.projects.spring_backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private String username;
	//TODO: in request pass encrypted value
	private String credential;
}
