insert into Profe (ape1, ape2, nombre, id) values ('sutil', 'martin', 'miguel', 1), ('rosa', 'cordero','gonzalez',2);
insert into CorreoElectronico (direccionCorreo, idCorreo) values  ('miguel@gmail.com', 1), ('miguelsutil@gmail.com', 2), ('miguel@yahoo.com', 3);
update CorreoElectronico set IdProfesor=1 where idCorreo=1;
update CorreoElectronico set IdProfesor=1 where idCorreo=2;
update CorreoElectronico set IdProfesor=1 where idCorreo=3;
