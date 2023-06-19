package com.example.cardatabase;

import com.example.cardatabase.domain.Car;
import com.example.cardatabase.domain.Owner;
import com.example.cardatabase.domain.User;
import com.example.cardatabase.repository.CarRepository;
import com.example.cardatabase.repository.OwnerRepository;
import com.example.cardatabase.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class CarDatabaseApplication implements CommandLineRunner {

    private static final Logger logger =
            LoggerFactory.getLogger(CarDatabaseApplication.class);
    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(CarDatabaseApplication.class, args);
        logger.info("Application Started@@");
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = Owner.builder()
                .firstName("John")
                .lastName("Johnson")
                .build();

        Owner owner2 = Owner.builder()
                .firstName("Mary")
                .lastName("Robinson")
                .build();

        ownerRepository.saveAll(Arrays.asList(owner1, owner2));


        Car car1 = Car.builder()
                .brand("Ford")
                .model("Mustang")
                .color("Red")
                .registerNumber("ADF-1121")
                .year(2021)
                .price(59000)
                .owner(owner1)
                .build();

        Car car2 = Car.builder()
                .brand("Nissan")
                .model("Leaf")
                .color("White")
                .registerNumber("SSJ-3002")
                .year(2019)
                .price(29000)
                .owner(owner2)
                .build();

        Car car3 = Car.builder()
                .brand("Toyota")
                .model("Prius")
                .color("Silver")
                .registerNumber("KKO-0212")
                .year(2020)
                .price(39000)
                .owner(owner2)
                .build();
        carRepository.saveAll(Arrays.asList(car1, car2, car3));
        logger.info(String.valueOf(carRepository.count()));
        for (Car car : carRepository.findAll()) {
            logger.info(car.getBrand() + " " + car.getModel());
        }

        User user1 = User.builder()
                .username("user")
                .password("$2y$05$Osc55jW/JcTbxZVoPrKA5OaphrZ5krjDFjcgdavn0V0i50xHvpaY.")
                .role("USER")
                .build();

        User user2 = User.builder()
                .username("admin")
                .password("$2y$05$iFp/42cY1b72KQ/YQ8/Os.R3aDWftr.JeQgtyQy4MZPC.Qh5szniC")
                .role("ADMIN")
                .build();
        userRepository.save(user1);
        userRepository.save(user2);

    }
}
