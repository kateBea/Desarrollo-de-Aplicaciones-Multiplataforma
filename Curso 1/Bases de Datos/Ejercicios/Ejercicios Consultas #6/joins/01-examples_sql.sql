use northwind_mysql;

/* ############# INTRODUCCIÓN A LAS JOINS #######################################################################################################
Para combinar datos de varias tablas usamos operaciones JOIN.
Hay tres tipos de uniones: 
   - INNER JOIN, 
   - OUTER (LEFT JOIN o RIGHT JOIN) 
    - y CROSS JOIN 
         nota: en MySQL CROSS JOIN es lo mismo que una unión interna. En otros sistemas de administración de bases de datos 
         como Microsoft SQL Server, las uniones cruzadas mostrar cada combinación de todas las filas en las tablas unidas. 
         Esto se puede lograr en MySQL usando una combinación sin una columna común.

REGLAS:
*Cuando se unen dos tablas, las dos tablas están relacionadas por la columna de clave principal en una tabla y la columna de clave externa en otra tabla. 
*Si las condiciones de combinación no se basan en la columna de clave principal y la columna de clave externa,
 deben basarse en columnas con valores de datos comunes del mismo tipo de datos o similar.
* Las columnas unidas no tienen que tener el mismo nombre de columna.
* Al unir dos tablas en una clave primaria compuesta, todas las columnas que componen la clave primaria compuesta deben usarse en la unión. 
De lo contrario, se devolverán registros duplicados en el conjunto de resultados.
* Cuando dos tablas usan los mismos nombres de columna, use el formato table_name.column_name o table_alias.column_name en la cláusula SELECT 
para diferenciarlos en el conjunto de resultados.
* Usar INNER JOIN siempre que sea posible porque OUTER JOIN usa muchos más recursos del sistema y es mucho más lento.
*/





/*
######################    INNER JOIN ####################################
-- INNER JOIN se utiliza para mostrar datos coincidentes entre las tablas A y B 
-- Sintaxis

SELECT <lista_campos> from <TablaA> INNER JOIN <TablaB> ON a.key=b.key;

*/
# Mostrar todos los productos que se encuentran en un pedido (u orden)
select p.ProductID, p.ProductName, o.OrderID 
from Products p inner join order_details o on p.ProductID=o.productID; 



/**************** OUTER JOIN ******************+
Con la combinación externa, podemos recuperar datos que NO tienen valores comunes en las columnas de combinación.
---> La combinación izquierda significa que se devolverán todos los datos de la tabla a la izquierda de la cláusula JOIN, 
incluidas las filas no coincidentes que no se encuentran en la tabla a la derecha de la cláusula JOIN
Sintaxis:
	select t1.* from Table1 as t1
	left join Table2 as t2 on t1.column1=t2.column1;
----> Cuando una columna en la tabla RIGHT contiene valores NULL, la consulta de unión izquierda solo devolverá filas 
no coincidentes que no se encuentran en la tabla a la derecha de la cláusula JOIN
Sintaxis: 
	select t1.* from Table1 as t1
	left join Table2 as t2 on t1.column1=t2.column1 where t2.column1 is null;
    

*/

/*********** LEFT OUTER JOIN O LEFT JOIN ****************
Muestra los registros de la tabla izquierda más los registros coincidentes con la tabla derecha
SINTAXIS
	SELECT <lista_campos>
	FROM <TablaA> 	LEFT JOIN <Tablab>	ON A.Key=B.Key

*/


# Se desea conocer que empleados han atendido un pedido independientemente si este lo ha realizado o no
Select OrderID, e.EmployeeID, LastName, FirstName
from Employees e left join orders o on e.employeeid=o.employeeid;

/*********** LEFT OUTER JOIN IS NULL O LEFT JOIN (is null)****************
Muestra los registros de la tabla izquierda menos los registros coincidentes con la tabla derecha
SINTAXIS
	SELECT <lista_campos>
	FROM <TablaA> 	LEFT JOIN <Tabla> 	ON A.Key=B.Key 	WHERE B.Key IS NULL

*/

# Se desea conocer los empleados que no han atendido ningún pedido
Select orderid, e.employeeid, firstname, lastname
from employees e left join orders o on e.employeeid=o.employeeid
where o.employeeid is null;

/***************** RIGHT OUTER JOIN  O RIGHT JOIN ******************+
Se obtienen todas las filas de la tabla de la derecha, aunque no tengan correspondencia en la tabla de la izquierda
Sintaxis:
	SELECT <lista_campos>
	FROM <TABLA> RIGHT [OUTER] JOIN <TABLAB> N A.key=B.key


*/
# Mostrar que productos ofrece cada proveedor independientemente tenga o no 
-- Se ha incluido empresa nueva 30 Mohou para comprobar que tiene a null NombreProducto
select productname, companyName, s.supplierid
from products p right join suppliers s on p.supplierid=s.supplierid order by s.supplierid;


/***************** RIGHT OUTER JOIN IS NULL O RIGHT JOIN IS NULL*****************+
Muestra los registros de la tabla derecha menos los registros coincidentes con la tabla izquierda

Sintaxis:
	SELECT <lista_campos>
	FROM <TABLA> RIGHT [OUTER] JOIN <TABLAB> N A.key=B.key WHERE a.key is null

*/

# mostrar qué proveedores no ha ofrecido productos 
select productname, companyName, s.supplierid
from products p right join suppliers s on p.supplierid=s.supplierid 
where p.supplierid is null -- ojo no confundir y poner s.suppliers is null
order by s.supplierid; 

/***** FULL OUTER JOIN O FULL JOIN
Se obtienen todas las filas en ambas tablas, aunque no tengan correspondencia en la otra tabla.
 Es decir, todos los registros de A y de B aunque no haya correspondencia entre ellos, rellenando con nulos los campos que falten
Sintaxis:
	SELECT <lista_campos> FROM <TablaA A> FULL JOIN <TablaB B> ON A.Key=B.Key


*/
# mostrar los productos que tengan o no asignado un proveedor y los proveedores independientemente si estos han ofrecido o no un producto
-- ojo esto en mysql no funciona
/*
SELECT Orders.OrderID, Customers.CompanyName, Orders.OrderDate
FROM Orders
    FULL OUTER JOIN Customers ON Customers.CustomerID = Orders.OrderID
ORDER BY Customers.CompanyName;
*/

/* ******************** CROSS JOIN **************************
Una combinación cruzada que no tenga una cláusula WHERE genera el producto cartesiano de las tablas involucradas en la combinación.
Sintaxis:
 Select <lista_campos> FROM <TABLA a> cross join <TABLAB>
*/


select productname, companyname
from products p cross join suppliers s;

-- Si se añade clausula where cross join se comporta como una inner join

select productname, companyname
from products p cross join suppliers s
where p.supplierid=s.supplierid;

select productname, companyname
from products p inner join suppliers s
where p.supplierid=s.supplierid;

