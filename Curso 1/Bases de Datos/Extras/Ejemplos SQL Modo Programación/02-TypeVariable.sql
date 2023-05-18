/* Ejemplos */
use curso;
DROP PROCEDURE IF EXISTS example_variables;
DELIMITER //
CREATE PROCEDURE example_variables()
BEGIN
	DECLARE entero1, entero2, entero3 int;
    DECLARE entero4 INT DEFAULT -100; -- Valor por defecto
    
    DECLARE entero5 int unsigned default 400000; -- enteros sin signo
    declare real1 float DEFAULT 50.89;
    DECLARE real2 NUMERIC (7, 2) default 4561.44;
    DECLARE caracter1 CHAR(1) default 'Y';
    declare texto VARCHAR (50);
    declare fecha1 date default '2023-11-03';
     -- visualizamos contenido
    select real1, real2, caracter1, fecha1, entero1, entero2, entero5, texto;
END//
DELIMITER ;

call example_variables();