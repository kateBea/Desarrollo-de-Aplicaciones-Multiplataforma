/*
UT 8
Ejercicios Clase II
*/
use jardineria;
SET SQL_SAFE_UPDATES=0; -- Desactivamos modo seguro
/*1.Bórrate como empleado*/
delete from empleados
where nombre ='Ruth' and apellido1='Lospitao';
-- No nos permite por la integridad referencial. Nos da 
-- el siguiente mensaje al ejecutar
-- Cannot delete or update a parent row: a foreign key constraint fails (`jardineria`.`clientes`, CONSTRAINT `Clientes_EmpleadosFK` FOREIGN KEY (`CodigoEmpleadoRepVentas`) REFERENCES `empleados` (`CodigoEmpleado`))	0.016 sec

/* Borra todos los productos de una de las gamas que has creado. ¿Qué ocurre?*/
delete from productos where gama like 'Semillas';
delete from gamasproductos where gama like 'Semillas';

/* 3. Borra todos los clientes de los que tú seas el representante de ventas. No puedes consultar cuál es tu código de empleado.*/
-- nota es necesario borrar en un orden...

delete from pagos 
where CodigoCliente in (select codigoCliente from Clientes 
						where codigoEmpleadoRepVentas in (select codigoEmpleado from empleados
															where nombre ='Ruth' and apellido1='Lospitao'));
                                                            
delete from detallePedidos
where CodigoPedido in ( select codigoPedido from pedidos 
						where codigoCliente in ( select CodigoCliente from clientes 
												where codigoEmpleadoRepVentas in (select codigoEmpleado 
																					from empleados where nombre='Ruth' and apellido1='Lospitao')));                                                     

delete from pedidos 
where codigoCliente in (select CodigoCliente from clientes
							where CodigoEmpleadoRepVentas in (select codigoEmpleado 
																from empleados 
                                                                where nombre ='Ruth' and apellido1='Lospitao'));																
                                                                
delete from clientes 
where CodigoEmpleadoRepVentas in (select codigoEmpleado from empleados 
								where nombre ='Ruth' and apellido1='Lospitao');  
                                
/* 4.	Borra todos los empleados que sean subordinados de tu jefe. */
delete from empleados 
where CodigoJefe in (select CodigoJefe 
					from (select codigoJefe from empleados 
							where nombre='Ruth' and apellido1='Lospitao') as temporal);

/* 5.	Borra la última línea del pedido 8.*/
delete from detallepedidos
where codigoPedido=8 
and NumeroLinea = (select linea 
					from (select max(NumeroLinea) as linea 
						  from detallePedidos where codigoPedido=8) as temp);


/*6.	Borra completamente el pedido 8.*/
-- ojo con el orden..
delete from detallepedidos where codigoPedido=8;
delete from pedidos where codigoPedido=8;

/* 7.	Borra todos los empleados de la oficina que más empleados tenga.*/
-- Nos da error por la integridad referencial porque los empleados relacionan a empleados para el jefe 
delete from empleados
where codigoOficina = (select CodigoOficina 
						from (select codigoOficina from empleados 
								group by CodigoOficina 
                                order by count(codigooficina) desc limit 1 ) as temp);
            
/*8.	Borra todos los pedidos de más de 1000€.*/
delete from detallepedidos
where codigopedido in (select codigopedido 
						from (select codigoPedido 
								from detallePedidos
								group by codigoPedido
                                having sum(preciounidad * cantidad)>1000) as tmp);
-- borramos los pedidos que no tengan ninguna línea
delete from pedidos where codigoPedido not in (select codigoPedido from detallePedidos);

/* 9 */
delete from detallepedidos
where codigopedido in (select codigopedido 
						from (select detallepedidos.codigoPedido 
							  from detallepedidos 
                              inner join pedidos on detallepedidos.codigoPedido=pedidos.codigoPedido
                              group by codigoCliente 
                              having sum(PrecioUnidad*cantidad)>1000) as tmp);

-- de nuevo borramos pedidos que no tengan líneas de detalle
delete from pedidos where codigoPedido not in (select codigoPedido from detallePedidos);

-- borramos los clientes que no tengan pedidos
delete from pagos where codigoCliente not in (select codigoCliente from pedidos);
delete from clientes where codigoCliente not in (select codigoCliente from pedidos);
                            
/* 10 Truncate tabla */
truncate table productos;
-- El truncate comprueba la integridad referencial así q no puede borrar algún producto que esta en un detalle de pedido




                                