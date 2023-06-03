package com.akbank.cityservice.builder;

import com.akbank.cityservice.modal.CityPojo;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.patch;

public class CityResponseClass {

    public static Response createCity(String path, CityPojo cityCreateRequest) {
        return given(CityTestBuild.getRequestSpec())
                .body(cityCreateRequest)
                .when()
                .post(path)
                .then()
                .spec(CityTestBuild.getResponseSpec())
                .extract()
                .response();
    }

    public static Response getAllCitiesByUsername(String path) {
        return getRequestMethod(path);
    }

    public static Response getCityWeatherDetailsByCityName(String path) {
        return getRequestMethod(path);
    }

    private static Response getRequestMethod(String path) {
        return given(CityTestBuild.getRequestSpec())
                .when()
                .get(path)
                .then()
                .spec(CityTestBuild.getResponseSpec())
                .extract()
                .response();
    }
}
