package com.akbank.userservice.builder;

import com.akbank.userservice.modal.UserPojo;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserResponseClass {

    public static Response createUser(String path, UserPojo userCreateRequest) {
        return given(TestBuild.getRequestSpec())
                .body(userCreateRequest)
                .when()
                .post(path)
                .then()
                .spec(TestBuild.getResponseSpec())
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
        return given(TestBuild.getRequestSpec())
                .body(userUpdateRequest)
                .when()
                .put(path)
                .then()
                .spec(TestBuild.getResponseSpec())
                .extract()
                .response();
    }

    public static Response deleteUser(String path) {
        return given(TestBuild.getRequestSpec())
                .when()
                .delete(path)
                .then()
                .extract()
                .response();
    }

    private static Response getRequestMethod(String path) {
        return given(TestBuild.getRequestSpec())
                .when()
                .get(path)
                .then()
                .spec(TestBuild.getResponseSpec())
                .extract()
                .response();
    }

}
