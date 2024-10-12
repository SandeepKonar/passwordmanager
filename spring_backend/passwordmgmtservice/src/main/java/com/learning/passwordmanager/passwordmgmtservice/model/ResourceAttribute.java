package com.learning.passwordmanager.passwordmgmtservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ResourceAttribute {
    @Id
    @NanoIdGenerator(name="nano-generator", prefix = "rsc-attr")
    private String attributeId;
    private String name;
    private String value;
    private String isEncrypted;
}
