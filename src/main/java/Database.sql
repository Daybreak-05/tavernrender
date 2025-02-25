-- Crear la base de datos
CREATE DATABASE anuncioss;

-- Usar la base de datos creada
USE Anuncioss;

-- Crear la tabla de misiones
CREATE TABLE misiones (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(255) NOT NULL,
                          descripcion TEXT,
                          completado BOOLEAN NOT NULL
);

-- Crear la tabla de eventos
CREATE TABLE eventos (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(255) NOT NULL,
                         descripcion TEXT,
                         fecha DATE NOT NULL
);
