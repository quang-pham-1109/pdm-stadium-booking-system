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
ON CONFLICT DO NOTHING;

INSERT INTO event(
    event_id, event_date, event_time, event_title, available_seats, total_seats)
VALUES (1, '2023-04-16', '17:00:00', 'NCT DREAM TOUR THE DREAM SHOW2: IN A DREAM', 8, 10),
       (2, '2023-04-30', '18:00:00', 'BILLIE EILISH 2023 WORLD TOUR', 7, 10),
       (3, '2023-05-01', '9:00:00', 'BADMINTON OPEN 2023', 7, 10)
    ON CONFLICT DO NOTHING;

INSERT INTO seat(seat_id, event_id, is_booked)
VALUES
    ('A01', 1, TRUE),
    ('A02', 1, FALSE),
    ('A03', 1, FALSE),
    ('A04', 1, FALSE),
    ('A05', 1, FALSE),
    ('A06', 1, TRUE),
    ('A07', 1, FALSE),
    ('A08', 1, FALSE),
    ('A09', 1, FALSE),
    ('A10', 1, FALSE)
ON CONFLICT DO NOTHING;


INSERT INTO seat(seat_id, event_id, is_booked)
VALUES
    ('A01', 2, TRUE),
    ('A02', 2, TRUE),
    ('A03', 2, FALSE),
    ('A04', 2, FALSE),
    ('A05', 2, FALSE),
    ('A06', 2, FALSE),
    ('A07', 2, TRUE),
    ('A08', 2, FALSE),
    ('A09', 2, FALSE),
    ('A10', 2, FALSE)
ON CONFLICT DO NOTHING;

INSERT INTO seat(seat_id, event_id, is_booked)
VALUES
    ('A01', 3, FALSE),
    ('A02', 3, TRUE),
    ('A03', 3, FALSE),
    ('A04', 3, FALSE),
    ('A05', 3, FALSE),
    ('A06', 3, FALSE),
    ('A07', 3, TRUE),
    ('A08', 3, TRUE),
    ('A09', 3, FALSE),
    ('A10', 3, FALSE)
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
