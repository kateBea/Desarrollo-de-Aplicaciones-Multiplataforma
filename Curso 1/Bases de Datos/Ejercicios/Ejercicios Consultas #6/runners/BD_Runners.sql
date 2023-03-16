USE db_runners;

DROP TABLE IF EXISTS Carreras, Corredores, Inscritos;

-- Tabla que alberga la información de las carreras
CREATE TABLE Carreras (
  ID_Carrera integer NOT NULL,
  FechaCar DATE NOT NULL,
  Distancia integer NOT NULL,
  Localidad varchar(30) NOT NULL,
  Record_Mas time DEFAULT NULL,
  Record_Fem time DEFAULT NULL,
  Premio integer DEFAULT NULL,
  Cuota integer DEFAULT NULL,
  PRIMARY KEY (ID_Carrera)
) engine=innodb;




-- Tabla que almacena la información relativa a los corredores
CREATE TABLE Corredores (
  ID_Corredor integer NOT NULL,
  Nombre varchar(30) NOT NULL,
  Apellido1 varchar(30) NOT NULL,
  Apellido2 varchar(30) DEFAULT NULL,
  FechaNac date NOT NULL,
  Club varchar(30) DEFAULT NULL,
  Federado varchar(2) DEFAULT NULL,
  Telefono varchar(9) DEFAULT NULL,
  Sexo  varchar(6) NOT NULL,
  Nacionalidad varchar(30) NOT NULL,
  PRIMARY KEY (ID_Corredor)
) engine=innodb;




-- Tabla en la que se guarda la información relativa a cada corredor inscrito en cada carrera
CREATE TABLE Inscritos (
  ID_Corredor integer NOT NULL,
  ID_Carrera integer NOT NULL,
  Dorsal integer NOT NULL,
  Marca time DEFAULT NULL,
  Edad integer DEFAULT NULL,
  Pagado integer DEFAULT NULL,
  PRIMARY KEY (ID_Corredor, ID_Carrera),
  CONSTRAINT Inscritos_CorredoresFK FOREIGN KEY (ID_Corredor) REFERENCES Corredores (ID_Corredor),
  CONSTRAINT Inscritos_CarrerasFK FOREIGN KEY (ID_Carrera) REFERENCES Carreras (ID_Carrera)
) engine=innodb;



