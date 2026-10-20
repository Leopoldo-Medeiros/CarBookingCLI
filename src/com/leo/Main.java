package com.leo;

import com.leo.booking.CarBooking;
import com.leo.booking.CarBookingService;
import com.leo.car.CarService;
import com.leo.user.UserService;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        CarService carService = new CarService();
        CarBookingService carBookingService = new CarBookingService();

        boolean running = true;

        // To keep the menu running
        while (running) {
            System.out.println("\n=== Car Booking CLI ===");
            System.out.println("1. List users");
            System.out.println("2. List cars");
            System.out.println("3. List bookings");
            System.out.println("4. Book car");
            System.out.println("5. Cancel a booking");
            System.out.println("6. List bookings by user");
            System.out.println("7. List bookings by car");
            System.out.println("8. Exit");
            System.out.println("Choose an option");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // List users
                    System.out.println("\n=== Users ===");
                    var users = userService.getUsers();
                    for (var user : users) {
                        if (user != null) {
                            System.out.println("ID: " + user.getId() +
                                    ", Name: " +
                                    user.getName());
                        }
                    }
                    break;
                case 2:
                    // List cars
                    System.out.println("\n=== Cars ===");
                    var cars = carService.getCars();
                    for (var car : cars) {
                        if (car != null) {
                            System.out.println("ID: " + car.getId() +
                                    ", RegNumber: " + car.getRegNumber() +
                                    ", Brand: " + car.getBrand() +
                                    ", Price: " + car.getDailyRentalPrice() +
                                    ", Electric: " + car.isElectric());
                        }
                    }
                    break;
                case 3:
                    // List bookings
                    System.out.println("\n=== Bookings ===");
                    var bookings = carBookingService.getBookings();
                    for (var booking : bookings) {
                        if (booking != null) {
                            System.out.println("ID: " + booking.getId() +
                                    ", RegNumber: " + booking.getCar().getRegNumber() +
                                    ", Booking Date: " + booking.getStartDate() +
                                    ", End date: " + booking.getEndDate() +
                                    ", Status: " + booking.getStatus());
                        }
                    }
                    break;
                case 4:
                    // Book car
                    // User ID
                    System.out.println("Enter user ID");
                    String userIdText = scanner.nextLine().trim();
                    UUID userId = UUID.fromString(userIdText); // Convert text to UUID
                    System.out.println(userId);

                    System.out.println("Enter car ID");
                    String carIdText = scanner.nextLine().trim(); // To remove spaces
                    UUID carId = UUID.fromString(carIdText);
                    System.out.println(carId);

                    System.out.println("Enter Start Date");
                    String startDateText = scanner.nextLine();
                    LocalDate startDate = LocalDate.parse(startDateText);
                    System.out.println(startDate);

                    System.out.println("Enter End Date");
                    String endDateText = scanner.nextLine().trim();
                    LocalDate endDate = LocalDate.parse(endDateText);
                    System.out.println(endDateText);

                    CarBooking newBooking = carBookingService.bookCar(userId, carId, startDate, endDate);
                    if(newBooking == null) {
                        System.out.println("Booking failed");
                    } else {
                        System.out.println("Booking created successfully");
                    }
                    break;

                case 5:
                    // Cancel booking
                    System.out.println("Enter booking ID to cancel");
                    String bookingIdText = scanner.nextLine();
                    UUID bookingId = UUID.fromString(bookingIdText);
                    boolean cancelled =
                    carBookingService.CancelBooking(bookingId);

                    if (cancelled) {
                        System.out.println("Booking cancelled");
                    } else {
                        System.out.println("Booking not found");
                    }
                    break;
                case 6:
                    // List bookings by user
                    System.out.println("Enter user ID");
                    String uidText = scanner.nextLine();
                    UUID uid = UUID.fromString(uidText);
                    CarBooking[] userBookings = carBookingService.getBookingsByUser(uid);

                    for (var booking : userBookings) {
                        if (booking != null) {
                            System.out.println("ID: " + booking.getId());
                        }
                    }
                    break;
                case 7:
                    // List bookings by car
                    System.out.println("Enter car ID");
                    String cidText = scanner.nextLine();
                    UUID cid = UUID.fromString(cidText);
                    CarBooking[] carBookings = carBookingService.carBookings(cid);

                    for (var booking : carBookings) {
                        if(booking != null) {
                            System.out.println("ID: " + booking.getId());
                        }
                    }
                    break;
                case 8:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}