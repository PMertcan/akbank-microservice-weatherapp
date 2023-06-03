package com.akbank.weatherservice.servicelayer.apiclient;

import com.akbank.weatherservice.dto.response.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "api.openweathermap.org/data/2.5/forecast", name = "openweather")
public interface WeatherClient {

    @GetMapping
    public WeatherResponse getWeather(@RequestParam String q,
                                      @RequestParam String appid);

}
