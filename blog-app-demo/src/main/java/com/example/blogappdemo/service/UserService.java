package com.example.blogappdemo.service;

import com.example.blogappdemo.entity.Role;
import com.example.blogappdemo.entity.User;
import com.example.blogappdemo.repository.RoleRepository;
import com.example.blogappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<User> findByRoleNameIn(){
        List<User> users = userRepository.findAll();
        List<User> userList= new ArrayList<>();
        for(User user : users) {
            for(int i =0;i<roleRepository.findAll().size();i++) {
                if(user.getRoleList().get(i).getName().equals("User") || user.getRoleList().get(i).getName().equals("Author")) {
                    userList.add(user);
                }
            }
        }
        return userList;
    }

}
