use curso;
-- Creamos tabla donde registramos las acciones hechas
drop table if exists audita;
create table audita(
	id int AUTO_INCREMENT primary key, 
    mensaje varchar(255)
);
select * from audita;
-- Creo una tabla alumnos con 2 registros
drop table if exists alumnos;
create table alumnos (
	id int primary key auto_increment,
    alumno varchar(50)

);
select * from alumnos;
-- Creamos el triger que registra los updadate sobre alumnos
DROP TRIGGER IF EXISTS trigger2;
DELIMITER //
CREATE TRIGGER trigger2 after update on alumnos for each row
begin
	DECLARE mens VARCHAR(255);
	SET mens = concat('Modificacion realizada por ', user(), ' el día ', now(), ' valores antiguos: ', old.id, ' y ', old.alumno, ' Valores nuevos: ', new.id, ' y ', new.alumno); 
	insert into audita  (mensaje) values (mens);
end //
delimiter ;

-- Probamos hacer un cambio, pero antes insertamos algun alumno para luego modificar datos
select * from alumnos;

insert into alumnos (id, alumno) values (1, 'Juan');
insert into alumnos (id, alumno) values (2, 'Pepe');
select * from alumnos;
update alumnos set alumno ='Marcos' where id=1;
select * from alumnos;
select * from audita;

