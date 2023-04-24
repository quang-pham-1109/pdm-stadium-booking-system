A project for Principle of Database Management Course in International University. This is a simple application that could handle booking for stadium. Currently just a barebone RESTful api, we are working on building the front-end

### Tech Stack
- **Back-end**: Spring Boot, Spring Data JPA, Spring Security
- **Front-end**: Reactjs
- **Database Management System**: PostgreSQL

### Application Properties
## Basic Functionalities
* **Sign in**: User can sign in with their username and password if they have an existing account.
* **Register**: User registers for a new username and password, add basic information like phone number, address.
* **Edit user information**: User can edit their username and other information on their profile.
* **Create a seat/book a seat**: User can book one or multiple seats of an event.
* **Check for available/booked seat**: User can check seat status.
* **Pay for booking**: User can pay for their booking.
* **Delete booking**: User can delete bookings that have not expired.

## ER Diagram 
![ER Diagram](https://i.imgur.com/qFAWFjU.jpg) "ER Diagram")

### Setting up the Backend
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

### Explore Rest APIs
The app supports the following requests

## Authentication
| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| POST   | /api/auth/signup | Sign up | [JSON](#signup) |
| POST   | /api/auth/signin | Log in | [JSON](#signin) |
Upon request, the api will return a `Json Web Token (JWT)` 

## Customer
| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| GET    | /api/v1/customer | Get all Customer information | |
| GET    | /api/v1/customer/{customerID} | Get a customer information by customerID | |
| PUT    | /api/v1/customer/{customerID} | Edit a customer information by customerID | [JSON](#editacustomer)
| DELETE | /api/v1/customer/{customerID} | Delete a customer by customerID| | 

## Booking

| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| GET    | /api/v1/booking | Get the information of all existing bookings | |
| GET    | /api/v1/booking/{bookingID} | Get information of a booking by bookingID | |
| GET    | /api/v1/booking/check-cost/{booking-id} | Get the cost of a booking by bookingID | |
| POST   | /api/v1/booking/{customerID} | Book a seat from an event of a customer by customerID | [JSON](#bookaseat) |
| PUT    | /api/v1/booking/{bookingID} | Edit information of a booking | [JSON](#editabooking |
| DELETE | /api/v1/booking/{bookingID} | Delete a booking | | |

## Event

| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| GET    | /api/v1/event | Get information of all existing event | |
| GET    | /api/v1/event/{eventID} | Get information of an event by eventID | |
| PUT    | /api/v1/event/{eventID} | Edit an event by eventID | [JSON](#editanevent) |
| DELETE | /api/v1/event/{eventID} | Delete an event by eventID | |

## Seat

| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| GET    | /api/v1/seat | Get Information of all seats | |
| GET    | /api/v1/seat/{seatID} | Get information of a single seat | | 
| GET    | /api/v1/seat/booked/{eventID} | Get all booked seat of an event by eventID | |
| GET    | /api/v1/seat/available/{eventID} | Get all available seat of an event by eventID | |
| GET    | /api/v1/seat/cost/{seatID} | Get price of a seat by seatID | |

## Seat Zone

| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| GET    | /api/v1/seat-zone | Get all Seat Zone information and pricing | |
| PUT    | /api/v1/seat-zone/{zone}/{price} | Change seat zone price by {price} | | 




