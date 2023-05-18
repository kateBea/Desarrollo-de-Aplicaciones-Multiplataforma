/*Ejemplo cursor que soluciona el error cuando llega al último registro */
use curso;
DROP PROCEDURE IF EXISTS cursor2;
DELIMITER //
CREATE PROCEDURE cursor2 () 
BEGIN  
    -- 1º Declaración variables
	declare dnombre_aux, localidad_aux varchar(25);
    declare ultima_fila int default 0;
    -- 2º Declaración cursores
    declare cursor_dptos cursor for  SELECT DNOMBRE, LOCALIDAD  FROM DEPARTAMENTOS ; 
	
    -- 3º Declaración de errores
    declare continue handler for not found set ultima_fila=1;
    -- Cuerpo
    Open cursor_dptos; -- Abrir cursor
    recorrer_dptos: loop -- Recorrerlo
		fetch cursor_dptos into dnombre_aux, localidad_aux;
        if ultima_fila=1 then -- Aseguramos que no llegamos a la última fila 
			leave recorrer_dptos;
        end if;
        -- Tratamiento del registro recuperado. En nuestro caso mostrarlo
        select dnombre_aux, localidad_aux;
    end loop recorrer_dptos;
    close cursor_dptos; -- Cerrar cursor
END //
DELIMITER ;
call cursor2();