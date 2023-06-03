package com.akbank.cityservice.tests;

import com.akbank.cityservice.builder.CityApiRequests;
import com.akbank.cityservice.modal.CityPojo;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityTests {

    private String username;
    private String cityName;

    @BeforeEach
    void instanceData() {
        username = "mertcan1";
        cityName = "Ankara";
    }


    @Test
    @Order(1)
    void createCityByUsernameTest() {
        CityPojo requestCity = CityPojo.builder()
                .username(username)
                .cityName(cityName)
                .build();

        Response response = CityApiRequests.createCityByUsername(requestCity);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED.value()));
        assertThat(response.getHeader("Content-Type"), equalTo(MediaType.APPLICATION_JSON_VALUE));

        CityPojo responseCity = response.as(CityPojo.class);

        assertThat(requestCity.getUsername(), equalTo(responseCity.getUsername()));
        assertThat(requestCity.getCityName(), equalTo(responseCity.getCityName()));
    }

    @Test
    @Order(2)
    void getAllCitiesByUsernameTest() {
        Response response = CityApiRequests.getCitiesByUsername(username);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK.value()));

        boolean isResponseHasUsername = response.getBody().prettyPrint().contains(username);
        boolean isNotResponseNull = response.getBody() != null;

        Assertions.assertTrue(isResponseHasUsername);
        Assertions.assertTrue(isNotResponseNull);
    }

    @Test
    @Order(3)
    void getCityWeatherDetailsByCityNameTest() {

        Response response = CityApiRequests.getCityWeatherDetailsByCityName("İstanbul");

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK.value()));
    }
}
