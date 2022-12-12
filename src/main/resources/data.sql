INSERT INTO roles (role_id, name) VALUES (1, "Admin");
INSERT INTO roles (role_id, name) VALUES (2, "User");

INSERT INTO user (user_id, email, first_name, last_name, password, username) VALUES (1, "akshatsinha97@gmail.com", "Akshat", "Sinha", "1234", "akshat97");

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);