-- Pre
USE jardineria;

/*************************************************************

    Error Code: 1418. This function has none of DETERMINISTIC, 
    NO SQL, or READS SQL DATA in its declaration and binary 
    logging is enabled (you *might* want to use the less 
    safe log_bin_trust_function_creators variable)

/*************************************************************/
SET GLOBAL log_bin_trust_function_creators = 1;

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

SELECT '¿44 es par?', boolaplha(esPar(44));

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

SELECT 'suma primeros 5 naturales', sumaN(5);
SELECT 'suma primeros 5 naturales', sumaNOptimized(5);

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

SELECT 'suma primeros 1/1 + 1/2 + ... + 1/5', sumaNDivisor(5);

-- Cleanup
DROP FUNCTION IF EXISTS sumaNDivisor;
DROP FUNCTION IF EXISTS sumaNOptimized;
DROP FUNCTION IF EXISTS sumaN;
DROP FUNCTION IF EXISTS concatDashes;
DROP FUNCTION IF EXISTS maxThree;
DROP FUNCTION IF EXISTS esPar;
DROP FUNCTION IF EXISTS maxNum;
DROP FUNCTION IF EXISTS boolalpha;
































