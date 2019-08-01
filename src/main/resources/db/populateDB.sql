DELETE FROM user_roles;
DELETE FROM users;
ALTER TABLE users ALTER COLUMN id RESTART WITH 1;

INSERT INTO users (name, email, password) VALUES
('User', 'user@gmail.com', 'password'),
('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
('ROLE_USER', 1),
('ROLE_ADMIN', 2),
('ROLE_USER', 2);