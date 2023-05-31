package com.akbank.weatherservice.dto.response;

import java.util.List;

public record WeatherDto(String cod,
                         int message,
                         int cnt,
                         List<Object> list,
                         Object city) {
}
