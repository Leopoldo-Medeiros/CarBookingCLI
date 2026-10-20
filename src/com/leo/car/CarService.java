package com.leo.car;

import java.util.UUID;

public class CarService {

    // CarDao instance
    private CarDao carDao = new CarDao();

    public Car[] getCars() {
        return carDao.getCars();
    }

    public Car findCarById(UUID id) {
        return carDao.findCarById(id);
    }
}
