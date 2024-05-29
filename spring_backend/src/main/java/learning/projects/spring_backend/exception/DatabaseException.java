package learning.projects.spring_backend.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DatabaseException extends RuntimeException {
	private static final long serialVersionUID = 2234148576784700841L;

	private String message;
	
	public DatabaseException(String msg) {
		super(msg);
		message = msg;
	}
}
