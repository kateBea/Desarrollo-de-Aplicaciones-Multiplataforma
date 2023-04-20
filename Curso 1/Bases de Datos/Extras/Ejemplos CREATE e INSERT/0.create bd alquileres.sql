CREATE DATABASE IF NOT EXISTS ALQUILERES;
use alquileres;
CREATE TABLE IF NOT EXISTS socios(
	socio_no int(4),
    apellidos varchar (50),
    telefono char(9),
    fecha_alta date default '2023-01-01',
    direccion varchar(100),
    codigo_postal int (5),
    constraint pk_socios primary key (socio_no),
    constraint uq_unique unique (apellidos),
    constraint ck_codigo check (codigo_postal between 28000 and 28999));

create table if not exists prestamos(
	num_prestamo int(2) primary key,
    socio_no int (4), 
    constraint fk_socio_prestamo foreign key (socio_no) references socios(socio_no));
    
    
CREATE TABLE inventario
 (num INT(2) AUTO_INCREMENT PRIMARY KEY,
descripcion VARCHAR(15));
