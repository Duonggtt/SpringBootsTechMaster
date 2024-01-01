package com.example.libexpress;

import com.example.libexpress.entity.BorrowManagement;
import com.example.libexpress.entity.BorrowManagementDetail;
import com.example.libexpress.entity.FinesLevel;
import com.example.libexpress.repository.FinesLevelRepository;
import com.example.libexpress.service.BorrowDetailService;
import com.example.libexpress.service.BorrowService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LibExpressApplicationTests {

	@Autowired
	private FinesLevelRepository finesLevelRepository;




	@Test
	void createFinesLevel() {
		FinesLevel finesLevel = new FinesLevel();
		finesLevel.setLevelName("10%");
		finesLevel.setDescription("Sách bị hư hỏng 10% so với ban đầu.");
		finesLevel.setAmount(5000);
		finesLevelRepository.save(finesLevel);

		FinesLevel finesLevel1 = new FinesLevel();
		finesLevel1.setLevelName("30%");
		finesLevel1.setDescription("Sách bị hư hỏng 30% so với ban đầu.");
		finesLevel1.setAmount(10000);
		finesLevelRepository.save(finesLevel1);

		FinesLevel finesLevel2 = new FinesLevel();
		finesLevel2.setLevelName("50%");
		finesLevel2.setDescription("Sách bị hư hỏng 50% so với ban đầu.");
		finesLevel2.setAmount(20000);
		finesLevelRepository.save(finesLevel2);


		FinesLevel finesLevel3 = new FinesLevel();
		finesLevel3.setLevelName("70%");
		finesLevel3.setDescription("Sách bị hư hỏng 70% so với ban đầu.");
		finesLevel3.setAmount(30000);
		finesLevelRepository.save(finesLevel3);

		FinesLevel finesLevel4 = new FinesLevel();
		finesLevel4.setLevelName("Mất sách");
		finesLevel4.setDescription("Sách bị mất.");
		finesLevel4.setAmount(50000);
		finesLevelRepository.save(finesLevel4);
	}



}
