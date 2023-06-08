package com.akbank.weatherservice.controller;

import com.akbank.weatherservice.dto.response.WeatherEvent;
import com.akbank.weatherservice.dto.response.WeatherResponse;
import com.akbank.weatherservice.kafka.WeatherProducer;
import com.akbank.weatherservice.servicelayer.service.IWeatherService;
import jdk.jfr.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/weathers")
@Slf4j
@RequiredArgsConstructor
public class WeatherController {

    private final IWeatherService weatherService;

    private final WeatherProducer weatherProducer;

    @GetMapping(value = "/{city}")
    public ResponseEntity<WeatherResponse> getWeather(@PathVariable String city) {
        var cityAndWeatherResponse = weatherService.getWeatherWithCity(city);

        var weatherEvent = eventParser(cityAndWeatherResponse);
        weatherProducer.sendMessage(weatherEvent);

        return ResponseEntity.ok(cityAndWeatherResponse);
    }

    private WeatherEvent eventParser(WeatherResponse weatherResponse) {
        return WeatherEvent.builder()
                .cod(weatherResponse.cod())
                .cnt(weatherResponse.cnt())
                .message(weatherResponse.message())
                .list(weatherResponse.list())
                .city(weatherResponse.city())
                .build();
    }
}
