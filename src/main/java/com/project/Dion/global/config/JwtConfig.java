package com.project.Dion.global.config;

import com.project.Dion.global.token.component.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Bean
    public JwtProvider jwtProvider() {
        return new JwtProvider();
    }

}
