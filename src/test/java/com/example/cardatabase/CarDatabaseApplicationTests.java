package com.example.cardatabase;

import com.example.cardatabase.controller.CarController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarDatabaseApplicationTests {

	@Autowired
	private CarController controller;
	@Test
	void contextLoads() {
		Assertions.assertThat(controller).isNotNull();
	}

}
