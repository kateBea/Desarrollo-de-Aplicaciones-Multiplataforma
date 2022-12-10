/* Ejercicio 05 */

/************************************************************
	Ejecutar el script en el orden en que aparecen las 
	sentencias para evitar errores de creación de tablas, 
	borrado de datos, entre otros
************************************************************/


CREATE DATABASE IF NOT EXISTS Banco 
CHARACTER SET utf8 
COLLATE utf8_general_ci;

USE Banco;

CREATE TABLE IF NOT EXISTS Cliente (
	Dni CHAR(10) PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL UNIQUE,
    Apellidos VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Sucursal (
	Numero CHAR(30) PRIMARY KEY,
    Ciudad CHAR(100) NOT NULL,
    Activo_actual DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS Cuenta (
	Numero CHAR(30),
    Num_sucursal INT,
	Saldo DOUBLE NOT NULL,
    
    PRIMARY KEY(Numero, Num_sucursal),
    CONSTRAINT Fk_numSucursal FOREIGN KEY (Num_sucursal) REFERENCES Sucursal(Numero)
);

CREATE TABLE IF NOT EXISTS Transaccion (
	Numero INT PRIMARY KEY,
    Fecha DATE NOT NULL,
    Tipo CHAR(3) NOT NULL CHECK (Tipo IN ('Ing', 'Ext')),
    Cantidad DOUBLE,
    Num_cuenta CHAR(30) NOT NULL,
    
    CONSTRAINT Fk_cuenta FOREIGN KEY (Num_cuenta) REFERENCES Cuenta (Numero)
);

/* Tabla inecesaria */
CREATE TABLE IF NOT EXISTS Asistencia (
	Dni_cliente CHAR(10),
    Num_sucursal INT,
    
    PRIMARY KEY (Dni_cliente, Num_sucursal),
    CONSTRAINT Fk_Asistencia1 FOREIGN KEY (Dni_cliente) REFERENCES Cliente (Dni),
    CONSTRAINT Fk_Asistencia2 FOREIGN KEY (Num_sucursal) REFERENCES Sucursal (Numero)
);

CREATE TABLE IF NOT EXISTS Propiedad (
	Dni_cliente CHAR(10),
    Num_cuenta CHAR(30),
    Num_sucursal CHAR(30),
    
    PRIMARY KEY (Dni_cliente, Num_cuenta, Num_sucursal),
    CONSTRAINT Fk_Propiedad1 FOREIGN KEY (Dni_cliente) REFERENCES Cliente (Dni),
    CONSTRAINT Fk_Propiedad2 FOREIGN KEY (Num_cuenta) REFERENCES Cuenta (Numero),
    CONSTRAINT Fk_Propiedad3 FOREIGN KEY (Num_sucursal) REFERENCES Sucursal (Numero)
);

CREATE TABLE IF NOT EXISTS Direccion (
	Dni_cliente CHAR(10),
    Calle CHAR(100),
    Codigo_postal INT,
    Ciudad CHAR(45),
    Pais CHAR(45),
    
    PRIMARY KEY (Dni_cliente, Calle, Codigo_postal, Ciudad, Pais),
    CONSTRAINT Fk_Direccion FOREIGN KEY (Dni_cliente) REFERENCES Cliente (Dni)
);

/* Consultas*/
SELECT * FROM Cliente;
SELECT * FROM Sucursal;
SELECT * FROM Direccion;
SELECT * FROM Propiedad;
SELECT * FROM Asistencia;
SELECT * FROM Transaccion;
SELECT * FROM Cuenta;

/* Inserts en tabla Cliente */
INSERT INTO Cliente VALUES('12345679-K', 'Raúl García');
INSERT INTO Cliente VALUES('87355679-F', 'José Pablo');
INSERT INTO Cliente VALUES('29861338-T', 'María Gisbert');
INSERT INTO Cliente VALUES('19746836-W', 'Roberto Torres');
INSERT INTO Cliente VALUES('89374827-E', 'José María');
INSERT INTO Cliente VALUES('87478261-W', 'Juan Antonio');
INSERT INTO Cliente VALUES('20589673-R', 'Albert Gisbert');
INSERT INTO Cliente VALUES('89374692-Y', 'Ferrán Giménez');
INSERT INTO Cliente VALUES('20383792-P', 'Roberto Carlos');
INSERT INTO Cliente VALUES('19374613-N', 'Cynthia Cirilla');

/* Inserts en tabla Sucursal */
INSERT INTO Sucursal VALUES();

/* Inserts en tabla Cuenta */
INSERT INTO Cuenta VALUES();

/* Inserts en tabla Transaccion */
INSERT INTO Transaccion VALUES();

/* Inserts en tabla Asistencia */
INSERT INTO Asistencia VALUES();

/* Inserts en tabla Propiedad */
INSERT INTO Propiedad VALUES();

/* Inserts en tabla Direccion */
INSERT INTO Direccion VALUES();

/* Limpieza */
TRUNCATE Direccion;
TRUNCATE Propiedad;
TRUNCATE Asistencia;
TRUNCATE Transaccion;
TRUNCATE Cuenta;
TRUNCATE Sucursal;
TRUNCATE Cliente;

DROP TABLE Direccion;
DROP TABLE Propiedad;
DROP TABLE Asistencia;
DROP TABLE Transaccion;
DROP TABLE Cuenta;
DROP TABLE Sucursal;
DROP TABLE Cliente;

DROP DATABASE Banco;