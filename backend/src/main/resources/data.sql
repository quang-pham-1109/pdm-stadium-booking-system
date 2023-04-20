

INSERT INTO customer(customer_id,
                     address,
                     date_of_birth,
                     email,
                     first_name,
                     last_name,
                     phone_number,
                     role)
VALUES
    (1,'Keskuskatu 45', '2000-11-29', 'haradas@gmail.com','Harada', 'Mizuki', 0949423422, 'USER'),
    (2,'Torikatu 38', '1988-03-11', 'pirkko@gmail.com','	Pirkko', 'Koskitalo', 0683526222, 'USER' ),
    (3,'Obere Str. 57', '2003-03-03', 'mariaanders@gmail.com','Alfreds', 'Futterkiste', 0842522222, 'USER'),
    (4,'23 Tsawassen Blvd.', '1985-06-06', 'mariaanders@gmail.com','Tran', 'Chung Lien', 083911508, 'USER'),
    (5,'Mataderos 2312', '1990-03-23', 'antonio90@gmail.com','Antonio', 'Moreno', 0845572822, 'USER')
ON CONFLICT DO NOTHING ;

INSERT INTO event(
                  event_id,
                  event_date,
                  event_time,
                  event_title,
                  available_seats,
                  total_seats)
VALUES (1, '2023-04-16', '17:00:00', 'NCT DREAM TOUR THE DREAM SHOW2: IN A DREAM', 8, 10),
       (2, '2023-04-30', '18:00:00', 'BILLIE EILISH 2023 WORLD TOUR', 7, 10),
       (3, '2023-05-01', '9:00:00', 'BADMINTON OPEN 2023', 7, 10)
    ON CONFLICT DO NOTHING;

INSERT INTO seat_zone(zone, cost)
VALUES ('A',650),
       ('B',500),
       ('C',370)
ON CONFLICT DO NOTHING;

INSERT INTO seat(seat_id, zone)
VALUES
    ('A01', 'A'),
    ('A02', 'A'),
    ('A03', 'A'),
    ('A04', 'A'),
    ('A05', 'A'),
    ('A06', 'A'),
    ('A07', 'A'),
    ('A08', 'A'),
    ('A09', 'A'),
    ('A10', 'A'),
    ('B01', 'B'),
    ('B02', 'B'),
    ('B03', 'B'),
    ('B04', 'B'),
    ('B05', 'B'),
    ('B06', 'B'),
    ('B07', 'B'),
    ('B08', 'B'),
    ('B09', 'B'),
    ('B10', 'B'),
    ('C01', 'C'),
    ('C02', 'C'),
    ('C03', 'C'),
    ('C04', 'C'),
    ('C05', 'C'),
    ('C06', 'C'),
    ('C07', 'C'),
    ('C08', 'C'),
    ('C09', 'C'),
    ('C10', 'C')
ON CONFLICT DO NOTHING;

INSERT INTO booking(booking_id,customer_id, event_id, seat_id, booking_date)
VALUES
    (1, 1, 1, 'A01', '2023-03-30'),
    (2, 2, 1, 'A06', '2023-03-31'),
    (3, 3, 2, 'A01', '2023-03-31'),
    (4, 2, 2, 'A02', '2023-04-02'),
    (5, 1, 2, 'A07', '2023-04-01'),
    (6, 1, 3, 'A02', '2023-04-05'),
    (7, 1, 3, 'A07', '2023-04-05'),
    (8, 2, 3, 'A08', '2023-04-06')
ON CONFLICT DO NOTHING;




