package com.rookie.user.infrastructure.controller;

import org.junit.jupiter.api.Test;

import com.rookie.ApplicationTestCase;

public class UserPutControllerShould extends ApplicationTestCase {
    @Test
    void create_an_user() throws Exception {
        assertRequestWithBody(
            "PUT",
            "/users/7799d098-9f48-4e1d-a8bc-35c2cb173a45",
            "{\"name\": \"name of user\", \"nick\": \"this is a nick\"}",
            201
        );
    }
}