package com.akbank.userservice.builder;

import com.akbank.userservice.datas.UsersPath;
import com.akbank.userservice.modal.UserPojo;
import io.restassured.response.Response;

public class UsersApiRequests {

    public static Response createUser(UserPojo userCreateRequest) {
        return UserResponseClass.createUser(UsersPath.BASE_ENDPOINT, userCreateRequest);
    }

    public static Response getAllUsers() {
        return UserResponseClass.getAllUsers(UsersPath.BASE_ENDPOINT);
    }

    public static Response getUserByUsername(String username) {
        return UserResponseClass.getUser(UsersPath.BASE_ENDPOINT + "/" + username);
    }

    public static Response updateUserByUsername(String username, UserPojo userUpdateRequest) {
        return UserResponseClass.updateUser(UsersPath.BASE_ENDPOINT + "/" + username, userUpdateRequest);
    }

    public static Response deleteUserByUsername(String username) {
        return UserResponseClass.deleteUser(UsersPath.BASE_ENDPOINT + "/" + username);
    }
}
