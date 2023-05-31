package com.akbank.weatherservice.service;

import com.akbank.weatherservice.dto.response.WeatherDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "api.openweathermap.org/data/2.5/forecast", name = "openweather")
public interface WeatherClient {

    @GetMapping
    public ResponseEntity<WeatherDto> getWeather(@RequestParam String q,
                                                 @RequestParam String appid);

}
