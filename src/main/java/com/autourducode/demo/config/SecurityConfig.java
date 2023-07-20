// fichier de configuration de la sécurité
package com.autourducode.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> auth
            .requestMatchers(new AntPathRequestMatcher("/produit/protected")).hasAnyRole("_ADMIN","_USER")
            .requestMatchers(new AntPathRequestMatcher("/produit/user")).hasRole("_USER")
            .requestMatchers(new AntPathRequestMatcher("/produit/admin")).hasRole("_ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/produit/public")).permitAll()
            .anyRequest()
            .authenticated()
        )
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = User.builder()
        .username("user")
        .password("user")
        .roles("_USER")
        .build();
        UserDetails admin = User.builder()
        .username("admin")
        .password("admin")
        .roles("_ADMIN")
        .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}


