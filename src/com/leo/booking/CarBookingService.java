package com.leo.booking;

import com.leo.car.CarDao;
import com.leo.user.UserDao;
import com.leo.user.User;
import com.leo.car.Car;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class CarBookingService {
    private CarBookingDao carBookingDao = new CarBookingDao();
    private CarDao carDao = new CarDao();
    private UserDao userDao = new UserDao();

    public CarBooking bookCar(
            UUID userId,
            UUID carId,
            LocalDate startDate,
            LocalDate endDate) {
        User user = userDao.findUserById(userId); // It searches for the user by id
        Car car = carDao.findCarById(carId); // It searches for the car by id

        if (user == null || car == null) {
            return null;
        }

        // Validating the data
        if (startDate.isBefore(LocalDate.now()) || endDate.isBefore(startDate)) {
            return null;
        }

        // I need to verify for double booking
        // Taking all bookings
        CarBooking[] existingBookings = carBookingDao.getBookings();

        for (CarBooking booking : existingBookings) {
            if (booking == null) continue;

            if (booking.getStatus() == BookingStatus.ACTIVE
                    && booking.getCar().getId().equals(carId)) {
                return null;
            }
        }

        // I need to calculate the price
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        double price = car.getDailyRentalPrice() * days;

        // Create the booking
        CarBooking newBooking = new CarBooking (
                UUID.randomUUID(),
                user,
                car,
                startDate,
                endDate,
                price,
                BookingStatus.ACTIVE,
                LocalDateTime.now()
        );

        carBookingDao.saveBooking(newBooking);
        return newBooking;
    }

    public void CancelBooking(UUID id) {
        carBookingDao.deleteBooking(id);
    }

    public CarBooking[] getBookings() {
        return carBookingDao.getBookings();
    }

    public CarBooking[] getBookingsByUser(UUID userId) {
        CarBooking[] all = carBookingDao.getBookings(); // all = Array with all reservations
        CarBooking[] result = new CarBooking[all.length]; // result = New array, with same size
        int count = 0; // count = Counter, it says what position is the array

        for (int i = 0; i <all.length; i++) {
            if (all[i] != null && all[i].getUser().getId().equals(userId)) {
                result[count] = all[i];
                count++;
            }
        }
        return result;
    }

    public CarBooking[] carBookings(UUID carId) {
        CarBooking[] all = carBookingDao.getBookings();
        CarBooking[] result = new CarBooking[all.length];
        int count = 0;

        for (int i = 0; i < all.length; i++) {
            if (all[i] != null && all[i].getUser().getId().equals(carId) ) {
                result[count] = all[i];
                count++;
            }
        }
        return result;
    }
}
