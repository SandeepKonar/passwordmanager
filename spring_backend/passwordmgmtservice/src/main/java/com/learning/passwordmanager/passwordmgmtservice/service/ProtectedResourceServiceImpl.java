package com.learning.passwordmanager.passwordmgmtservice.service;

import com.learning.passwordmanager.passwordmgmtservice.dto.ResourceRequest;
import com.learning.passwordmanager.passwordmgmtservice.dto.ResourceResponse;
import com.learning.passwordmanager.passwordmgmtservice.mapper.ResourceMapper;
import com.learning.passwordmanager.passwordmgmtservice.model.ProtectedResource;
import com.learning.passwordmanager.passwordmgmtservice.repository.ProtectedResourceRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class ProtectedResourceServiceImpl implements ProtectedResourceService {
    @Autowired
    private ProtectedResourceRepository resourceRepository;
    @Autowired
    private ResourceMapper resourceMapper;
    private Logger logger = LoggerFactory.getLogger(ProtectedResourceServiceImpl.class);

    @Override
    @Transactional
    public void addResource(ResourceRequest request) {
        //TODO: validate Request
        ProtectedResource resource = resourceMapper.mapResource(request);
        resourceRepository.save(resource);
    }

    @Override
    public void deleteResource(String resourceName) {
        if(!StringUtils.hasText(resourceName))
            throw new IllegalArgumentException("Resource name null or empty");
        Optional<ProtectedResource> resource = resourceRepository.findByResourceName(resourceName);
        if(resource.isPresent()) {
            resourceRepository.deleteByResourceName(resourceName);
        } else {
            throw new RuntimeException(String.format("resource %s not found ", resourceName));
        }
    }

    @Override
    public void updateResource(ResourceRequest request) {
        if(!StringUtils.hasText(request.getResourceName()))
            throw new IllegalArgumentException("Resource name null or empty");
        Optional<ProtectedResource> resource = resourceRepository.findByResourceName(request.getResourceName());
        if(resource.isPresent()) {
            ProtectedResource currentResource = resource.get();
            ProtectedResource updatedResource = resourceMapper.mapResource(request);
            updatedResource.setResourceId(currentResource.getResourceId());
            resourceRepository.save(updatedResource);
        } else {
            throw new RuntimeException(String.format("resource %s not found ", request.getResourceName()));
        }
    }

    @Override
    public ResourceResponse getResource(String resourceName) {
        if(!StringUtils.hasText(resourceName))
            throw new IllegalArgumentException("Resource name null or empty");
        Optional<ProtectedResource> resource = resourceRepository.findByResourceName(resourceName);
        return resource.map(resourceMapper::mapProtectResourceToResponse).orElseThrow(() -> new RuntimeException("resourceNotFound"));
    }
}
