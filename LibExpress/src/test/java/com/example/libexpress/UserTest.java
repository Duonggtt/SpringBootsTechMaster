package com.example.libexpress;

import com.example.libexpress.entity.LibraryCard;
import com.example.libexpress.entity.User;
import com.example.libexpress.repository.LibraryCardRepository;
import com.example.libexpress.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LibraryCardRepository cardRepository;

    @Test
    void save_users() {
        for (int i = 1; i <= 20; i++) {
            User user = new User();
            user.setPassword("password" + i);
            user.setFirstName("Trần Tùng ");
            user.setLastName("Dương");
            user.setBirthDate(new Date());
            user.setAddress("Address " + i);
            user.setPhone("Phone " + i);

            user.setEmail("user" + i + "@example.com");
            user.setStatus(true);
            user.setCardCreated(false);
            user.setAvatar("avatar" + i + ".jpg");

            // Lưu user vào cơ sở dữ liệu
            userRepository.save(user);
        }
    }

    @Test
    void save_card() {

        Calendar calendar = Calendar.getInstance();
        List<User> users = userRepository.findAll();
        for (int i =0;i<users.size();i++) {
            if(users.get(i).isCardCreated()) {
                LibraryCard card = new LibraryCard();
                card.setUser(users.get(i));
                card.setUsername(users.get(i).getFirstName() +" "+ users.get(i).getLastName());
                card.setUserBirthDate(users.get(i).getBirthDate());
                card.setCreatedAt(new Date());
                calendar.setTime(card.getCreatedAt());
                calendar.add(Calendar.MONTH, 12);
                card.setEnd_at(calendar.getTime());
                card.setAvatar(users.get(i).getAvatar());
                cardRepository.save(card);
            }
        }

    }


//    @Test
//    void sortUser() {
////        List<User> sortUserAsc = userRepository.findAllByOrderByIdAsc();
////        for (User u : sortUserAsc) {
////            System.out.println(u.getId());
////        }
//
//        List<User> sortUserDesc = userRepository.findAllOrderByName();
//        for (User u : sortUserDesc) {
//            System.out.println(u.getFullName());
//        }
//    }

}
