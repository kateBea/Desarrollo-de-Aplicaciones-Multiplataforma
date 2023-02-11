create database if not exists instituto;

use instituto;

drop table if exists cursos, materias, inscritos;

create table cursos(
codigo tinyint unsigned auto_increment,
nombre varchar(30),
primary key(codigo)
);

create table materias(
codigo tinyint unsigned auto_increment,
codigocurso tinyint unsigned,
nombre varchar(30),
profesor varchar(30),
primary key(codigo,codigocurso)
);

create table inscrito(
documento char(8) not null,
codigocurso tinyint unsigned,
codigomateria tinyint unsigned,
anio year,
cuota char(1),/* ‘s’ si esta pagado o ‘n’ si no*/
primary key (documento,codigocurso,codigomateria,anio)
);

/* Inserts en los cursos*/
insert into cursos values(1,'Analista de sistemas');
insert into cursos values(2,'Diseñador web');

/* Inserts en las materias*/
insert into materias values(1,1,'Programacion I','Alfredo Lopez');
insert into materias values(2,1,'Sistemas de datos I','Bernardo Garcia');
insert into materias values(3,1,'Ingles tecnico','Edit Torres');
insert into materias values(1,2,'Programacion basica','Alfredo Lopez');
insert into materias values(2,2,'Ingles I','Edit Torres');
insert into materias values(3,2,'Protocolos','Hector Juarez');

/* Inserts en inscritos*/
insert into inscrito values('22333444',1,1,'2015','s');
insert into inscrito values('22333444',1,2,'2015','s');
insert into inscrito values('22333444',1,3,'2016','n');
insert into inscrito values('23222222',1,1,'2015','s');
insert into inscrito values('23222222',1,2,'2016','s');
insert into inscrito values('24555666',1,1,'2015','s');
insert into inscrito values('24555666',2,1,'2015','s');
insert into inscrito values('25000999',1,1,'2015','s');
insert into inscrito values('25000999',1,2,'2015','s');
insert into inscrito values('25000999',2,1,'2016','n');
insert into inscrito values('25000999',2,2,'2016','s');