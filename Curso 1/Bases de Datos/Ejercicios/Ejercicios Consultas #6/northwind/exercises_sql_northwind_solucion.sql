use northwind_mysql;


# Se desea conocer los empleados que han atendido una orden y en qué fecha lo hicieron, los
# registros se deben ordenar por el campo EmployeeID
select e.EmployeeID, o.OrderID, e.LastName, e.FirstName, o.OrderDate
from employees e inner join orders o on e.EmployeeId=o.EmployeeId
order by e.EmployeeId asc;

# Mostrar el nombre del proveedor de cada producto
SELECT p.ProductName, 
       s.CompanyName AS SupplierName
FROM products AS p
INNER JOIN suppliers AS s ON p.SupplierID=s.SupplierID
ORDER BY SupplierName;

# Mostrar el nombre de producto, su proveedor y categoría 
SELECT p.ProductName, 
       s.CompanyName AS SupplierName,
       c.CategoryName
FROM products AS p
INNER JOIN suppliers AS s ON p.SupplierID=s.SupplierID
INNER JOIN categories AS c ON p.CategoryID=c.CategoryID
ORDER BY SupplierName;

# qué empresas han realizado pedidos

SELECT Customers.CompanyName, Orders.OrderID FROM Customers INNER JOIN Orders ON Customers.CustomerID=Orders.CustomerID ORDER BY Customers.CompanyName; 

# mostrar todas las empresas y cualquier pedido que hubieran realizado

SELECT Customers.CompanyName, Orders.OrderID FROM Customers LEFT JOIN Orders ON Customers.CustomerID=Orders.CustomerID ORDER BY Customers.CompanyName;

# qué empresas realizaron pedidos entre 1998-05-04 y 1998-05-06.
SELECT DISTINCT c.CompanyName, o.OrderDate
FROM orders AS o
INNER JOIN Customers AS c ON o.CustomerID=c.CustomerID
WHERE o.OrderDate BETWEEN '1998-05-04' AND '1998-05-06'
ORDER BY o.OrderDate;

# qué empresas realizaron pedidos después de 1998-05-03.
SELECT DISTINCT c.CompanyName, o.OrderDate
FROM orders AS o
INNER JOIN Customers AS c ON o.CustomerID=c.CustomerID
WHERE o.OrderDate > '1998-05-03'
ORDER BY o.OrderDate; 

# mostrar  el nombre de la empresa del cliente y fecha de cada pedido 
SELECT Orders.OrderID, Customers.CompanyName, Orders.OrderDate
FROM Customers
    INNER JOIN Orders ON Customers.CustomerID = Orders.CustomerID
ORDER BY Customers.CompanyName;

# mostrar todos los empleados y cualquier pedido que hayan tramitado
SELECT Orders.OrderID, Employees.FirstName FROM Orders RIGHT JOIN Employees ON Orders.EmployeeID=Employees.EmployeeID ORDER BY Orders.OrderID;

# selecciona todos los pedidos y todos los clientes
/* Ojo la siguiente solución no es compatible en mysql
SELECT Customers.CompanyName, Orders.OrderID FROM Customers FULL OUTER JOIN Orders ON Customers.CustomerID=Orders.CustomerID ORDER BY Customers.CompanyName;*/

/* Prueba de left y luego right OJO NO FUNCIONA SE MANDO DUDA 11-03 A LAS 8:50
SELECT Customers.CompanyName, Orders.OrderID FROM Customers left JOIN Orders ON Customers.CustomerID=Orders.CustomerID 
right join Orders on Customers.CustomerID=Orders.CustomerID ;

*/

 
# mostrar los pedidos enviados a Francia o Bélgica (campo ShipCountry)
Select OrderID ,CustomerID ,ShipCountry
From Orders where  ShipCountry = 'France' or ShipCountry = 'Belgium';
 
# mostrar el precio de venta de cada pedido después de aplicar el descuento
select distinct y.OrderID, 
    y.ProductID, 
    x.ProductName, 
    y.UnitPrice, 
    y.Quantity, 
    y.Discount, 
    round(y.UnitPrice * y.Quantity * (1 - y.Discount), 2) as Precio
from Products x
inner join Order_Details y on x.ProductID = y.ProductID
order by y.OrderID;



# mostrar los 10 productos más caros
/* solución 1*/
select distinct ProductName as Ten_Most_Expensive_Products, 
         UnitPrice
from Products as a
where 10 >= (select count(distinct UnitPrice)
                    from Products as b
                    where b.UnitPrice >= a.UnitPrice)
order by UnitPrice desc;
 
 /*solucion 2*/
 select * from
(
    select distinct ProductName as Ten_Most_Expensive_Products, 
           UnitPrice
    from Products
    order by UnitPrice desc
) as a
limit 10;

Select ProductID, ProductName, UnitPrice
From Products
Order By UnitPrice desc
limit 10;

# mostrar los productos por cada proveedor, ordenándolo por su nombre proveedor y nombre producto
-- poner join es lo mismo que inner join
SELECT CompanyName, ProductName 
FROM Products JOIN Suppliers 
ON Suppliers.SupplierID = Products.SupplierID 
ORDER BY CompanyName, ProductName;

# mostrar cuántos productos ofrece cada proveedor, ordena el resultado por orden alfabético
SELECT CompanyName, count(ProductName) NumProducts 
FROM Products JOIN Suppliers 
ON Suppliers.SupplierID = Products.SupplierID
group by CompanyName 
ORDER BY CompanyName;

# mostrar el nombre y el id de la compania del cliente,fecha,precio unitario y producto de la orden          
SELECT  O.OrderID,CompanyName,O.CustomerID,O.OrderDate,
          OD.UnitPrice,P.ProductName
FROM Customers AS C INNER JOIN Orders AS O ON C.CustomerID=O.CustomerID
		INNER JOIN order_Details AS OD ON O.OrderID=OD.OrderID             
        INNER JOIN Products AS P ON P.ProductID=OD.ProductID;



#Visualizar el nombre de la categoria y el numero de productos que hay por cada categoria.
SELECT CategoryName ,COUNT(*)  AS 'TOTAL PRODUCTOS'
FROM Categories AS C INNER JOIN Products AS P ON C.CategoryID=P.CategoryID
GROUP BY CategoryName;

# MOSTRAR  los 5 productos mas vendidos          
SELECT ProductName,SUM(Quantity) 'UDS VENDDIAS'       
FROM Order_Details AS D INNER JOIN Products AS P ON D.ProductID=P.ProductID            
GROUP BY ProductName   
ORDER BY SUM(Quantity) desc
LIMIT 5; 

# MOSTRAR todas las ordenes hechas por el empleado Janet Leverling
SELECT O.OrderID
FROM Orders AS O  INNER JOIN Employees AS E  ON  O.EmployeeID=E.EmployeeID
WHERE firstname='Janet' and  lastname='Leverling';

# ¿Cuántos pedidos ha gestionado el empleado  Janet Leverling
SELECT count(O.OrderID) "Num pedidos", lastname, firstname
FROM Orders AS O  INNER JOIN Employees AS E  ON  O.EmployeeID=E.EmployeeID
WHERE firstname='Janet' and  lastname='Leverling';

# Obtener todos los productos(codigo,nombre,precio,stock) de la orden 10256
SELECT O.OrderID,OD.ProductID,ProductName,OD.UnitPrice,UnitsInStock          
FROM Products AS P INNER JOIN Order_Details AS OD   ON P.ProductID=OD.ProductID
INNER JOIN Orders AS O ON O.OrderID=OD.OrderID
WHERE O.OrderID=10256; 

#Obtener todos los productos(codigo,nombre,precio,stock) de las ordenes hechas desde 1997 hasta la fecha de hoy.
SELECT O.OrderDate,OD.ProductID,ProductName, OD.UnitPrice,UnitsInStock
FROM Products AS P  INNER JOIN Order_Details AS OD ON P.ProductID=OD.ProductID
INNER JOIN Orders AS O  ON O.OrderID=OD.OrderID
WHERE YEAR(O.OrderDate) BETWEEN 1997 AND year(current_Date()); 

# Obtener el nombre de las categorías y para cada uno mostrar sus productos, precio y stock
SELECT CategoryName,ProductName,UnitPrice,UnitsInStock
FROM Categories AS C  INNER JOIN Products AS P ON C.CategoryID=P.CategoryID;



# para cada pedido, calcular el subtotal identificado por orderID
select OrderID,     
format(sum(UnitPrice * Quantity * (1 - Discount)), 2) as Subtotal
from Order_Details
group by OrderID
order by OrderID;

# cuántos pedidos tiene cada cliente de UK
SELECT Customers.CompanyName, COUNT(Orders.OrderID) NumPedidos
FROM Customers  
    LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID
WHERE Customers.Country = 'UK'
GROUP BY Customers.CompanyName;

Select c.CompanyName, c.Country, count(o.OrderId)
From Orders o inner join Customers c on o.CustomerId=c.customerId
where c.Country='UK'
group by c.customerid;

# cuantos productos ha pedido cada cliente de UK cada año
SELECT Customers.CompanyName, YEAR(Orders.OrderDate) Año, SUM( Order_Details.Quantity ) Total
FROM Customers  
    INNER JOIN Orders ON Customers.CustomerID = Orders.CustomerID
    INNER JOIN Order_Details ON Orders.OrderID = Order_Details.OrderID
WHERE Customers.Country = 'UK'
GROUP BY Customers.CompanyName, YEAR(Orders.OrderDate)
ORDER BY Customers.CompanyName, YEAR(Orders.OrderDate);

# cuantos productos ha pedido cada cliente de UK cada año y cuánto pagó
SELECT C.CompanyName, 
        YEAR(O.OrderDate), 
        SUM( OD.Quantity ), 
        SUM( OD.Quantity * OD.UnitPrice * (1-OD.Discount)) AS IngresoTotal 
FROM Customers AS C
    INNER JOIN Orders AS O ON C.CustomerID = O.CustomerID
    INNER JOIN Order_Details AS OD ON O.OrderID = OD.OrderID
WHERE C.Country = 'UK'
GROUP BY C.CompanyName, YEAR(O.OrderDate)
ORDER BY C.CompanyName, YEAR(O.OrderDate);

 # mostrar cuántos objetos ha pedido cada cliente del Reino Unido cada año y cuánto pagó
 SELECT C.CompanyName, 
        YEAR(O.OrderDate), 
        SUM( OD.Quantity ), 
        SUM( OD.Quantity * OD.UnitPrice * (1-OD.Discount)) AS Total
FROM Customers AS C
    INNER JOIN Orders O ON C.CustomerID = O.CustomerID
    INNER JOIN Order_Details OD ON O.OrderID = OD.OrderID
WHERE C.Country = 'UK'
GROUP BY C.CompanyName, YEAR(O.OrderDate)
ORDER BY C.CompanyName, YEAR(O.OrderDate);



