package com.akbank.cityservice.mapper;

import com.akbank.cityservice.dto.request.CityCreateRequest;
import com.akbank.cityservice.dto.response.CityResponse;
import com.akbank.cityservice.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityMapper MAP = Mappers.getMapper(CityMapper.class);

    CityResponse entityToDto(City city);

    City dtoToEntity(CityCreateRequest cityCreateRequest);

    List<CityResponse> entityListToDtoList(List<City> cities);

}
