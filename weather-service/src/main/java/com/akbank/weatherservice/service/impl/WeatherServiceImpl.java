package com.akbank.weatherservice.service.impl;

import com.akbank.weatherservice.service.WeatherClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class WeatherServiceImpl {



    private final WeatherClient weatherClient;

    public WeatherServiceImpl(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public ResponseEntity<String> getWeather(@PathVariable String city) {

        String API_KEY = "&appid=d7920d19ac2aba1c7708f112f2082370";

        weatherClient.getWeather(city, API_KEY);
        return null;
    }

}
