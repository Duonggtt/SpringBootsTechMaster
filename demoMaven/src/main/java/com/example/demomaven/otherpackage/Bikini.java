package com.example.demomaven.otherpackage;

import com.example.demomaven.Outfit;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("bikini1")
@Primary
public class Bikini implements Outfit {
    @Override
    public void wear() {
        System.out.println("Đang mặc bikini");
    }
}
