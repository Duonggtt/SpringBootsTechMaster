package com.example.demofile;

import com.example.demofile.model.entity.User;
import com.example.demofile.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoFileApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void save_user() {
		User user = new User();
		user.setName("Duong");
		userRepository.save(user);
	}

}
