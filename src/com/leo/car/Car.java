package com.leo.car;

import java.util.UUID;

public class Car {
    private UUID id;
    private String regNumber;
    private double dailyRentalPrice;
    private Brand brand;
    private boolean isElectric;

    public Car(
            UUID id,
            String regNumber,
            double dailyRentalPrice,
            Brand brand,
            boolean isElectric) {
        this.id = id;
        this.regNumber = regNumber;
        this.dailyRentalPrice = dailyRentalPrice;
        this.brand = brand;
        this.isElectric = isElectric;
    }

    public UUID getId() {
        return id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public double getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public Brand getBrand() {
        return brand;
    }

    public boolean isElectric() {
        return isElectric;
    }
}
