use curso;
DROP PROCEDURE IF EXISTS while1;
DELIMITER //
CREATE PROCEDURE while1()
BEGIN
	DECLARE i tinyint unsigned;
    set i=0;
    mibucle: while i<4 do
		set i=i+1;        
        select 'Valor de i=' + i as i;        
	end while mibucle;
END//
DELIMITER ;
 
CALL while1();









