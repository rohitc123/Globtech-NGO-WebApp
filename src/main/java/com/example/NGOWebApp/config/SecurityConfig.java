package com.example.NGOWebApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.Authentication;

@Configuration
@EnableWebSecurity
public class SecurityConfig { 

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
        http
            .csrf(csrf -> csrf.disable()) 
            .authorizeHttpRequests(auth -> auth 
                .requestMatchers("/admin/dashboard").hasRole("ADMIN") 
              
                .requestMatchers("/donate").authenticated()
                .anyRequest().permitAll() // Allow all other requests
            ) 
            .formLogin(form -> form 
                .loginPage("/login") // Custom login page 
                .successHandler(customAuthenticationSuccessHandler())  
                .permitAll() 
            ) 
            .logout(logout -> logout 
                .logoutUrl("/logout") 
                .logoutSuccessUrl("/login?logout") 
                .permitAll() 
            ); 
        return http.build(); 
    } 

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException, ServletException {
                String redirectUrl = "/"; // Default for normal users

                if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
                    redirectUrl = "/admin/dashboard";
                }

                response.sendRedirect(redirectUrl);
            }
        };
    }

    
}
