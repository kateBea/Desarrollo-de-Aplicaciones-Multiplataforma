use curso;

DROP PROCEDURE IF EXISTS case01;
DELIMITER //
CREATE PROCEDURE case01 ()
BEGIN
	DECLARE forma_pago enum ('metálico', 'tarjeta', 'tranferencia');
    set forma_pago=2;
    case forma_pago
		when 'metálico' then
			Select 'Forma pago metálico';
        when 'tarjeta' then
			Select 'Forma pago tarjta';
        else
			Select 'Forma pago transferencia';
	end case;
END
DELIMITER ;
 
CALL case01();









