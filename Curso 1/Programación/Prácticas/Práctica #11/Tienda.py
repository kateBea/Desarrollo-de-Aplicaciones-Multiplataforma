# Fichero: Tienda.py
# Fecha: 17 de junio de 2023
# Autor: Hugo Pelayo

from Date import *
from Almacen import *
from Cliente import *

class Tienda:
    def __init__(self, almacen):
        self._almacen = almacen
        self._clientes = list()
        self._ventas = list()

    @property
    def clientes(self):
        return self._clientes

    @property
    def ventas(self):
        return self._ventas

    @property
    def almacen(self):
        return self._almacen

    def registrar_cliente(self, cliente):
        indice = self._clientes.count(cliente)

        if indice == 0:
            self._clientes.append(cliente)

    def borrar_cliente(self, cliente):
        try:
            self._clientes.remove(cliente)
        except ValueError:
            print('No existe el cliente')

    def listar_clientes(self):
        for cliente in self._clientes:
            print(cliente)

    def vender(self, articulos, cliente):
        venta = Venta('Pendiente', cliente, Date.generar_fecha_aleatoria())
        for articulo in articulos:
            if self._almacen.comprobar_disponibilad(articulo) >= cantidad:
                venta.add_articulo(articulo)
                self._almacen.disminuir_cantidad_articulo(articulo, cantidad)

        self.anadir_venta(venta)
            


    def historico_compras(self):
        for venta in self._ventas:
            print(f'Compra de cliente: {venta.cliente} en la fecha {venta.fecha}')

    def anadir_venta(self, venta):
        indice = self._clientes.count(cliente)

        if indice == 0:
            self._ventas.append(venta)