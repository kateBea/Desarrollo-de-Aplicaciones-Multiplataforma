CREATE
DATABASE ciclistas;
USE
ciclistas;
 
CREATE TABLE etapas (
    numero INTEGER NOT NULL PRIMARY KEY,
    fecha DATE,
    hora_salida TIME,
    hora_llegada TIME,
    km INTEGER CHECK (km > 0),
    lugar_salida VARCHAR(50),
    lugar_llegada VARCHAR(50)
);
 
CREATE TABLE puertos_montania (
    nombre VARCHAR(30) NOT NULL,
    categoria INTEGER,
    numero INTEGER NOT NULL,
    PRIMARY KEY (nombre, numero)
);
 
CREATE TABLE equipos (
    nombre VARCHAR(20) NOT NULL PRIMARY KEY,
    nacionalidad VARCHAR(30),
    director VARCHAR(50),
    patrocinador VARCHAR(50)
);
 
CREATE TABLE participaciones (
    numero INTEGER NOT NULL,
    dorsal INTEGER NOT NULL,
    PRIMARY KEY (numero, dorsal)
);
 
CREATE TABLE ciclistas (
    dorsal INTEGER NOT NULL PRIMARY KEY,
    nombre VARCHAR(50),
    nacionalidad VARCHAR(30),
    equipo VARCHAR(20) NOT NULL
);
 
CREATE TABLE cadenas (
    nombre VARCHAR(50) NOT NULL PRIMARY KEY
);
 
CREATE TABLE entrevistas (
    dorsal INTEGER NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    PRIMARY KEY (dorsal, nombre)
);
 
CREATE TABLE mejores_clasificaciones (
    dorsal INTEGER NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    PRIMARY KEY (dorsal, nombre)
);
 
ALTER TABLE puertos_montania ADD CONSTRAINT
FK_puertos_etapa FOREIGN KEY (numero) REFERENCES etapas (numero) ON DELETE
CASCADE ON UPDATE CASCADE;
 
ALTER TABLE participaciones ADD CONSTRAINT
FK_participantes_etapa FOREIGN KEY (numero) REFERENCES etapas (numero) ON
DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE participaciones ADD CONSTRAINT FK_participantes_ciclista
FOREIGN KEY (dorsal) REFERENCES ciclistas (dorsal) ON DELETE RESTRICT ON UPDATE
CASCADE;
 
ALTER TABLE ciclistas ADD CONSTRAINT
FK_ciclista_equipo FOREIGN KEY (equipo) REFERENCES equipos (nombre) ON DELETE
RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE entrevistas ADD CONSTRAINT
FK_entrevista_cadena FOREIGN KEY (nombre) REFERENCES cadenas (nombre) ON DELETE
RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE entrevistas ADD CONSTRAINT
FK_entrevista_ciclista FOREIGN KEY (dorsal) REFERENCES ciclistas (dorsal) ON
DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE mejores_clasificaciones ADD CONSTRAINT
FK_mejores_clasificaciones FOREIGN KEY (dorsal) REFERENCES ciclistas (dorsal)
ON DELETE CASCADE ON UPDATE CASCADE;