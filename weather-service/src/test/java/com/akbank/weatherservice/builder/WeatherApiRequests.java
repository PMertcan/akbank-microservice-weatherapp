package com.akbank.weatherservice.builder;

import com.akbank.weatherservice.datas.WeatherPath;
import io.restassured.response.Response;

public class WeatherApiRequests {

    public static Response getWeatherByCityName(String cityName) {
        return WeatherResponseClass.getWeathersByCityName(WeatherPath.BASE_PATH + "/" + cityName);
    }
}
