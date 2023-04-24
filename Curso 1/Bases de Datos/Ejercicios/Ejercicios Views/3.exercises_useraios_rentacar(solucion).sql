-- Ejercicios de usuarios y privilegios

USE rentacar;



/* 1.Hemos contratado personal nuevo y necesitamos proporcionarle 
acceso a la BD, crea el usuario “RafaM25” con la contraseña “RafaBD”. */
CREATE USER RafaM25 IDENTIFIED BY 'RafaBD';



/* 2.También queremos crear otra usuaria de la BD, se llamará 
“ElenaG28” con contraseña “Admin33”. */
CREATE USER ElenaG28 IDENTIFIED BY 'Admin33';

select user, host from mysql.user; -- mostramos los uusarios

/* 3.La usuaria “ElenaG28” nos ha pedido cambiar su nombre de 
usuaria por “HelenP”, atiende esa petición. */
RENAME USER ElenaG28 TO HelenP;
select user, host from mysql.user;

/* 4.Da permiso de SELECT e INSERT a la tabla Clientes de 
RentACar a la usuaria “HelenP”. */
GRANT SELECT, INSERT ON Clientes TO HelenP;
SHOW grants FOR 'HelenP';


/* 5.Concede permiso solo de SELECT a la tabla Vehiculos de 
RentACar al usuario “RafaM25”. */
GRANT SELECT ON Vehiculos TO RafaM25;
SHOW grants FOR 'RafaM25';

/* 6.Otorga permiso a “HelenP” de SELECT e INSERT a todas las 
tablas de RentACar. */
GRANT SELECT, INSERT ON rentacar.* TO HelenP;
SHOW grants FOR 'HelenP';

/* 7.Concede permiso a “RafaM25” de SELECT, INSERT y UPDATE a 
la tabla Vehiculos de RentACar. */
GRANT select, insert, update on Vehiculos TO RafaM25;
SHOW grants FOR 'RafaM25';

/* 8.Da el permiso DELETE a “HelenP” sobre la tabla Clientes 
de RentACar. */
GRANT DELETE ON Clientes TO HelenP;
SHOW grants FOR 'HelenP';


/* 9.Otro error de actuación de “RafaM25”, elimina el permiso de 
“RafaM25” de INSERT y UPDATE sobre la tabla Vehiculos de RentACar. */
REVOKE INSERT, UPDATE ON Vehiculos FROM RafaM25;
SHOW grants FOR 'RafaM25';


/* 10.“HelenP” lo está haciendo bien, a diferencia de “RafaM25”, 
concédela todos los privilegios sobre todas las tablas de RentACar. */
GRANT ALL privileges ON rentacar.* To HelenP;
SHOW grants FOR 'HelenP';

/* 11.Quita los permisos que aún tenía “RafaM25” sobre la tabla 
Vehiculos de RentACar. */
REVOKE SELECT ON Vehiculos FROM RafaM25;

/* 12.Otorga a “HelenP” permiso SELECT sobre el resto de las tablas 
de todas las  bases de datos. */
GRANT SELECT ON *.* To HelenP;

/* 13.El usuario “RafaM25” ha vuelto a pifiarla, elimina este usuario. */
DROP USER RafaM25;

/* 14.“HelenP” con su buen hacer ha demostrado que merece nuestra 
confianza, concédela todos los privilegios sobre todas las bases de datos. */
GRANT ALL privileges ON *.* To HelenP;

-- Ejemplo quitar privilegios globales
SHOW grants FOR 'HelenP';
REVOKE ALL PRIVILEGES, GRANT OPTION  FROM HelenP; 

