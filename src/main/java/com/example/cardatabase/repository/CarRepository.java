package com.example.cardatabase.repository;

import com.example.cardatabase.domain.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
}
