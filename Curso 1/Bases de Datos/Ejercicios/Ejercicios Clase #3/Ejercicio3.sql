/* Ejercicio 03 */
CREATE DATABASE IF NOT EXISTS Universidad 
CHARACTER SET utf8 
COLLATE utf8_general_ci;

USE Universidad;

CREATE TABLE IF NOT EXISTS Alumno (
	  Dni CHAR(10) PRIMARY KEY,
      Nombre VARCHAR(100),
      Nota REAL,
      Opcion CHAR(1) CHECK (Opcion IN ('A', 'C', 'B', 'D'))
);

CREATE TABLE IF NOT EXISTS Estudio (
	Codigo INT PRIMARY KEY,
    Nombre VARCHAR(100),
    NotaDeCorte REAL CONSTRAINT CHECK (NotaDeCorte > 5)
);

CREATE TABLE IF NOT EXISTS Preinscripcion (
	DniAlumno CHAR(10), 
    CodigoEstudio INT,
    Admitido CHAR(1) CHECK (Admitido IN ('S', 'N')),
    Orden INT,
    PRIMARY KEY (DniAlumno, CodigoEstudio),
    CONSTRAINT Fk_Dni FOREIGN KEY (DniAlumno) REFERENCES Alumno(Dni),
    CONSTRAINT Fk_Codigo FOREIGN KEY (CodigoEstudio) REFERENCES Estudio(Codigo)
);

/* Consulta de datos*/
SELECT * 
FROM Alumno;

SELECT * 
FROM Estudio;

SELECT * 
FROM Preinscripcion;

/* Inserts en Alumno */
INSERT INTO Alumno VALUES ();

/* Inserts en Estudio */
INSERT INTO Estudio VALUES ();

/* Inserts en Estudio */
INSERT INTO Estudio VALUES ();


/* Limpieza */
DROP TABLE Preinscripcion CASCADE;
DROP TABLE Estudio CASCADE;
DROP TABLE Alumno CASCADE;
DROP DATABASE Universidad;
