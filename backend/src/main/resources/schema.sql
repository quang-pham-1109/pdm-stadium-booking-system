DROP SEQUENCE IF EXISTS customer_seq CASCADE;

DROP SEQUENCE IF EXISTS event_seq CASCADE;

DROP TABLE IF EXISTS seat_zone CASCADE;

DROP TABLE IF EXISTS booking CASCADE;

DROP TABLE IF EXISTS customer CASCADE;

DROP TABLE IF EXISTS event CASCADE;

DROP TABLE IF EXISTS seat CASCADE;

DROP TABLE IF EXISTS payment_bill CASCADE;

SELECT 'CREATE DATABASE stadium-booking'
WHERE NOT EXISTS (SELECT FROM pg_database
                         WHERE datname = 'stadium-booking');


CREATE TABLE customer (
    customer_id int NOT NULL,
    address varchar(50),
    date_of_birth date,
    email varchar(50),
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    phone_number varchar(50),
    password varchar,
    role varchar(50),
    primary key (customer_id)
);

CREATE TABLE event (
    event_id int NOT NULL,
    event_date date,
    event_time time,
    event_title varchar(100),
    available_seats int,
    total_seats int,
    primary key (event_id)
);

CREATE TABLE seat (
    seat_id varchar(10) NOT NULL,
    zone varchar(2),
    primary key (seat_id)
);

CREATE TABLE seat_zone (
    zone varchar(2) NOT NULL,
    cost int,
    PRIMARY KEY (zone)
);

CREATE TABLE booking (
    customer_id int NOT NULL,
    event_id int,
    seat_id varchar(10),
    booking_date date,
    PRIMARY KEY (event_id, seat_id)
);

CREATE TABLE payment_bill(
    payment_id int NOT NULL,
    customer_id int,
    event_id int,
    payment_date date,
    total_cost int,
    PRIMARY KEY (payment_id)
);

ALTER TABLE booking DROP CONSTRAINT IF EXISTS FK_CustomerBooking;

ALTER TABLE booking
       ADD CONSTRAINT FK_CustomerBooking
       FOREIGN KEY (customer_id)
       REFERENCES customer(customer_id) ON DELETE CASCADE;

ALTER TABLE booking DROP CONSTRAINT IF EXISTS FK_EventBooking;

ALTER TABLE booking
       ADD CONSTRAINT FK_EventBooking
       FOREIGN KEY (event_id)
       REFERENCES event(event_id) ON DELETE CASCADE;

ALTER TABLE booking DROP CONSTRAINT IF EXISTS FK_SeatBooking;

ALTER TABLE booking
       ADD CONSTRAINT FK_SeatBooking
       FOREIGN KEY (seat_id)
       REFERENCES seat(seat_id) ON DELETE CASCADE;

ALTER TABLE seat DROP CONSTRAINT IF EXISTS FK_SeatZoneSeat;

ALTER TABLE seat
    ADD CONSTRAINT FK_SeatZoneSeat
    FOREIGN KEY (zone)
    REFERENCES seat_zone(zone);

ALTER TABLE payment_bill DROP CONSTRAINT IF EXISTS FK_CustomerBill;

ALTER TABLE payment_bill
    ADD CONSTRAINT FK_CustomerBill
    FOREIGN KEY (customer_id)
    REFERENCES customer(customer_id) ON DELETE CASCADE;

ALTER TABLE payment_bill DROP CONSTRAINT IF EXISTS FK_EventBill;

ALTER TABLE payment_bill
    ADD CONSTRAINT FK_EventBill
    FOREIGN KEY (event_id)
    REFERENCES event(event_id) ON DELETE CASCADE;

CREATE SEQUENCE IF NOT EXISTS customer_seq
    START WITH 6
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE SEQUENCE IF NOT EXISTS event_seq
    START WITH 6
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE SEQUENCE IF NOT EXISTS bill_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


