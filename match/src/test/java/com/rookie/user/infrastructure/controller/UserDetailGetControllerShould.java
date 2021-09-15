package com.rookie.user.infrastructure.controller;

import org.junit.jupiter.api.Test;

import com.rookie.ApplicationTestCase;
import com.rookie.shared.domain.UuidMother;

public class UserDetailGetControllerShould extends ApplicationTestCase {

    @Test
    void return_an_user() throws Exception {
        String id   = UuidMother.random();
        String body =  "{\"name\": \"name of user\", \"nick\": \"this is a nick\"}";
        givenThereIsAnUser(id, body);

        assertResponse(String.format("/users/%s", id), 200);
    }

    private void givenThereIsAnUser(String id, String body) throws Exception {
        assertRequestWithBody("PUT", String.format("/users/%s", id), body, 201);
    }
}