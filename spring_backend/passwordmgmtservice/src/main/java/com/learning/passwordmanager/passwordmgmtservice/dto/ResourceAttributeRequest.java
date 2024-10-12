package com.learning.passwordmanager.passwordmgmtservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResourceAttributeRequest {
    private String attributeName;
    private String attributeValue;
    private String appId;
}
