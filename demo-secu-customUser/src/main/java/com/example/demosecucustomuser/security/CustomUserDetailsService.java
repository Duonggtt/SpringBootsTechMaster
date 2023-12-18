package com.example.demosecucustomuser.security;

import com.example.demosecucustomuser.model.CustomUserDetails;
import com.example.demosecucustomuser.model.User;
import com.example.demosecucustomuser.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService, org.springframework.security.core.userdetails.UserDetailsService {

    private final PasswordEncoder passwordEncoder;


    private final UserRepository userRepository;

    public CustomUserDetailsService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found"));

        return new CustomUserDetails(user);
    }
}
