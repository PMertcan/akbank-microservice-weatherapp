package com.akbank.userservice.builder;

import com.akbank.userservice.modal.UserPojo;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserResponseClass {

    public static Response createUser(String path, UserPojo userCreateRequest) {
        return given(UserTestBuild.getRequestSpec())
                .body(userCreateRequest)
                .when()
                .post(path)
                .then()
                .spec(UserTestBuild.getResponseSpec())
                .extract()
                .response();
    }

    public static Response getUser(String path) {
        return getRequestMethod(path);
    }

    public static Response getAllUsers(String path) {
        return getRequestMethod(path);
    }

    public static Response updateUser(String path, UserPojo userUpdateRequest) {
        return given(UserTestBuild.getRequestSpec())
                .body(userUpdateRequest)
                .when()
                .put(path)
                .then()
                .spec(UserTestBuild.getResponseSpec())
                .extract()
                .response();
    }

    public static Response deleteUser(String path) {
        return given(UserTestBuild.getRequestSpec())
                .when()
                .delete(path)
                .then()
                .extract()
                .response();
    }

    private static Response getRequestMethod(String path) {
        return given(UserTestBuild.getRequestSpec())
                .when()
                .get(path)
                .then()
                .spec(UserTestBuild.getResponseSpec())
                .extract()
                .response();
    }

}
