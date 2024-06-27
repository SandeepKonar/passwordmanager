package learning.projects.spring_backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserRequest {
	private String username;
	private String credential;
}
