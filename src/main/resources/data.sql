INSERT INTO roles (role_id, name) VALUES (1, "Admin");
INSERT INTO roles (role_id, name) VALUES (2, "User");

INSERT INTO user (id, email, first_name, last_name, password, username) VALUES (1, "akshatsinha97@gmail.com", "Akshat", "Sinha","$2a$10$sYz0n1EoN64DRCgmQ03uMOX.jwtNo8QAK9v2E3G4ekC1KB8NAz8TW" , "akshat97");

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);