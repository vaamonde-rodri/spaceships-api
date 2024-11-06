package com.rodrigovaamonde.spaceships;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rodrigovaamonde.spaceships.controllers.dto.SpaceShipDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SpaceShipControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createSpaceShipReturnsCreatedResource() throws Exception {
        SpaceShipDTO spaceShipDTO = SpaceShipDTO.builder()
                .name("Test Ship")
                .description("Test Description")
                .source("Test Source")
                .build();

        mockMvc.perform(post("/spaceship")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(spaceShipDTO))
                .with(httpBasic("user", "password")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Ship"));
    }

    @Test
    void getSpaceShipReturnsResource() throws Exception {
        mockMvc.perform(get("/spaceship/1")
                        .contentType(MediaType.APPLICATION_JSON)
                .with(httpBasic("user", "password")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Serenity"));
    }

    @Test
    void deleteSpaceShipReturnsNoContent() throws Exception {
        mockMvc.perform(delete("/spaceship/1")
                        .contentType(MediaType.APPLICATION_JSON)
                .with(httpBasic("user", "password")))
                .andExpect(status().isNoContent());
    }

}
