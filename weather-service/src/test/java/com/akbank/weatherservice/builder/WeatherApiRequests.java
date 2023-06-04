package com.akbank.weatherservice.builder;

import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;

public class WeatherApiRequests {

    @Value("${base.path}")
    private static String basePath;

    public static Response getWeatherByCityName(String cityName) {
        return WeatherResponseClass.getWeathersByCityName(basePath+ "/" + cityName);
    }
}
