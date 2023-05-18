/* SQL PROGRAMACIÓN */
use curso;

DROP PROCEDURE IF EXISTS HolaMundo;
DELIMITER $$
CREATE PROCEDURE HolaMundo ()
BEGIN
SELECT 'Mi primer programa en MySQL';
END$$
DELIMITER ;

call HolaMundo();

