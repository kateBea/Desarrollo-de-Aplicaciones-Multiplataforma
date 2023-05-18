/* Ejemplo asignación variable */
use curso;

DROP PROCEDURE IF EXISTS example_variable02;
DELIMITER //
CREATE PROCEDURE example_variable02()
BEGIN
	DECLARE caracter1 char(1);
    DECLARE forma_pago ENUM('Metálico', 'Tarjeta', 'Transferencia');
    
    -- asiganmos valores a las variables
    SET caracter1 = 'N';
    SET forma_pago = 'Tarjeta';
    SET forma_pago=1; -- Metélico
    -- SET forma_pago = 'cheque' da error porque no existe dicho valor
	SELECT caracter1, forma_pago;
END//
DELIMITER ;

CALL example_variable02();