import customtkinter
import datetime
import tkinter

from modules.extension import Modulo
from utilidades import *

LIMIT_DATA = 20

class LoadTemps(Modulo):
    
    def __init__(self, master, on_frame_active):
        super(LoadTemps, self).__init__(master, "Mostrar temperaturas", on_frame_active)
        self._create_fonts()
        
        self.configure(fg_color=COLOR_PRINCIPAL)
        
        self.dato_temperatura = 0.0
        self.temperaturas = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        self.temperaturas_info = []
        self.time_format = '%Y-%m-%d %H:%M:%S'
        
        # se usa para centrar label_right1 (que es un grid) -> Modulo loadtemps
        self.label_right1_container = customtkinter.CTkLabel(self, fg_color=COLOR_PRINCIPAL, text="")
        self.label_right1 = customtkinter.CTkLabel(self.label_right1_container, text="Villablanca\n  E.R.P", font=self.font_welcome_text, text_color="white")
        self.label_right2 = customtkinter.CTkLabel(self.label_right1_container, text="", font=self.font_welcome_text, text_color="white")
        
        self.label_right1_container.pack(anchor="center", pady=200)
        
         # Para inmediatamente actualizar la interfaz de temperaturas.
        PRECISION = 2
        self.label_right1_container.pack(anchor="center", pady=200)
        
        self.label_right2.configure(text=f"{round(self.dato_temperatura, PRECISION)} ºC")
        self.label_right1.grid(column=0, row=0)
        self.label_right2.grid(column=0, row=1)
        
    def procesar_dato(self, dato):
        self.dato_temperatura = float(dato)
        self.temperaturas.append(self.dato_temperatura)
        self.temperaturas = self.temperaturas[-LIMIT_DATA:]
        
        self.temperaturas_info.append( {"temperatura": self.dato_temperatura, "tiempo": f"{datetime.datetime.now().strftime(self.time_format)}"} )
        self.temperaturas_info = self.temperaturas_info[-LIMIT_DATA:]
        
        print(f"Recibido '{dato} ºC' el '{self.temperaturas_info[-1]}'") 
        
        PRECISION = 2
        self.label_right2.configure(text=f"{round(self.dato_temperatura, PRECISION)} ºC")
        self.label_right2.grid(column=0, row=1) 
        
    def action(self):
        super().action()
        
    def get_temps(self):
        return self.temperaturas
    
    def get_info(self):
        return self.temperaturas_info
    
    def get_time_format(self):
        return self.time_format