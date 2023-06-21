# Fichero: Administrador.py
# Fecha: 17 de junio de 2023
# Autor: Hugo Pelayo

from Persona import *
from Tienda import *
from Almacen import *

class Administrador(Persona):
    def __init__(self, sueldo, nombre, dni, telefono, clave_de_acceso, tienda):
        super().__init__(nombre, dni, telefono, clave_de_acceso)
        self._sueldo = sueldo
        self._tienda = tienda

    @property
    def sueldo(self):
        return self._sueldo

    def mostrar_inventario_almacen(self):
        self._tienda.almacen.listar_stock_articulos()

    def mostrar_inventario_articulo(self, identificador):
        self._tienda.almacen.listar_stock(identificador)

    def aumentar_stock_articulo(self, identificador, cantidad):
        articulo = self._tienda.almacen.buscar_articulo(identificador)

        if articulo != None:
            self._tienda.almacen.aumentar_cantidad_articulo(articulo, cantidad)
        else:
            print('El artículo no existe')

    def mostrar_clientes(self):
        self._tienda.listar_clientes()

    def buscar_articulo(self, identificador):
        articulo = self._tienda.almacen.buscar_articulo(identificador)
        
        if articulo != None:
            print(articulo)
        else:
            print('El artículo no existe')