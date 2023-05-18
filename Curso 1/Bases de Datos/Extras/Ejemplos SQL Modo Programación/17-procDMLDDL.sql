/* Ejemplo Procedimiento Almacenado y DML */
USE CURSO;
DROP PROCEDURE IF EXISTS procDML;
DELIMITER //
CREATE PROCEDURE procDML ()
BEGIN	    
    DROP TABLE IF exists dptosMadrid;
    create table dptosMadrid(
		id int NOT NULL AUTO_INCREMENT primary KEY,
		dnombre varchar(25),
		localidad varchar(45)    
    );
    
    insert into dptosMadrid (DNOMBRE, LOCALIDAD) 
    SELECT DNOMBRE, LOCALIDAD FROM DEPARTAMENTOS WHERE LOCALIDAD='MADRID';    
    SELECT * FROM dptosMadrid;   
END //
DELIMITER ;
call procDML();


 


