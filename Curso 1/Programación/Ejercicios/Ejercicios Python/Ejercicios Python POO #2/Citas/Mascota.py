class Mascota:
    def __init__(self, id : int, nombre : str, edad : int):
        self._id = id
        self._nombre = nombre
        self._edad = edad

    @property
    def id(self):
        return self._id

    @property
    def nombre(self):
        return self._nombre
    
    @property
    def edad(self):
        return self._edad
    
    def __str__(self):
        return f'IDENTIFICADOR: {self._id} NOMBRE: {self._nombre} EDAD: {self._edad}'