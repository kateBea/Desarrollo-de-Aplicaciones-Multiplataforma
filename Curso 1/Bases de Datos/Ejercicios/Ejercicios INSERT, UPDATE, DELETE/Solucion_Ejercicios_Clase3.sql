/*
UT8
Ejercicios clase 3
*/
use jardineria;
SET SQL_SAFE_UPDATES = 0;
/*1*/
UPDATE detallePedidos
SET cantidad = 3
WHERE codigoPedido=10 and numeroLinea=1;

/*2*/
UPDATE productos
SET dimensiones='20-30', proveedor ='NaranjasValencianas.com'
where codigoProducto='OR-246';

/*3*/
SELECT * FROM GAMASPRODUCTOS;
-- Como no está la gama primero la inserto y luego hago update
-- primero inserto
INSERT INTO gamasproductos (gama, descripcionTexto, descripcionHTML, imagen)
select 'Herramienta', descripcionTexto, descripcionHTML, imagen
from gamasproductos
where gama='Herramientas';

-- actualizo productos
update productos 
set gama='Herramienta' 
where gama='Herramientas';

-- eliminar la gama
delete from gamasproductos where gama='Herramientas';

/*4*/
update gamasproductos 
set descripcionHTML=concat('<b>', descripcionTexto, '</b>');

/*5*/
update oficinas set ciudad='Barcelona', region='Barcelona'
where ciudad='Madrid';

/*6*/
update clientes set limitecredito=limitecredito *1.1;

/*7*/
update clientes 
set limitecredito=limitecredito *0.95
where codigoEmpleadoRepVentas in (select codigoEmpleado
									from empleados 
                                    where codigooficina in (select codigooficina from oficinas
															where ciudad='Barcelona'));

/*8*/
update clientes c set limitecredito = limitecredito *0.95
where codigoEmpleadoRepVentas in (select codigoEmpleado
									from empleados
									where codigoOficina in (select codigoOficina 
															from Oficinas o 
                                                            where o.ciudad=c.ciudad));

 /*9a*/
 update pedidos set estado ='Entregado' where estado ='entregado';
 update pedidos set estado ='Rechazado' where estado ='rechazado';
 update pedidos set estado ='Pendiente' where estado ='pendiente';

/*9b*/
update pedidos set estado='Entregado'
where fechaEntrega is not null and estado='Pendiente';

/*10a*/
create index ejercicio10 on detallePEdidos (CodigoPedido, CodigoProducto, NumeroLinea);
create table detallePedidos10(
	CodigoPedido integer not null, 
    codigoProducto varchar(15) not null, 
    Cantidad integer not null, 
    PrecioUnidad numeric (15,2) not null,
    NumeroLinea smallint not null, 
    primary key (CodigoPedido, CodigoProducto),
    CONSTRAINT DetallePedidos10_PedidoFK foreign key (CodigoPedido) REFERENCES Pedidos (codigopedido),
    CONSTRAINT DetallePedidos10_ProdutoFK foreign key (CodigoProducto) REFERENCES Productos (codigoproducto),
    CONSTRAINT DetallePedidos10_DetallePedidoFK foreign key (CodigoPedido, CodigoProducto, NumeroLinea) REFERENCES DetallePedidos (CodigoPedido, CodigoProducto, NumeroLinea)    
);

/*10b*/
insert into detallePedidos10 select * from detallePEdidos;
select * from detallepedidos10;

/*10c*/
delete from detallepedidos10 
where preciounidad = (select  precioventa from productos p
					where detallePedidos10.codigoProducto=p.codigoProducto);
/*10d*/
update detallepedidos10 
set preciounidad = (select  precioventa from productos p
					where detallePedidos10.codigoProducto=p.codigoProducto)-precioUnidad;

/*11a*/
create table detallePedidos11(
	CodigoPedido integer not null, 
    codigoProducto varchar(15) not null, 
    Cantidad integer not null, 
    PrecioUnidad numeric (15,2) not null,
    NumeroLinea smallint not null, 
    primary key (CodigoPedido, CodigoProducto),
    CONSTRAINT DetallePedidos11_PedidoFK foreign key (CodigoPedido) REFERENCES Pedidos (codigopedido),
    CONSTRAINT DetallePedidos11_ProdutoFK foreign key (CodigoProducto) REFERENCES Productos (codigoproducto),
    CONSTRAINT DetallePedidos11_DetallePedidoFK foreign key (CodigoPedido, CodigoProducto, NumeroLinea) REFERENCES DetallePedidos (CodigoPedido, CodigoProducto, NumeroLinea)    
);

/*11b*/
insert into detallePedidos11 (CodigoPedido,codigoProducto,Cantidad, PrecioUnidad, NumeroLinea)
select CodigoPedido, dp.codigoProducto, Cantidad, 
		PrecioVenta-Preciounidad, NumeroLinea
from detallePedidos dp
inner join productos p
on dp.CodigoProducto=p.CodigoProducto
where precioVenta-precioUnidad<>0;