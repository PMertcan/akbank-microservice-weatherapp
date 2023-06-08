package com.akbank.userservice.servicelayer.impl;

import com.akbank.userservice.dao.IUserRepository;
import com.akbank.userservice.entity.User;
import com.akbank.userservice.dto.request.UserCreateRequest;
import com.akbank.userservice.dto.request.UserUpdateRequest;
import com.akbank.userservice.dto.response.UserResponse;
import com.akbank.userservice.exception.enums.UserExceptionTypes;
import com.akbank.userservice.exception.exceptions.UserNotCreatedException;
import com.akbank.userservice.exception.exceptions.UserNotDeletedException;
import com.akbank.userservice.exception.exceptions.UserNotFoundException;
import com.akbank.userservice.exception.exceptions.UserNotUpdatedException;
import com.akbank.userservice.mapper.UserMapper;
import com.akbank.userservice.servicelayer.UserEntityService;
import com.akbank.userservice.servicelayer.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {

    private final UserEntityService userEntityService;

    private final IUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> userList = userEntityService.findAll();

        List<UserResponse> userResponse = UserMapper.MAP.entityListToDtoList(userList);

        if (!userResponse.isEmpty()) return userResponse;
        else throw new UserNotFoundException(UserExceptionTypes.USERS_NOT_FOUND.getValue());
    }

    @Override
    public UserResponse getUserById(Long id) {
       Optional<User> user = userEntityService.findById(id);

       if (user.isPresent()) {
           log.info("User Credentials : {}", user.get());
           return UserMapper.MAP.entityToDto(user.get());
       } else throw new UserNotFoundException(UserExceptionTypes.USER_NOT_FOUND_ID.getValue());
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        Optional<User> user = userRepository.findUserByUserName(username);

        if (user.isPresent()) {
            log.info("User Credentials : {}", user.get());
            return UserMapper.MAP.entityToDto(user.get());
        } else throw new UserNotFoundException(UserExceptionTypes.USER_NOT_FOUND_USERNAME.getValue() + username);
    }

    @Override
    public UserResponse saveUser(UserCreateRequest userCreateRequest) {
        User user;
        try {
            user = UserMapper.MAP.dtoToUser(userCreateRequest);
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            userEntityService.save(user);
            log.info("User Is Created Successfully With Credentials -> {}", user);
            return UserMapper.MAP.entityToDto(user);
        } catch (Exception exception) {
            throw new UserNotCreatedException(UserExceptionTypes.USER_NOT_CREATED.getValue());
        }
    }

    @Override
    public UserResponse updateUserByUsername(String username, UserUpdateRequest userUpdateRequest) {
        Optional<User> validUser = Optional.ofNullable(userRepository.findUserByUserName(username).orElseThrow(
                () -> new UserNotFoundException(UserExceptionTypes.USER_NOT_FOUND_USERNAME.getValue() + username))
        );

        if (validUser.isPresent()) {
            User user = validUser.get();
            UserMapper.MAP.updateDtoToUser(userUpdateRequest, user);
            user.setPassword(this.passwordEncoder.encode(userUpdateRequest.password()));
            userEntityService.save(user);
            log.info("User Is Updated Successfully With Credentials -> {}", user);
            return UserMapper.MAP.entityToDto(user);
        } else throw new UserNotUpdatedException(UserExceptionTypes.USER_NOT_UPDATED.getValue() + userUpdateRequest.userName());
    }

    @Override
    public void deleteUserByUsername(String username) {
        User user = userRepository.findUserByUserName(username).orElseThrow(
                () -> new UserNotFoundException(UserExceptionTypes.USER_NOT_FOUND_USERNAME.getValue() + username)
        );

        try{
            userEntityService.delete(user.getId());
            log.info("User Deleted With By Username : {}", user);
        }catch (Exception exception) {
            throw new UserNotDeletedException(UserExceptionTypes.USER_NOT_DELETED.getValue());
        }
    }
}
