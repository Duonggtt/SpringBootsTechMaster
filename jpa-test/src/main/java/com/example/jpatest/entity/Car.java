package com.example.jpatest.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car")
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Type(JsonType.class)
    @Column(name = "images", columnDefinition = "json")
    private List<String> images;
    @Type(JsonType.class)
    @Column(name = "engine" , columnDefinition = "json")
    private Engine engine;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Engine implements Serializable {
        private int cc;
        private String type;
    }
}
