package com.akbank.userservice.controller;

import com.akbank.userservice.dto.request.*;
import com.akbank.userservice.dto.response.UserResponse;
import com.akbank.userservice.servicelayer.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        var savedUser = this.userService.saveUser(userCreateRequest);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        var userList = this.userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable String username) {
       var user = this.userService.getUserByUsername(username);
       return ResponseEntity.ok(user);
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long userId,
                                                   @Valid @RequestBody UserUpdateRequest userUpdateRequest) {
        var updatedUser = this.userService.updateUserById(userId, userUpdateRequest);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        this.userService.deleteUserById(userId);
    }
}
