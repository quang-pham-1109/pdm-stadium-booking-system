A project for the Principle of Database Management Course at International University. This is a simple application that could handle booking for the stadium. Intended to be a Full-Stack Application but due to the time constraint, we could only finish the API on time.

# Prerequisite
- **Back-end**: Spring Boot, Spring Data JPA, Spring Security
- **Database Management System**: PostgreSQL

# Application Properties
## Basic Features
* **Sign in**: User can sign in with their username and password if they have an existing account.
* **Register**: User registers for a new username and password, add basic information like phone number, and address.
* **Basic Authentication**: The user's password is encrypted and the user must give a JWT Token in order to access the application
* **Edit user information**: User can edit their username and other information on their profile.
* **Create a seat/book a seat**: User can book one or multiple seats of an event.
* **Check for available/booked seat**: User can check seat status.
* **Pay for booking**: User can check their bill and pay for their booking.
* **Delete booking**: User can delete bookings that have not expired.

## Diagrams
### ER Diagram
![ER Diagram](https://i.imgur.com/cw6wEGW.png)

### Use Case Diagram
![Use Case Diagram](https://i.imgur.com/BsOFR8Y.png)

# Setting up the Backend
**1. Clone the application**

```bash
git clone https://github.com/quang-pham-1109/pdm-stadium-booking-system.git
```

**2. Setup your PostgreSQL database**

Download PostgreSQL if you haven't. Create the database:
```bash
CREATE DATABASE "stadium-booking";
```
+ Open `/backend/src/main/resources/.env`
+ Change `USER`, `PASSWORD` and `PORT` as per your PostgreSQL installation.
+ Database's configuration and Sample data can be seen in `/resources/schema.sql` and `/resources/data.sql` respectively.

**3. Run the app using Maven**
Donwload the required dependencies.
```bash
mvn clean install
```

Navigate to src folder to run the project.
```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>

If you have trouble downloading or running the app using Maven, you could use Intellj IDE to run the application. The repository has `.idea` so Intellj could easily read and run the application.

# Explore Rest APIs
The app supports the following requests:

## Authentication
| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| POST   | /api/auth/signup | Sign up | [JSON](#signup) |
| POST   | /api/auth/signin | Log in | [JSON](#signin) |

**Note:** Upon request, the api will return a `Json Web Token (JWT)` please enter the token as `Bearer Token` in Authorization Header in order to access the application.

## Customer
| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| GET    | /api/v1/customer | Get all Customer information | |
| GET    | /api/v1/customer/{customerID} | Get a customer information by customerID | |
| PUT    | /api/v1/customer/{customerID} | Edit a customer information by customerID | [JSON](#editacustomer)
| DELETE | /api/v1/customer/{customerID} | Delete a customer by customerID| | 

## Booking

| Method | Url                                                                                        | Decription | Sample Valid Request Body | 
| ------ |--------------------------------------------------------------------------------------------| ---------- | --------------------------- |
| GET    | /api/v1/booking                                                                            | Get the information of all existing bookings | |
| GET    | /api/v1/booking/get-booking?eventID={eventID}&seatID={seatID}                              | Get information of a booking | |
| GET    | /api/v1/booking/get-price-of-booking?eventID={eventID}&seatID={seatID}                     | Get the cost of a booking by bookingID | |
| GET    | /api/v1/booking/get-by-customer-id?customerID={customerID}                                 | Get all booking of a customer by customerID | |
| POST   | /api/v1/booking /create-booking?customerID={customerID}                                    | Book a seat from an event of a customer by customerID | [JSON](#bookaseat) |
| DELETE | /api/v1//booking/delete-booking?customerID={customerID}&eventID={eventID}&seatID={seatID}  | Delete a booking | | |

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
| PUT    | /api/v1/seat-zone/{zone}/{price} | Change seat zone price by {price} |[JSON](#editseatzoneprice) | 

## Payment Bill
| Method | Url                  | Decription                       | Sample Valid Request Body | 
| ------ |----------------------|----------------------------------| --------------------------- |
| GET    | /api/v1/payment-bill | Get Information of all seats     | |
| GET    | /api/v1/payment-bill/get-by-customer-id/{customer-id} | Get all payment bill of a customer by customerID | | 

## Sample Valid JSONs Request Body

### <a id="signup">Sign Up. POST -> /api/auth/signup</a>
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

### <a id="signin">Sign In. POST -> /api/auth/signin</a>
```json
{
    "email": "phvuquang@gmail.com",
    "password": "1234"
}
```
### <a id="editacustomer">Edit a Customer with Customer ID 6 information. PUT -> /api/v1/customer/*6* </a>
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
### <a id="bookaseat">Customer with ID 6 book a seat of an event. POST -> /api/v1/booking/*6* </a>
```json
{
    "eventID": 1,
    "seatID": "A03"
}
```

### <a id="editanevent">Edit an event with ID 1. PUT -> /api/v1/event/*1* </a>
```json
{
    "eventName": "FNATIC vs NRG: VCT Finals."
}
```
### <a id="editseatzoneprice">Change Seat Zone A price to 100. PUT -> /api/v1/seat-zone/*A*/*100* </a>

## Sample User Interaction with the App

The sample user below will have the following interaction: Register -> Check All Event -> Check available seat of desired event -> Book a seat -> Recieve Payment Bill with Total Cost.

### Register

*POST* request to `/api/auth/signup` with the following body

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
*Note*: Newly registered `customerID = 6` and after the request is completed. The API will return a `JWT Token` , use this as `Bearer Token` as your Request Header in order to access the appplication.
### Check all event
*GET* request to `/api/v1/event`

Sample Response:
```json
[
    {
        "eventID": 1,
        "eventDate": "2023-04-16",
        "eventTime": "17:00:00",
        "eventTitle": "NCT DREAM TOUR THE DREAM SHOW2: IN A DREAM",
        "availableSeats": 8,
        "totalSeats": 10
    },
    {
        "eventID": 2,
        "eventDate": "2023-04-30",
        "eventTime": "18:00:00",
        "eventTitle": "BILLIE EILISH 2023 WORLD TOUR",
        "availableSeats": 7,
        "totalSeats": 10
    }
]
```

### Check all available seat of event with ID 1
*GET* request to `/api/v1/seat/available/1`

Sample Response:
```json
[
    "A02",
    "A03",
    "A04",
    "A05",
    "A07",
    "A08",
    "A09",
    "A10"
]
```
### Check price of booking 
*GET* request to `/api/v1/booking/get-price-of-booking?eventID=1&seatID=A03`

Sample Response:
```json
{
    "price": 650
}
```
### Book seat A03 of event with ID 1
*POST* request to `api/v1/booking/create-booking?customerID=7`
```json
{
    "eventID": 1,
    "seatID": "A03"
}
```
### Book seat B03 of event with ID 1
*POST* request to `api/v1/booking/create-booking?customerID=1`
```json
{
    "eventID": 1,
    "seatID": "B03"
}
```
### Checkout with Payment Bill
*GET* request to `api/v1/payment-bill/get-by-customer-id/6`
```json
{
    "paymentID": 7,
    "customerID": 6,
    "eventID": 1,
    "billDate": "2023-30-4",
    "totalCost": 1150
}
```
*Note:* The Bill Date will be automatically assigned to the current date of booking.

# Contact
If you have any questions regarding the project, feel free the email me at phvuquang@gmail.com or ITITIU21096@student.hcmiu.edu.vn. Fellow IUers are always welcome!
