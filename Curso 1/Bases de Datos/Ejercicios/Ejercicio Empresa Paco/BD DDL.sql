/* EMPRESAS PACO */

-- TODO: definir la tabla especificada en el pdf de ejercicios BD EmpresaPaco (solo hay los INSERTS)
DROP DATABASE IF EXISTS EmpresaPaco;

CREATE DATABASE IF NOT EXISTS EmpresaPaco;

USE EmpresaPaco;

CREATE TABLE IF NOT EXISTS departamentos (
	dep_no INT PRIMARY KEY,
	dnombre VARCHAR(14),
    localidad VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS empleados (
	emp_no INT PRIMARY KEY,
    apellido VARCHAR(8),
    oficio VARCHAR(10),
    director INT,
    fecha_alta DATE,
    salario FLOAT(6, 2),
    comision FLOAT(6, 2),
    dep_no INT,
    CONSTRAINT empleados_fk_director FOREIGN KEY (director) REFERENCES empleados (emp_no),
    CONSTRAINT empleados_fk_departamento FOREIGN KEY (dep_no) REFERENCES departamentos (dep_no)
);

CREATE TABLE IF NOT EXISTS clientes (
	cliente_no INT PRIMARY KEY,
    nombre VARCHAR(25),
    localidad VARCHAR(14),
    vendedor_no INT,
    debe FLOAT(9, 2),
    haber FLOAT(9, 2),
    limite_credito FLOAT(9, 2),
    CONSTRAINT clientes_fk_vendedor FOREIGN KEY (vendedor_no) REFERENCES empleados (emp_no)
);

CREATE TABLE IF NOT EXISTS productos (
	producto_no INT PRIMARY KEY,
    descripcion VARCHAR(30),
    precio_actual FLOAT(8, 2),
    stock_disponible INT
);

CREATE TABLE IF NOT EXISTS renovar_stock (
	id_entrada INT PRIMARY KEY AUTO_INCREMENT,
    producto_no INT,
    stock_actual INT,
    fecha_aviso DATE,
    CONSTRAINT renovar_stock_fk_producto FOREIGN KEY (producto_no) REFERENCES productos (producto_no)
);

CREATE TABLE IF NOT EXISTS pedidos (
	pedido_no INT,
    producto_no INT,
    cliente_no INT,
    unidades INT,
    fecha_pedido DATE,
    CONSTRAINT pedidos_fk_producto FOREIGN KEY (producto_no) REFERENCES productos (producto_no),
    CONSTRAINT pedidos_fk_cliente FOREIGN KEY (cliente_no) REFERENCES clientes (cliente_no)
);

#' ##################### INTRODUCCIÓN DE DATOS ######################

#' ## departamentos
INSERT INTO departamentos VALUES(10, 'CONTABILIDAD', 'BARCELONA');
INSERT INTO departamentos VALUES(20, 'INVESTIGACION', 'VALENCIA');
INSERT INTO departamentos VALUES(30, 'VENTAS',        'MADRID'); 
INSERT INTO departamentos VALUES(40, 'PRODUCCION',    'SEVILLA');

#' ## EMPLEADOS
INSERT INTO empleados VALUES (7839,'REY',     'PRESIDENTE',NULL,'1981-11-17',6000,   NULL, 10);
INSERT INTO empleados VALUES (7698,'GARRIDO', 'DIRECTOR',  7839,'1981-05-01',3850.12,NULL, 30);
INSERT INTO empleados VALUES (7782,'MARTINEZ','DIRECTOR',  7839,'1981-06-09',2450,   NULL, 10);
INSERT INTO empleados VALUES(7499,'ALONSO',   'VENDEDOR',  7698,'1981-02-23',1400,   400,30);
INSERT INTO empleados VALUES (7521,'LOPEZ',   'EMPLEADO',  7782,'1981-05-08',1350.50,NULL,10);      
INSERT INTO empleados VALUES (7654,'MARTIN',  'VENDEDOR',  7698,'1981-09-28',1500,   1600, 30);
INSERT INTO empleados VALUES (7844,'CALVO',   'VENDEDOR',  7698,'1981-09-08',1800,   0,    30);
INSERT INTO empleados VALUES (7876,'GIL',     'ANALISTA',  7782,'1982-05-06',3350,   NULL, 20);
INSERT INTO empleados VALUES (7900,'JIMENEZ', 'EMPLEADO',  7782,'1983-03-24',1400,   NULL, 20);	

#' ## clientes
INSERT INTO clientes VALUES (101, 'DISTRIBUCIONES GOMEZ', 'MADRID', 7499, 0,0,5000);
INSERT INTO clientes VALUES (102, 'LOGITRONICA S.L', 'BARCELONA', 7654,0,0,5000);
INSERT INTO clientes VALUES (103, 'INDUSTRIAS LACTEAS S.A.', 'LAS ROZAS', 7844,0,0, 10000);
INSERT INTO clientes VALUES (104, 'TALLERES ESTESO S.A.', 'SEVILLA', 7654, 0, 0, 5000);
INSERT INTO clientes VALUES (105, 'EDICIONES SANZ', 'BARCELONA', 7499, 0,0,5000);
INSERT INTO clientes VALUES (106, 'SIGNOLOGIC S.A.', 'MADRID', 7654,0,0,5000);
INSERT INTO clientes VALUES (107, 'MARTIN Y ASOCIADOS S.L.', 'ARAVACA' , 7844,0,0, 10000);
INSERT INTO clientes VALUES (108, 'MANUFACTURAS ALI S.A.', 'SEVILLA', 7654, 0, 0, 5000);

#' ## PRODUCTOS
INSERT INTO productos VALUES(10,'MESA DESPACHO MOD. GAVIOTA', 550, 50);
INSERT INTO productos VALUES (20, 'SILLA DIRECTOR MOD. BUFALO', 670, 25);
INSERT INTO productos VALUES (30, 'ARMARIO NOGAL DOS PUERTAS', 460, 20);
INSERT INTO productos VALUES (40, 'MESA MODELO UNIÓN',340, 15);
INSERT INTO productos VALUES (50, 'ARCHIVADOR CEREZO',1050, 20);
INSERT INTO productos VALUES (60, 'CAJA SEGURIDAD MOD B222', 280, 15);
INSERT INTO productos VALUES (70, 'DESTRUCTORA DE PAPEL A3',450, 25);
INSERT INTO productos VALUES (80, 'MODULO ORDENADOR MOD. ERGOS', 550, 25);

#' ## pedidos

INSERT INTO pedidos VALUES(1000, 20, 103, 3, '1999-10-06');
INSERT INTO pedidos VALUES(1001, 50, 106, 2, '1999-10-06');
INSERT INTO pedidos VALUES(1002, 10, 101, 4, '1999-10-07');
INSERT INTO pedidos VALUES(1003, 20, 105, 4, '1999-10-16');
INSERT INTO pedidos VALUES(1004, 40, 106, 8, '1999-10-20');
INSERT INTO pedidos VALUES(1005, 30, 105, 2, '1999-10-20');
INSERT INTO pedidos VALUES(1006, 70, 103, 3, '1999-11-03');
INSERT INTO pedidos VALUES(1007, 50, 101, 2, '1999-11-06');
INSERT INTO pedidos VALUES(1008, 10, 106, 6, '1999-11-16');
INSERT INTO pedidos VALUES(1009, 20, 105, 2, '1999-11-26');
INSERT INTO pedidos VALUES(1010, 40, 102, 3, '1999-12-08');
INSERT INTO pedidos VALUES(1011, 30, 106, 2, '1999-12-15');
INSERT INTO pedidos VALUES(1012, 10, 105, 3, '1999-12-06');
INSERT INTO pedidos VALUES(1013, 30, 106, 2, '1999-12-06');
INSERT INTO pedidos VALUES(1014, 20, 101, 4, '2000-01-07');
INSERT INTO pedidos VALUES(1015, 70, 105, 4, '2000-01-16');
INSERT INTO pedidos VALUES(1017, 20, 105, 6, '2000-01-20');




