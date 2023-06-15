package com.example.cardatabase.repository;

import com.example.cardatabase.domain.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car,Long> {

    //색상으로 자동차를 검색
    List<Car> findByColor(String color);

    //브랜드로 자동차를 검색하고 연도로 정렬
    List<Car> findByBrandOrderByYearAsc(String brand);

    //sql 문을 이용해 브랜드로 자동차를 검색
    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrand(String brand);

    Iterable<Car> findAll(Sort sort);

    Page<Car> findAll(Pageable pageable);

}
