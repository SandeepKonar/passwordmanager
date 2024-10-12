package com.learning.passwordmanager.passwordmgmtservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class ResourceRequest {
    private String resourceName;
    private String credential;
    private Map<String, String> attributes;
}
