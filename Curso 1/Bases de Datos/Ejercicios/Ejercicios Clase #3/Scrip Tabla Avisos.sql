CREATE DATABASE IF NOT EXISTS Empresa;
USE Empresa;

CREATE TABLE IF NOT EXISTS Oficinas (
	CodigoOficina VARCHAR(10) PRIMARY KEY,
    Ciudad VARCHAR(30) NOT NULL,
    Pais VARCHAR(50) NOT NULL,
    Region VARCHAR(50),
    CodigoPostal VARCHAR(10) NOT NULL,
    Telefono VARCHAR(20) NOT NULL,
    LineaDireccion1 VARCHAR(50),
    LineaDireccion2 VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Empleados (
	CodigoEmpleado INT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Apellido1 VARCHAR(50) NOT NULL,
    Apellido2 VARCHAR(50),
	Extension VARCHAR(10) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    CodigoOficina VARCHAR(10) NOT NULL,
    CodigoJefe INT,
    Puesto VARCHAR(50),
    
    CONSTRAINT Fk_CodOficina FOREIGN KEY  (CodigoOficina) REFERENCES Oficina (CodigoOficina),
    CONSTRAINT Fk_CodJefe FOREIGN KEY (Extension) REFERENCES Empleados (CodigoEmpleado)
);

CREATE TABLE IF NOT EXISTS Clientes (
	CodigoCliente INT PRIMARY KEY,
    NombreCliente VARCHAR(50) NOT NULL,
    NombreContacto VARCHAR(30),
    ApellidoContacto VARCHAR(30),
    Telefono VARCHAR(15) NOT NULL,
    Fax VARCHAR(15) NOT NULL,
    LineaDireccion1 VARCHAR(50) NOT NULL,
    LineaDireccion2 VARCHAR(50),
    Ciudad VARCHAR(50) NOT NULL,
    Region VARCHAR(50),
    Pais VARCHAR(50),
    CodigoPostal VARCHAR(10),
    CodigoEmpleadoRepVentas INT,
    LimiteCredito DECIMAL,
    
    CONSTRAINT Fk_CodEmpleadoCliente FOREIGN KEY (CodigoEmpleadoRepVentas) REFERENCES Empleados (CodigoEmpleado)
);

CREATE TABLE IF NOT EXISTS Pedidos (
	CodigoPostal INT PRIMARY KEY,
    FechaPedido DATE NOT NULL,
    FechaEsperada DATE NOT NULL,
    FechaEntrega DATE,
    Estado VARCHAR(15) NOT NULL,
    Comentarios TEXT,
    CodigoCliente INT,
    
    CONSTRAINT Fk_CodClientePedidos FOREIGN KEY (CodigoCliente) REFERENCES Clientes (Clientes)
);

CREATE TABLE IF NOT EXISTS DetallePedidos (
	CodigoPedido INT,
    CodigoProducto VARCHAR(15),
    Cantidad INT NOT NULL,
    PrecioUnidad DECIMAL NOT NULL,
    NumeroLinea SMALLINT NOT NULL
);

CREATE TABLE IF NOT EXISTS Pagos (
	IDTransaccion VARCHAR(50) PRIMARY KEY,
    CodigoCliente INT NOT NULL,
    FormaPago VARCHAR(40) NOT NULL,
    FechaPago DATE NOT NULL,
    Cantidad DECIMAL NOT NULL,
    
    CONSTRAINT Fk_CodClientePagos FOREIGN KEY (CodigoCliente) REFERENCES Clientes(CodigoCliente)
);

CREATE TABLE IF NOT EXISTS GamasProductos (
	Gama VARCHAR(50) PRIMARY KEY,
    DescripcionTexto TEXT,
    DescripcionHTML TEXT,
    Imagen BLOB
);

CREATE TABLE IF NOT EXISTS Productos (
	CodigoProducto VARCHAR(15) PRIMARY KEY,
    Nombre VARCHAR(70) NOT NULL,
    Gama VARCHAR(50) NOT NULL,
    Dimensiones VARCHAR(25),
    Proveedor VARCHAR(50),
    Descripcion TEXT,
    CantidadEnStock SMALLINT NOT NULL,
	PrecioVenta DECIMAL NOT NULL,
    PrecioProveedor DECIMAL,
    
    CONSTRAINT Fk_Gama FOREIGN KEY (Gama) REFERENCES GamasProductos(Gama)
);
