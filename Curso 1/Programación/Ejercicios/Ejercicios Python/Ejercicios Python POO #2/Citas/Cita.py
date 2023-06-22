from Mascota import *
from Cliente import *

class Cita:
    def __init__(self, identificador : int , tiempo : str, cliente : Cliente, mascota: Mascota):
        self._identificador = identificador
        self._tiempo = tiempo # Fecha y hora
        self._cliente = cliente
        self._mascota = mascota # solo se puede tener cita con una mascota

    @property
    def id(self):
        return self._identificador
    
    @property
    def tiempo(self):
        return self._tiempo
    
    @property
    def cliente(self):
        return self._cliente
    
    @property
    def mascota(self):
        return self._mascota
    
    def __str__(self):
        return f'Cita {self._identificador} a {self._tiempo} con {self._cliente.nombre} ({self._cliente.dni}) y {self._mascota.nombre}'