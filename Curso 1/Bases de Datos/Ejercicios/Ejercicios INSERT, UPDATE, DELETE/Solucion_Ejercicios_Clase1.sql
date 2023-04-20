/*
UT 8
Ejercicios clase 1 
*/
use jardineria;
/*1.Insértate como empleado. Perteneces a la oficina ‘MAD-ES’, y no tienes jefe*/
insert into empleados (codigoEmpleado, nombre, apellido1, apellido2, extension, email, codigooficina, codigoJefe, puesto)
values (1000, 'Ruth', 'Lospitao', 'Ruiz', 999, 'ruth@correo.es', 'MAD-ES', null, 'Profesor');


/*2. Inserta las gamas y productos que creas conveniente. Al menos serán 2 gamas y 10 productos. Tienes que realizar al menos una sentencia en la que se inserten 3 productos en la misma sentencia.*/
insert into gamasproductos (gama, descripcionTexto, descripcionHTML, Imagen)
values ('Semillas', 'Semillas de plantas', null, null);

insert into productos (codigoProducto, nombre, gama, dimensiones, proveedor, descripcion, cantidadEnStock, PrecioVenta, PrecioProveedor)
values (1000, 'Semilla 0', 'Semillas', '2x3', 'Murcia Seasons', 'Semillas de planta', 2, 1.09, 0.89),
		(1001, 'Semilla 1', 'Semillas', '2x3', 'Murcia Seasons', 'Semillas de planta', 2, 1.09, 0.89),
        (1002, 'Semilla 2', 'Semillas', '2x3', 'Murcia Seasons', 'Semillas de planta', 2, 1.09, 0.89),
        (1003, 'Semilla 3', 'Semillas', '2x3', 'Murcia Seasons', 'Semillas de planta', 2, 1.09, 0.89),
        (1004, 'Semilla 4', 'Semillas', '2x3', 'Murcia Seasons', 'Semillas de planta', 2, 1.09, 0.89),
        (1005, 'Semilla 5', 'Semillas', '2x3', 'Murcia Seasons', 'Semillas de planta', 2, 1.09, 0.89),
        (1006, 'Semilla 6', 'Semillas', '2x3', 'Murcia Seasons', 'Semillas de planta', 2, 1.09, 0.89),
        (1007, 'Semilla 7', 'Semillas', '2x3', 'Murcia Seasons', 'Semillas de planta', 2, 1.09, 0.89),
        (1008, 'Semilla 8', 'Semillas', '2x3', 'Murcia Seasons', 'Semillas de planta', 2, 1.09, 0.89),
        (1009, 'Semilla 9', 'Semillas', '2x3', 'Murcia Seasons', 'Semillas de planta', 2, 1.09, 0.89);


/*3. Inserta a tu compañero como cliente. El empleado representante de ventas serás tú, pero no puedes poner tu código de empleado en la sentencia. Es decir, la misma sentencia que guarda el cliente, busca el código de empleado.*/
insert into clientes (codigoCliente, nombreCliente, nombreContacto, ApellidoContacto, telefono, fax, LineaDireccion1, LineaDireccion2, ciudad, region, pais, codigoPostal, CodigoEmpleadoRepVentas, LimiteCredito)
select 1000, 'compañero', 'alias', 'apellidoCompañero', 6666666, 912222222, 'calle la que sea', null, 'Madrid', 'Madrid', 'España', 28000, codigoEmpleado, 1000
from empleados where nombre='Ruth' and apellido1='Lospitao';

select * from clientes;

/*4. Inserta a otro compañero como empleado, sin jefe, y de la oficina ‘MAD-ES’. Su código debe ser el siguiente al del último empleado (es decir, simular un autoincrement). No puedes consultar con un select el código del último empleado.*/
insert into empleados (codigoEmpleado, nombre, apellido1, apellido2, extension, email, codigooficina, codigoJefe, puesto)
select max(codigoEmpleado) + 1, 'Otro compañero', 'Apellido 1', 'Apellido2', 998, 'otro@correo.es', 'MAD-ES', null, 'otro'
from empleados; 

select * from empleados;

/*5. En el pedido 8, se desea insertar una nueva línea de pedido, del producto FR-44, de 3 unidades, y al precio de 2,98€*/
insert into detallepedidos (codigoPedido, codigoProducto, cantidad, precioUnidad, numeroLinea)
select 8, 'FR-44', 3, 2.98, max(numeroLinea)+1
from detallepedidos where codigoPedido=8;



/*6. Tu compañero que es cliente (ejercicio 3), quiere realizar un nuevo pedido, donde va a pedir una unidad de todos los productos que sean de la gama herramientas. Refleja el pedido completo en la base de datos. Puedes consultar las tablas que quieras para conocer los códigos, excepto de la tabla productos.*/
insert into pedidos (codigoPedido, fechaPedido, fechaEsperada, FechaEntrega, Estado, Comentarios, CodigoCliente)
values (1000, current_date(), current_date(), null, 'Pendiente', 'Pedido de mi compañero', 1000);

SET @row_number=0; -- declara una variable
insert into detallepedidos (codigoPedido, codigoProducto, cantidad, precioUnidad, numeroLinea)
select 1000, codigoProducto, 1, precioVenta, (@row_number:=@row_number+1)
from productos where gama = 'Herramientas';


/*7. Inserta a otro compañero de clase como empleado, de la oficina que más empleados tenga.*/
insert into empleados (codigoEmpleado, nombre, apellido1, apellido2, extension, email, codigooficina, codigoJefe, puesto)
select 3000, 'Aitor', 'Apellido1', 'Apellido2', 787, 'aitor@correo.es',
		(select CodigoOficina from empleados group by CodigoOficina order by count(CodigoEmpleado) desc limit 1),
        null, 'otro puesto';


/*8. Inserta a otro compañero más como empleado, de forma que sea subordinado del jefe de tu jefe. Pertenecerá a la misma oficina que el jefe de tu jefe. No puedes hacer consultas select.*/
-- lo hacemos sobre el codigoEmpleado=3
insert into empleados (codigoEmpleado, nombre, apellido1, apellido2, extension, email, codigooficina, codigoJefe)
select 1004, 'juan', 'rodriguez', 'fernandez', 2334, 'juan@correo.es', e3.codigooficina, e3.codigoempleado
from empleados e1
inner join empleados e2 on e1.codigojefe=e2.codigoempleado
inner join empleados e3 on e2.codigojefe=e3.codigoempleado
where e1.codigoempleado=3;



/*9. Tu compañero acaba de pagar ahora mismo el pedido del ejercicio 6. Actualiza la base de datos para reflejar ese pago. (no puedes realizar ningún select).*/
insert into pagos (codigoCliente, formapago, idtransaccion, fechapago, cantidad)
select c.codigocliente, 'Efectivo', '2345', current_date(), sum(PrecioUnidad*cantidad)
from clientes c
inner join pedidos p on c.codigoCliente=p.CodigoCliente
inner join detallepedidos dp on p.CodigoPedido =dp.CodigoPedido
where p.CodigoPedido=1000
group by c.codigoCliente;

select * from pagos;
select * from detallepedidos where codigopedido=1000;

/*10. Inserta a otro compañero de la clase como empleado de la oficina que más empleados tenga, de tal forma que tú seas su jefe. (Solo puedes realizar una instrucción, y no sabes ni cuál es la oficina que más empleados tiene, ni cual es tu código de empleado).*/
-- Pendiente error PRIMARY duplicado que no tiene ¿?---
insert into empleados (codigoEmpleado, nombre, apellido1, apellido2, extension, email, codigooficina, codigoJefe, puesto) 
select 3001, 'OtroM', 'Otro Compañero', 'OtroMA2', 997, 'otroM@correo.es', e.codigoOficina, e1.CodigoEmpleado, 'otro'
from empleados e
inner join empleados e1 on 1=1
where e1.nombre='Ruth' and e1.apellido1='Lospitao'
group by e.codigoOficina having count(*) = (select count(*) from empleados group by codigoOficina order by count(*) desc limit 1);

select * from empleados;

/* 11.a Crear tabla auxiliar con la misma estructura */
CREATE TABLE AUX_DetallePedidos(
	CodigoPedido integer NOT NULL, 
    CodigoProducto varchar(15) not null,
    Cantidad integer not null, 
    PrecioUnidad numeric(15,2) not null,
    NumeroLinea smallint not null,
    PRIMARY KEY (CodigoPedido, CodigoProducto)
);

select * from AUX_DetallePedidos;

/* 11.b copiar datos a la nueva tabla */
insert into AUX_DetallePedidos (codigoPedido, codigoProducto, cantidad, precioUnidad, numeroLinea)
select codigoPedido, codigoProducto, cantidad, precioUnidad, numeroLinea
from detallePedidos
where codigoProducto not in ('OR-127');

select * from aux_detallePedidos;

describe detallePedidos;
   
/*11.c Modificar claves foráneas*/
-- No tiene

/*11.d Añadir claves foráneas e índices a la  nueva tabla */
ALTER TABLE DetallePedidos DROP foreign key DetallePedidos_PedidoFK;
ALTER TABLE DetallePedidos DROP foreign key DetallePedidos_ProductoFK;
ALTER TABLE AUX_DetallePedidos ADD CONSTRAINT DetallesPedido_PedidoFK foreign key (CodigoPedido) REFERENCES Pedidos (CodigoPedido);
ALTER TABLE AUX_DetallePedidos ADD CONSTRAINT DetallesPedido_ProductoFK foreign key (CodigoProducto) REFERENCES Productos (CodigoProducto);
  
/* 11. e Eliminar tabla antigua*/
DROP TABLE DetallePedidos;
/* 11.f Renombrar tabla */
RENAME TABLE AUX_DetallePedidos TO DetallePedidos;