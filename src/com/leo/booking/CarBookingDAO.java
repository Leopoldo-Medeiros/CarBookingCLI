package com.leo.booking;

import java.util.UUID;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class CarBookingDAO {
    private static final CarBooking[] bookings = new CarBooking[10];
    private static int bookingCount = 0;

    public CarBooking[] getBookings() {
        return bookings;
    }

    public void saveBooking(CarBooking booking) {
        if(bookingCount < bookings.length) {
            bookings[bookingCount++] = booking;
        } else {
            throw new RuntimeException("Booking limit reached");
        }
    }

    public CarBooking findBookingById(UUID bookingId) {
        for(CarBooking booking : bookings) {
            if(booking != null && booking.getBookingId().equals(bookingId)) {
                return booking;
            }
        }
        throw new RuntimeException("Booking not found with ID: " + bookingId);
    }

    public void deleteBooking(UUID bookingId) {
        for(int i = 0; i < bookings.length; i++) {
            if(bookings[i] != null && bookings[i].getBookingId().equals(bookingId)) {
                bookings[i] = null;
                return;
            }
        }
        throw new RuntimeException("Booking not found with ID: " + bookingId);
    }
}
