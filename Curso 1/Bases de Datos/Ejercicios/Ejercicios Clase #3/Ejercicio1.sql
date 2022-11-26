/* Ejercicio 01 */
CREATE DATABASE IF NOT EXISTS EMPRESA 
CHARACTER SET utf8 
COLLATE utf8_general_ci;

USE EMPRESA;

CREATE TABLE IF NOT EXISTS Departamento (
	codDpto VARCHAR (4) PRIMARY KEY,
	nombreDpto VARCHAR(20) NOT NULL,
	ciudad VARCHAR(15),
	codDirector VARCHAR (10)
);

CREATE TABLE IF NOT EXISTS Empleado (
	codEmp VARCHAR(10) NOT NULL PRIMARY KEY,
	nomEmp VARCHAR(30) NOT NULL,
	sexEmp CHAR(1) NOT NULL CHECK (sexEmp IN ('F','M')),
	fecNac DATE NOT NULL,
	fecIncorporacion DATE NOT NULL,
	salEmp FLOAT NOT NULL,
	comisionE FLOAT NOT NULL,
	cargoE VARCHAR(15) NOT NULL,
	nroDpto VARCHAR(4) NOT NULL,
	CONSTRAINT	FK_Dpto FOREIGN KEY (nroDpto) REFERENCES Departamento (codDpto)    
);

SELECT * 
FROM Departamento;

SELECT * 
FROM Empleado;

/* Inserts en Departamento */
INSERT INTO Departamento VALUES ('1000', 'GERENCIA', 'MADRID', '32.526.220');
INSERT INTO Departamento VALUES ('2000', 'PRODUCCIÓN', 'MADRID', '16.215.250');
INSERT INTO Departamento VALUES ('2500', 'VENTAS', 'BARCELONA', '20.648.351');
INSERT INTO Departamento VALUES ('3000', 'INVESTIGACIÓN', 'BARCELONA', '75.745.745');
INSERT INTO Departamento VALUES ('4000', 'VENTAS', 'SEVILLA', '14.142.142');
INSERT INTO Departamento VALUES ('4500', 'INVESTIGACIÓN', 'SEVILLA', '36.361.361');

/* Inserts en Empleado */
/* NOTA: El formato correcto de fecha usado es YYYY-MM-DD donde YYYY representa el año,
MM representa el mes y DD representa el día */
INSERT INTO Empleado VALUES ('31.840.269', 'María Rojas', 'F', '1985-01-15', '2000-05-16', 1500, 200, 'Gernte', '1000');
INSERT INTO Empleado VALUES ('74.758.963', 'Juan Martín', 'M', '1980-04-23', '2019-04-29', 1000, 50, 'Comercial', '2500');
INSERT INTO Empleado VALUES ('96.963.963', 'Pepe Viciana', 'M', '2000-05-25', '2019-01-04', 2500, 0, 'Científico', '3000');
INSERT INTO Empleado VALUES ('58.582.582', ',María José Sanchez', 'F', '1990-10-10', '2005-01-15', 5000, 400, 'Gerente', '1000');
INSERT INTO Empleado VALUES ('74.741.741', 'Laura Pastor', 'F', '1986-05-25', '2009-04-20', 3000, 350, 'At. Cliente', '2500');

DROP TABLE Empleado CASCADE;
DROP TABLE Departamento CASCADE;
DROP DATABASE Empresa;
