package com.example.b3prj;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Random;
@Configuration
public class Config {

    @Bean
    public Random random() {
        return new Random();
    }
}
