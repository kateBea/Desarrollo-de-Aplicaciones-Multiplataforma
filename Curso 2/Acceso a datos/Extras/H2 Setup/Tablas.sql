CREATE TABLE departamento(
id VARCHAR(4) PRIMARY KEY,
nombre VARCHAR(20),
localidad VARCHAR(20),
fecha_creacion DATE
);

CREATE TABLE empleado(
id VARCHAR(4) PRIMARY KEY,
nombre VARCHAR(30),
depto_id VARCHAR(4),
email VARCHAR(30),
puesto VARCHAR(30),
fecha_alta DATE,
CONSTRAINT emp_dep_fk FOREIGN KEY (depto_id) REFERENCES departamento (id)
);

INSERT INTO departamento (id, nombre, localidad, fecha_creacion)
Values('001', 'SISTEMAS', 'VICALVARO', CURRENT_DATE());

INSERT INTO empleado (id, nombre, depto_id, email, puesto, fecha_alta)
Values('001', 'PABLO MARMOL', '001', 'pablomarmol@educa.org', 'PROGRAMADOR', CURRENT_DATE());
