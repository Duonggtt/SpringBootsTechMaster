package com.example.demosecucustomuser;

import com.example.demosecucustomuser.model.Role;
import com.example.demosecucustomuser.model.User;
import com.example.demosecucustomuser.repository.RoleRepository;
import com.example.demosecucustomuser.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class DemoSecuCustomUserApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;


	private final PasswordEncoder passwordEncoder;

	DemoSecuCustomUserApplicationTests(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Test
	void contextLoads() {
	}

	@Test
	void save_role() {
		Role role = new Role();
		role.setName("ADMIN");
		roleRepository.save(role);


		Role roleUser = new Role();
		roleUser.setName("USER");;
		roleRepository.save(roleUser);
	}


	@Test
	void save_user() {
		Role roleAdmin = roleRepository.findByName("ADMIN");
		Role roleUser = roleRepository.findByName("USER");

		User userAdmin = new User();
		userAdmin.setName("Duong Tung");
		userAdmin.setEmail("duong123@gmail.com");
		userAdmin.setPassword(passwordEncoder.encode("123"));
		userAdmin.getRoles().add(roleAdmin);
		userRepository.save(userAdmin);


		User user = new User();
		user.setName("Anh");
		user.setEmail("anh123@gmail.com");
		user.setPassword(passwordEncoder.encode("123"));
		user.getRoles().add(roleUser);
		userRepository.save(userAdmin);
	}

}
