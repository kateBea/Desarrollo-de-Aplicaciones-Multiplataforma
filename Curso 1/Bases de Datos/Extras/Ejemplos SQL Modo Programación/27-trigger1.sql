use curso;
select * from alumnos; -- para ver los registros tiene la tabla original
drop table if exists alumnos_replica;
create table alumnos_replica
(
	id int primary key,
    alumno varchar(50)
);

-- Creación trigger que mantiene sincronizada una copia de seguridad
DROP TRIGGER IF EXISTS trigger1;
DELIMITER //
CREATE TRIGGER trigger1 before insert on alumnos for each row
begin
	insert into alumnos_replica values (new.id, new.alumno);
end //
delimiter ;
select * from alumnos_replica; -- no tenemos alumnos
-- Insertamos un nuevo alumno
insert into alumnos values (3, 'Juan');
select * from alumnos_replica; -- aparece el nuevo registro