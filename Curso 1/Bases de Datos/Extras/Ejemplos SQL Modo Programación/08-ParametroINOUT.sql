use curso;

DROP PROCEDURE IF EXISTS parametroINOUT;
DELIMITER //
CREATE PROCEDURE parametroINOUT(inout param decimal(7,2))
BEGIN
	
	set param = param / 166.386;
END//
DELIMITER ;
SET @p1=1000;
CALL parametroINOUT(@p1); 

SELECT @p1; 





