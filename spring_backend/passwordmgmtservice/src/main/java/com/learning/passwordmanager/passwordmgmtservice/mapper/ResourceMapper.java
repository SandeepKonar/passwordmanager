package com.learning.passwordmanager.passwordmgmtservice.mapper;

import com.learning.passwordmanager.passwordmgmtservice.dto.ResourceRequest;
import com.learning.passwordmanager.passwordmgmtservice.dto.ResourceResponse;
import com.learning.passwordmanager.passwordmgmtservice.model.ProtectedResource;
import com.learning.passwordmanager.passwordmgmtservice.model.ResourceAttribute;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ResourceMapper {

    ProtectedResource mapResource(ResourceRequest request);

    default List<ResourceAttribute> mapAttributeMapToList(Map<String, String> attributes) {
        return attributes.entrySet().stream().map(this::mapAttribute).collect(Collectors.toList());
    }

    @Mapping(target = "name", source = "key")
    @Mapping(target = "value", source = "value")
    ResourceAttribute mapAttribute(Map.Entry<String, String> entry);


    ResourceResponse mapProtectResourceToResponse(ProtectedResource resource);

    default Map<String, String> mapAttributeListToMap(List<ResourceAttribute> attributes) {
        return attributes.stream().collect(Collectors.toMap(ResourceAttribute::getName, ResourceAttribute::getValue));
    }

}
