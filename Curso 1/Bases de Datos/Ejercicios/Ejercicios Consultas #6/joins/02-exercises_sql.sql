use northwind_mysql;


# Se desea conocer los empleados que han atendido una orden y en qué fecha lo hicieron, los
# registros se deben ordenar por el campo EmployeeID
SELECT *
FROM employees CROSS JOIN Orders
WHERE employees.EmployeeID IN (SELECT DISTINCT EmployeeID FROM orders)
ORDER BY employees.EmployeeID;

# Mostrar el nombre del proveedor de cada producto
SELECT products.ProductName, suppliers.CompanyName AS 'Proveedor'
FROM products INNER JOIN suppliers ON products.SupplierID = suppliers.SupplierID;


# Mostrar el nombre de producto, su proveedor y categoría 
SELECT ProductName, suppliers.CompanyName AS 'Proveedor', CategoryName AS 'Categoría'
FROM 
products INNER JOIN suppliers INNER JOIN categories ON products.SupplierID = suppliers.SupplierID AND products.CategoryID = categories.CategoryID;


# qué empresas han realizado pedidos
SELECT DISTINCT CompanyName
FROM shippers INNER JOIN orders ON shippers.ShipperID = orders.ShipVia;

# mostrar todas las empresas y cualquier pedido que hubieran realizado




# qué empresas realizaron pedidos entre 1998-05-04 y 1998-05-06.



# qué empresas realizaron pedidos después de 1998-05-03.



# mostrar  el nombre de la empresa del cliente y fecha de cada pedido 



# mostrar todos los empleados y cualquier pedido que hayan tramitado



 
# mostrar los pedidos enviados a Francia o Bélgica (campo ShipCountry)

 
# mostrar el precio de venta de cada pedido después de aplicar el descuento




# mostrar los 10 productos más caros


# mostrar los productos por cada proveedor, ordenándolo por su nombre proveedor y nombre producto

# mostrar cuántos productos ofrece cada proveedor, ordena el resultado por orden alfabético

# mostrar el nombre y el id de la compania del cliente,fecha,precio unitario y producto de la orden          




#Visualizar el nombre de la categoria y el numero de productos que hay por cada categoria.


# MOSTRAR  los 5 productos mas vendidos          


# MOSTRAR todas las ordenes hechas por el empleado Janet Leverling


# ¿Cuántos pedidos ha gestionado el empleado  Janet Leverling


# Obtener todos los productos(codigo,nombre,precio,stock) de la orden 10256


#Obtener todos los productos(codigo,nombre,precio,stock) de las ordenes hechas desde 1997 hasta la fecha de hoy.


# Obtener el nombre de las categorías y para cada uno mostrar sus productos, precio y stock


# para cada pedido, calcular el subtotal identificado por orderID


# cuántos pedidos tiene cada cliente de UK


# cuantos productos ha pedido cada cliente de UK cada año


# cuantos productos ha pedido cada cliente de UK cada año y cuánto pagó


 # mostrar cuántos objetos ha pedido cada cliente del Reino Unido cada año y cuánto pagó




