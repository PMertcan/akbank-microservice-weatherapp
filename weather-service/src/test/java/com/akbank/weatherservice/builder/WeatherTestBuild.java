package com.akbank.weatherservice.builder;

import com.akbank.weatherservice.datas.WeathersPath;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class WeatherTestBuild {

    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder().
                setBaseUri(WeathersPath.BASE_URI).
                setContentType(ContentType.JSON).
                log(LogDetail.ALL).
                build();
    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL).
                build();
    }

}
