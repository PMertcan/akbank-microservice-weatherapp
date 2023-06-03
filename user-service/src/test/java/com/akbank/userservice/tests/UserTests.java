package com.akbank.userservice.tests;

import com.akbank.userservice.builder.UsersApiRequests;
import com.akbank.userservice.datas.DummyData;
import com.akbank.userservice.modal.UserPojo;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserTests {

    private String firstName;
    private String lastName;
    private String username;
    private String password;

    @BeforeEach
    void instanceData() {
        firstName = DummyData.DUMMY_FIRST_NAME;
        lastName = DummyData.DUMMY_LAST_NAME;
        username = DummyData.DUMMY_USERNAME;
        password = DummyData.DUMMY_PASSWORD;
    }

    @Test
    @Order(1)
    void getAllUsersTest() {
        Response response = UsersApiRequests.getAllUsers();

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK.value()));
    }

    @Test
    @Order(2)
    void createUserTest() {
        UserPojo requestUser = UserPojo.builder()
                .firstName(firstName)
                .lastName(lastName)
                .userName(username)
                .password(password)
                .build();

        Response response = UsersApiRequests.createUser(requestUser);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED.value()));

        UserPojo responseUser = response.as(UserPojo.class);

        assertThat(responseUser.getFirstName(), equalTo(requestUser.getFirstName()));
        assertThat(responseUser.getLastName(), equalTo(requestUser.getLastName()));
        assertThat(responseUser.getUserName(), equalTo(requestUser.getUserName()));
    }

    @Test
    @Order(3)
    void getUserByUsernameTest() {
        Response response = UsersApiRequests.getUserByUsername(username);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK.value()));
    }

    @Test
    @Order(4)
    void updateUserByUsernameTest() {
        UserPojo requestUser = UserPojo.builder()
                .firstName(firstName)
                .lastName(lastName)
                .userName("mertcan")
                .password(password)
                .build();

        Response response = UsersApiRequests.updateUserByUsername(username, requestUser);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK.value()));

        UserPojo responseUser = response.as(UserPojo.class);

        assertThat(responseUser.getUserName(), equalTo(requestUser.getUserName()));
    }

    @Test
    @Order(5)
    void deleteUserByUsernameTest() {
        Response response = UsersApiRequests.deleteUserByUsername(username);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK.value()));
    }
}
