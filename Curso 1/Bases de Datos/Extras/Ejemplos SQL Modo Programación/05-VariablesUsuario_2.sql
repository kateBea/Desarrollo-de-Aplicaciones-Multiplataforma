use curso;

DROP PROCEDURE IF EXISTS example_varUser2;
DELIMITER //
CREATE PROCEDURE example_varUser2()
BEGIN
	
	SET @nombre='Lucía';
    CALL saluda();
    select @nombre;
END//
DELIMITER ;

CALL example_varUser2();






