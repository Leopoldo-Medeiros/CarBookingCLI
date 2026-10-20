package com.leo.car;

import java.util.UUID;

public class CarDao {

    private static final Car[] cars;
    private static final int carCount = 4;

    static {
        cars = new Car[carCount];
        cars[0] = new Car(
                UUID.fromString("A043EC25-6CF5-4627-88AA-66AD6E8E484E"),
                "ABC-123",
                100.0,
                Brand.TESLA,
                true
        );

        cars[1] = new Car(
                UUID.fromString("1CAE6EBF-A0D7-49BE-9F16-AD2D349369A0"),
                "ABC-456",
                120.0,
                Brand.AUDI,
                false
        );

        cars[2] = new Car(
                UUID.fromString("54CF85E4-D010-4484-9D2E-BECC51DFA779"),
                "ABC-789",
                146.0,
                Brand.MERCEDES,
                true
        );

        cars[3] = new Car(
                UUID.fromString("04C5A780-47BB-4256-9970-B023B518F707"),
                "ABC-012",
                110.0,
                Brand.TOYOTA,
                false
        );
    }

    public Car[] getCars() {
        return cars;
    }

    public Car findCarById(UUID id) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null && cars[i].getId().equals(id)) {
                return cars[i];
            }
        }
        return null;
    }
}
