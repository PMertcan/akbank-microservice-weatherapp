package com.akbank.weatherservice.servicelayer.service;

import com.akbank.weatherservice.dto.response.WeatherResponse;

public interface IWeatherService {

    WeatherResponse getWeatherWithCity(String city);

}
