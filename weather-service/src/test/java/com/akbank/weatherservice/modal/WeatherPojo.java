package com.akbank.weatherservice.modal;

import java.util.List;

public record WeatherPojo
        (
                String cod,
                int message,
                int cnt,
                List<Object> list,
                Object city
        ) {}
