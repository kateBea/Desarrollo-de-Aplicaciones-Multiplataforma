use curso;
DROP PROCEDURE IF EXISTS loop2;
DELIMITER //
CREATE PROCEDURE loop2()
BEGIN
	DECLARE i tinyint unsigned;
    set i=0;
    mibucle: loop
		set i=i+1;
        if i=3 then
			iterate mibucle;
		end if;
        select 'Valor de i=' + i as i; -- esta línea se ejecutará tres veces para los valores de i 1 al 4 excepto para 3
        if i=4 then
			leave mibucle;
		end if;
	end loop mibucle;
END//
DELIMITER ;
 
CALL loop2();









