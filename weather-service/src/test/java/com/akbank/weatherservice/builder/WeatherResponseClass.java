package com.akbank.weatherservice.builder;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class WeatherResponseClass {

    public static Response getWeathersByCityName (String path) {
        return getRequestMethod(path);
    }

    private static Response getRequestMethod(String path) {
        return given(WeatherTestBuild.getRequestSpec())
                .when()
                .get(path)
                .then()
                .spec(WeatherTestBuild.getResponseSpec())
                .extract()
                .response();
    }

}
