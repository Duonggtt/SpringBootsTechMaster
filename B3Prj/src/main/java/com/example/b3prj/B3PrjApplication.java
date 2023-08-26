package com.example.b3prj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class B3PrjApplication implements CommandLineRunner {

    @Autowired
    private User user;

    @Autowired
    private Random random;

    public static void main(String[] args) {
        SpringApplication.run(B3PrjApplication.class, args);
    }

    public void run(String...args) throws Exception {
        user.work();
        System.out.println("Random number = " + random.nextInt(1000));
    }
}
