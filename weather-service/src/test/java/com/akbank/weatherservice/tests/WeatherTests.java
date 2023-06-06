package com.akbank.weatherservice.tests;

import com.akbank.weatherservice.builder.WeatherApiRequests;
import com.akbank.weatherservice.datas.DummyData;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@RequiredArgsConstructor
@Slf4j
class WeatherTests {

    private String cityName;

    @BeforeEach
    void instance() {
        cityName = DummyData.CITY_NAME;
    }

    @Test
    void getWeatherResponseTest() {
        Response response = WeatherApiRequests.getWeatherByCityName(this.cityName);

        log.info("Weather Response Is Successfully Returning");
        assertThat(HttpStatus.OK.value(), equalTo(response.getStatusCode()));
        assertThat(response.getHeader("Content-Type"), equalTo(MediaType.APPLICATION_JSON_VALUE));

        boolean isResponseNotNull = response.getBody() != null;
        Assertions.assertTrue(isResponseNotNull, "Weather Response Is Not Null.");

        boolean isResponseHasCity = response.getBody().prettyPrint().contains(this.cityName);
        Assertions.assertTrue(isResponseHasCity, "Weather Response Has City Name");
    }

}
