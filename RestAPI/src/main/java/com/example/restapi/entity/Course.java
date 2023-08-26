package com.example.restapi.entity;

import com.example.restapi.db.TopicDb;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    private Integer id;
    private String name;
    private String description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private Integer userId;

    public <E> Course(Integer id, String name, String description, String type, List<E> topics, String thumnail, String thumbnail, int userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.topics = TopicDb.topicList;
        this.thumbnail = thumbnail;
        this.userId = userId;
    }
}
