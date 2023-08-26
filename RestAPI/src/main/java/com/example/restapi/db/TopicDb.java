package com.example.restapi.db;

import com.example.restapi.entity.Course;
import com.example.restapi.entity.User;

import java.util.ArrayList;
import java.util.List;

public class TopicDb {
    public static List<String> topicList = new ArrayList<>(
            List.of("Frontend", "Backend", "Database", "Devaps", "Basic", "Moblie")
    );
}
