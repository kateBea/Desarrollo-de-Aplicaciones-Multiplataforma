DROP DATABASE IF EXISTS rentacar;

CREATE DATABASE IF NOT EXISTS rentacar;

USE rentacar;

CREATE TABLE Clientes (
  ID_Cliente integer NOT NULL,
  Nombre varchar(50) NOT NULL,
  Apellido1 varchar(50) NOT NULL,
  Apellido2 varchar(50) DEFAULT NULL,
  MedioPago varchar(16) NOT NULL,
  TipoCarnet varchar(10) NOT NULL,
  NumCarnet varchar(10) NOT NULL,
  Telefono varchar(9) NOT NULL,
  Direccion1 varchar(50) NOT NULL,
  Ciudad varchar(20) NOT NULL,
  Email varchar(100) NOT NULL,
  PRIMARY KEY (ID_Cliente)
) engine=innodb;

INSERT INTO Clientes VALUES (100, 'Luis', 'Pérez', 'Ramos', '4072160589757845','Todos', '50560541', '696857412', 'Santa Ana, 22', 'Madrid', 'luis25@trumpmail.com');
INSERT INTO Clientes VALUES (101, 'Ana', 'Velasco', 'Luengo', '8952160589766652','Coche', '50588446', '694126857', 'Comendador, 44', 'Madrid', 'anitadinamita@trumpmail.com');
INSERT INTO Clientes VALUES (102, 'Eva', 'Ruíz', 'Leal', '8952421589766444','Moto', '50588446', '615146858', 'Granada, 101', 'Madrid', 'evasion@trumpmail.com');
INSERT INTO Clientes VALUES (103, 'Pedro', 'Velarde', 'Mesa', '5028160589762850','Moto', '88446505', '698574126', 'Corregidor, 3', 'Madrid', 'pedroyvilma@trumpmail.com');
INSERT INTO Clientes VALUES (104, 'Pepe', 'Montilla', 'Moriles', '1605502889762850','Todos', '88446599', '698574777', 'Ibiza, 25', 'Madrid', 'pepemm@trumpmail.com');
INSERT INTO Clientes VALUES (105, 'Vanessa', 'Márquez', 'Villa', '2889762851605500','Todos', '715446592', '674777985', 'Saldaña, 12', 'Madrid', 'vane365@trumpmail.com');
INSERT INTO Clientes VALUES (106, 'Teresa', 'Moreno', 'Villanueva', '7628516055002889','Coche', '446715592', '622277985', 'Santiago, 7', 'Madrid', 'teresa44@trumpmail.com');
INSERT INTO Clientes VALUES (107, 'Mario', 'Martos', 'Monterrey', '1605762855002889','Moto', '433715592', '622277321', 'Santurce, 17', 'Madrid', 'mariomar@trumpmail.com');
INSERT INTO Clientes VALUES (108, 'Marta', 'Casado', 'Guerra', '3455762855002880','Todos', '302243371', '628822141', 'Sanabria, 31', 'Madrid', 'martacasado@trumpmail.com');
INSERT INTO Clientes VALUES (109, 'Manuel', 'Dominguez', 'Santos', '6285500283455780','Todos', '337102243', '622214188', 'San Martín, 1', 'Madrid', 'manudom28@trumpmail.com');
INSERT INTO Clientes VALUES (110, 'María', 'Dominguez', 'Villanueva', '9255500283455925','Todos', '102243373', '622812345', 'San Patricio, 86', 'Madrid', 'mariadomvilla@trumpmail.com');



CREATE TABLE Vehiculos (
  ID_Vehiculo integer NOT NULL,
  Matricula varchar(7) NOT NULL,
  Marca varchar(10) NOT NULL,
  Modelo varchar(15) NOT NULL,
  TipoCarnet varchar(10) NOT NULL,
  Estado varchar(10) NOT NULL,
  PRIMARY KEY (ID_Vehiculo)
 ) engine=innodb;
 
 INSERT INTO Vehiculos VALUES (500, '7566LBP', 'Mini', 'One', 'Coche', 'En uso');
 INSERT INTO Vehiculos VALUES (501, '7567LBP', 'Mini', 'One', 'Coche', 'En uso');
 INSERT INTO Vehiculos VALUES (502, '7568LBP', 'Mini', 'One', 'Coche', 'En uso');
 INSERT INTO Vehiculos VALUES (503, '7569LBP', 'Mini', 'One', 'Coche', 'En uso');
 INSERT INTO Vehiculos VALUES (504, '7570LBP', 'Mini', 'One', 'Coche', 'En uso');
 INSERT INTO Vehiculos VALUES (505, '4220LCC', 'Yamaha', 'T-Max', 'Moto', 'En uso');
 INSERT INTO Vehiculos VALUES (506, '4221LCC', 'Yamaha', 'T-Max', 'Moto', 'En uso');
 INSERT INTO Vehiculos VALUES (507, '4222LCC', 'Yamaha', 'T-Max', 'Moto', 'En uso');
 INSERT INTO Vehiculos VALUES (508, '4223LCC', 'Yamaha', 'T-Max', 'Moto', 'En uso');
 INSERT INTO Vehiculos VALUES (509, '4224LCC', 'Yamaha', 'T-Max', 'Moto', 'En uso');
 INSERT INTO Vehiculos VALUES (510, '1110LDB', 'Ford', 'Transit', 'Furgoneta', 'En uso');
 INSERT INTO Vehiculos VALUES (511, '1111LDB', 'Ford', 'Transit', 'Furgoneta', 'En uso');
 INSERT INTO Vehiculos VALUES (512, '1112LDB', 'Ford', 'Transit', 'Furgoneta', 'En uso');
 
 
 
 
 CREATE TABLE Alquileres (
  ID_Alquiler integer NOT NULL,
  InicioAlquiler timestamp  NOT NULL,
  FinAlquiler timestamp DEFAULT NULL,
  ID_Cliente integer NOT NULL,
  ID_Vehiculo integer NOT NULL,
  SeguroExtra varchar(2) NOT NULL,
  PRIMARY KEY (ID_Alquiler),
  CONSTRAINT Alquileres_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Clientes (ID_Cliente),
  CONSTRAINT Alquileres_Vehiculo FOREIGN KEY (ID_Vehiculo) REFERENCES Vehiculos (ID_Vehiculo)
) engine=innodb;

INSERT INTO Alquileres VALUES (1000, '2020-01-10 13:10:54', '2020-01-10 18:45:50', 100, 500, 'Sí');
INSERT INTO Alquileres VALUES (1001, '2020-01-10 12:21:54', '2020-01-12 11:45:10', 101, 501, 'Sí');
INSERT INTO Alquileres VALUES (1002, '2020-01-10 15:18:14', '2020-01-10 18:31:22', 104, 502, 'No');
INSERT INTO Alquileres VALUES (1003, '2020-01-10 16:10:18', '2020-01-10 19:45:50', 109, 510, 'Sí');
INSERT INTO Alquileres VALUES (1004, '2020-01-11 08:10:46', '2020-01-13 18:50:45', 110, 509, 'No');
INSERT INTO Alquileres VALUES (1005, '2020-01-11 08:25:20', '2020-01-11 18:50:45', 103, 507, 'No');
INSERT INTO Alquileres VALUES (1006, '2020-01-11 10:54:20', '2020-01-13 16:20:10', 107, 506, 'Sí');
INSERT INTO Alquileres VALUES (1007, '2020-01-12 08:12:22', '2020-01-12 08:55:40', 105, 508, 'No');
INSERT INTO Alquileres VALUES (1008, '2020-02-03 08:10:54', '2020-02-03 21:50:45', 108, 509, 'Sí');
INSERT INTO Alquileres VALUES (1009, '2020-02-04 09:21:30', '2020-02-05 01:06:24', 109, 501, 'Sí');
INSERT INTO Alquileres VALUES (1010, '2020-02-05 20:10:54', '2020-02-06 02:39:39', 110, 502, 'Sí');
INSERT INTO Alquileres VALUES (1011, '2020-02-10 15:10:54', '2020-03-12 11:23:50', 101, 501, 'Sí');
INSERT INTO Alquileres VALUES (1012, '2020-03-10 15:18:54', '2020-03-10 18:45:50', 104, 502, 'No');
INSERT INTO Alquileres VALUES (1013, '2020-03-10 16:10:54', '2020-03-10 19:19:12', 109, 510, 'Sí');
INSERT INTO Alquileres VALUES (1014, '2020-03-11 08:10:54', '2020-03-13 14:03:45', 110, 509, 'No');
INSERT INTO Alquileres VALUES (1015, '2020-03-11 08:25:54', '2020-03-12 18:50:45', 103, 507, 'No');
INSERT INTO Alquileres VALUES (1016, '2020-03-11 10:54:20', '2020-03-13 16:20:10', 107, 506, 'Sí');
INSERT INTO Alquileres VALUES (1017, '2020-03-12 08:12:22', '2020-03-12 18:15:40', 105, 508, 'No');
INSERT INTO Alquileres VALUES (1018, '2020-04-03 08:10:54', '2020-04-03 18:50:45', 108, 509, 'Sí');
INSERT INTO Alquileres VALUES (1019, '2020-04-04 09:21:30', '2020-04-05 01:06:24', 109, 501, 'Sí');
INSERT INTO Alquileres VALUES (1020, '2020-04-05 20:10:54', '2020-04-06 02:39:39', 110, 502, 'Sí');
INSERT INTO Alquileres VALUES (1021, '2020-04-10 15:10:54', '2020-04-12 20:45:50', 101, 501, 'Sí');
INSERT INTO Alquileres VALUES (1022, '2020-04-10 11:18:00', '2020-04-10 21:34:15', 104, 502, 'No');
INSERT INTO Alquileres VALUES (1023, '2020-04-10 16:10:54', '2020-04-10 16:23:50', 109, 510, 'Sí');
INSERT INTO Alquileres VALUES (1024, '2020-04-11 08:10:54', '2020-04-12 14:50:45', 110, 509, 'No');
INSERT INTO Alquileres VALUES (1025, '2020-04-11 08:25:54', '2020-04-12 12:50:45', 103, 507, 'No');
INSERT INTO Alquileres VALUES (1026, '2020-04-11 10:54:20', '2020-04-13 12:20:10', 107, 506, 'Sí');
INSERT INTO Alquileres VALUES (1027, '2020-04-12 08:12:22', '2020-04-12 19:15:40', 105, 505, 'No');
INSERT INTO Alquileres VALUES (1028, '2020-04-03 08:10:54', '2020-04-03 18:50:45', 108, 509, 'Sí');
INSERT INTO Alquileres VALUES (1029, '2020-04-04 09:21:30', '2020-04-05 03:06:24', 109, 501, 'Sí');
INSERT INTO Alquileres VALUES (1030, '2020-04-05 20:10:54', '2020-04-06 02:39:39', 110, 502, 'Sí');
INSERT INTO Alquileres VALUES (1031, '2020-05-10 15:10:54', '2020-05-12 11:45:50', 101, 501, 'Sí');
INSERT INTO Alquileres VALUES (1032, '2020-05-10 15:18:54', '2020-05-10 18:45:50', 104, 502, 'No');
INSERT INTO Alquileres VALUES (1033, '2020-05-10 16:10:54', '2020-05-10 19:45:50', 109, 510, 'Sí');
INSERT INTO Alquileres VALUES (1034, '2020-05-11 08:10:54', '2020-05-13 18:50:45', 110, 509, 'No');
INSERT INTO Alquileres VALUES (1035, '2020-05-11 08:25:54', '2020-05-22 18:50:45', 103, 507, 'No');
INSERT INTO Alquileres VALUES (1036, '2020-05-11 10:54:20', '2020-05-13 16:20:10', 107, 506, 'Sí');
INSERT INTO Alquileres VALUES (1037, '2020-05-12 08:12:22', '2020-05-12 18:15:40', 105, 508, 'No');
INSERT INTO Alquileres VALUES (1038, '2020-05-03 08:10:54', '2020-06-03 18:50:45', 108, 509, 'Sí');
INSERT INTO Alquileres VALUES (1039, '2020-05-04 09:21:30', '2020-05-05 01:06:24', 109, 501, 'Sí');
INSERT INTO Alquileres VALUES (1040, '2020-05-05 20:10:54', '2020-05-06 02:39:39', 110, 502, 'Sí');