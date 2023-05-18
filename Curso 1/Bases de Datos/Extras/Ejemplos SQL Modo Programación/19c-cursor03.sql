/*Ejemplo cursor que inserta todos los departamentos en otra tabla*/
use curso;
DROP PROCEDURE IF EXISTS cursor3;
DELIMITER //
CREATE PROCEDURE cursor3 () 
BEGIN  
    -- 1º Declaración variables
	declare dnombre_aux, localidad_aux varchar(25);
    declare ultima_fila int default 0;
    -- 2º Declaración cursores
    declare c_todos cursor for  SELECT DNOMBRE, LOCALIDAD  FROM DEPARTAMENTOS; 
	 -- 3º Declaración de errores
    declare continue handler for not found set ultima_fila=1;
    -- Cuerpo
    DROP TABLE IF exists dptosMadrid;
    create table dptosMadrid(
		id int NOT NULL AUTO_INCREMENT primary KEY,
		dnombre varchar(25),
		localidad varchar(45)    
    );    
    Open c_todos; -- Abrir cursor
    recorrer_dptos: loop -- Recorrerlo
		fetch c_todos into dnombre_aux, localidad_aux;
        if ultima_fila=1 then -- Aseguramos que no llegamos a la última fila 
			leave recorrer_dptos;
        end if;
        -- Tratamiento del registro recuperado. En nuestro caso mostrarlo
        insert into dptosMadrid (DNOMBRE, LOCALIDAD)   
        select dnombre_aux, localidad_aux;
    end loop recorrer_dptos;
    close c_todos; -- Cerrar cursor 
END //
DELIMITER ;
call cursor3();
SELECT * FROM dptosMadrid;