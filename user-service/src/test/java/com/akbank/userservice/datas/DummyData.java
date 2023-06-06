package com.akbank.userservice.datas;

import com.github.javafaker.Faker;

public class DummyData {

    private static final Faker FAKER = new Faker();

    public static final String DUMMY_FIRST_NAME = FAKER.name().firstName();
    public static final String DUMMY_LAST_NAME = FAKER.name().lastName();
    public static final String DUMMY_USERNAME = FAKER.name().username();
    public static final String DUMMY_PASSWORD = FAKER.internet().password();

}
