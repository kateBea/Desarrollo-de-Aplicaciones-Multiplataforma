use alquileres;

/* Pensar en el orden hay que insertar los datos */
insert into socios(socio_no, apellidos, telefono, fecha_alta, direccion, codigo_postal) 
	values (1000, 'LOPEZ', '918888888', '2005-01-08', 'C\La que sea', 28850);
insert into socios(socio_no, apellidos, telefono, fecha_alta, direccion, codigo_postal) 
	values (1001, 'PÉREZ', '917777777', '2006-01-08', 'C\Otra', 28080);
    
insert into socios  (socio_no, apellidos)  values (1002, 'RUIZ');

INSERT INTO prestamos (num_prestamo, socio_no) values (1 ,1000 );
insert into prestamos (num_prestamo, socio_no) values (2, 1001);
insert into prestamos (num_prestamo, socio_no) values (2, 1005);

select * from socios;
select * from prestamos;

insert into inventario (descripcion) values ('ARMARIO');
INSERT INTO inventario values (null, 'ORDENADOR');
INSERT INTO inventario (num, descripcion) values (null, 'SILLA');

SELECT * FROM INVENTARIO;


-- Ejemplos update

update socios set apellidos='MORENO', telefono='123455678'
where socio_no=1002;

set sql_safe_updates=0; -- desactivar modo seguro
update socios set codigo_postal=28850;
select * from socios;
set sql_safe_updates=1; -- activar modo seguro
update socios set codigo_postal=28800;

-- Ejemplo delete
set sql_safe_updates=0;
delete from inventario where descripcion='ARMARIO';
SELECT * FROM INVENTARIO;

