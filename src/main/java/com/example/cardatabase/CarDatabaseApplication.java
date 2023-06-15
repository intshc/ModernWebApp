package com.example.cardatabase;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CarDatabaseApplication {
	private static final Logger logger=
			LoggerFactory.getLogger(CarDatabaseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarDatabaseApplication.class, args);
		logger.info("Application Started@@");
//		log.info("Application Started!!");
	}

}
