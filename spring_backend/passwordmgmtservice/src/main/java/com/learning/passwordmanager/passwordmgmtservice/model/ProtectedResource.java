package com.learning.passwordmanager.passwordmgmtservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class ProtectedResource {
    @Id
    @NanoIdGenerator(name="nano-generator", prefix = "rsc")
    private String resourceId;
    @Column(unique = true)
    private String resourceName;
    private String credential;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "resourceId")
    private List<ResourceAttribute> attributes;
}

