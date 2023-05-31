package com.akbank.cityservice.controller;

import com.akbank.cityservice.dto.request.CityCreateRequest;
import com.akbank.cityservice.dto.response.CityResponse;
import com.akbank.cityservice.dto.response.ClientResponse;
import com.akbank.cityservice.servicelayer.service.ICityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/cities")
@RequiredArgsConstructor
public class CityController {

    private final ICityService cityService;

    @GetMapping(value = "/{username}")
    public ResponseEntity<List<CityResponse>> getAllCities(@PathVariable String username) {
        var cities = cityService.getAllCitiesWithUsername(username);
        return ResponseEntity.ok(cities);
    }

    @PostMapping
    public ResponseEntity<CityResponse> saveCity(@RequestBody CityCreateRequest cityCreateRequest) {
        var city = cityService.saveCityByUsername(cityCreateRequest);
        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{city}/weather")
    public ResponseEntity<ClientResponse> getCityWeatherByCityName(@PathVariable String city) {
       var cityWeatherDetails = cityService.getCityWeatherDetailsByCityName(city);
       return ResponseEntity.ok(cityWeatherDetails);
    }
}
