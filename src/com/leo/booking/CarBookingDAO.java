package com.leo.booking;

import java.util.Arrays;
import java.util.UUID;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class CarBookingDAO {

    private static CarBooking[] bookings = new CarBooking[1];

    public CarBooking[] getBookings() {
        int count = 0;
        for (CarBooking booking : bookings) {
            if (booking != null) {
                count++;
            }
        }

        CarBooking[] actualBookings = new CarBooking[count];
        int index = 0;
        for (CarBooking booking : bookings) {
            if (booking != null) {
                actualBookings[index++] = booking;
            }
        }

        return actualBookings;
    }

    public void saveBooking(CarBooking booking) {
        int index = 0;
        for (int i = 0; i < bookings.length; i++) {
            index = i;
            if (bookings[i] == null) {
                bookings[i] = booking;
                return;
            }
        }

        bookings = Arrays.copyOf(bookings, bookings.length * 2);

        bookings[++index] = booking;
    }

    public CarBooking findBookingById(UUID bookingId) {
        for(CarBooking booking : bookings) {
            if(booking != null && booking.getBookingId().equals(bookingId)) {
                return booking;
            }
        }
        return null;
    }

    public boolean deleteBooking(UUID bookingId) {
        for(int i = 0; i < bookings.length; i++) {
            if(bookings[i] != null && bookings[i].getBookingId().equals(bookingId)) {
                bookings[i] = null;
                return true;
            }
        }
        return false;
    }
}
