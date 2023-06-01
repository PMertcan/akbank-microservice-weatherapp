package com.akbank.userservice.exception.enums;

public enum UserExceptionTypes implements IExceptionTypes{

    USERS_NOT_FOUND("Users Not Found !"),
    USER_NOT_FOUND_ID("User Not Found With Id : "),
    USER_NOT_FOUND_USERNAME("User Not Found With username : "),
    USER_NOT_CREATED("User Not Created !"),
    USER_NOT_UPDATED("User Not Updated With Id : "),
    USER_NOT_DELETED("User Not Deleted With Id : ");

    private final String value;

    @Override
    public String getValue() {
        return this.value;
    }

    UserExceptionTypes(String value) {
        this.value = value;
    }

}
