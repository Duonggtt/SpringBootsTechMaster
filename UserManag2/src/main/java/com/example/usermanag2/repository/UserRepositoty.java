package com.example.usermanag2.repository;

import com.example.usermanag2.dto.CreateUserRequest;
import com.example.usermanag2.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoty {



    public List<User> getAllUsers() {
        return UserDB.users;
    }

    public Optional<User> getUserById(Integer id) {
        return UserDB.users.stream().filter(user -> user.getId() == id).findFirst();
    }

    public List<User> getUserByNameContain(String name) {
        return UserDB.users.stream().filter(user -> user.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }

    public User createUser(User user) {
        int maxId = UserDB.users.stream().mapToInt(User::getId).max().orElse(0);
        User createnewUser = user.toBuilder().widthId(maxId).build();
        UserDB.users.add(createnewUser);
        return user;
    }

    public User updateUser(User user) {
        User updateUser = null;
        for (User u : UserDB.users) {
            if (u.getId() == user.getId()){
                updateUser = u;
                break;
            }
        }

        if (updateUser != null){
            updateUser.setName(user.getName());
            updateUser.setEmail(user.getEmail());
            updateUser.setPhone(user.getPhone());
            return updateUser;
        } else {
            return null;
        }
    }

    public boolean deleteUser(Integer id) {
        User userDelete = null;
        for(User user: UserDB.users) {
            if(user.getId()==id) {
                userDelete = user;
            }
        }
        if(userDelete != null) {
            UserDB.users.remove(userDelete);
            return true;
        }
        return false;
    }
}
