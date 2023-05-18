/*Ejemplo de uso de cursores anidados.
Lista los departamentos y el num de sus empleados*/
use curso;
DROP PROCEDURE IF EXISTS anidados;
DELIMITER //
CREATE PROCEDURE anidados () 
BEGIN  
    -- 1º Declaración variables
	declare dnombre_aux, localidad_aux varchar(25);
	declare dnum_aux, total_empleados int;
    declare enum_aux int;
    declare eapellido_aux varchar (8);
    
    declare ultima_fila int default 0;
    -- 2º Declaración cursores
    declare c_departamentos cursor for  SELECT *  FROM DEPARTAMENTOS; 
    declare c_empleados cursor for SELECT emp_no, apellido FROM EMPLEADOS;
	 -- 3º Declaración de errores
    declare continue handler for not found set ultima_fila=1;
    -- Cuerpo
      
    Open c_departamentos; -- Abrir cursor de los departamentos
    recorrer_dptos: loop -- Recorrerlo
		fetch c_departamentos into dnum_aux, dnombre_aux, localidad_aux;
        if ultima_fila=1 then -- Aseguramos que no llegamos a la última fila 
			leave recorrer_dptos;
        end if;
        -- Tratamiento del registro recuperado. 
      
        set total_empleados=0;
        open c_empleados; -- Abrimos el segundo cursor
		recorrer_empleados: loop
			fetch c_empleados into enum_aux, eapellido_aux;
            if ultima_fila=1 then -- Aseguramos que no llegamos a la última fila 
				leave recorrer_empleados;
			end if;
            -- Tratamiento del registro recuperado
           
            set total_empleados = total_empleados + 1;
        end loop recorrer_empleados;
        close c_empleados;
        
        set ultima_fila=0;  
         SELECT CONCAT ("Departamento ", dnum_aux, " - ", dnombre_aux, " - ", localidad_aux, " - Total empleados: ", total_empleados) as resultado; 
        
    end loop recorrer_dptos;
    close c_departamentos; -- Cerrar cursor 
END //
DELIMITER ;
call anidados();
