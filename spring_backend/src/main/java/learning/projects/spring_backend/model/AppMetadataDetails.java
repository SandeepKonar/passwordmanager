package learning.projects.spring_backend.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@IdClass(AppMetadataKey.class)
@Table(name = "password_metadata")
public class AppMetadataDetails {
	@Id
	private int appId;
	@Id
	private String fieldName;
	private String fieldValue;
	@Column(name = "isHashed")
	private boolean isHashed;
}