/****************************************************
Este Script contiene la definición de una tabla sencilla
perteneciente a una basa de datos MySQL.

Autor: Hugo Pelayo
Fecha: 22 de enero de 2023
Fichero: Script DML.sql
****************************************************/

# Hostpitales table data
# Auto-Incremented Key
INSERT INTO Hospitales values(NULL);
INSERT INTO Hospitales values(NULL);
INSERT INTO Hospitales values(NULL);
INSERT INTO Hospitales values(NULL);

# Puestos table data
INSERT INTO Puestos VALUES('CONSERJE', 1200);

INSERT INTO Puestos VALUES('DIRECTOR', 2400);
INSERT INTO Puestos VALUES('DIRECTOR', 2000);

INSERT INTO Puestos VALUES('MEDICO', 2200);
INSERT INTO Puestos VALUES('MEDICO', 1900);
INSERT INTO Puestos VALUES('MEDICO', 1700);
INSERT INTO Puestos VALUES('MEDICO', 1600);

# Personas table data
INSERT INTO Personas VALUES(1, '12345678', 'García Hernández, Eladio', 'CONSERJE', 1200, 'LORCA');
INSERT INTO Personas VALUES(1, '87654321', 'Fuentes Bermejo, Carlos', 'DIRECTOR', 2000, 'MURCIA');
INSERT INTO Personas VALUES(2, '55544433', 'González Marín Alicia', 'CONSERJE', 1200, 'MURCIA');
INSERT INTO Personas VALUES(1, '66655544', 'Castillo Montes, Pedro', 'MEDICO', 1700, 'MURCIA');
INSERT INTO Personas VALUES(2, '22233322', 'Tristán García, Ana', 'MEDICO', 1900, 'MURCIA');
INSERT INTO Personas VALUES(3, '55544411', 'Ruiz Hernández, Caridad', 'MEDICO', 1900, 'LORCA');
INSERT INTO Personas VALUES(3, '99988333', 'Serrano Díaz, Alejandro', 'DIRECTOR', 2400, 'CARTAGENA');
INSERT INTO Personas VALUES(4, '3322211', 'Mesa del Castillo, Juan', 'MEDICO', 2200, 'LORCA');
INSERT INTO Personas VALUES(2, '22233333', 'Martínez Molina, Andrés', 'MEDICO', 1600, 'CARTAGENA');
INSERT INTO Personas VALUES(4, '55544412', 'Jiménez Jiménez, Dolores', 'CONSERJE', 1200, 'MURCIA');
INSERT INTO Personas VALUES(4, '22233311', 'Martínez Molina, Gloria', 'MEDICO', 1600, 'MURCIA');

# Consultas
SELECT *
FROM Hospitales;

SELECT *
FROM Puestos;

SELECT *
FROM Personas;

# Consultas Ejercicios
# 1)
SELECT *
FROM Personas;

