package com.example.sistema.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize


                        //exceptions SELLER
                        .requestMatchers(HttpMethod.GET, "/clients").hasRole("SELLER")
                        .requestMatchers(HttpMethod.GET, "/clients/{id}").hasRole("SELLER")
                        .requestMatchers(HttpMethod.GET, "/clients/search/{cpf}").hasRole("SELLER")
                        .requestMatchers(HttpMethod.POST, "/clients").hasRole("SELLER")
                        .requestMatchers(HttpMethod.PUT, "/clients/{id}").hasRole("SELLER")

                        .requestMatchers(HttpMethod.GET, "/cars").hasRole("SELLER")
                        .requestMatchers(HttpMethod.GET, "/cars/{id}").hasRole("SELLER")

                        .requestMatchers(HttpMethod.POST, "/sales").hasRole("SELLER")
                        .requestMatchers(HttpMethod.GET, "/sales/client/{id}").hasRole("SELLER")
                        .requestMatchers(HttpMethod.GET, "/sales/car/{id}").hasRole("SELLER")
                        .requestMatchers(HttpMethod.GET, "/sales").hasRole("SELLER")

                        //exceptions ADMIN
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET).hasRole("ADMIN")

//                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
