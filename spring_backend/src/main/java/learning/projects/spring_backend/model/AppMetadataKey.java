package learning.projects.spring_backend.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppMetadataKey implements Serializable {	
	private static final long serialVersionUID = -8130973824826373441L;
	
	private int appId;
	private String fieldName;
}