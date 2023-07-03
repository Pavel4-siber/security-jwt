package com.example.securityjwt.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zhurenkov Pavel 03.07.2023
 */
@Configuration
public class SpringConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
