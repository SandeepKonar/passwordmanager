package com.learning.passwordmanager.passwordmgmtservice.service;

import com.learning.passwordmanager.passwordmgmtservice.dto.ResourceRequest;
import com.learning.passwordmanager.passwordmgmtservice.dto.ResourceResponse;

public interface ProtectedResourceService {

    void addResource(ResourceRequest request);

    void deleteResource(String resourceName);

    void updateResource(ResourceRequest request);

    ResourceResponse getResource(String resourceName);
}
