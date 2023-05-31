package com.akbank.userservice.controller;

import com.akbank.userservice.dao.IUserRepository;
import com.akbank.userservice.dto.request.UserCreateRequest;
import com.akbank.userservice.dto.request.UserUpdateRequest;
import com.akbank.userservice.dto.response.UserResponse;
import com.akbank.userservice.servicelayer.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;


    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserCreateRequest userCreateRequest) {
        var savedUser = userService.saveUser(userCreateRequest);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        var userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }



    @GetMapping(value = "/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable String username) {
       var user = userService.getUserByUsername(username);
       return ResponseEntity.ok(user);
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long userId, @RequestBody UserUpdateRequest userUpdateRequest) {
        var updatedUser = userService.updateUserById(userId, userUpdateRequest);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUserById(userId);
    }

}
