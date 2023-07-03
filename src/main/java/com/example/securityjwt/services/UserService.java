package com.example.securityjwt.services;

import com.example.securityjwt.dto.SingUpRequest;
import com.example.securityjwt.dto.UserDTO;
import com.example.securityjwt.entity.User;
import com.example.securityjwt.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Zhurenkov Pavel 18.06.2023
 */

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;

    @Transactional
    public UserDTO createNewUser(SingUpRequest singUpRequest){

        User user = modelMapper.map(singUpRequest, User.class);
        user.setRoles(List.of(roleService.findByName("ROLE_USER")));

        User createdUser = userRepository.save(user);

        return modelMapper.map(createdUser, UserDTO.class);
    }
}
