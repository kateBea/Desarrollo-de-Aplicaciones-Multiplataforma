import time
import random
import reactivex

from reactivex import operators

class Server:
    def __init__(self, pool_scheduler):
        self.source = reactivex.create(
            self._generar_datos) \
                .pipe(operators.subscribe_on(pool_scheduler))
        
        self.temp_max = 50.0
        self.temp_min = 20.0
        
        self.is_running = True
    
    def _generar_datos(self, observer, scheduler):
        while self.is_running:
            dato = random.random() * (self.temp_max - self.temp_min) + self.temp_min
            
            observer.on_next(dato)
            
            data_generation_delay = random.randint(1, 3)
            time.sleep(data_generation_delay)
            
    def subscribe(self, func):
        _ = self.source.subscribe(on_next=func)