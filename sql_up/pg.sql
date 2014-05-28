CREATE TABLE users
(
    id INT NOT NULL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO users (id, username, password) VALUES (1, 'ipastushenko', 'password');