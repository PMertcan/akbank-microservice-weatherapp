package com.akbank.userservice.servicelayer.impl;

import com.akbank.userservice.dao.IUserRepository;
import com.akbank.userservice.entity.User;
import com.akbank.userservice.dto.request.UserCreateRequest;
import com.akbank.userservice.dto.request.UserUpdateRequest;
import com.akbank.userservice.dto.response.UserResponse;
import com.akbank.userservice.exception.exceptions.UserNotFoundException;
import com.akbank.userservice.mapper.UserMapper;
import com.akbank.userservice.servicelayer.UserEntityService;
import com.akbank.userservice.servicelayer.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {

    private final UserEntityService userEntityService;

    private final IUserRepository userRepository;

    @Override
    public List<UserResponse> getAllUsers() {

        List<User> userList = userEntityService.findAll();

        List<UserResponse> userResponse = UserMapper.MAP.entityListToDtoList(userList);

        if (!userResponse.isEmpty()) return userResponse;
        else throw new RuntimeException("Hata");
    }

    @Override
    public UserResponse getUserById(Long id) {
       Optional<User> user = userEntityService.findById(id);

       if (user.isPresent()) {
           return UserMapper.MAP.entityToDto(user.get());
       } else throw new RuntimeException("User not found with id : " + id);
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        Optional<User> user = userRepository.findUserByUserName(username);

        if (user.isPresent()) {
            return UserMapper.MAP.entityToDto(user.get());
        } else throw new RuntimeException("Hata");
    }

    @Override
    public UserResponse saveUser(UserCreateRequest userCreateRequest) {
        User user = UserMapper.MAP.dtoToUser(userCreateRequest);
        userEntityService.save(user);
        return UserMapper.MAP.entityToDto(user);
    }

    @Override
    public UserResponse updateUserById(Long id, UserUpdateRequest userUpdateRequest) {
        Optional<User> user = userEntityService.findById(id);
        if (user.isPresent()) {
            UserMapper.MAP.dtoToUser(userUpdateRequest);
            userEntityService.save(user.get());
            return UserMapper.MAP.entityToDto(user.get());
        } else throw new RuntimeException("");
    }

    @Override
    public void deleteUserById(Long id) {
        Optional<User> user = userEntityService.findById(id);

        if (user.isPresent()) {
            userEntityService.delete(id);
            log.info("User deleted with by id : {}", id);
        } else throw new RuntimeException("User not deleted with id :" + id);
    }
}
