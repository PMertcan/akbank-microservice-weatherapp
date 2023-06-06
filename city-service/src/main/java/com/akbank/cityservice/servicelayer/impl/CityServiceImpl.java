package com.akbank.cityservice.servicelayer.impl;

import com.akbank.cityservice.dao.ICityRepository;
import com.akbank.cityservice.dto.request.CityCreateRequest;
import com.akbank.cityservice.dto.response.*;
import com.akbank.cityservice.entity.City;
import com.akbank.cityservice.exception.enums.CityExceptionTypes;
import com.akbank.cityservice.exception.exceptions.*;
import com.akbank.cityservice.mapper.CityMapper;
import com.akbank.cityservice.servicelayer.*;
import com.akbank.cityservice.servicelayer.service.ICityService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityServiceImpl implements ICityService {

    private final ICityRepository cityRepository;

    private final UserClient userClient;

    private final WeatherClient weatherClient;

    @Override
    public CitiesResponse getAllCitiesWithUsername(String username) {

        List<City> cities = cityRepository.findCitiesByUsername(username);
        List<String> cityList = new ArrayList<>();

        for (City city : cities) {
            cityList.add(city.getCityName());
        }

        CitiesResponse citiesResponse = CitiesResponse.builder()
                .username(username)
                .cityNames(cityList)
                .build();

        if (citiesResponse != null) return citiesResponse;
        else throw new CityNotFoundException(CityExceptionTypes.CITIES_NOT_FOUND_EXCEPTION.getValue() + username);
    }

    @Override
    public CityResponse saveCityByUsername(CityCreateRequest cityCreateRequest) {

        try {
            userClient.getUsername(cityCreateRequest.username());
        }catch (Exception exception) {
            throw new CityNotCreatedException(CityExceptionTypes.CITY_NOT_CREATED_EXCEPTION.getValue() + cityCreateRequest.username());
        }

            City city = CityMapper.MAP.dtoToEntity(cityCreateRequest);
            cityRepository.save(city);
            return CityMapper.MAP.entityToDto(city);
    }

    @Override
    public ClientResponse getCityWeatherDetailsByCityName(String cityName) {

        Optional<City> city = cityRepository.findCityByCityName(cityName);

        if (city.isPresent()) {

            CityResponse cityResponse = CityMapper.MAP.entityToDto(city.get());

            CityWeatherResponse cityWeatherResponse = weatherClient.getCityWithWeather(cityResponse.cityName());

            return clientResponseParser(cityResponse, cityWeatherResponse);

        } else throw new CityNotFoundException(CityExceptionTypes.CITY_NOT_FOUND_EXCEPTION.getValue() + cityName);
    }

    private ClientResponse clientResponseParser(CityResponse cityResponse, CityWeatherResponse cityWeatherResponse) {
        return ClientResponse.builder()
                .cityResponse(cityResponse)
                .cityWeatherResponse(cityWeatherResponse)
                .build();
    }
}
