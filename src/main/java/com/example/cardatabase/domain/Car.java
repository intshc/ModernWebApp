package com.example.cardatabase.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand, model, color, registerNumber;

    @Column(name = "`year`")
    private int year;
    private int price;

    @Builder
    public Car(String brand, String model, String color, String registerNumber, int year, int price) {
        super();
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.year = year;
        this.price = price;
    }
}
