package com.leo.booking;

import com.leo.car.Car;
import com.leo.car.CarService;
import com.leo.user.User;
import com.leo.user.UserService;
import java.util.UUID;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CarBookingService {
    private CarBookingDAO bookingDAO;
    private CarService carService;
    private UserService userService;

    public CarBookingService() {
        this.bookingDAO = new CarBookingDAO();
        this.carService = new CarService();
        this.userService = new UserService();
    }

    public CarBooking[] getBookings() {
        return bookingDAO.getBookings();
    }

    public CarBooking findBookingById(UUID bookingId) {
        return bookingDAO.findBookingById(bookingId);
    }

    public void deleteBooking(UUID bookingId) {
        bookingDAO.deleteBooking(bookingId);
    }

    public CarBooking bookCar(UUID userId, UUID carId, LocalDate startDate, LocalDate endDate) {
        User user = userService.findUserById(userId);
        Car car = carService.findCarById(carId);

        long days = ChronoUnit.DAYS.between(startDate, endDate);
        if(days <= 0) {
            throw new RuntimeException("End date must be after start date");
        }

        double totalPrice = car.getRentalPricePerDay() * days;
        UUID bookingId = UUID.randomUUID();

        CarBooking booking = new CarBooking(
            bookingId,
            user,
            car,
            totalPrice,
            BookingStatus.ACTIVE,
            LocalDateTime.now(),
            startDate,
            endDate
        );

        bookingDAO.saveBooking(booking);
        return booking;
    }
}
