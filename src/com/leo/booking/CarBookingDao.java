package com.leo.booking;

import java.util.UUID;

public class CarBookingDao {

    // Here I need implement the logic behind the CarBookingDao
    // Array of CarBooking with size 100
    private static CarBooking[] bookings = new CarBooking[100];
    // Counter of CarBooking
    private static int bookingCount = 0;

    public CarBooking[] getBookings() {
        return bookings;
    }

    public CarBooking findBookingById(UUID id) {

        // loop through array
        for(int i = 0; i < bookingCount; i++) {
            // if it's found, return the booking
            if(bookings[i] != null && bookings[i].getId().equals(id)) {
                return bookings[i];
            }
        }
        return null;
    }

    public void saveBooking(CarBooking carBooking) {
        bookings[bookingCount] = carBooking;
        bookingCount++;
    }

    // Delete a booking by id
    public void deleteBooking(UUID id) {
        CarBooking booking = findBookingById(id);
        if (booking != null) {
            booking.setStatus(BookingStatus.CANCELLED);
        }
    }

}
