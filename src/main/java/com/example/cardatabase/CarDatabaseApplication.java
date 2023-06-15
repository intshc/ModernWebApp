package com.example.cardatabase;

import com.example.cardatabase.domain.Car;
import com.example.cardatabase.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CarDatabaseApplication implements CommandLineRunner {
	private static final Logger logger=
			LoggerFactory.getLogger(CarDatabaseApplication.class);
	private final CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarDatabaseApplication.class, args);
		logger.info("Application Started@@");
	}

	@Override
	public void run(String... args) throws Exception {
		carRepository.save(Car.builder()
				.brand("Ford")
				.model("Mustang")
				.color("Red")
				.registerNumber("ADF-1121")
				.year(2021)
				.price(59000)
				.build());
		carRepository.save(Car.builder()
				.brand("Nissan")
				.model("Leaf")
				.color("White")
				.registerNumber("SSJ-3002")
				.year(2019)
				.price(29000)
				.build());
		carRepository.save(Car.builder()
				.brand("Toyota")
				.model("Prius")
				.color("Silver")
				.registerNumber("KKO-0212")
				.year(2020)
				.price(39000)
				.build());
	}
}
