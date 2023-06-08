package com.akbank.weatherservice.servicelayer.impl;

import com.akbank.weatherservice.dto.response.WeatherResponse;
import com.akbank.weatherservice.servicelayer.apiclient.WeatherClient;
import com.akbank.weatherservice.servicelayer.service.IWeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class WeatherServiceImpl implements IWeatherService {

    private final WeatherClient weatherClient;

    @Value("${api.key}")
    private String apiKey;


    @Override
    public WeatherResponse getWeatherWithCity(String city) {
        log.info("Received the City Weather Details -> {}", city);
        return weatherClient.getWeather(city, apiKey);
    }
}
