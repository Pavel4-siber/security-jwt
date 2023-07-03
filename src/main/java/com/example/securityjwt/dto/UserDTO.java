package com.example.securityjwt.dto;

import lombok.Data;

/**
 * @author Zhurenkov Pavel 02.07.2023
 */

@Data
public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private String email;
}
