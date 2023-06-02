package com.akbank.cityservice.exception.enums;

public enum CityExceptionTypes implements ICityExceptionTypes {

    CITIES_NOT_FOUND_EXCEPTION("Not Found Any Cities For This User : "),
    CITY_NOT_FOUND_EXCEPTION("City Not Found In Database With City Name : "),
    CITY_NOT_CREATED_EXCEPTION("City Not Created With Invalid User Name");

    private final String value;

    @Override
    public String getValue() {
        return this.value;
    }

    CityExceptionTypes(String value) {
        this.value = value;
    }
}
