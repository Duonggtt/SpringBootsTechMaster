package com.example.demomaven.anotherpakage;

import com.example.demomaven.Outfit;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Dress implements Outfit {

    @Override
    public void wear() {
        System.out.println("Đang mặc váy");
    }
}
