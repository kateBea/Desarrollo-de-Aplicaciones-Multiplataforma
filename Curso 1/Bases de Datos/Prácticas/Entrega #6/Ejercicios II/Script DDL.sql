drop database if exists gestor_fabricantes;

#Creación de Tablas en Base de datos
create database if not exists gestor_fabricantes;

use gestor_fabricantes;

create table fabricante (id_fab INTEGER PRIMARY KEY, nombre VARCHAR(50) NOT NULL, pais VARCHAR(30));
create table programa (codigo INTEGER PRIMARY KEY, nombre VARCHAR(50) NOT NULL, version VARCHAR(50));
create table comercio (cif INTEGER PRIMARY KEY, nombre VARCHAR(50) NOT NULL, ciudad VARCHAR(50));
create table cliente (dni INTEGER PRIMARY KEY, nombre VARCHAR(50) NOT NULL, edad INTEGER);
create table registra (cif INTEGER, dni INTEGER, codigo INTEGER, medio VARCHAR(20));
create table desarrolla (id_fab INTEGER, codigo INTEGER);
create table distribuye (cif INTEGER, codigo INTEGER, cantidad INTEGER); 


#Datos a insertar en Tabla fabricante
INSERT INTO fabricante VALUES (1,'ORACLE','ESTADOS UNIDOS');
INSERT INTO fabricante VALUES (2,'MICROSOFT','ESTADOS UNIDOS');
INSERT INTO fabricante VALUES (3,'IBM','ESTADOS UNIDOS');
INSERT INTO fabricante VALUES (4,'DINAMIC','ESPAÑA');
INSERT INTO fabricante VALUES (5,'BORLAND','ESTADOS UNIDOS');
INSERT INTO fabricante VALUES (6,'SYMANTEC','ESTADOS UNIDOS'); 

# Datos a insertar en Tabla programa
INSERT INTO programa VALUES (1,'APPLICATION SERVER','9i');
INSERT INTO programa VALUES (2,'DATABASE','8i');
INSERT INTO programa VALUES (3,'DATABASE','9i');
INSERT INTO programa VALUES (4,'DATABASE','10g');
INSERT INTO programa VALUES (5,'DEVELOPER','6i');
INSERT INTO programa VALUES (6,'ACCESS','97');
INSERT INTO programa VALUES (7,'ACCESS','2000');
INSERT INTO programa VALUES (8,'ACCESS','XP');
INSERT INTO programa VALUES (9,'WINDOWS','98');
INSERT INTO programa VALUES (10,'WINDOWS','XP PROFESSIONAL');
INSERT INTO programa VALUES (11,'WINDOWS','XP HOME EDITION');
INSERT INTO programa VALUES (12,'WINDOWS','2003 SERVER');
INSERT INTO programa VALUES (13,'NORTON INTERNET SECURITY','2004');
INSERT INTO programa VALUES (14,'FREDDY HARDEST','');
INSERT INTO programa VALUES (15,'PARADOX','2');
INSERT INTO programa VALUES (16,'C++ BUILDER','55');
INSERT INTO programa VALUES (17,'DB/2','20');
INSERT INTO programa VALUES (18,'OS/2','10');
INSERT INTO programa VALUES (19,'JBUILDER','X');
INSERT INTO programa VALUES (20,'LA PRISION','10');
 
#Datos a insertar en Tabla comercio 
INSERT INTO comercio VALUES (1,'El Corte Inglȩs','Sevilla');
INSERT INTO comercio VALUES (2,'El Corte Inglȩs','Madrid');
INSERT INTO comercio VALUES (3,'Jump','Valencia');
INSERT INTO comercio VALUES (4,'Centro Mail','Sevilla');
INSERT INTO comercio VALUES (5,'FNAC','Barcelona'); 

# Datos a insertar en Tabla cliente
INSERT INTO cliente VALUES (1,'PEPITO PEREZ', 38);
INSERT INTO cliente VALUES (2,'JUAN CHARRASQUIADO', 55);
INSERT INTO cliente VALUES (3,'MARTIN PESCADOR', 38);
INSERT INTO cliente VALUES (4,'ROSA CANTOR', 25); 

# Datos a insertar en Tabla registra
INSERT INTO registra VALUES (1, 1, 1, 'INTERNET');
INSERT INTO registra VALUES (1, 3, 4, 'TARJETA POSTAL');
INSERT INTO registra VALUES (4, 2, 10, 'TELEFONO');
INSERT INTO registra VALUES (4, 1, 10, 'TARJETA POSTAL');
INSERT INTO registra VALUES (5, 2, 12, 'INTERNET');
INSERT INTO registra VALUES (2, 4, 15, 'INTERNET');

#Datos a insertar en Tabla desarrolla 
INSERT INTO desarrolla VALUES (1, 1);
INSERT INTO desarrolla VALUES (1, 2);
INSERT INTO desarrolla VALUES (1, 3);
INSERT INTO desarrolla VALUES (1, 4);
INSERT INTO desarrolla VALUES (1, 5);
INSERT INTO desarrolla VALUES (2, 6);
INSERT INTO desarrolla VALUES (2, 7);
INSERT INTO desarrolla VALUES (2, 8);
INSERT INTO desarrolla VALUES (2, 9);
INSERT INTO desarrolla VALUES (2, 10);
INSERT INTO desarrolla VALUES (2, 11);
INSERT INTO desarrolla VALUES (2, 12);
INSERT INTO desarrolla VALUES (6, 13);
INSERT INTO desarrolla VALUES (3, 17);
INSERT INTO desarrolla VALUES (3, 18);
INSERT INTO desarrolla VALUES (5, 19);
INSERT INTO desarrolla VALUES (5, 15);
INSERT INTO desarrolla VALUES (5, 16);
INSERT INTO desarrolla VALUES (4, 14);
INSERT INTO desarrolla VALUES (4, 20);
 
#Datos a insertar en Tabla distribuye 
INSERT INTO distribuye VALUES (1, 1, 10);
INSERT INTO distribuye VALUES (1, 2, 11);
INSERT INTO distribuye VALUES (1, 6, 5);
INSERT INTO distribuye VALUES (1, 7, 3);
INSERT INTO distribuye VALUES (1, 10, 5);
INSERT INTO distribuye VALUES (1, 13, 7);
INSERT INTO distribuye VALUES (2, 1, 6);
INSERT INTO distribuye VALUES (2, 2, 6);
INSERT INTO distribuye VALUES (2, 6, 4);
INSERT INTO distribuye VALUES (2, 7, 7);
INSERT INTO distribuye VALUES (3, 10, 8);
INSERT INTO distribuye VALUES (3, 13, 5);
INSERT INTO distribuye VALUES (4, 14, 3);
INSERT INTO distribuye VALUES (4, 20, 6);
INSERT INTO distribuye VALUES (5, 15, 8);
INSERT INTO distribuye VALUES (5, 16, 2);
INSERT INTO distribuye VALUES (5, 17, 3);
INSERT INTO distribuye VALUES (5, 19, 6);
INSERT INTO distribuye VALUES (5, 8, 8);
