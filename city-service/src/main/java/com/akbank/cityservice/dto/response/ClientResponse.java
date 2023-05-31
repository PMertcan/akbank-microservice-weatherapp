package com.akbank.cityservice.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponse {

    private CityResponse cityResponse;
    private CityWeatherResponse cityWeatherResponse;

}
