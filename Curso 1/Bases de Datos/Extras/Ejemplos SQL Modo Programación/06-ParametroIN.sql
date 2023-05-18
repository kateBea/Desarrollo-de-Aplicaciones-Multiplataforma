use curso;

DROP PROCEDURE IF EXISTS parametroIN;
DELIMITER //
CREATE PROCEDURE parametroIN(in param integer)
BEGIN
	
	SET param = 25;
END//
DELIMITER ;
SET @p1=10;
CALL parametroIN(@p1);
SELECT @p1;





