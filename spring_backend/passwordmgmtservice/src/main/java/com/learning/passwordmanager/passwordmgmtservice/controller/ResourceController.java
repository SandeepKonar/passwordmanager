package com.learning.passwordmanager.passwordmgmtservice.controller;

import com.learning.passwordmanager.passwordmgmtservice.dto.ResourceRequest;
import com.learning.passwordmanager.passwordmgmtservice.dto.ResourceResponse;
import com.learning.passwordmanager.passwordmgmtservice.service.ProtectedResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    private ProtectedResourceService resourceService;

    public ResourceController(ProtectedResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping
    public ResponseEntity<String> addResource(@RequestBody ResourceRequest request) {
        resourceService.addResource(request);
        return ResponseEntity.ok().body(String.format("resource %s added successfully.", request.getResourceName()));
    }

    @PutMapping
    public ResponseEntity<String> updateResource(ResourceRequest request) {
        resourceService.updateResource(request);
        return ResponseEntity.ok().body(String.format("resource %s updated successfully.", request.getResourceName()));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteResource(@RequestParam(name = "resource", required = true) String resourceName) {
        resourceService.deleteResource(resourceName);
        return ResponseEntity.ok().body(String.format("resource %s deleted successfully.", resourceName));
    }

    @GetMapping
    public ResponseEntity<ResourceResponse> getResource(@RequestParam(name = "resource", required = true) String resourceName) {
        ResourceResponse resourceResponse = resourceService.getResource(resourceName);
        return ResponseEntity.ok(resourceResponse);
    }
}
