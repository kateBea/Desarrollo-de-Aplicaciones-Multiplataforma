/*
	Hugo Pelayo Aseko
    Examen Bases de Datos: MODELO A
	22 - 05 - 2023
*/

USE curso;
SET GLOBAL log_bin_trust_function_creators = 1;

-- Ejercicio 1:
DROP TRIGGER IF EXISTS control_stock_positivo_prod;
DELIMITER $$
CREATE DEFINER = CURRENT_USER TRIGGER control_stock_positivo_prod
BEFORE INSERT ON productos
FOR EACH ROW
BEGIN
	IF NEW.stock_disponible < 0 THEN
		SET NEW.stock_disponible = 0;
	END IF;
END $$
DELIMITER ;

SELECT * FROM productos;
INSERT INTO PRODUCTOS (producto_no, descripcion, precio_actual, stock_disponible) 
	VALUES (90, 'SMART TV', 784.3, -5);
SELECT * FROM productos;

-- Ejercicio 2:
DROP PROCEDURE IF EXISTS nuevoProducto;
DELIMITER $$
CREATE PROCEDURE nuevoProducto(codProd INT(4), descrip VARCHAR(30), precio FLOAT(8, 2), stock INT(9))
BEGIN
	DECLARE EXIT HANDLER FOR 1062
    BEGIN
		SELECT 'Registro no insertado porque ya existe' AS 'mensaje';
        INSERT INTO error_log (Fecha, error_message)  
			VALUES (CONCAT('Fecha: ', CURRENT_DATE()), CONCAT('Código producto repetido: ', codProd)); 
	END;
    
	CREATE TABLE IF NOT EXISTS error_log (Fecha CHAR(20), error_message VARCHAR(128));
    
    INSERT INTO PRODUCTOS (producto_no, descripcion, precio_actual, stock_disponible) 
		VALUES (codProd, descrip, precio, stock);
	
    SELECT 'Registro insertado correctamente' AS 'mensaje';
    
END $$
DELIMITER ;

CALL nuevoProducto(10, 'SMART TV', 784.3, -5);
CALL nuevoProducto(90, 'SMART TV', 784.3, -5);
SELECT * FROM error_log;

-- Ejercicio 3:
CREATE TABLE IF NOT EXISTS auditaClientes(
			info VARCHAR(512)
	);


DROP TRIGGER IF EXISTS control_audita_clientes;
DELIMITER $$
CREATE DEFINER = CURRENT_USER TRIGGER control_audita_clientes
AFTER UPDATE ON clientes
FOR EACH ROW
BEGIN
	INSERT INTO auditaClientes VALUES (	
			CONCAT(CURRENT_DATE(), ': modificación del cliente ', NEW.cliente_no, '\n',
				'Debe anterior: ', OLD.debe, ' Debe actualizado: ', NEW.debe, '\n',
                'Haber anterior: ', OLD.haber, '  actualizado: ', NEW.haber, '\n',
                'Límite crédito anterior: ', OLD.limite_credito, ' Límite crédito actualizado: ', NEW.limite_credito, '\n'
            )
	);
END $$
DELIMITER ;

UPDATE clientes
SET debe = 0, haber = 50, limite_credito = 3000
WHERE cliente_no = 108;

SELECT * FROM auditaClientes;
SELECT * FROM Clientes;

-- Ejercicio 4:
DROP TABLE IF EXISTS cuadrados;
CREATE TABLE IF NOT EXISTS cuadrados (
	numero INT UNSIGNED,
    columna INT UNSIGNED
);

DROP PROCEDURE IF EXISTS calcular_cuadrados;
DELIMITER $$
CREATE PROCEDURE calcular_cuadrados(limite INT UNSIGNED)
BEGIN
	DECLARE counter INT UNSIGNED DEFAULT 1;
    
	IF (SELECT COUNT(*) FROM cuadrados) > 0 THEN
		TRUNCATE cuadrados;
	END IF;
    
	WHILE (counter <= limite) DO
		INSERT INTO cuadrados (numero, columna) VALUES (counter, counter * counter);
        SET counter = counter + 1;
    END WHILE;
    
END $$
DELIMITER ;

-- Ejemplo 1:
CALL calcular_cuadrados(4);
SELECT * FROM cuadrados;

-- Ejemplo 2:
CALL calcular_cuadrados(12);
SELECT * FROM cuadrados;

