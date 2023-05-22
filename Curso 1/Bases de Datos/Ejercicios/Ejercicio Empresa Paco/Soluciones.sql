USE EmpresaPaco;
SET GLOBAL log_bin_trust_function_creators = 1;

-- Ejercicio 1:
DROP FUNCTION IF EXISTS comision_actual;
DELIMITER $$
CREATE FUNCTION comision_actual(Emp_no INT)
RETURNS INT
BEGIN
	
	DECLARE resultado INT DEFAULT 0;
    DECLARE cursor_result CURSOR FOR SELECT comision FROM empleados WHERE empleados.emp_no = Emp_no;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND
		SET resultado = '-1';
        
	OPEN cursor_result;
    FETCH cursor_result INTO resultado;
    CLOSE cursor_result;
    
    IF resultado IS NULL THEN
		SET resultado = 0;
    END IF;
    
    RETURN resultado;
END $$
DELIMITER ;


SELECT 7499 AS 'Número empleado', comision_actual(7499) AS 'Comisión actual';
SELECT 7654 AS 'Número empleado', comision_actual(7654) AS 'Comisión actual';
SELECT 7782 AS 'Número empleado', comision_actual(7782) AS 'Comisión actual';
SELECT 1623 AS 'Número empleado', comision_actual(1623) AS 'Comisión actual';


-- Ejercicio 2:
DROP PROCEDURE IF EXISTS pone_comision;
DELIMITER $$
CREATE PROCEDURE pone_comision(par_codEmpleado INT, par_comision FLOAT(6, 2))
BEGIN
    DECLARE resultado INT DEFAULT 0;
    DECLARE emp_comision INT;
    DECLARE erro_comision_mayor CONDITION FOR SQLSTATE '45000';
    DECLARE cursor_result CURSOR FOR SELECT emp_no FROM empleados WHERE emp_no = par_codEmpleado;
    
    DECLARE EXIT HANDLER FOR NOT FOUND
        SELECT par_codEmpleado AS 'No existe empleado';
        
    DECLARE EXIT HANDLER FOR erro_comision_mayor
        SELECT par_codEmpleado AS 'Empleado ya tiene comision mayor';
    
    -- Comprobar que existe el empleado
    OPEN cursor_result;
    FETCH cursor_result INTO emp_comision;
    CLOSE cursor_result;
    
    IF emp_comision > par_comision THEN
        SIGNAL erro_comision_mayor;
    END IF;
    
    UPDATE empleados
    SET comision = par_comision
    WHERE emp_no = par_codEmpleado;
    
END $$
DELIMITER ;

CALL pone_comision(12, 3.4);
CALL pone_comision(7654, 500);



-- Ejercicio 3:
DROP PROCEDURE IF EXISTS sube_productos_10porcien;
DELIMITER $$
CREATE PROCEDURE sube_productos_10porcien()
BEGIN
	DECLARE subida FLOAT(8, 2) DEFAULT 0.1;
    
    SET SQL_SAFE_UPDATES = 0;
	UPDATE productos
    SET precio_actual = precio_actual * (1.0 + subida);
    SET SQL_SAFE_UPDATES = 1;
    
    SELECT CONCAT('Subida de ', subida, '% aplicada') AS InfoMessage;
END $$
DELIMITER ;
CALL sube_productos_10porcien();


-- Ejercicio 4:
DROP TRIGGER IF EXISTS actualiza_stock;
DELIMITER $$
CREATE DEFINER = CURRENT_USER TRIGGER actualiza_stock
BEFORE INSERT ON pedidos
FOR EACH ROW
BEGIN     
	UPDATE productos
	SET stock_disponible = stock_disponible - NEW.unidades
	WHERE producto_no = NEW.producto_no;
END $$
DELIMITER ;

INSERT INTO pedidos VALUES(1019, 50, 105, 6, '2023-12-17');
INSERT INTO pedidos VALUES(1020, 50, 105, 5, '2023-12-17');


-- Ejercicio 5:
DROP TRIGGER IF EXISTS alerta_stock_bajo;
DELIMITER $$
CREATE DEFINER = CURRENT_USER TRIGGER alerta_stock_bajo
AFTER UPDATE ON productos
FOR EACH ROW
BEGIN 
	DECLARE RENOVACION INT DEFAULT 20;
	DECLARE unidades_actuales INT DEFAULT 0;
    SELECT (SELECT stock_disponible FROM productos WHERE productos.producto_no = NEW.producto_no) INTO unidades_actuales;
	
    -- En el caso de haber solicitado más cantidad de la que teníamos
    -- disponible, el stock_disponible tendrá un valor negativo debido al trigger del
    -- ejercicio 4
    IF (unidades_actuales) < 0 THEN
		INSERT INTO renovar_stock (id_entrada, producto_no, stock_actual, fecha_aviso) 
				VALUES (NULL, NEW.producto_no, unidades_actuales * (-1) , CURRENT_DATE());
    
    ELSEIF (unidades_actuales) < 10 THEN
		-- Solicitamos RENOVACION unidades cada vez que nos quedamos sin stock
		INSERT INTO renovar_stock (id_entrada, producto_no, stock_actual, fecha_aviso) 
				VALUES (NULL, NEW.producto_no, RENOVACION , CURRENT_DATE());
    END IF;
END $$
DELIMITER ;


INSERT INTO pedidos VALUES(1019, 50, 105, 6, '2023-12-17');
INSERT INTO pedidos VALUES(1020, 50, 105, 5, '2023-12-17');


















