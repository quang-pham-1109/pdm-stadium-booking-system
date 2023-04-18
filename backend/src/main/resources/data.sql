

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
    event_id, event_date, event_time, event_title, available_seats, total_seats)
VALUES (1, '2023-04-16', '17:00:00', 'NCT DREAM TOUR THE DREAM SHOW2: IN A DREAM', 8, 10),
       (2, '2023-04-30', '18:00:00', 'BILLIE EILISH 2023 WORLD TOUR', 7, 10),
       (3, '2023-05-01', '9:00:00', 'BADMINTON OPEN 2023', 7, 10)
    ON CONFLICT DO NOTHING;

INSERT INTO seat(seat_id, price)
VALUES
    ('A01', 100),
    ('A02', 100),
    ('A03', 100),
    ('A04', 100),
    ('A05', 100),
    ('A06', 100),
    ('A07', 100),
    ('A08', 100),
    ('A09', 100),
    ('A10', 100),
    ('B01', 100),
    ('B02', 100),
    ('B03', 100),
    ('B04', 100),
    ('B05', 100),
    ('B06', 100),
    ('B07', 100),
    ('B08', 100),
    ('B09', 100),
    ('B10', 100),
    ('C01', 100),
    ('C02', 100),
    ('C03', 100),
    ('C04', 100),
    ('C05', 100),
    ('C06', 100),
    ('C07', 100),
    ('C08', 100),
    ('C09', 100),
    ('C10', 100)
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


