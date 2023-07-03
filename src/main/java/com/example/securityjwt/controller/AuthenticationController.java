package com.example.securityjwt.controller;

import com.example.securityjwt.dto.AuthenticationRequestDTO;
import com.example.securityjwt.dto.AuthenticationResponseDTO;
import com.example.securityjwt.services.UserDetailsServiceImpl;
import com.example.securityjwt.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Zhurenkov Pavel 03.07.2023
 */

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/authenticate")
    public AuthenticationResponseDTO createAuthenticationToken(@RequestBody AuthenticationRequestDTO authenticationDTO,
                                                               HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getEmail(), authenticationDTO.getPassword()));
        } catch (BadCredentialsException e){
            throw new BadCredentialsException("Incorrect username or password!");
        } catch (DisabledException disabledException){
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not activated");
            return null;
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDTO.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        return new AuthenticationResponseDTO(jwt);
    }
}
