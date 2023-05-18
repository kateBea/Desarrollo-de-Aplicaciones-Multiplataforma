/*Ejemplo cursor al llegar al último registro nos mostrará error*/
use curso;
DROP PROCEDURE IF EXISTS cursor1;
DELIMITER //
CREATE PROCEDURE cursor1 () 
BEGIN  
    -- 1º Declaración variables
	declare dnombre_aux, localidad_aux varchar(25);
    
    -- 2º Declaración cursores
    declare cursor_dptos cursor for  SELECT DNOMBRE, LOCALIDAD  FROM DEPARTAMENTOS ; 
	
    -- Cuerpo
    Open cursor_dptos; -- Abrir cursor
    recorrer_dptos: loop -- Recorrerlo
		fetch cursor_dptos into dnombre_aux, localidad_aux;
        
        -- Tratamiento del registro recuperado. En nuestro caso mostrarlo
        select dnombre_aux, localidad_aux;
    end loop recorrer_dptos;
    close cursor_dptos; -- Cerrar cursor
END //
DELIMITER ;
call cursor1();