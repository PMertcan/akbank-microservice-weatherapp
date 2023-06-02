package com.akbank.weatherservice.dto.response;

import java.util.List;

public record WeatherResponse
        (
                String cod,
                int message,
                int cnt,
                List<Object> list,
                Object city
        ) {}
