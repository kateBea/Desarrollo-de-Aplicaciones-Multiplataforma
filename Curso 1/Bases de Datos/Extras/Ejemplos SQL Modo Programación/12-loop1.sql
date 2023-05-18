use curso;
-- Ejemplo donde se ejecutará 4 veces el bucle
DROP PROCEDURE IF EXISTS loop1;
DELIMITER //
CREATE PROCEDURE loop1()
BEGIN
	DECLARE i tinyint unsigned;
    set i=0;
    mibucle: loop
		set i=i+1;
        select 'Valor de i=' + i as i;
        if i=4 then
			leave mibucle;
		end if;
	end loop mibucle;
END//
DELIMITER ;
 
CALL loop1();









