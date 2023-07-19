// fichier de configuration de la sécurité
package com.autourducode.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception {
        // http.csrf((csrf) -> csrf.disable());
        http.authorizeHttpRequests((auth) -> auth
            // .antMatchers("/public").permitAll()
            // .anyRequest()
            // .authenticated()
            .requestMatchers(new AntPathRequestMatcher("/produit/public")).permitAll().anyRequest().authenticated()
        )
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}


