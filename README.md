# CarBookingCLI

A command-line application for managing car bookings. This Java-based CLI allows users to book cars, track rental periods, and manage booking statuses.

## Features

- **Car Management**: Manage a fleet of cars with different brands (Tesla, Audi, Toyota, Mercedes)
- **User Management**: Track users who book cars
- **Booking System**: Create and manage car bookings with start/end dates
- **Status Tracking**: Monitor booking status (Active, Cancelled, Completed)
- **Electric Vehicle Support**: Track electric vs. non-electric vehicles
- **Pricing**: Calculate rental costs based on daily rates

## Project Structure

```
CarBookingCLI/
├── src/
│   └── com/
│       └── leo/
│           ├── booking/
│           │   ├── BookingStatus.java     # Booking status enum
│           │   ├── CarBooking.java        # Booking entity
│           │   └── CarBookingService.java # Booking service logic
│           ├── car/
│           │   ├── Brand.java             # Car brand enum
│           │   └── Car.java               # Car entity
│           └── user/
│               └── User.java              # User entity
├── .gitignore
├── LICENSE
└── README.md

```
## Requirements

- Java 11 or higher
- Maven or Gradle (for dependency management)

## Building the Project

```bash
# Compile the project
javac -d out src/com/leo/**/*.java

# Or use your IDE's build functionality