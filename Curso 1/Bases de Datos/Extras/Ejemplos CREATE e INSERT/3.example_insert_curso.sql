USE CURSO;

create table departamentos2
(
	dep_no int(2),
    nombre varchar(14),
    constraint pk_departamentos PRIMARY KEY (dep_no)
);

/*Ejemplo: insertar en la tabla
departamentos2 aquellos departmentos cuyo nombre
tenga más de 8 caracteres*/

insert into departamentos2 
select dep_no, dnombre from departamentos
where length(dnombre)>8;
select * from departamentos;
select * from departamentos2;

/*Ejemplo: actualizar salario de los empleados +500 euros
solo a los empleados cuyo dpto no esté Madrid */
set sql_safe_updates=0; -- para desactivar 0 / para activar 1
update empleados set salario = salario + 500
where dep_no not in (select dep_no from departamentos
					  where localidad<>'MADRID');

/* Eliminar los departamentos que no tienen empleados*/
delete from departamentos
where dep_no not in (select distinct dep_no from empleados);
select * from departamentos;
