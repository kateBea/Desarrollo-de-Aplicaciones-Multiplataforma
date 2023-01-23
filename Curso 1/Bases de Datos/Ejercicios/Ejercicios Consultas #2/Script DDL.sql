/****************************************************
Este Script contiene la definición de una tabla sencilla
perteneciente a una basa de datos MySQL.

Autor: Hugo Pelayo
Fecha: 22 de enero de 2023
Fichero: Script DDL.sql
****************************************************/

CREATE DATABASE IF NOT EXISTS Organizacion;

USE Organizacion;

CREATE TABLE IF NOT EXISTS Hospitales(
    Codigo INT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Puestos(
    # Podría haber diferente salario por mismo puesto
    Funcion VARCHAR(45),
    Salario REAL,

    CONSTRAINT Pk_Puestos PRIMARY KEY (Funcion, Salario)
);

CREATE TABLE IF NOT EXISTS Personas(
    Cod_Hospital INT NOT NULL,
    Dni VARCHAR(8) PRIMARY KEY,
    Apellidos VARCHAR(100) NOT NULL,
    Funcion VARCHAR(45) NOT NULL,
    Salario REAL NOT NULL,
    Localidad VARCHAR(45) NOT NULL,

    CONSTRAINT Fk_Funcion FOREIGN KEY (Funcion, Salario) REFERENCES Puestos(Funcion, Salario),
    CONSTRAINT Fk_Hospital FOREIGN KEY (Cod_Hospital) REFERENCES Hospitales(Codigo)
);

# Limpieza
DROP TABLE Hospital;
DROP TABLE Puestos;
DROP TABLE Personas;

DROP DATABASE Organizacion;