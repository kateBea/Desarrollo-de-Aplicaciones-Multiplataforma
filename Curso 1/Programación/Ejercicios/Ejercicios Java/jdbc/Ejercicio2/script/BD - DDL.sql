CREATE DATABASE IF NOT EXISTS  test_programacion;

USE test_programacion;

CREATE TABLE IF NOT EXISTS Coches (
    Matricula CHAR(7) PRIMARY KEY,
    Marca INT NOT NULL,
    Modelo CHAR(45) NOT NULL,
    Fecha_Compra DATETIME NOT NULL
);

drop table Coches;

SHOW TABLES;
