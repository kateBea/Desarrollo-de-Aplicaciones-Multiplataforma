/****************************************************
Este Script contiene la definición de una tabla sencilla
perteneciente a una base de datos MySQL. Importante e imprescindible 
ejecutar el Script en el orden en que están las sentencias.

Autor: Hugo Pelayo
Fecha: 24 de enero de 2023
Fichero: Script DDL.sql
****************************************************/

CREATE DATABASE IF NOT EXISTS Empresa;

USE Empresa;

# Para uso en AUTO_INCREMENT. Controla el número de saltos entre auto incremento
# Ejemplo: NombreCampo += 10
SET SESSION auto_increment_increment = 10;

# Para uso en AUTO_INCREMENT. Controla el valor de inicio para auto incremento
# Ejemplo: NombreCampo toma valor inicial 10
SET SESSION auto_increment_offset = 10;

CREATE TABLE IF NOT EXISTS Departamentos (
    Dept_No INT AUTO_INCREMENT PRIMARY KEY,
    Dnombre VARCHAR(45) NOT NULL,
    Loc VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Dirs (
	# NOTA: Puede que falten datos. Por ello se define el campo Apellido
	# como opcional ya que no se provee los datos del Dir con
	# Códogio 7782
    Codigo CHAR(4) PRIMARY KEY,
    Apellido VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Empleados (
    Emp_No CHAR(5) PRIMARY KEY,
    Apellido VARCHAR(20) NOT NULL,
    Oficio VARCHAR(20) NOT NULL,
    Dir CHAR(4),
    Fecha_Alt DATE NOT NULL,
    Salario INT NOT NULL,
    Comision INT,
    Dept_No INT NOT NULL,

    CONSTRAINT Fk_EmpDir FOREIGN KEY (Dir) REFERENCES Dirs(Codigo)
);

/****************************************************
Queries Auxiliares
****************************************************/

# Consulta el estado de las variables de la conexión actual
# que contengan la cadena 'auto_inc' en su nombre. Si las variables encontradas no tienen valor
# en la conexión actual, se muestra el valor global.
# Src: https://dev.mysql.com/doc/refman/5.7/en/show-status.html
SHOW SESSION VARIABLES LIKE '%auto_inc%';

# Limpieza
DROP TABLE Empleados;
DROP TABLE Dirs;
DROP TABLE Departamentos;
DROP DATABASE Empresa;