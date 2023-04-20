DROP SEQUENCE IF EXISTS booking_seq;

DROP SEQUENCE IF EXISTS event_seq;

DROP TABLE IF EXISTS customer CASCADE ;

DROP TABLE IF EXISTS seat CASCADE ;

DROP TABLE IF EXISTS event CASCADE ;

SELECT 'CREATE DATABASE stadium-booking'
WHERE NOT EXISTS (SELECT FROM pg_database
                         WHERE datname = 'stadium-booking');


CREATE TABLE IF NOT EXISTS customer (
        customer_id int NOT NULL,
        address varchar(50),
        date_of_birth date,
        email varchar(50),
        first_name varchar(50) NOT NULL,
        last_name varchar(50) NOT NULL,
        phone_number varchar(50),
        password varchar,
        role varchar(50),
        booking_id int,
        primary key (customer_id)
    );

CREATE TABLE IF NOT EXISTS event (
        event_id int NOT NULL,
        event_date date,
        event_time time,
		event_title varchar(100),
		available_seats int,
		total_seats int,
        primary key (event_id)
    );

CREATE TABLE IF NOT EXISTS seat (
        seat_id varchar(10) NOT NULL,
        zone varchar(2),
        primary key (seat_id)
    );

CREATE TABLE IF NOT EXISTS seat_zone (
    zone varchar(2) NOT NULL,
    cost int,
    PRIMARY KEY (zone)
);


CREATE TABLE IF NOT EXISTS booking (
        booking_id int NOT NULL,
        customer_id int NOT NULL,
        event_id int,
        seat_id varchar(10),
		booking_date date,
        primary key (booking_id)
    );


ALTER TABLE booking DROP CONSTRAINT IF EXISTS FK_CustomerBooking;

ALTER TABLE booking
       ADD CONSTRAINT FK_CustomerBooking
       FOREIGN KEY (customer_id)
       REFERENCES customer(customer_id);

ALTER TABLE booking DROP CONSTRAINT IF EXISTS FK_EventBooking;

ALTER TABLE booking
       ADD CONSTRAINT FK_EventBooking
       FOREIGN KEY (event_id)
       REFERENCES event(event_id);

ALTER TABLE booking DROP CONSTRAINT IF EXISTS FK_SeatBooking;

ALTER TABLE booking
       ADD CONSTRAINT FK_SeatBooking
       FOREIGN KEY (seat_id)
       REFERENCES seat(seat_id);

ALTER TABLE seat DROP CONSTRAINT IF EXISTS FK_SeatZoneSeat;

ALTER TABLE seat
    ADD CONSTRAINT FK_SeatZoneSeat
    FOREIGN KEY (zone)
    REFERENCES seat_zone(zone);

CREATE SEQUENCE IF NOT EXISTS customer_seq
    START WITH 6
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE SEQUENCE IF NOT EXISTS booking_seq
    START WITH 9
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



