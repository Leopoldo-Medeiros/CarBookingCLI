package com.leo.car;

import java.util.UUID;

public class Car {
    private UUID id;
    private String regNumber;
    private Brand brand;
    private double rentalPricePerDay;
    private boolean isElectric;

    public Car(UUID id, String regNumber, Brand brand, double rentalPricePerDay, boolean isElectric) {
        this.id = id;
        this.regNumber = regNumber;
        this.brand = brand;
        this.rentalPricePerDay = rentalPricePerDay;
        this.isElectric = isElectric;
    }

    public UUID getId() {
        return id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public Brand getBrand() {
        return brand;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public boolean isElectric() {
        return isElectric;
    }

    @Override
    public String toString() {
        return regNumber + " - " + brand + " - $" + rentalPricePerDay + "/day";
    }
}
