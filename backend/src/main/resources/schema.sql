drop sequence if exists customer_seq;

drop sequence if exists  booking_seq;

drop sequence if exists event_seq;

drop table if exists booking;

drop table if exists customer;

drop table if exists seat;

drop table if exists event;

SELECT 'CREATE DATABASE stadium-booking'
WHERE NOT EXISTS (SELECT FROM pg_database
                         WHERE datname = 'stadium-booking');


CREATE TABLE IF NOT EXISTS customer (
        customer_id int not null,
        address varchar(50),
        date_of_birth date,
        email varchar(50),
        first_name varchar(50) not null,
        last_name varchar(50) not null,
        phone_number varchar(50),
        password varchar,
        role varchar(50),
        booking_id int,
        primary key (customer_id)
    );

CREATE TABLE IF NOT EXISTS event (
        event_id int not null,
        event_date date,
        event_time time,
		event_title varchar(100),
		available_seats int,
		total_seats int,
        primary key (event_id)
    );

CREATE TABLE IF NOT EXISTS seat (
        seat_id varchar(10) not null,
        is_booked BOOLEAN NOT NULL ,
        price int,
        primary key (seat_id)
    );

CREATE TABLE IF NOT EXISTS booking (
        booking_id int not null,
        customer_id int not null,
        event_id int not null,
        seat_id varchar(10) not null,
		booking_date date,
        primary key (booking_id)
    );
ALTER TABLE booking DROP CONSTRAINT IF EXISTS FK_CustomerBooking;

ALTER TABLE booking
       add constraint FK_CustomerBooking
       foreign key (customer_id)
       references customer(customer_id);

ALTER TABLE booking DROP CONSTRAINT IF EXISTS FK_EventBooking;

ALTER TABLE booking
       add constraint FK_EventBooking
       foreign key (event_id)
       references event(event_id);

ALTER TABLE booking DROP CONSTRAINT IF EXISTS FK_SeatBooking;

ALTER TABLE booking
       add constraint FK_SeatBooking
       foreign key (seat_id)
       references seat(seat_id);

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


