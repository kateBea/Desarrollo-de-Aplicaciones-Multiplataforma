use curso;

DROP PROCEDURE IF EXISTS operadores1;
DELIMITER //
CREATE PROCEDURE operadores1()
BEGIN	
	DECLARE a int default 2;
    declare b int default 256;
    declare c float default 440.56;
    
    set c=c+b/a; -- 568.56
    select c; -- 852.8399
    select c/2*3; -- 0
    select b%a;
END//
DELIMITER ;
CALL operadores1(); 










