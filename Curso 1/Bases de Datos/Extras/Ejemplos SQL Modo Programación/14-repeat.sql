use curso;
DROP PROCEDURE IF EXISTS repeat1;
DELIMITER //
CREATE PROCEDURE repeat1()
BEGIN
	DECLARE i tinyint unsigned;
    set i=0;
    mibucle: repeat
		set i=i+1;
        
        select 'Valor de i=' + i as i; 
        until i=4
	end repeat mibucle;
END//
DELIMITER ;
 
CALL repeat1();









