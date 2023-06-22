from Mascota import *

class Cliente:
    def __init__(self, nombre : str, dni : str, email : str, telefono : str):
        self._nombre = nombre
        self._dni = dni
        self._email = email
        self._telefono = telefono
        self._mascotas = list()

    @property
    def nombre(self):
        return self._nombre
    
    @property
    def dni(self):
        return self._dni
    
    @property
    def email(self):
        return self._email
    
    @property
    def telefono(self):
        return self._telefono
    
    @property
    def mascotas(self):
        return self._mascotas
    
    def adoptar(self, mascota : Mascota):
        try:
            self._mascotas.index(mascota)
            print('EL cliente ya es amo de la mascota')
        except:
            # La mascota no existe
            self._mascotas.append(mascota)

    def es_amo_de(self, mascota : Mascota):
        try:
            self._mascotas.index(mascota)
            return True
        except:
            # El cliente no es dueño de la mascota
            return False
        
    def es_amo_de(self, id_mascota : int):
        indice = 0
        encontrado = False

        while indice < len(self._mascotas) and not encontrado:
            encontrado = self._mascotas[indice].id = id_mascota

            if not encontrado:
                indice += 1

        return encontrado

    def __str__(self):
        return f'NOMBRE: {self._dni}\nEDAD: {self._nombre}\nEMAIL: {self._email}\nTELF: {self._telefono}'