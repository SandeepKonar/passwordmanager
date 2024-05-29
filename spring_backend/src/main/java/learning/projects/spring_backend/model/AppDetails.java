package learning.projects.spring_backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "app_passwords")
public class AppDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appId;
	private int userId;
	private String appName;
	private String credential;
	private boolean metadataFlag;
	private String appStatus; 
	
}
