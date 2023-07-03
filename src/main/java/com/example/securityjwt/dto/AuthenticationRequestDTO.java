package com.example.securityjwt.dto;

import lombok.Data;

/**
 * @author Zhurenkov Pavel 03.07.2023
 */

@Data
public class AuthenticationRequestDTO {

    private String email;

    private String password;

}
