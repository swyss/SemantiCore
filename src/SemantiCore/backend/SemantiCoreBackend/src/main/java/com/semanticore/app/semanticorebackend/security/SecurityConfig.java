package com.semanticore.app.semanticorebackend.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Value("${spring.security.user.name}")
    private String adminUsername;

    @Value("${spring.security.user.password}")
    private String adminPassword;

    @Value("${spring.security.user.role}")
    private String adminRole;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/public/**").permitAll() // Public APIs are accessible
                                .anyRequest().authenticated() // All other requests require authentication
                )
                .formLogin(withDefaults()) // Enable form-based login with default configuration
                .httpBasic(withDefaults()); // Enable basic authentication with default configuration

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for password hashing
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            // Hardcoding admin for simplicity. In real-world applications, you would fetch this from a database
            if (this.adminUsername.equals(username)) {
                return User.builder()
                        .username(this.adminUsername)
                        .password(passwordEncoder().encode(this.adminPassword))
                        .roles(this.adminRole) // Dynamically assign the role from application.yml
                        .build();
            } else {
                throw new UsernameNotFoundException("User not found: " + username);
            }
        };
    }
}

