package com.akbank.userservice.datas;

import com.github.javafaker.Faker;

public class DummyData {

    private static final Faker faker = new Faker();

    public static final String DUMMY_FIRST_NAME = faker.name().firstName();
    public static final String DUMMY_LAST_NAME = faker.name().lastName();
    public static final String DUMMY_USERNAME = faker.name().username();
    public static final String DUMMY_PASSWORD = faker.internet().password();

}
