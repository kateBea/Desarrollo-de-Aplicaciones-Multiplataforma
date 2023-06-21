# Fichero: Cliente.py
# Fecha: 20 de junio de 2023
# Autor: Hugo Pelayo

class Elemento:
    def __init__(self, id, cantidad):
        self._id = id
        self._cantidad = cantidad

    @property
    def id(self):
        return self._id

    @property
    def cantidad(self):
        return self._cantidad
    

class Carrito:
    def __init__(self):
        self._lista = list()

    def add_item(self, elemento):
        self._lista.append(elemento)

    def remove_item(self, elemento):
        try:
            self._lista.remove(elemento)
        except:
            print('No existe el elemento en el carrito')

    def get(self, identificador):
        encontrado = False
        indice = 0

        while indice < len(self._lista) and not encontrado:
            encontrado = self._lista[indice].id == identificador

            if not encontrado:
                indice += 1

        if encontrado:
            return self._lista[indice]
        else:
            return None