INSERT INTO customer(customer_id, address, date_of_birth, email, first_name, last_name, phone_number)
VALUES
    (1,'Keskuskatu 45', '2000-11-29', 'haradas@gmail.com','Harada', 'Mizuki', 0949423422),
    (2,'Torikatu 38', '1988-03-11', 'pirkko@gmail.com','	Pirkko', 'Koskitalo', 0683526222),
    (3,'Obere Str. 57', '2003-03-03', 'mariaanders@gmail.com','Alfreds', 'Futterkiste', 0842522222),
    (4,'23 Tsawassen Blvd.', '1985-06-06', 'mariaanders@gmail.com','Tran', 'Chung Lien', 083911508),
    (5,'Mataderos 2312', '1990-03-23', 'antonio90@gmail.com','Antonio', 'Moreno', 0845572822)
ON CONFLICT DO NOTHING;

INSERT INTO event(
    event_id, event_date, event_time, event_title)
VALUES (1, '2023-04-16', '17:00:00', 'NCT DREAM TOUR THE DREAM SHOW2: IN A DREAM'),
       (2, '2023-04-30', '18:00:00', 'BILLIE EILISH 2023 WORLD TOUR'),
       (3, '2023-05-01', '9:00:00', 'BADMINTON OPEN 2023'),
       (4, '2023-05-10', '19:00:00', 'FIFA WOMEN WORLD CUP: FRANCE V JAMAICA')
    ON CONFLICT DO NOTHING;

INSERT INTO seat_zone(zone, cost)
VALUES ('A',650),
       ('B',500),
       ('C',370)
ON CONFLICT DO NOTHING;

INSERT INTO seat(seat_id, zone, is_booked)
VALUES ('A01', 'A', FALSE),
       ('A02', 'A', FALSE),
       ('A03', 'A', FALSE),
       ('A04', 'A', FALSE),
       ('A05', 'A', FALSE),
       ('A06', 'A', FALSE),
       ('A07', 'A', FALSE),
       ('A08', 'A', FALSE),
       ('A09', 'A', FALSE),
       ('A10', 'A', FALSE)
ON CONFLICT DO NOTHING;


INSERT INTO seat(
    seat_id, zone, is_booked)
VALUES ('B01', 'B', FALSE),
       ('B02', 'B', FALSE),
       ('B03', 'B', FALSE),
       ('B04', 'B', FALSE),
       ('B05', 'B', FALSE),
       ('B06', 'B', FALSE),
       ('B07', 'B', FALSE),
       ('B08', 'B', FALSE),
       ('B09', 'B', FALSE),
       ('B10', 'B',FALSE)
ON CONFLICT DO NOTHING;

INSERT INTO seat(
    seat_id, zone, is_booked)
VALUES ('C01', 'C', FALSE),
       ('C02', 'C', FALSE),
       ('C03', 'C', FALSE),
       ('C04', 'C', FALSE),
       ('C5', 'C', FALSE),
       ('C06', 'C', FALSE),
       ('C07', 'C', FALSE),
       ('C08', 'C', FALSE),
       ('C09', 'C', FALSE),
       ('C10', 'C', FALSE)
ON CONFLICT DO NOTHING;

INSERT INTO booking(booking_id,customer_id, event_id, seat_id, booking_date)
VALUES
    (1, 1, 1, 'A01', '2023-03-30'),
    (2, 2, 1, 'A06', '2023-03-31'),
    (3, 3, 2, 'A01', '2023-03-31'),
    (4, 4, 1, 'B01', '2023-04-02'),
    (5, 1, 2, 'B07', '2023-04-01'),
    (6, 1, 3, 'B02', '2023-04-05'),
    (7, 1, 4, 'A07', '2023-04-05'),
    (8, 2, 2, 'C07', '2023-04-06')
ON CONFLICT DO NOTHING;
