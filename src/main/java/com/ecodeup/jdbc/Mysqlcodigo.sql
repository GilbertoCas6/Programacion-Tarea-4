CREATE DATABASE login_db;

USE login_db;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL
);


USE login_db;

INSERT INTO usuarios (nombre, apellido, usuario, telefono, correo, contraseña) 
VALUES ('Juan', 'Pérez', 'juan123', '123456789', 'juan@example.com', '12345');
SELECT * FROM usuarios