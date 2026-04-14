package com.leo.car;

import java.util.UUID;

public class CarDAO {
    private static final Car[] cars = new Car[5];

    static {
        cars[0] = new Car(UUID.randomUUID(), "TE-001", Brand.TESLA, 29.99, true);
        cars[1] = new Car(UUID.randomUUID(), "AU-002", Brand.AUDI, 37.99, false);
        cars[2] = new Car(UUID.randomUUID(), "ME-003", Brand.MERCEDES, 45.99, false);
        cars[3] = new Car(UUID.randomUUID(), "TO-004", Brand.TOYOTA, 27.99, true);
        cars[4] = new Car(UUID.randomUUID(), "TE-005", Brand.TESLA, 36.99, true);
    }

    public Car[] getCars() {
        return cars;
    }

    public Car findCarById(UUID id) {
        for(Car car : cars) {
            if(car != null && car.getId().equals(id)) {
                return car;
            }
        }
        throw new RuntimeException("Car not found with ID: " + id);
    }
}
