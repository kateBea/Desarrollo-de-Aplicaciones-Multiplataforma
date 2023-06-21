# Fichero: Cliente.py
# Fecha: 17 de junio de 2023
# Autor: Hugo Pelayo

from Persona import *
from Carrito import *

class Cliente(Persona):
    def __init__(self, nombre, dni, telefono, clave_de_acceso, direccion_entrega):
        super().__init__(nombre, dni, telefono, clave_de_acceso)
        self._saldo = 0.0
        self._direccion_entrega = direccion_entrega
        self._carrito = Carrito()

    @property
    def clave(self):
        return self._clave_de_acceso
        
    @property
    def direccion_entrega(self):
        return self._direccion_entrega

    def aumentar_saldo(self, cantidad):
        if cantidad > 0:
            self._saldo += cantidad

    def recuperar_saldo(self):
        return self._saldo

    def anadir_a_carrito(self, elemento):
        self._carrito.add_item(elemento)

    def quitar_de_carrito(self, elemento):
        self._carrito.remove_item(elemento)

    def get_item_carrito(self, id):
        return self._carrito.get(id)