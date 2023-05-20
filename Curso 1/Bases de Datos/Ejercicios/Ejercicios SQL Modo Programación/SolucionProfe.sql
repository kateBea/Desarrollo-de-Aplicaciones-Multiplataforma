use curso;
SET GLOBAL log_bin_trust_function_creators=1;
DELIMITER //
-- Ejercicio 1
CREATE FUNCTION suma3(n1 float, n2 float, n3 float) 
returns float
begin
	return n1+n2+n3;
end //
DELIMITER ;
-- Ejercicio 2
DELIMITER //
CREATE FUNCTION par (numero int) returns boolean
BEGIN   
   return numero % 2 = 0;    
END //
DELIMITER ;

-- Ejercicio 3
DELIMITER //
CREATE FUNCTION maximo (n1 int, n2 int, n3 int) 
returns int
BEGIN   
   if (n1>n2 && n1>n3) then
		return n1;
	elseif n2>n3 then
		return n2;
	else
		return n3;
	end if;
END //
DELIMITER ;

-- Ejercicio 4
DELIMITER //
CREATE FUNCTION guiones (numero int) returns varchar(255)
BEGIN
	declare cadena varchar(255) default '';
    while (numero>0) do
		set cadena = concat (cadena , '-');
        set numero = numero -1;
    end while;
    return cadena;
END //
DELIMITER ;
-- ejercicio 5:   Crea una función que sume los n primeros números naturales. N será indicado como parámetro.
drop function if exists sumaNaturales;
DELIMITER //
create function sumaNaturales (numero int) returns int
begin
	declare suma float default 0;
    declare contador int default 1;
    while contador <= numero do
		set suma = suma + contador;
        set contador = contador + 1;
    end while;
    return suma;
end //
DELIMITER ;

select sumaNaturales(3);
select sumaNaturales(5);


-- ejercicio 6
drop function if exists sumaFracciones;
DELIMITER //
create function sumaFracciones (numero int) returns float
begin
	declare suma float default 0;
    declare contador int default 1;
    while contador <= numero do
		set suma = suma + 1 / contador;
        set contador = contador + 1;
    end while;
    return suma;
end //
DELIMITER ;

select sumaFracciones(3);
-- ejercicio 7
DELIMITER //
create function hipotenusa (cateto1 float, cateto2 float) returns float
begin
	return sqrt (pow(cateto1, 2)+pow(cateto2,2));
end //
DELIMITER ;
select hipotenusa(3,4);

-- ejercicio 8
delimiter //
create function imc (peso float, altura int) returns float
begin
	return peso / pow(altura / 100,2);
end //
delimiter ;
select imc(70, 180);

-- ejercicio 9
delimiter //
create function varcharIMC (peso float, altura int) returns varchar(255)
begin
	declare imc float default imc(peso, altura);
    case
		when imc < 20 then return 'Peso bajo';
        when imc < 25 then return 'Rango normal';
        when imc < 30 then return 'Sobrepeso';
        else return 'Obesidad';
    end case;    
end //
delimiter ;

select varcharIMC(70, 180);
select varcharIMC(50, 160);

-- ejercicio 10
delimiter //
create function precioConIva (precioBase float, porcentajeIVA int) returns float
Begin
	return precioBase * (1 + porcentajeIVA / 100);
End //
delimiter ;
select precioConIva (100, 21), precioConIVA (2000, 21);

-- ejercicio 11
drop function if exists importeIVA;
delimiter //
create function importeIVA(precio float, porcentajeIVA int ) returns float
begin
	return precio * (porcentajeIVA / 100 / (1+porcentajeIVA/100));
end//
delimiter ;
select importeIVA (121, 21), importeIVA (2420, 21);

-- ejercicio 12 factorial
drop function if exists factorial;
delimiter //
create function factorial (numero int) returns long
begin
	declare factor int default 1;
    declare factorial long default 1;
    while (factor <= numero) do
		set factorial = factorial * factor;
        set factor = factor +1;    
    end while;
    return factorial;
end //
select factorial(2), factorial(5);

-- ejercicio factoria recursivo
delimiter //
create procedure factorialRecursivo (IN numero int, OUT resultado long)
BEGIN
	if numero <=1 then
		set resultado =1;
    else
		call factorialRecursivo (numero-1, resultado);
        set resultado = resultado * numero;
    end if;
END //
delimiter ;
-- para recursividad cuando ejecuto me dará un error de la vble max_sp_recursion_depth tenemos dar valor
set max_sp_recursion_depth=50;
call factorialRecursivo (5, @numero);
select @numero;

-- ejercicio 14
delimiter //
create procedure fibonacci (in numero int, out resultado long)
begin
	declare resultado1 long;
    declare resultado2 long;
    if numero =0 then
		set resultado =0;
    elseif numero <=2 then
		set resultado = 1;
    else
		call fibonacci (numero -1, resultado1);
        call fibonacci (numero -2, resultado2);
        set resultado = resultado1+resultado2;
    end if;
end //
delimiter ;
call fibonacci (5, @numero);
select @numero;

-- se añade un procedimietno para mostrar el fibonacci
delimiter //
create procedure showFibonacci (in numero int)
begin
	declare contador int default 1;
    declare resultado long;
    while (contador < numero) do
		call fibonacci(contador, resultado);
        select resultado;
        set contador = contador +1;
    end while;
end //
delimiter ;
call showFibonacci(5);

-- ejercicio 15

delimiter //
create procedure division (in dividendo int, in divisor int, out cociente int, out resto int)
begin
	set cociente = truncate (dividendo / divisor, 0);
    set resto = dividendo % divisor;
end //
delimiter ;

set @dividendo=23;
set @divisor=4;
call division (@dividendo, @divisor, @cociente, @resto);
select @dividendo, @divisor, @cociente, @resto;


/* Ejercicio 16*/
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