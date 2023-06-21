# Fichero: Date.py
# Fecha: 17 de junio de 2023
# Autor: Hugo Pelayo

import random

class Date:

    def __init__(self, day, month, year):
        self._day = int(day)
        self._month = int(month)
        self._year = int(year)

    @property
    def day(self):
        return self._day

    @property
    def month(self):
        return self.month

    @property
    def year(self):
        return self.year

    def is_before(self, other):
        if year < other.year:
            return True
        elif year == other.year:
            if moth < other.moth:
                return True
            elif moth == other.moth:
                return day < other.day
            else: 
                return True


        return False

    def is_same(self, other):
        return (day == other.day) and (month == other.month) and (year == other.year)
    
    @classmethod
    def es_bisiesto(cls, year):
        return year % 4 == 0

    @classmethod
    def generar_aleatorio_en_rango(cls, limite_inferior, limite_superior):
        return random.randint(limite_inferior, limite_superior)
    
    @classmethod
    def generar_fecha_aleatoria(cls):
        month = Date.generar_aleatorio_en_rango(1, 12)
        year = Date.generar_aleatorio_en_rango(1984, 2023)

        # Validación para més de febereo, tiene dias entre 1 y 28 (29
        #  si el año es bisiesto)
        if Date.es_bisiesto(year) and month == 2:
            day = Date.generar_aleatorio_en_rango(1, 29)
        elif not Date.es_bisiesto(year) and month == 2:
            day = Date.generar_aleatorio_en_rango(1, 29)
        else:
            # Para simplificar se asume que el resto de meses tienen 30 días
            day = Date.generar_aleatorio_en_rango(1, 30)

        return Date(day, month, year)

    def __str__(self):
        return f'{self._day}-{self._month}-{self._year}'