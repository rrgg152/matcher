package com.rookie.player.infrastructure.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.rookie.ApplicationTestCase;
import com.rookie.shared.domain.UuidMother;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

public class PlayerPutControllerShould extends ApplicationTestCase {
    @Test
    void create_a_player() throws Exception {
        String id   = UuidMother.random();
        String body =  "{\"name\": \"name of user\", \"nick\": \"this is a nick\"}";

        givenThereIsAnUser(id, body);

        assertRequestWithBody(
            "POST",
            String.format("/users/%s/player", id),
            "\"7799d098-9f48-4e1d-a8bc-35c2cb173a45\"}",
            201
        );
    }

    @Test
    void not_create_a_player_with_non_existing_user() throws Exception {
        String id   = UuidMother.random();
        mockMvc
        .perform(request(HttpMethod.valueOf("POST"), String.format("/users/%s/player", id))
        .content("\"7799d098-9f48-4e1d-a8bc-35c2cb173a45\"}")
        .contentType(APPLICATION_JSON))
        .andExpect(status().is(404));

    }
    
    private void givenThereIsAnUser(String id, String body) throws Exception {
        assertRequestWithBody("PUT", String.format("/users/%s", id), body, 201);
    }
}