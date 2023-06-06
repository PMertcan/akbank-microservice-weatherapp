package com.akbank.cityservice.servicelayer.service;

import com.akbank.cityservice.dto.request.CityCreateRequest;
import com.akbank.cityservice.dto.response.CitiesResponse;
import com.akbank.cityservice.dto.response.CityResponse;
import com.akbank.cityservice.dto.response.ClientResponse;
import java.util.List;

public interface ICityService {

    CitiesResponse getAllCitiesWithUsername(String username);

    CityResponse saveCityByUsername (CityCreateRequest cityCreateRequest);

    ClientResponse getCityWeatherDetailsByCityName(String cityName);

}
