-- Pre
USE jardineria;

/*************************************************************

    Error Code: 1418. This function has none of DETERMINISTIC, 
    NO SQL, or READS SQL DATA in its declaration and binary 
    logging is enabled (you *might* want to use the less 
    safe log_bin_trust_function_creators variable)

/*************************************************************/
SET GLOBAL log_bin_trust_function_creators = 1;
SET GLOBAL max_sp_recursion_depth = 50;

-- Helper functions ----------------------------------------------
DROP FUNCTION IF EXISTS boolalpha;
DELIMITER //
CREATE FUNCTION boolaplha(val BOOL)
RETURNS CHAR(5)
BEGIN
	IF val = TRUE THEN
		RETURN 'true';
	ELSE
		RETURN 'false';
    END IF;
END//
DELIMITER ;

DROP FUNCTION IF EXISTS maxNum;
DELIMITER //
CREATE FUNCTION maxNum(num1 FLOAT, num2 FLOAT)
RETURNS FLOAT
BEGIN
	IF num1 > num2 THEN
		RETURN num1;
	ELSE 
		RETURN num2;
	END IF;
END//
DELIMITER ; 


-- Solutions -------------------------------------------------------

-- 1:
DROP FUNCTION IF EXISTS suma3;
DELIMITER //
CREATE FUNCTION suma3(num1 FLOAT, num2 FLOAT, num3 FLOAT)
RETURNS INT
BEGIN
    RETURN num1 + num2 + num3;
END//
DELIMITER ;

SELECT suma3(4.2, 5.4, 6.7);

-- 2:
DROP FUNCTION IF EXISTS esPar;
DELIMITER //
CREATE FUNCTION esPar(numero INT)
RETURNS INT
BEGIN
    RETURN numero % 2 = 0;
END//
DELIMITER ;

SELECT boolaplha(esPar(44)) AS '¿44 es par?';

-- 3
DROP FUNCTION IF EXISTS maxThree;
DELIMITER //
CREATE FUNCTION maxThree(num1 FLOAT, num2 FLOAT, num3 FLOAT)
RETURNS FLOAT
BEGIN
	DECLARE first_val FLOAT;
    DECLARE second_val FLOAT;
    
    SELECT maxNum(num1, num2) INTO first_val;
    SELECT maxNum(first_val, num3) INTO second_val;
    
	RETURN second_val;
END//
DELIMITER ; 

SELECT maxThree(4.5, 10.5, 9.2);
SELECT maxThree(12.5, 10.5, 9.2);
SELECT maxThree(5.6, 3.5, 8.1);

-- 4:
DROP FUNCTION IF EXISTS concatDashes;
DELIMITER //
CREATE FUNCTION concatDashes(dashes_count INT)
RETURNS VARCHAR(512)
BEGIN
	DECLARE result VARCHAR(512) DEFAULT '';
    DECLARE filler CHAR(1) DEFAULT '-';
    DECLARE counter INT DEFAULT 0;
    
    WHILE (counter < dashes_count) DO
		SET result = CONCAT(result, filler);
        SET counter = counter + 1;
    END WHILE;
    
    RETURN result;
END//
DELIMITER ;

SELECT concatDashes(10);

-- 5:
DROP FUNCTION IF EXISTS sumaN;
DELIMITER //
CREATE FUNCTION sumaN(limite INT)
RETURNS INT
BEGIN
	DECLARE result INT DEFAULT 0;
    DECLARE counter INT DEFAULT 1;
    WHILE (counter <= limite) DO
		SET result = result + counter;
        SET counter = counter + 1;
    END WHILE;
    RETURN result;
END//
DELIMITER ;

DROP FUNCTION IF EXISTS sumaNOptimized;
DELIMITER //
CREATE FUNCTION sumaNOptimized(limite INT)
RETURNS INT
BEGIN
	RETURN (limite * (limite + 1)) / 2;
END//
DELIMITER ;

SELECT sumaN(5) AS 'suma primeros 5 naturales';
SELECT sumaNOptimized(5) AS 'suma primeros 5 naturales';

-- 6:
DROP FUNCTION IF EXISTS sumaNDivisor;
DELIMITER //
CREATE FUNCTION sumaNDivisor(limite INT)
RETURNS FLOAT
BEGIN
	DECLARE result FLOAT DEFAULT 0.0;
    DECLARE counter FLOAT DEFAULT 1.0;
    WHILE (counter <= limite) DO
		SET result = result + (1.0 / (counter));
        SET counter = counter + 1.0;
    END WHILE;
    RETURN result;
END//
DELIMITER ;

SELECT sumaNDivisor(5) AS 'suma primeros 1/1 + 1/2 + ... + 1/5';

-- 7:
DROP FUNCTION IF EXISTS computeHipotenusa;
DELIMITER //
CREATE FUNCTION computeHipotenusa(catAdj FLOAT, catOpuest FLOAT)
RETURNS FLOAT
BEGIN
	RETURN SQRT(POW(catAdj, 2) + POW(catOpuest, 2));
END//
DELIMITER ;

SELECT computeHipotenusa(3.6, 7.88) AS 'hipotenusa';

-- 8:
DROP FUNCTION IF EXISTS imc;
DELIMITER //
/*Recibe el peso en kilogramos y la altura en centímetros*/
CREATE FUNCTION imc(peso FLOAT, altura FLOAT)
RETURNS FLOAT
BEGIN
	RETURN peso / POW(altura / 100, 2);
END//
DELIMITER ;

SELECT imc(76.9, 178) AS 'imc peso (kG) altura (cm)';

-- 9:
DROP FUNCTION IF EXISTS imcStr;
DELIMITER //
/*Recibe el peso en kilogramos y la altura en centímetros*/
CREATE FUNCTION imcStr(peso FLOAT, altura FLOAT)
RETURNS VARCHAR(128)
BEGIN
	DECLARE result VARCHAR(128) DEFAULT '';
    DECLARE resultado FLOAT;
    SET resultado = imc(peso, altura);
    
    SET result =
		CASE 
			WHEN resultado BETWEEN 16 AND 18.4 THEN 'Bajo Peso'
            WHEN resultado BETWEEN 18.5 AND 24.9 THEN 'Rango Normal'
			WHEN resultado BETWEEN 25 AND 29.9 THEN 'Sobrepeso'
            ELSE 'Obesidad'
		END;
    SET result = CONCAT(result, ' [ imc: ', resultado,  ' ]');
    RETURN result;
END//
DELIMITER ;

SELECT imcStr(76.9, 155) AS 'imc peso (kG) altura (cm)';

-- 10:
DROP FUNCTION IF EXISTS precioConIva;
DELIMITER //
/*el valor del IVA se recibe en tanto por 100*/
CREATE FUNCTION precioConIva(precioSinInva FLOAT, valorIVA FLOAT)
RETURNS FLOAT
BEGIN
	RETURN precioSinInva * (1.0 + (valorIVA / 100)); 
END//
DELIMITER ;

SELECT precioConIva(14.45, 20) AS 'precio con IVA (20%)';

-- 12:
DROP FUNCTION IF EXISTS factorial;
DELIMITER //
CREATE FUNCTION factorial(numero INT)
RETURNS INT
BEGIN
	DECLARE counter INT DEFAULT 1;
    DECLARE result INT DEFAULT 1;
    WHILE counter <= numero DO
		SET result = result * counter;
        SET counter = counter + 1;
    END WHILE;
    
    RETURN result;
END//
DELIMITER ;

SELECT factorial(5) AS 'factorial de 5';

-- 13:
DROP PROCEDURE IF EXISTS recursiveFactorial;
DELIMITER //
CREATE PROCEDURE recursiveFactorial(IN limite INT, OUT result LONG)
BEGIN
	IF limite <= 0 THEN 
		SET result = 1;
	ELSE
		CALL recursiveFactorial(limite - 1, result);
		SET result = result * limite;
    END IF;
END//
DELIMITER ;

CALL recursiveFactorial(5, @my_variable);
SELECT @my_variable;

-- 14:
DROP PROCEDURE IF EXISTS fibonacci;
delimiter //
CREATE PROCEDURE fibonacci (IN numero INT, OUT resultado LONG)
BEGIN
	DECLARE resultado1 LONG;
    DECLARE resultado2 LONG;
    IF numero = 0 THEN
		SET resultado =0;
    ELSEIF numero <= 2 THEN
		SET resultado = 1;
    ELSE
		CALL fibonacci (numero - 1, resultado1);
        CALL fibonacci (numero - 2, resultado2);
        SET resultado = resultado1 + resultado2;
    END IF;
END//
DELIMITER ;
CALL fibonacci (5, @numero);
SELECT @numero;

-- 15:
DROP PROCEDURE IF EXISTS division;
DELIMITER //
CREATE PROCEDURE division(IN dividendo INT, IN divisor INT, OUT cociente INT, OUT resto INT)
BEGIN
	SET cociente = TRUNCATE(dividendo / divisor, 0);
    SET resto = dividendo % divisor;
END//
DELIMITER ;

SET @dividendo = 23;
SET @divisor = 4;
CALL division(@dividendo, @divisor, @cociente, @resto);
SELECT @dividendo, @divisor, @cociente, @resto;

-- 16:

SHOW FUNCTION STATUS;
-- Cleanup
DROP PROCEDURE IF EXISTS fibonacci;
DROP FUNCTION IF EXISTS recursiveFactorial;
DROP FUNCTION IF EXISTS factorial;
DROP FUNCTION IF EXISTS precioConIva;
DROP FUNCTION IF EXISTS imcStr;
DROP FUNCTION IF EXISTS imc;
DROP FUNCTION IF EXISTS computeHipotenusa;
DROP FUNCTION IF EXISTS sumaNDivisor;
DROP FUNCTION IF EXISTS sumaNOptimized;
DROP FUNCTION IF EXISTS sumaN;
DROP FUNCTION IF EXISTS concatDashes;
DROP FUNCTION IF EXISTS maxThree;
DROP FUNCTION IF EXISTS esPar;
DROP FUNCTION IF EXISTS maxNum;
DROP FUNCTION IF EXISTS boolalpha;
































