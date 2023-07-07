package com.example.jpatest;

import com.example.jpatest.entity.Car;
import com.example.jpatest.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@AllArgsConstructor
public class JpaTestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JpaTestApplication.class, args);
    }

    private CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {
            Car car = new Car();
            car.setName("Some car...");
            List<String> images = new ArrayList<>();
            images.add("/img/car1");
            images.add("/img/car2");
            car.setImages(images);
            Car.Engine engine = new Car.Engine(320, "2.0");
            car.setEngine(engine);
            carRepository.save(car);

        Optional<Car> getCar = carRepository.findById(1);
        System.out.println(getCar.get().toString());

    }
}
