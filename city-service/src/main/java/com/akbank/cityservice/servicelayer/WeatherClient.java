package com.akbank.cityservice.servicelayer;

import com.akbank.cityservice.dto.response.CityWeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "WEATHER-SERVICE")
public interface WeatherClient {

    @GetMapping(value = "/api/weathers/{city}")
    CityWeatherResponse getCityWithWeather(@PathVariable String city);
}
