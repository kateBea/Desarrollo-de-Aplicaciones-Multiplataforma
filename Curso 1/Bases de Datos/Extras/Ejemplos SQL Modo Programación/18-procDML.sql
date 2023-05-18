/* Ejemplo guardar registro en variables, cuando es solo uno podemos hacerlo pero si la select nos devuelve más de un registro nos dará error */
USE CURSO;
DROP PROCEDURE IF EXISTS procDML2;
DELIMITER //
CREATE PROCEDURE procDML2 ()
BEGIN	    
	declare dnombre_aux, localidad_aux varchar(25);
    SELECT DNOMBRE, LOCALIDAD 
    INTO dnombre_aux, localidad_aux
    FROM DEPARTAMENTOS where localidad='MADRID' ;   -- Nos devolverá solo un registro porque solo tiene uno 
	select dnombre_aux, localidad_aux; 
END //
DELIMITER ;
call procDML2();

DROP PROCEDURE IF EXISTS procDML3;
DELIMITER //
CREATE PROCEDURE procDML3 () -- Sin embargo, en este procedimiento nos devolverá más de un registro y no podremos guardar en variables
BEGIN  
    
	declare dnombre_aux, localidad_aux varchar(25);
    SELECT DNOMBRE, LOCALIDAD 
    INTO dnombre_aux, localidad_aux
    FROM DEPARTAMENTOS ;   -- Nos devolverá más de un registro
	select dnombre_aux, localidad_aux; -- Provocará un error 1172 Result Consisted of more than one row
END //
DELIMITER ;
call procDML3();

 


