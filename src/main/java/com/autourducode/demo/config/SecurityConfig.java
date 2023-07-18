// fichier de configuration de la sécurité
package com.autourducode.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception {

        
        return http.build();
    }
}


