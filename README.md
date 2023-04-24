A project for Principle of Database Management Course in International University. This is a simple application that could handle booking for stadium.

## Prerequisite
- **Back-end**: Spring Boot, Spring Data JPA, Spring Security
- **Front-end**: Reactjs
- **Database Management System**: PostgreSQL

##App Features
* *Sign in*: User can sign in with their username and password if they have an existing account.
* *Register*: User registers for a new username and password, add basic information like phone number, address.
* *Edit user information*: User can edit their username and other information on their profile.
* *Create a seat/book a seat*: User can book one or multiple seats of an event.
* *Pay for booking*: User can pay for their booking.
* *Delete booking*: User can delete bookings that have not expired.

## Setting up the Backend
**1. Clone the application**

```bash
git clone https://github.com/quang-pham-1109/pdm-stadium-booking-system.git
```

**2. Setup your PostgreSQL database**
The database will be created automatically when the Spring Boot application is ran
+ open `/backend/src/main/resources/.env`
+ change `USER`, `USER` and `PORT` as per your PostgreSQL installation

**3. Run the app using Maven**
```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>

## Explore Rest APIs


The app defines following CRUD APIs
