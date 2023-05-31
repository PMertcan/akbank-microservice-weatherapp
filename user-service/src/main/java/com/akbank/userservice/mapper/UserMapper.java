package com.akbank.userservice.mapper;

import com.akbank.userservice.entity.User;
import com.akbank.userservice.dto.request.UserCreateRequest;
import com.akbank.userservice.dto.request.UserUpdateRequest;
import com.akbank.userservice.dto.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper MAP = Mappers.getMapper(UserMapper.class);

    UserResponse entityToDto(User user);

    User dtoToUser(UserCreateRequest userCreateRequest);

    List<UserResponse> entityListToDtoList(List<User> users);

    User dtoToUser(UserUpdateRequest userUpdateRequest);

}
