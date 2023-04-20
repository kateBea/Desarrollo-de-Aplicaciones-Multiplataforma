# Hugo Pelayo Aseko
# 20 de abril de 2023

/* Sobre la BD Jardinería realizar las siguientes consultas */
use jardineria;
select * from Clientes;

/*Escriba una vista que se llame listado_pagos_clientes que muestre un listado donde 
aparezcan todos los clientes y los pagos que ha realizado cada uno de ellos. 
La vista deberá tener las siguientes columnas: nombre y apellidos del cliente 
concatenados, teléfono, ciudad, pais, fecha_pago, total del pago, id de la transacción*/
CREATE OR REPLACE VIEW listado_pagos_clientes
(NombreCliente, Telefono, Ciudad, Pais, FechaPago, TotalPago, IdTransaccion) AS
SELECT NombreCliente, Telefono, Ciudad, Pais, FechaPago, SUM(Cantidad), IdTransaccion
FROM Clientes INNER JOIN Pagos ON Clientes.CodigoCliente = Pagos.CodigoCliente
GROUP BY Clientes.NombreCliente;

SELECT * FROM listado_pagos_clientes;

/*Escriba una vista que se llame listado_pedidos_clientes que muestre un listado donde aparezcan 
todos los clientes y los pedidos que ha realizado cada uno de ellos. La vista deberá tener las 
siguientes columnas: nombre y apellidos del cliente concatendados, teléfono, ciudad, pais, 
código del pedido, fecha del pedido, fecha esperada, fecha de entrega y la cantidad total del 
pedido, que será la suma del producto de todas las cantidades por el precio de cada unidad, 
que aparecen en cada línea de pedido.*/
CREATE OR REPLACE VIEW listado_pedidos_clientes
(NombreCompleto, Telefono, Ciudad, Pais, CodigoPedido, FechaEsperada, FechaEntrega, Total) AS
SELECT CONCAT(NombreContacto, ' ', ApellidoContacto), Telefono, Ciudad, Pais, Pedidos.CodigoPedido, FechaEsperada, FechaEntrega, Cantidad * PrecioUnidad
FROM Clientes INNER JOIN Pedidos INNER JOIN DetallePedidos ON Clientes.CodigoCliente = Pedidos.CodigoCliente AND Pedidos.CodigoPedido = DetallePedidos.CodigoPedido
GROUP BY Clientes.NombreCliente, Pedidos.CodigoPedido;

SELECT * FROM listado_pedidos_clientes;


/*Utilice las vistas que ha creado en los pasos anteriores para devolver un listado de los 
clientes de la ciudad de Madrid que han realizado pagos.*/
SELECT * FROM listado_pedidos_clientes WHERE FechaEntrega IS NOT NULL;

/*Utilice las vistas que ha creado en los pasos anteriores para devolver un listado de los 
clientes que todavía no han recibido su pedido.*/
SELECT * FROM listado_pedidos_clientes WHERE FechaEntrega IS NULL;

/*Utilice las vistas que ha creado en los pasos anteriores para calcular el número de pedidos 
que se ha realizado cada uno de los clientes.*/
SELECT NombreCompleto, COUNT(*) AS 'Número Pedidos' 
FROM listado_pedidos_clientes
GROUP BY NombreCompleto;

/*Utilice las vistas que ha creado en los pasos anteriores para calcular el valor del pedido 
máximo y mínimo que ha realizado cada cliente.*/
SELECT NombreCompleto, MAX(Total) AS 'Max', MIN(Total) AS 'Min' 
FROM listado_pedidos_clientes
GROUP BY NombreCompleto;

/*Modifique el nombre de las vista listado_pagos_clientes y asígnele el nombre 
listado_de_pagos. Una vez que haya modificado el nombre de la vista ejecute una consulta 
utilizando el nuevo nombre de la vista para comprobar que sigue funcionando correctamente.*/
RENAME TABLE listado_pagos_clientes TO listado_de_pagos;
SELECT * FROM listado_de_pagos;
/*Elimine las vistas que ha creado en los pasos anteriores*/
DROP VIEW listado_pagos_clientes;
DROP VIEW listado_pedidos_clientes;