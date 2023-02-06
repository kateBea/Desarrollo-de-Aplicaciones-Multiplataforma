use jardineria;

-- todas en orden de ejercicio si no se especifica contrario

select * from clientes;
select * from oficinas;
select nombre, apellido1, apellido2 from empleados;
select fechapago, cantidad from pagos;
select concat(nombre, ' ', apellido1, ' ', apellido2) from empleados;
select nombre, precioventa from productos;
select nombre from empleados where apellido1 like '%LOPEZ%';
select * from empleados where concat(nombre, ' ', apellido1, ' ', apellido1) like '%CARLOS SORIA BALE%'; # no hay ninguno. Hay otro con giménez
select * from clientes where nombrecontacto like 'LUIS' and apellidocontacto <>'JIMENEZ';
select nombre, precioventa from productos where cantidadenstock < 100;
select * from productos where precioventa = 5;
select * from productos where gama = 'HERRAMIENTAS' and precioventa < 2.5 and proveedor like 'C%';
select * from productos where precioventa % 2 = 0;
select * from productos where precioventa < 1 or precioventa > 2;
select * from productos where gama in ('HERRAMIENTAS', 'ORNAMENTALES', 'FRUTALES');
select * from pedidos where fechapedido between '2008-04-03' and '2009-05-20';
select * from productos where descripcion like '%vulgar%';
select * from productos where descripcion like '%vulgar%' and precioventa < 2;
select * from productos where precioventa between 1 and 4.34;
select * from productos where round(precioventa) < 2;
select * from productos where nombre like '%E%E%';
select * from productos where length(nombre) = 7;
select * from empleados where nombre like '%A' and apellido1 like '%A';
select * from clientes where nombrecliente not like '%A%';
select * from productos where precioventa not in (3, 4); # 25 y 26
select * from pagos where day(fechapago) = 1;
select year(fechapago), cantidad from pagos where cantidad < 300; 
select * from pagos where fechapago between '2005-08-01' and '2005-08-31';



