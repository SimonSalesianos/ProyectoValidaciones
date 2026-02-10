package com.salesianostriana.ProyectoValidaciones;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {


    @Bean
    UserDetailsService userDetailsManager(){

        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        UserDetails admin =  User.builder()
                .username("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();

        UserDetails user =  User.builder()
                .username("user")
                .password("{noop}user")
                .roles("USER")
                .build();


        userDetailsManager.createUser(admin);
        userDetailsManager.createUser(user);


        return userDetailsManager;
    }

    @PostConstruct
    public void init() {
        User user = User.builder()
                .username("user")
                .password("{noop}password")
                .build();

        User admin = User.builder()
                .username("admin")
                .password("{noop}admin")
                .role("ADMIN")
                .build();

        userRepository.saveAll(List.of(user, admin));

    }


}


