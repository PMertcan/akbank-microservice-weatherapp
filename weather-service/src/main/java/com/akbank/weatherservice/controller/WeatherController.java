package com.akbank.weatherservice.controller;

import com.akbank.weatherservice.dto.response.WeatherResponse;
import com.akbank.weatherservice.servicelayer.service.IWeatherService;
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

    @GetMapping(value = "/{city}")
    public ResponseEntity<WeatherResponse> getWeather(@PathVariable String city) {
        var cityAndWeatherResponse = weatherService.getWeatherWithCity(city);
        return ResponseEntity.ok(cityAndWeatherResponse);
    }
}
