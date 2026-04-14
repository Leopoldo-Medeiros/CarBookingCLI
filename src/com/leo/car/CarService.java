package com.leo.car;

import java.util.UUID;

public class CarService {
    private CarDAO carDAO;

    public CarService() {
        this.carDAO = new CarDAO();
    }

    public Car[] getCars() {
        return carDAO.getCars();
    }

    public Car findCarById(UUID id) {
        return carDAO.findCarById(id);
    }
}
