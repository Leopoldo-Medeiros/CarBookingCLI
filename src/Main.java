import com.leo.car.CarService;
import com.leo.user.UserService;
import com.leo.booking.CarBookingService;
import com.leo.car.Car;
import com.leo.user.User;
import com.leo.booking.CarBooking;

import java.util.Scanner;
import java.util.UUID;
import java.time.LocalDate;

public class Main {
    private static CarService carService = new CarService();
    private static UserService userService = new UserService();
    private static CarBookingService bookingService = new CarBookingService();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Main entry point for the Car Booking CLI application
     * Displays menu and handles user interaction loop
     */
    public static void main(String[] args) {
        while(true) {
            displayMenu();
            switch(getIntInput()) {
                case 1: bookCar(); break;
                case 2: viewUserBookedCars(); break;
                case 3: viewAllBookings(); break;
                case 4: viewAvailableCars(); break;
                case 5: viewElectricCars(); break;
                case 6: viewAllUsers(); break;
                case 7: System.out.println("Goodbye!"); System.exit(0);
                default: System.out.println("Invalid choice.");
            }
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }

    /**
     * Main menu
     */
    private static void displayMenu() {
        System.out.println("\n=== Car Booking System ===");
        System.out.println("1 - Book Car");
        System.out.println("2 - View All User Booked Cars");
        System.out.println("3 - View All Bookings");
        System.out.println("4 - View Available Cars");
        System.out.println("5 - View Available Electric Cars");
        System.out.println("6 - View all users");
        System.out.println("7 - Exit");
        System.out.print("Enter choice: ");
    }

    /**
     * Reads and validates integer input from user
     * @return parsed integer or -1 if invalid input
     */
    private static int getIntInput() {
        try { 
            String input = scanner.nextLine();
            return input.isEmpty() ? -1 : Integer.parseInt(input); 
        }
        catch(Exception e) { return -1; }
    }

    /**
     * Reads and validates UUID input from user
     * @return parsed UUID or null if invalid input
     */
    private static UUID getUUIDInput() {
        try { 
            String input = scanner.nextLine();
            return input.isEmpty() ? null : UUID.fromString(input); 
        }
        catch(Exception e) { return null; }
    }

    /**
     * Handles the car booking process
     * Shows available cars, validates user, gets dates, creates booking
     */
    private static void bookCar() {
        System.out.println("\n--- Book a Car ---");
        Car[] cars = carService.getCars();
        int count = 0;
        for(Car car : cars) if(car != null)
            System.out.println(++count + ". " + car.getRegNumber() + " - " + car.getBrand() + " - $" + car.getRentalPricePerDay() + "/day - ID: " + car.getId());

        if(count == 0) {
            System.out.println("No cars available.");
            return;
        }

        System.out.print("Enter User ID: ");
        UUID userId = getUUIDInput();
        if(userId == null) {
            System.out.println("Invalid User ID.");
            return;
        }

        try {
            userService.findUserById(userId);
        }
        catch(Exception e) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter car number: ");
        int carChoice = getIntInput();
        if(carChoice < 1 || carChoice > count) {
            System.out.println("Invalid selection.");
            return;
        }

        Car selectedCar = null;
        count = 0;
        for(Car car : cars) {
            if(car != null) {
                if(++count == carChoice) { selectedCar = car;
                    break;
                }
            }
        }

        System.out.print("Enter start date (YYYY-MM-DD): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter end date (YYYY-MM-DD): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());

        try {
            CarBooking booking = bookingService.bookCar(userId, selectedCar.getId(), startDate, endDate);
            System.out.println("✅ Booking successful! ID: " + booking.getBookingId() + " Price: $" + booking.getPrice());
        } catch(Exception e) {
            System.out.println("❌ Booking failed: " + e.getMessage());
        }
    }

    /**
     * Displays all active bookings grouped by users
     * Shows user name, car details, and booking information
     */
    private static void viewUserBookedCars() {
        System.out.println("\n--- All User Booked Cars ---");
        for(CarBooking booking : bookingService.getBookings())
            if(booking != null && booking.getStatus().name().equals("ACTIVE"))
                System.out.println("📗 " + booking.getUser().getName() + " - " + booking.getCar().getRegNumber() + " - $" + booking.getPrice());
    }

    /**
     * Displays all bookings in the system
     * Shows both active and inactive bookings with full details
     */
    private static void viewAllBookings() {
        System.out.println("\n--- All Bookings ---");
        for(CarBooking booking : bookingService.getBookings())
            if(booking != null)
                System.out.println("📋 " + booking.getUser().getName() + " - " + booking.getCar().getRegNumber() + " - " + booking.getStatus());
    }

    /**
     * Displays all available cars in the system
     * Shows car registration, brand, price, and unique ID
     */
    private static void viewAvailableCars() {
        System.out.println("\n--- Available Cars ---");
        for(Car car : carService.getCars())
            if(car != null)
                System.out.println("🚗 " + car.getRegNumber() + " - " + car.getBrand() + " - $" + car.getRentalPricePerDay() + "/day - ID: " + car.getId());
    }

    /**
     * Displays all electric cars (Tesla) in the system
     * Filters for electric cars and shows their details
     */
    private static void viewElectricCars() {
        System.out.println("\n--- Electric Cars ---");
        for(Car car : carService.getCars())
            if(car != null && car.isElectric())
                System.out.println("⚡ " + car.getRegNumber() + " - $" + car.getRentalPricePerDay() + "/day - ID: " + car.getId());
    }

    /**
     * Displays all users in the system
     * Shows user name and their unique UUID
     */
    private static void viewAllUsers() {
        System.out.println("\n--- All Users ---");
        for(User user : userService.getUsers())
            if(user != null)
                System.out.println("👤 " + user.getName() + " - ID: " + user.getId());
    }
}
