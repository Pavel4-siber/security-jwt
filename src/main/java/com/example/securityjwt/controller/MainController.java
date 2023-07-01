package com.example.securityjwt.controller;

import com.example.securityjwt.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> adminData(){
        return ResponseEntity.ok(new User());
    }

    @GetMapping("/info")
    public String userData(Principal principal){
        return principal.getName();
    }
}
