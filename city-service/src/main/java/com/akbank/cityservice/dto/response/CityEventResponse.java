package com.akbank.cityservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityEventResponse {
    private String cod;
    private int message;
    private int cnt;
    private List<Object> list;
    private Object city;
}
