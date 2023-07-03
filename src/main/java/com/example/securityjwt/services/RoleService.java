package com.example.securityjwt.services;

import com.example.securityjwt.entity.Role;
import com.example.securityjwt.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zhurenkov Pavel 18.06.2023
 */

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role findByName(String name){
        return roleRepository.findByName(name).orElseThrow(()-> new UsernameNotFoundException("Role not found"));
    }
}
