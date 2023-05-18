use curso;

DROP PROCEDURE IF EXISTS saluda;
DELIMITER //
CREATE PROCEDURE saluda()
BEGIN
	
	SET @nombre= CONCAT ('Hola ', @nombre);
  
END//
DELIMITER ;








