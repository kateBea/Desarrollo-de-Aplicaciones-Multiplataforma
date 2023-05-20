/* Ejercicio 16*/
use jardineria;
SET GLOBAL log_bin_trust_function_creators=1;
drop procedure if exists pagosClientes;
delimiter //
create procedure  pagosClientes (IN codCliente int)
begin
	-- declaración vbles
    declare mensaje text default '';
    declare fin int default 0;
    declare total float default 0;
	declare codigo1 int;
    declare nombre1 varchar(50);
    declare ciudad1 varchar(50);
    declare pais1 varchar(50);
    declare formaPago1 varchar(50);
    declare FechaPago1 date;
    declare cantidad1 decimal (15,2);
    declare IDTransaccion1 varchar(50);

    
    
    
    -- cursor
	declare cursorPagos cursor for select formaPago, IDTransaccion, FechaPago, Cantidad from jardineria.pagos where codigoCliente = codCliente;
    -- handle
    declare continue handler for not found set fin=1;
    
    
    select codigoCliente, nombreCliente, ciudad, pais 
    into codigo1, nombre1, ciudad1, pais1 
    from jardineria.clientes where CodigoCliente=codCliente;
    
    set mensaje = concat (mensaje, concat ('\nCODIGO CLIENTE: ', codigo1), '\n');
    set mensaje = concat (mensaje, concat ('\nNOMBRE CLIENTE: ', nombre1), '\n');
    set mensaje = concat (mensaje, concat ('\nCIUDAD CLIENTE: ', ciudad1), '\n');
    set mensaje = concat (mensaje, concat ('\PAIS CLIENTE: ', pais1), '\n');
		
    
    set mensaje = concat (mensaje, '===============================================', '\n');
    set mensaje = concat (mensaje, 'ID-TRANSACCIÓN\t\t FECHA\t\t FORMA\t\t CANTIDAD', '\n');
    set mensaje = concat (mensaje, '===============================================', '\n');
    
    -- ABRIR EL CURSOR
    open cursorPagos;
    repeat -- mientras tenemos datos
		-- sacamos datos
		fetch cursorPagos into formaPago1, IDTransaccion1, FechaPago1, cantidad1;
        if (fin<>1) then
			set mensaje = concat (mensaje, concat (IDTransaccion1, '\t\t', fechaPago1, '\t\t', formaPago1, '\t\t', cantidad1), '\n');
            set total = total + cantidad1;
        end if;               
    until fin=1 end repeat;
    
    set mensaje = concat (mensaje, '==============================', '\n');
    set mensaje = concat (mensaje, concat ('TOTAL PAGOS: ', total), '\n');
	-- mostrar mensaje
    select mensaje;
    -- cerrar cursor 
    close cursorPagos;    
    
end //
delimiter ;

call pagosClientes(1);