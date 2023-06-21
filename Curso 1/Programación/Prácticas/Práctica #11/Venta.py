# Fichero: Venta.py
# Fecha: 17 de junio de 2023
# Autor: Hugo Pelayo

from Date import *
from Articulos import *

class InvalidDateTypeError(Exception):
    def __init__(self, message):
        self._message = message
        super().__init__(self._message)

class Venta:
    def __init__(self, estado, cliente, fecha):
        if not isinstance(fecha, Date):
            raise InvalidDateTypeError('Usa el tipo Date para crear fechas')

        self._estado = estado
        self._articulos = list()
        self._cliente = cliente
        self._fecha = fecha

    @property
    def estado(self):
        return self._estado

    @property
    def articulos(self):
        return self._articulos

    @property
    def cliente(self):
        return self._cliente

    @property
    def fecha(self):
        return self._fecha

    def add_articulo(self, articulo):
        self._articulos.append(articulo)

    def remove_articulo(self, articulo):
        self._articulos.remove(articulo)

    def calcular_factura(self):
        total = 0.0

        for articulo in self._articulos:
            total += articulo.precio * articulo.cantidad

        return total

    def cerrar_venta(self):
        pass