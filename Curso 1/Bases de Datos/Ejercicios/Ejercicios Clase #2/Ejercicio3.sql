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
INSERT INTO Alumno VALUES ('27183634-K', 'Cynthia Beatriz', 9.78, 'C');
INSERT INTO Alumno VALUES ('37652481-F', 'Gandalf', 7.22, 'A');
INSERT INTO Alumno VALUES ('12862499-T', 'Robert Gisbert', 8.88, 'A');
INSERT INTO Alumno VALUES ('34628456-V', 'Paul Jackson', 9.5, 'D');
INSERT INTO Alumno VALUES ('37528967-A', 'Isha Roig', 9.99, 'B');

/* Inserts en Estudio */
INSERT INTO Estudio VALUES (78899, 'Computer Engineering', 8.99);
INSERT INTO Estudio VALUES (78870, 'Computer Science', 9.5);
INSERT INTO Estudio VALUES (42441, 'Philosophy', 6.5);
INSERT INTO Estudio VALUES (82444, 'The German Language', 7.1);
INSERT INTO Estudio VALUES (82440, 'The Japanese Language', 9.99);
INSERT INTO Estudio VALUES (82440, 'The Spanish Language', 6.22);

/* Inserts en Preinscripcion */
INSERT INTO Preinscripcion VALUES ('27183634-K', 78899, 'S', 122);
INSERT INTO Preinscripcion VALUES ('27183634-K', 82444, 'S', 224);
INSERT INTO Preinscripcion VALUES ('27183634-K', 82440, 'N', 554);


/* Limpieza */
DROP TABLE Preinscripcion CASCADE;
DROP TABLE Estudio CASCADE;
DROP TABLE Alumno CASCADE;
DROP DATABASE Universidad;