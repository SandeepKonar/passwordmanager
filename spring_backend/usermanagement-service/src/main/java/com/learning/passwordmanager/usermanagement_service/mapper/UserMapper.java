package com.learning.passwordmanager.usermanagement_service.mapper;

import com.learning.passwordmanager.usermanagement_service.dto.SignupRequest;
import com.learning.passwordmanager.usermanagement_service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "secretQuestion", source = "securityQuestion.question")
    @Mapping(target = "secretAnswer", source = "securityQuestion.answer")
    User signupRequestToUser(SignupRequest request);
}
