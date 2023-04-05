package com.example.demomaven;

import com.example.demomaven.anotherpakage.Dress;
import com.example.demomaven.otherpackage.Bikini;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoMavenApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoMavenApplication.class, args);
    }

}
