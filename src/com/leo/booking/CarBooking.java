package com.leo.booking;

import com.leo.car.Car;
import com.leo.user.User;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.UUID;

public class CarBooking {
    private UUID bookingId;
    private User user;
    private Car car;
    private double price;
    private BookingStatus status;
    private LocalDateTime bookedAt;
    private LocalDate startDate;
    private LocalDate endDate;

    public CarBooking(UUID bookingId, User user, Car car, double price, BookingStatus status, LocalDateTime bookedAt, LocalDate startDate, LocalDate endDate) {
        this.bookingId = bookingId;
        this.user = user;
        this.car = car;
        this.price = price;
        this.status = status;
        this.bookedAt = bookedAt;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Car getCar() {
        return car;
    }

    public double getPrice() {
        return price;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public LocalDateTime getBookedAt() {
        return bookedAt;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId + " - " + user.getName() + " - " + car.getRegNumber() + " - " + status;
    }
}
