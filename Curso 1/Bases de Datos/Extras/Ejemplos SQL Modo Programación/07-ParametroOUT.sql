use curso;

DROP PROCEDURE IF EXISTS parametroOUT;
DELIMITER //
CREATE PROCEDURE parametroOUT(out param integer)
BEGIN
	DECLARE v1 integer default 300;
    set v1=param; -- se asigna 100
    select v1, param;
	-- mostrará null en ambas porque un parámetro out no puede ser accedido desde el programa almacenado
	set param=33;
    SET param=param-5;
END//
DELIMITER ;
SET @p1=100;
CALL parametroOUT(@p1); -- Ejecuta el procedimiento mostrará 28

SELECT @p1; -- Despues de ejecutar call





