package com.akbank.userservice.mapper;

import com.akbank.userservice.entity.User;
import com.akbank.userservice.dto.request.UserCreateRequest;
import com.akbank.userservice.dto.request.UserUpdateRequest;
import com.akbank.userservice.dto.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper MAP = Mappers.getMapper(UserMapper.class);

    UserResponse entityToDto(User user);

    User dtoToUser(UserCreateRequest userCreateRequest);

    List<UserResponse> entityListToDtoList(List<User> users);

    void updateDtoToUser(UserUpdateRequest userUpdateRequest, @MappingTarget User user);
}
