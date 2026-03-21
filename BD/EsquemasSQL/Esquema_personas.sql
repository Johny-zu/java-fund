CREATE DATABASE IF NOT EXISTS personas;
USE personas;

CREATE TABLE datos_personas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO datos_personas (nombre, edad, email) VALUES 
('lola avac', 28, 'vacalola@email.com'),
('Carlos gim', 34, 'curlos@email.com');

SELECT * FROM datos_personas;