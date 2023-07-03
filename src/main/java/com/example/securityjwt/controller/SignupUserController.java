package com.example.securityjwt.controller;

import com.example.securityjwt.dto.SingUpRequest;
import com.example.securityjwt.dto.UserDTO;
import com.example.securityjwt.entity.Role;
import com.example.securityjwt.entity.User;
import com.example.securityjwt.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

/**
 * @author Zhurenkov Pavel 18.06.2023
 */

@RestController
@RequiredArgsConstructor
public class SignupUserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/info")
    public String userData(Principal principal){
        return principal.getName();
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody SingUpRequest singUpRequest){
        singUpRequest.setPassword(passwordEncoder.encode(singUpRequest.getPassword()));

        UserDTO createdUser = userService.createNewUser(singUpRequest);
        if (createdUser == null){
            return new ResponseEntity<>("User is not created", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

}
