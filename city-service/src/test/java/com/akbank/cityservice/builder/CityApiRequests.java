package com.akbank.cityservice.builder;

import com.akbank.cityservice.datas.CitiesPath;
import com.akbank.cityservice.modal.CityPojo;
import io.restassured.response.Response;

public class CityApiRequests {

    public static Response createCityByUsername(CityPojo cityCreateRequest) {
        return CityResponseClass.createCity(CitiesPath.BASE_ENDPOINT, cityCreateRequest);
    }

    public static Response getCitiesByUsername(String username) {
        return CityResponseClass.getAllCitiesByUsername(CitiesPath.BASE_ENDPOINT + "/" + username);
    }

    public static Response getCityWeatherDetailsByCityName(String cityName) {
        return CityResponseClass.getCityWeatherDetailsByCityName(CitiesPath.BASE_ENDPOINT + "/" + cityName + "/weather");
    }

}
