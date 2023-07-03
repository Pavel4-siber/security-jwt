package com.example.securityjwt.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.context.annotation.SecurityTestExecutionListeners;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.beans.Transient;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Zhurenkov Pavel 25.06.2023
 */

@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    @WithMockUser(username = "USER", password = "user")
//    void unsecuredData_ReturnResponseWithStatusOk()throws Exception{
//        //given
//        var requestBuilder = MockMvcRequestBuilders.get("/unsecured");
//        //when
//        this.mockMvc.perform(requestBuilder)
//                .andExpectAll(
//                        status().isOk(),
//                        content().contentType("text/plain;charset=UTF-8"),
//                        content().string("Unsecured data"));
//    }

//    @Test
//    @WithMockUser(username = "ADMIN", password = "admin", authorities = "ROLE_ADMIN")
//    void adminData_ReturnResponseWithStatusOk()throws Exception{
//        //given
//        var requestBuilder = MockMvcRequestBuilders.get("/admin");
//        //when
//        this.mockMvc.perform(requestBuilder)
//                .andExpectAll(
//                        status().isOk(),
//                        header().string("Content-Type", "application/json"),
//                        header().string("X-Content-Type-Options", "nosniff"),
//                        header().string("X-XSS-Protection", "0"),
//                        header().string("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate"),
//                        header().string("Pragma", "no-cache"),
//                        header().string("Expires", "0"),
//                        header().string("X-Frame-Options", "DENY"),
//                        content().contentType(MediaType.APPLICATION_JSON),
//                        content().json("""
//                                    {
//                                    "id": 1,
//                                    "username": admin,
//                                    "password": admin,
//                                    "email": admin@gmail.com,
//                                    "roles": null
//                                    }
//                                    """));
//    }
//
//    @Test
//    void unsecuredData() throws IOException, InterruptedException {
//        final HttpRequest httpRequest = HttpRequest.newBuilder()
//                .uri(URI.create("http://localhost:8080/unsecured"))
//                .GET()
//                .build();
//        final HttpClient httpClient = HttpClient.newHttpClient();
//        final HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//
//        assertEquals("Unsecured data", response.body());
//    }
}
