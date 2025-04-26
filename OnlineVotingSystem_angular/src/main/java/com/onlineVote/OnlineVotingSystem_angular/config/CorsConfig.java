package com.onlineVote.OnlineVotingSystem_angular.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Allow all paths
                registry.addMapping("/**") 
                        .allowedOrigins("http://localhost:4200") // Allow Angular app
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow these HTTP methods
                        .allowedHeaders("*") // Allow any header
                        .allowCredentials(true) // Allow credentials (cookies, authorization headers)
                        .maxAge(3600); // Cache pre-flight response for 1 hour
            }
        };
    }
}
