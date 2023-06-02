package com.akbank.weatherservice.controller;


import com.akbank.weatherservice.dto.response.WeatherDto;
import com.akbank.weatherservice.service.WeatherClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/weathers")
@Slf4j
public class WeatherController {

//    private final RestTemplate restTemplate;
//
//    public WeatherController(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    @GetMapping(value = "/{city}")
//    public ResponseEntity<String> getWeather(@PathVariable String city) {
//
//        String URI = "https://api.openweathermap.org/data/2.5/forecast?q=";
//
//        String CITY = city;
//
//        String API_KEY = "&appid=d7920d19ac2aba1c7708f112f2082370";
//
//        log.info("Getted the city {}", city);
//        return restTemplate.getForEntity(URI + CITY + API_KEY, String.class);
//    }


    private final WeatherClient weatherClient;

    public WeatherController(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @Value("${api.key}")
    private String apiKey;

    @GetMapping(value = "/{city}")
    public ResponseEntity<WeatherDto> getWeather(@PathVariable String city) {
        log.info("Got the city {}", city);
        return weatherClient.getWeather(city, apiKey);
    }
}
