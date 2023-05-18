use curso;
DROP PROCEDURE IF EXISTS buclesanidados;
DELIMITER //
CREATE PROCEDURE buclesanidados()
BEGIN
	DECLARE i,j tinyint unsigned default 1;    
    bucle_externo: loop
		set j=1;
        bucle_interno: loop
			select concat ("valor de i y j: ", i, "-", j) as i_j;
            set j=j+1;
            if j>2 then
				leave bucle_interno;
			end if;        
        end loop bucle_interno;        
        set i=i+1;
        if i>2 then
			leave bucle_externo;
		end if;    
    end loop bucle_externo;   
    
END//
DELIMITER ;
 
CALL buclesanidados();









