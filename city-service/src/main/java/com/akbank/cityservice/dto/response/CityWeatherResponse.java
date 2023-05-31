package com.akbank.cityservice.dto.response;

import java.util.List;

public record CityWeatherResponse(String cod,
                                  int message,
                                  int cnt,
                                  List<Object> list,
                                  Object city
                                  ) {
}
