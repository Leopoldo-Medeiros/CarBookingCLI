# Car Booking CLI - Phase 1

A comprehensive command-line car booking system designed for car company administrators to manage vehicle reservations efficiently.

---

## 📋 Table of Contents
- [Features](#-features)
- [Requirements](#-requirements)
- [Quick Start](#-quick-start)
- [Usage Guide](#-usage-guide)
- [Project Structure](#-project-structure)
- [Test Data](#-test-data)
- [Phase 1 Requirements](#-phase-1-requirements)

---

## 🚀 Features

### Core Functionality
- **📝 Book Car** - Complete booking workflow with user validation and date selection
- **👥 View User Booked Cars** - Display all active bookings grouped by users
- **📋 View All Bookings** - Show complete booking history with status details
- **🚗 View Available Cars** - List all available vehicles with pricing
- **⚡ View Electric Cars** - Filter and display Tesla electric vehicles
- **👤 View All Users** - Display user directory with UUID identifiers
- **🚪 Exit System** - Clean application termination

### Technical Features
- ✅ **UUID-based Identification** - Unique user and car identifiers
- ✅ **Static Seed Data** - Pre-populated with 2 users and 5 cars
- ✅ **Professional Package Structure** - Organized codebase with proper naming
- ✅ **Error Handling** - Comprehensive input validation and exception management
- ✅ **JavaDoc Documentation** - Professional code documentation

---

## 💻 Requirements

- **Java 17+** - Modern Java features and syntax
- **Terminal/Command Prompt** - For CLI interaction
- **Git** - For version control (optional)

---

## 🚀 Quick Start

### 1. Clone the Repository
```bash
git clone https://github.com/Leopoldo-Medeiros/CarBookingCLI.git
cd CarBookingCLI
```

### 2. Compile the Application
```bash
javac -cp src src/Main.java
```

### 3. Run the Application
```bash
java -cp src Main
```

---

## 📖 Usage Guide

### Main Menu
```
=== Car Booking System ===
1 - Book Car
2 - View All User Booked Cars
3 - View All Bookings
4 - View Available Cars
5 - View Available Electric Cars
6 - View all users
7 - Exit
Enter choice:
```

### Booking Process Example
1. **Select Option 1** - Book Car
2. **Choose from Available Cars:**
   ```
   1. TE-001 - TESLA - $29.99/day - ID: [uuid]
   2. AU-002 - AUDI - $37.99/day - ID: [uuid]
   ...
   ```
3. **Enter User ID:** `8ca01d13-580a-4934-bc92-50d4567b43f9` (James)
4. **Select Car Number** (1-5)
5. **Enter Dates** (YYYY-MM-DD format):
   - Start: `2026-04-05`
   - End: `2026-04-07`
6. **Confirmation:** Booking created with ID and total price

---

## 🏗️ Project Structure

```
CarBookingCLI/
├── src/
│   ├── Main.java                    # CLI interface and menu system
│   └── com/
│       └── leo/
│           ├── car/
│           │   ├── Car.java           # Car entity
│           │   ├── CarDAO.java        # Car data access
│           │   ├── CarService.java     # Car business logic
│           │   └── Brand.java         # Car brand enum
│           ├── user/
│           │   ├── User.java          # User entity
│           │   ├── UserDAO.java       # User data access
│           │   └── UserService.java    # User business logic
│           └── booking/
│               ├── CarBooking.java     # Booking entity
│               ├── CarBookingDAO.java  # Booking data access
│               ├── CarBookingService.java # Booking business logic
│               └── BookingStatus.java  # Booking status enum
├── .gitignore                     # Git ignore rules
└── README.md                      # This file
```

---

## 🧪 Test Data

### Pre-configured Users
| Name   | UUID                                    |
|--------|-----------------------------------------|
| James  | 8ca01d13-580a-4934-bc92-50d4567b43f9 |
| Jamila | 6a35029a-2782-45e3-982c-47fc9ef154c1 |

### Pre-configured Cars
| Reg No | Brand    | Price/Day | Electric |
|---------|-----------|------------|----------|
| TE-001  | TESLA     | $29.99     | ✅       |
| AU-002  | AUDI      | $37.99     | ❌       |
| ME-003  | MERCEDES  | $45.99     | ❌       |
| TO-004  | TOYOTA    | $27.99     | ✅       |
| TE-005  | TESLA     | $36.99     | ✅       |

---

## ✅ Phase 1 Requirements Status

| Requirement | Status | Implementation |
|-------------|---------|---------------|
| Book Car | ✅ Complete | User ID validation, car selection, date booking |
| View User Booked Cars | ✅ Complete | Active bookings by users |
| View All Bookings | ✅ Complete | All bookings with status |
| View Available Cars | ✅ Complete | All available cars |
| View Electric Cars | ✅ Complete | Tesla electric cars |
| View All Users | ✅ Complete | User directory |
| Exit System | ✅ Complete | Clean termination |
| POJO Classes | ✅ Complete | User, Car, CarBooking |
| Service Classes | ✅ Complete | Business logic layer |
| Package Organization | ✅ Complete | Professional structure |
| Naming Conventions | ✅ Complete | Proper standards |
| Static Data | ✅ Complete | 2 users, 5 cars |

---

## 🎯 Ready for Submission

This Phase 1 implementation is complete and ready for review:

✅ All 7 required menu options implemented
✅ Professional package structure (POJOs, Services, DAOs)
✅ Static seed data (2 users, 5 cars)
✅ Complete error handling and validation
✅ JavaDoc documentation on all methods
✅ Clean repository with professional README

**Repository:** https://github.com/Leopoldo-Medeiros/CarBookingCLI

---

*Phase 1 Complete - Ready for review and submission!* 🎉
