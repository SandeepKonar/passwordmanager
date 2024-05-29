package learning.projects.spring_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import learning.projects.spring_backend.domain.App;
import learning.projects.spring_backend.exception.DatabaseException;
import learning.projects.spring_backend.model.AppDetails;
import learning.projects.spring_backend.model.AppMetadataDetails;
import learning.projects.spring_backend.repository.AppMetadataRepository;
import learning.projects.spring_backend.repository.AppRepository;

@Service
public class PasswordManagerServiceImpl implements PasswordManagerService {
	@Autowired
	AppRepository appRepository;
	@Autowired
	AppMetadataRepository appMetadataRepository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveApp(App app) {
		AppDetails appDetails = new AppDetails();
		appDetails.setAppName(app.getAppName());
		appDetails.setCredential(app.getCredential());
		appDetails.setUserId(app.getUserId());
		appDetails.setAppStatus(app.getAppStatus());
		try {
			AppDetails result = appRepository.save(appDetails);
			if(result != null && !CollectionUtils.isEmpty(app.getMetadatas())) {
				appDetails.setMetadataFlag(true);
				List<AppMetadataDetails> appMetadatas = app.metadataMapper(result.getAppId());
				appMetadataRepository.saveAll(appMetadatas);
			}
		}catch(Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
