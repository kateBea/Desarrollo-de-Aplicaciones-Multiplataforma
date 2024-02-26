from multiprocessing import cpu_count
from reactivex.scheduler import ThreadPoolScheduler

from observable import Server

from customtkinter import *

from modulos.modulobase import Modulo
from utilidades.comunes import *

class ModRecibirTiempos(Modulo):
    
    def __init__(self, master, on_frame_active):
        super(ModRecibirTiempos, self).__init__(master, "Recibir tiempos", on_frame_active)
        
        self.configure(fg_color=COLOR_VENTANA_PRINCIPAL)
        
        # El pool scheduler nos proprociona un thread por
        # cada suscripción para evitar bloquear el main thread
        # en la recepción de datos
        self.procesadores = cpu_count() + 1
        self.pool_scheduler = ThreadPoolScheduler(self.procesadores)
        # Necesario crear recoger información del número de corredores 
        # y la distancia antes de crear el servidor
        self.server = Server(self.pool_scheduler) 
        self.server.subscribe(self.procesar_dato)
        
        # Datos iniciales de prueba
        # (Este es el formato de datos que guarda nuestro observador
        # y es el formato con que trabajan el resto de módulos los cuales
        # tienen acceso a esta lista a través del método get_data())
        self.media_tiempos = [
            {"tiempo": 11.2, "punto": "10km"}, 
            {"tiempo": 13.5, "punto": "21km"},
            {"tiempo": 15.2, "punto": "32km"},
            {"tiempo": 10.2, "punto": "42km"},
        ]
        
        #self.media_tiempos = [] 
               
        self.label_right1_container = CTkLabel(self, fg_color=COLOR_VENTANA_PRINCIPAL, text="")
        self.label_right1 = CTkLabel(self.label_right1_container, text="Tiempos", font=self.font_welcome_text, text_color="white")
        self.label_right2 = CTkLabel(self.label_right1_container, text="", font=self.font_welcome_text, text_color="white")
        
        self.label_right2.configure(text=f"Sin datos")
        
        self.label_right1.grid(column=0, row=0)
        self.label_right2.grid(column=0, row=1)
        self.label_right1_container.pack(anchor="center", pady=200)        
        
    def procesar_dato(self, datos):
        print(f"Recibido {datos}") 
        
        # El servidor nos envía una lista con los datos de cada corredor
        # Junto con el tiempo que ha necesitado para un punto en concreto
        media = 0.0
        for item in datos:
            media = media + int(item["tiempo"])
        
        self.media_tiempos.append({"tiempo": media / len(datos), "punto": item["punto"]})
                
    def action(self):
        super().action()
        
    def get_data(self):
        return self.media_tiempos
    