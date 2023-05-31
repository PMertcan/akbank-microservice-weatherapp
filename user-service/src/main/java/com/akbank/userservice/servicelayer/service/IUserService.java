package com.akbank.userservice.servicelayer.service;

import com.akbank.userservice.dto.request.UserCreateRequest;
import com.akbank.userservice.dto.request.UserUpdateRequest;
import com.akbank.userservice.dto.response.UserResponse;
import java.util.List;

public interface IUserService {

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    UserResponse getUserByUsername(String username);

    UserResponse saveUser(UserCreateRequest userCreateRequest);

    UserResponse updateUserById(Long id, UserUpdateRequest userUpdateRequest);

    void deleteUserById(Long id);



}
