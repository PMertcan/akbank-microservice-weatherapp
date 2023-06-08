package com.akbank.weatherservice.dto.response;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherEvent {
    private String cod;
    private int message;
    private int cnt;
    private List<Object> list;
    private Object city;
}
