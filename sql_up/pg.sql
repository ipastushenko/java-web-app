-- Users
CREATE TABLE users
(
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO users (username, password) VALUES ('ipastushenko', 'password');

-- Roles
CREATE TABLE roles
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO roles (name) VALUES ('ROLE_USER');

-- UsersRoles
CREATE TABLE users_roles
(
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES users(id),
    role_id INT NOT NULL REFERENCES roles(id)
);

INSERT INTO users_roles (user_id, role_id) VALUES ((SELECT id FROM users WHERE username='ipastushenko'), (SELECT id FROM roles WHERE name='ROLE_USER'));