# Fichero: Articulos.py
# Fecha: 17 de junio de 2023
# Autor: Hugo Pelayo

class Articulo:
    def __init__(self, id, precio, cantidad, titulo):
        self._id = id
        self._precio = precio
        self._cantidad = cantidad
        self._titulo = titulo

    @property
    def id(self):
        return self._id

    @property
    def precio(self):
        return self._precio

    @property
    def cantidad(self):
        return self._cantidad

    @property
    def titulo(self):
        return self._titulo

    def anadir_cantidad(self, cantidad):
        if cantidad > 0:
            self._cantidad += cantidad


    def quitar_cantidad(self, cantidad):
        # La cantidad es positiva y tenemos suficiente para quitar
        if cantidad > 0 and self._cantidad >= cantidad:
            self._cantidad -= cantidad

    def comprobar_cantidad(self):
        pass

    def __str__(self):
        return f'ID: {self._id} PRECIO: {self._precio} CANTIDAD: {self._cantidad} TÍTULO: { self._titulo}'




# Tipos de artículos --------------------

class Libro(Articulo):
    def __init__(self, id, precio, cantidad, titulo, autor, editorial):
        super().__init__(id, precio, cantidad, titulo)
        self._autor = autor
        self._editorial = editorial

    @property
    def autor(self):
        return self._autor

    @property    
    def editorial(self):
        return self._editorial

    def __str__(self):
        return f'{super().__str__()} AUTOR: {self._autor} EDITORIAL: {self._editorial}'



class Disco(Articulo):
    def __init__(self, id, precio, cantidad, titulo, interprete, anio_de_publicacion):
        super().__init__(id, precio, cantidad, titulo)
        self._interprete = interprete
        self._anio_de_publicacion = anio_de_publicacion

    @property
    def interprete(self):
        return self._interprete

    @property    
    def anio_de_publicacion(self):
        return self._anio_de_publicacion
    def __str__(self):
        return f'{super().__str__()} INTÉRPRETE: {self._interprete} AÑO PUBLICACIÓN: {self._anio_de_publicacion}'



class Pelicula(Articulo):
    def __init__(self, id, precio, cantidad, titulo, genero, director):
        super().__init__(id, precio, cantidad, titulo)
        self._genero = genero
        self._director = director

    @property
    def genero(self):
        return self._genero

    @property    
    def director(self):
        return self._director

    def __str__(self):
        return f'{super().__str__()} GÉNERO: {self._genero} DIRECTOR: {self._director}'