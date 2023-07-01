package com.example.securityjwt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Zhurenkov Pavel 18.06.2023
 */

@RestController
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/unsecured")
    public String unsecuredData(){
        return "Unsecured data";
    }

    @GetMapping(value = "/secured")
    public String securedData(){
        return "Secured data";
    }

    @GetMapping("/admin")
    public String adminData(){
        return "Admin data";
    }

    @GetMapping("/info")
    public String userData(Principal principal){
        return principal.getName();
    }
}
