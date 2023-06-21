# Fichero: Almacen.py
# Fecha: 17 de junio de 2023
# Autor: Hugo Pelayo

from Articulos import *

class Almacen:
    def __init__(self):
        self._articulos = list()

    @property
    def articulos(self):
        return self._articulos

    def anadir_articulo(self, articulo):
        result = self._articulos.count(articulo)

        if result == 0:
            self._articulos.append(articulo)

    def borrar_articulo(self, articulo):
        try:
            self._articulos.remove(articulo)
        except ValueError:
            print('No existe el artículo')

    def comprobar_disponibilad(self, identificador):
        encontrado = False
        indice = 0

        while indice < len(self._articulos) and not encontrado:
            encontrado = self._articulos[indice].id == identificador

            if not encontrado:
                indice += 1

        if encontrado:
            return self._articulos[indice].cantidad
        else:
            return -1

    def aumentar_cantidad_articulo(self, identificador, cantidad):
        encontrado = False
        indice = 0

        while indice < len(self._articulos) and not encontrado:
            encontrado = self._articulos[indice].id == identificador

            if not encontrado:
                indice += 1

        if encontrado:
            return self._articulos[indice].anadir_cantidad(cantidad)
        else:
            print('No existe el artículo en el almacén')

    def disminuir_cantidad_articulo(self, identificador, cantidad):
        encontrado = False
        indice = 0

        while indice < len(self._articulos) and not encontrado:
            encontrado = self._articulos[indice].id == identificador

            if not encontrado:
                indice += 1

        if encontrado:
            return self._articulos[indice].quitar_cantidad(cantidad)
        else:
            print('No existe el artículo')

    def listar_articulos(self):
        for articulo in self._articulos:
            print(articulo)

    def buscar_articulo(self, identificador):
        encontrado = False
        indice = 0

        while indice < len(self._articulos) and not encontrado:
            encontrado = self._articulos[indice].id == identificador

            if not encontrado:
                indice += 1

        if encontrado:
            return self._articulos[indice]
        else:
            return None

    def listar_stock_articulos(self):
        for articulo in self._articulos:
            print(f'ID: {articulo.id}')
            print(f'TÍTULO: {articulo.titulo }')
            print(f'CANTIDAD: {articulo.cantidad}')
            print('------------------------------')

    def listar_stock(self, identificador):
        encontrado = False
        indice = 0

        while indice < len(self._articulos) and not encontrado:
            encontrado = self._articulos[indice].id == identificador

            if not encontrado:
                indice += 1

        if encontrado:
            articulo = self._articulos[indice]
            print(f'\nID: {articulo.id}')
            print(f'TÍTULO: {articulo.titulo}')
            print(f'CANTIDAD: {articulo.cantidad}')
            print('------------------------------')
        else:
            print(f'No existe artículo con identificador {identificador}')