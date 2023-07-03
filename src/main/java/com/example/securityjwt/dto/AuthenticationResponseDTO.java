package com.example.securityjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Zhurenkov Pavel 03.07.2023
 */

@Data
@AllArgsConstructor
public class AuthenticationResponseDTO {

    private String jwt;
}
