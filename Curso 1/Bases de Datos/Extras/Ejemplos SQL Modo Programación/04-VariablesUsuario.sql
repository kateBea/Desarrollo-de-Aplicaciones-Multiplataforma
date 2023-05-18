use curso;

DROP PROCEDURE IF EXISTS example_varUser;
DELIMITER //
CREATE PROCEDURE example_varUser(in numero int)
BEGIN
	
	SET @V1=numero*2;
END//
DELIMITER ;

CALL example_varUser(3);

select @v1;




