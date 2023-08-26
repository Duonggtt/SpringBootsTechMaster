package com.example.restapi.db;

import com.example.restapi.entity.Course;
import com.example.restapi.entity.User;

import java.util.ArrayList;
import java.util.List;

public class CourseDb {
    public static List<Course> courseList = new ArrayList<>(
            List.of(
                    new Course(1,"Data Structure - Algorithm - LeetCode","none","Online",List.of(),"thumnail","ảnh khóa học1",1),
                    new Course(2,"Ruby","none","Onlab",List.of(),"thumnail","ảnh khóa học2",2),
                    new Course(3,"Javascript","none","Online",List.of(),"thumnail","ảnh khóa học3",3),
                    new Course(4,"PHP","none","Online",List.of(),"thumnail","ảnh khóa học4",4),
                    new Course(5,"Python","none","Onlab",List.of(),"thumnail","ảnh khóa học5",5),
                    new Course(6,"FE","none","Online",List.of(),"thumnail","ảnh khóa học6",6),
                    new Course(7,"Data Structure","none","Onlab",List.of(),"thumnail","ảnh khóa học7",7),
                    new Course(8,"Robot","none","Online",List.of(),"thumnail","ảnh khóa học8",8),
                    new Course(9,"NodeJs","none","Onlab",List.of(),"thumnail","ảnh khóa học9",9),
                    new Course(10,"Database","none","Online",List.of(),"thumnail","ảnh khóa học10",10)
            )
    );
}
