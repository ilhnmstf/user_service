INSERT INTO country (title)
VALUES
    ('Russia'),
    ('United States'),
    ('United Kingdom'),
    ('Australia'),
    ('France');

INSERT INTO users (username, email, phone, password, active, about_me, country_id, city, created_at, updated_at)
VALUES
    ('JohnDoe', 'johndoe@example.com', '1234567890', 'password1', true, 'About John Doe', 1, 'New York', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('JaneSmith', 'janesmith@example.com', '0987654321', 'password2', true, 'About Jane Smith', 2, 'London', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('MichaelJohnson', 'michaeljohnson@example.com', '1112223333', 'password3', true, 'About Michael Johnson', 1, 'Sydney', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('EmilyDavis', 'emilydavis@example.com', '4445556666', 'password4', true, 'About Emily Davis', 3, 'Paris', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('WilliamTaylor', 'williamtaylor@example.com', '7778889999', 'password5', true, 'About William Taylor', 2, 'Toronto', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('OliviaAnderson', 'oliviaanderson@example.com', '0001112222', 'password6', true, 'About Olivia Anderson', 5, 'Berlin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('JamesWilson', 'jameswilson@example.com', '3334445555', 'password7', true, 'About James Wilson', 5, 'Tokyo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('SophiaMartin', 'sophiamartin@example.com', '6667778888', 'password8', true, 'About Sophia Martin', 4, 'Rome', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('BenjaminThompson', 'benjaminthompson@example.com', '9990001111', 'password9', true, 'About Benjamin Thompson', 4, 'Moscow', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('AvaHarris', 'avaharris@example.com', '2223334444', 'password10', true, 'About Ava Harris', 3, 'Madrid', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);