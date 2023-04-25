A project for Principle of Database Management Course in International University. This is a simple application that could handle booking for stadium. Currently just a barebone RESTful api, we are working on building the front-end

# Tech Stack
- **Back-end**: Spring Boot, Spring Data JPA, Spring Security
- **Front-end**: Reactjs
- **Database Management System**: PostgreSQL

# Application Properties
## Basic Features
* **Sign in**: User can sign in with their username and password if they have an existing account.
* **Register**: User registers for a new username and password, add basic information like phone number, address.
* **Basic Authentication**: The user's password is encrypted and the user must give a JWT Token in order to access the application
* **Edit user information**: User can edit their username and other information on their profile.
* **Create a seat/book a seat**: User can book one or multiple seats of an event.
* **Check for available/booked seat**: User can check seat status.
* **Pay for booking**: User can pay for their booking.
* **Delete booking**: User can delete bookings that have not expired.

## ER Diagram 
![ER Diagram](https://i.imgur.com/qFAWFjU.jpg)

# Setting up the Backend
**1. Clone the application**

```bash
git clone https://github.com/quang-pham-1109/pdm-stadium-booking-system.git
```

**2. Setup your PostgreSQL database**

Download PostgreSQL if you haven't. The database will be created automatically when the Spring Boot application is ran
+ Open `/backend/src/main/resources/.env`
+ Change `USER`, `USER` and `PORT` as per your PostgreSQL installation
+ Database's configuration and Sample data can be seen in `/resources/schema.sql` and `/resources/data.sql` 

**3. Run the app using Maven**

Download maven if you haven't and navigate to src folder to run the project
```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>

## Explore Rest APIs
The app supports the following requests

### Authentication
| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| POST   | /api/auth/signup | Sign up | [JSON](#signup) |
| POST   | /api/auth/signin | Log in | [JSON](#signin) |

**Note:** Upon request, the api will return a `Json Web Token (JWT)` please enter the token as `Bearer Token` in Authorization Header in order to access the application

### Customer
| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| GET    | /api/v1/customer | Get all Customer information | |
| GET    | /api/v1/customer/{customerID} | Get a customer information by customerID | |
| PUT    | /api/v1/customer/{customerID} | Edit a customer information by customerID | [JSON](#editacustomer)
| DELETE | /api/v1/customer/{customerID} | Delete a customer by customerID| | 

### Booking

| Method | Url                                                                                        | Decription | Sample Valid Request Body | 
| ------ |--------------------------------------------------------------------------------------------| ---------- | --------------------------- |
| GET    | /api/v1/booking                                                                            | Get the information of all existing bookings | |
| GET    | /api/v1/booking/get-booking?eventID={eventID}&seatID={seatID}                              | Get information of a booking | |
| GET    | /api/v1/booking/get-price-of-booking?eventID={eventID}&seatID={seatID}                     | Get the cost of a booking by bookingID | |
| GET    | /api/v1/booking/get-by-customer-id?customerID={customerID}                                 | Get all booking of a customer by customerID | |
| POST   | /api/v1/booking /create-booking?customerID={customerID}                                    | Book a seat from an event of a customer by customerID | [JSON](#bookaseat) |
| DELETE | /api/v1//booking/delete-booking?customerID={customerID}&eventID={eventID}&seatID={seatID}  | Delete a booking | | |

### Event

| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| GET    | /api/v1/event | Get information of all existing event | |
| GET    | /api/v1/event/{eventID} | Get information of an event by eventID | |
| PUT    | /api/v1/event/{eventID} | Edit an event by eventID | [JSON](#editanevent) |
| DELETE | /api/v1/event/{eventID} | Delete an event by eventID | |

### Seat

| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| GET    | /api/v1/seat | Get Information of all seats | |
| GET    | /api/v1/seat/{seatID} | Get information of a single seat | | 
| GET    | /api/v1/seat/booked/{eventID} | Get all booked seat of an event by eventID | |
| GET    | /api/v1/seat/available/{eventID} | Get all available seat of an event by eventID | |
| GET    | /api/v1/seat/cost/{seatID} | Get price of a seat by seatID | |

### Seat Zone

| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| GET    | /api/v1/seat-zone | Get all Seat Zone information and pricing | |
| PUT    | /api/v1/seat-zone/{zone}/{price} | Change seat zone price by {price} |[JSON](#editseatzoneprice) | 

## Sample Valid JSONs Request Body

#### <a id="signup">Sign Up. POST -> /api/auth/signup</a>
```json
{
    "firstName": "Quang",
    "lastName": "Pham",
    "email": "phvuquang@gmail.com",
    "dateOfBirth": "2003-11-09",
    "phoneNumber":"(+84) 12345678",
    "address": "International University",
    "password": "1234"
}
```

#### <a id="signin">Sign In. POST -> /api/auth/signin</a>
```json
{
    "email": "phvuquang@gmail.com",
    "password": "1234"
}
```
#### <a id="editacustomer">Edit a Customer with Customer ID 6 information. PUT -> /api/v1/customer/*6* </a>
```json
{
    "firstName": "Phuc",
    "lastName": "Nguen",
    "email": "phvuquang@gmail.com",
    "dateOfBirth": "2003-11-09",
    "phoneNumber":"(+84) 12345678",
    "address": "International University"
}
```
#### <a id="bookaseat">Customer with ID 6 book a seat of an event. POST -> /api/v1/booking/*6* </a>
```json
{
    "eventID": 1,
    "seatID": "A03"
}
```

#### <a id="editanevent">Edit an event with ID 1. PUT -> /api/v1/event/*1* </a>
```json
{
    "eventName": "FNATIC vs NRG: VCT Finals."
}
```
#### <a id="editseatzoneprice">Change Seat Zone A price to 100. PUT -> /api/v1/seat-zone/*A*/*100* </a>



