package com.akbank.cityservice.servicelayer.impl;

import com.akbank.cityservice.dao.ICityRepository;
import com.akbank.cityservice.dto.request.CityCreateRequest;
import com.akbank.cityservice.dto.response.CityResponse;
import com.akbank.cityservice.dto.response.CityWeatherResponse;
import com.akbank.cityservice.dto.response.ClientResponse;
import com.akbank.cityservice.entity.City;
import com.akbank.cityservice.mapper.CityMapper;
import com.akbank.cityservice.servicelayer.UserClient;
import com.akbank.cityservice.servicelayer.WeatherClient;
import com.akbank.cityservice.servicelayer.service.ICityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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
    public List<CityResponse> getAllCitiesWithUsername(String username) {

        List<City> cities = cityRepository.findCitiesByUsername(username);

        List<CityResponse> citiesResponse = CityMapper.MAP.entityListToDtoList(cities);

        if (!citiesResponse.isEmpty()) return citiesResponse;
        else throw new RuntimeException("Hata !");
    }

    @Override
    public CityResponse saveCityByUsername(CityCreateRequest cityCreateRequest) {

        Optional<City> username = userClient.getUsername(cityCreateRequest.username());

        if (username.isPresent()) {

            City city = CityMapper.MAP.dtoToEntity(cityCreateRequest);

            cityRepository.save(city);

            return CityMapper.MAP.entityToDto(city);

        } else throw new RuntimeException("Exc");
    }

    @Override
    public ClientResponse getCityWeatherDetailsByCityName(String cityName) {

        Optional<City> city = cityRepository.findCityByCityName(cityName);

        if (city.isPresent()) {

            CityResponse cityResponse = CityMapper.MAP.entityToDto(city.get());

            CityWeatherResponse cityWeatherResponse = weatherClient.getCityWithWeather(cityResponse.cityName());

            return ClientResponse.builder()
                    .cityResponse(cityResponse)
                    .cityWeatherResponse(cityWeatherResponse)
                    .build();

        } else throw new RuntimeException("Hata");
    }

}
