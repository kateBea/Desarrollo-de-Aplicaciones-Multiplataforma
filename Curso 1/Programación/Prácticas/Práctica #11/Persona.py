# Fichero: Persona.py
# Fecha: 17 de junio de 2023
# Autor: Hugo Pelayo

class Persona:
    def __init__(self, nombre, dni, telefono, clave_de_acceso):
        self._nombre = nombre
        self._dni = dni
        self._telefono = telefono
        self._clave_de_acceso = clave_de_acceso


    @property
    def nombre(self):
        return self._nombre

    @property
    def dni(self):
        return self._dni

    @property
    def telefono(self):
        self._telefono

    @property
    def clave_de_acceso(self):
        self._clave_de_acceso

    def __str__(self):
        return f'NOMBRE: {self._nombre}  DNI: {self._dni}  TELÉFONO: {self._telefono}  CLAVE: {self._clave_de_acceso}'