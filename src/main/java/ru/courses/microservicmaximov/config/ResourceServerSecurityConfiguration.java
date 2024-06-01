package ru.courses.microservicmaximov.config;

import io.micrometer.core.annotation.Timed;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ResourceServerSecurityConfiguration {
    @Timed("OAuth2")
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    // Требует аутентификации только для запросов к БД
                    .antMatchers("/api/v1/**").authenticated()
                    // Разрешает все остальные запросы
                    .anyRequest().permitAll()
                .and()
                    .oauth2ResourceServer()
                    .jwt();
        return http.build();
    }
}
