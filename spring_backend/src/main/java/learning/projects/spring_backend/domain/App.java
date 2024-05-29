package learning.projects.spring_backend.domain;

import java.util.ArrayList;
import java.util.List;

import learning.projects.spring_backend.model.AppMetadataDetails;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class App {
	private int appId;
	private int userId;
	private String appName;
	private String credential;
	private boolean metadataFlag;
	private String appStatus; 
	private List<AppMetadata> metadatas;
	
	public List<AppMetadataDetails> metadataMapper(int appId) {
		List<AppMetadataDetails> appMetadatas = new ArrayList<>();
		for(AppMetadata metadata: metadatas) {
			AppMetadataDetails appMetadata = new AppMetadataDetails();
			appMetadata.setAppId(appId);
			appMetadata.setFieldName(metadata.getFieldName());
			appMetadata.setFieldValue(metadata.getFieldValue());
			appMetadata.setHashed(metadata.isHashed());
			appMetadatas.add(appMetadata);
		}
		return appMetadatas;
	}
	
	@Data
	@NoArgsConstructor
	public static class AppMetadata {
		private String fieldName;
		private String fieldValue;
		private boolean isHashed;
	}
}
