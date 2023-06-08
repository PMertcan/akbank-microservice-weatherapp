package com.akbank.weatherservice.builder;

import com.akbank.weatherservice.datas.WeathersPath;
import io.restassured.response.Response;

public class WeatherApiRequests {

    public static Response getWeatherByCityName(String cityName) {
        return WeatherResponseClass.getWeathersByCityName(WeathersPath.BASE_PATH + "/" + cityName);
    }
}
