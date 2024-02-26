import time
import random

import reactivex

from reactivex import *
from reactivex import operators

from utilidades.comunes import *

# Por cuestiones de depuración lo limitamos a 1 y 3 (segundos)
# Aquí asignaríamos el intervalo de envío de datos especificado en el enunciado
# que estaría entre 20 y 25 minutos (20 * 60, y 25 * 60 respectivamente)
SERVER_LOWER_BOUND_DELAY = 1
SERVER_UPPER_BOUND_DELAY = 3


# No emite los valores, pasando el pool scheduler, reactivex nos proporciona
# un hilo para cada emisor de datos de modo que no necesitamos crear hilos.
# Pero el servidor no está emitiendo los datos necesarios para el módulo receptor de datos
class Server:
    def __init__(self, pool_scheduler,  numcorredores=1, max_punto = 42):
        self.source = reactivex.create(self._generar_datos).pipe(operators.subscribe_on(pool_scheduler))
    
        self.indice_punto = 0
        self.puntos = [10, 21, 32, 42]
        
        self.total_corredores = numcorredores
        self.max_punto = max_punto
    
    def _generar_datos(self, observer, scheduler):
        
        # Acabamos cuando se han recorrido todos los puntos
        # y estamos en el punto límite de la carrera
        while (self.indice_punto < len(self.puntos)) and (self.puntos[self.indice_punto] == self.max_punto):
            # Preparamos la lista de datos que vamos a enviar
            lista = []
            for index in range(0, self.total_corredores):
                lista.append({ "corredor": f"{index}", "punto": f"{self.puntos[self.indice_punto]}", "tiempo": f"{random.randint(TIEMPO_MIN, TIEMPO_MAX)}"})
            
            # Punto actual alcanzado y avanzamos al siguiente
            indice_punto += 1    
            
            # Llamamos a la función que nos ha indicado el suscriptor
            # pasando los datos recogidos
            observer.on_next(lista)
            
            # Esperamos a que los corredores lleguen al siguiente punto
            data_generation_delay = random.randint(SERVER_LOWER_BOUND_DELAY, SERVER_UPPER_BOUND_DELAY)
            time.sleep(data_generation_delay) # espera tiempo en segundos
            
    def subscribe(self, func):
        # Suscribe un observador para recibir datos del servidor
        subscription = self.source.subscribe(on_next=func)