/* Ejercicio 04 */

/************************************************************
	Ejecutar el script en el orden en que aparecen las 
	sentencias para evitar errores de creación de tablas, 
	borrado de datos, entre otros.
************************************************************/

CREATE DATABASE IF NOT EXISTS Centrosalud 
CHARACTER SET utf8 
COLLATE utf8_general_ci;

USE Centrosalud;

CREATE TABLE IF NOT EXISTS Medico (
    Nif CHAR(10) PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Apellidos VARCHAR(100) NOT NULL,
    Edad INT NOT NULL,
    Anio INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Paciente (
    Nif CHAR(10) PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Edad INT NOT NULL,
    Telefono VARCHAR(15),
    Med_Assig CHAR(10),

    CONSTRAINT FK_Nif FOREIGN KEY (Med_Assig) REFERENCES Medico (Nif)
);

CREATE TABLE IF NOT EXISTS Sala (
    Identificador INT PRIMARY KEY,
    Descripcion VARCHAR(300) NOT NULL
);

CREATE TABLE IF NOT EXISTS Consulta (
    Nif_med CHAR(10),
    Id_Sala INT,
    Fecha DATE,
    Hora CHAR(8) NOT NULL, 

    CONSTRAINT Pk_Consulta PRIMARY KEY (Nif_med, Id_Sala, Fecha),
    CONSTRAINT Fk_med FOREIGN KEY (Nif_med) REFERENCES Medico(Nif),
    CONSTRAINT Fk_Sala FOREIGN KEY (Id_Sala) REFERENCES Sala(Identificador)
);


