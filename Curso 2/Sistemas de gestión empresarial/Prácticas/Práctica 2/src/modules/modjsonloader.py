import tkinter
import customtkinter

from modules.extension import Modulo
from utilidades import *


class JSONLoader(Modulo):
    def __init__(self, master, temp_src, on_frame_active):
        super().__init__(master, "JSON Manager", on_frame_active)
        
        self.configure(fg_color=COLOR_PRINCIPAL)
        
        self.temps_src = temp_src
        
        # Guardar datos a fichero json
        self.guardar_frame = customtkinter.CTkFrame(self, fg_color=self._fg_color)
        self.label_todo = customtkinter.CTkLabel(self.guardar_frame, text="Serializar todos los datos", font=self.font_default, text_color="white")
        self.label_todo.pack(anchor="center")
        self.ruta_fichero = customtkinter.CTkEntry(self.guardar_frame, width=200, height=40, corner_radius=5, fg_color="transparent", placeholder_text="Ruta fichero...", font=self.font_default, text_color="white")
        self.ruta_fichero.pack(pady=10)
        self.guardar_todos = customtkinter.CTkButton(self.guardar_frame, text="Guardar", fg_color="transparent", border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEAD_FOOT)
        self.guardar_todos.configure(corner_radius=MODULE_BUTTONS_CORNER_RADIUS, command=self._guardar_todo)
        self.guardar_todos.pack(pady=2)
        
        self.guardar_frame.pack(pady=20)
        
        # Cargar datos de fichero json
        self.cargar_frame = customtkinter.CTkFrame(self, fg_color=self._fg_color)
        self.label_cargar = customtkinter.CTkLabel(self.cargar_frame, text="Cargar datos de JSON", font=self.font_default, text_color="white")
        self.label_cargar.pack(anchor="center")
        self.ruta_fichero_carga = customtkinter.CTkEntry(self.cargar_frame, width=200, height=40, corner_radius=5, fg_color="transparent", placeholder_text="Ruta fichero...", font=self.font_default, text_color="white")
        self.ruta_fichero_carga.pack(pady=10)
        self.cargar_todos = customtkinter.CTkButton(self.cargar_frame, text="Cargar", fg_color="transparent", border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEAD_FOOT)
        self.cargar_todos.configure(corner_radius=MODULE_BUTTONS_CORNER_RADIUS, command=self._cargar_todo)
        self.cargar_todos.pack(pady=2)
        self.datos_cargados_preview = customtkinter.CTkTextbox(self.cargar_frame, font=self.font_default, width=500, height=200, fg_color="transparent", border_color="white", border_width=1, text_color="white")
        self.datos_cargados_preview.pack(pady=10)
        self.limpiar = customtkinter.CTkButton(self.cargar_frame, text="Limpiar", fg_color="transparent", border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEAD_FOOT)
        self.limpiar.configure(corner_radius=MODULE_BUTTONS_CORNER_RADIUS, command=self._limpiar_preview)
        self.limpiar.pack()
        
        self.cargar_frame.pack()
        
    def _limpiar_preview(self):
        print("Limpiando preview")
        
        self.datos_cargados_preview.delete('1.0', tkinter.END)
        
    def _guardar_todo(self):
        ruta = self.ruta_fichero.get()
        print(f"Guardando todos los datos a fichero JSON en '{ruta}'")
        
        temps_info = self.temps_src.get_info()
        serialize_to_json_file(temps_info, ruta)
        
    def _cargar_todo(self):
        ruta = self.ruta_fichero_carga.get()
        print(f"Cargando todos los datos de fichero JSON en '{ruta}'")
        
        datos = load_json_from_file(ruta)
        print(datos)
        
        indice = 1
        contenido = ""
        
        # Se espera que los datos cargados sean una lista de objetos (ver self.temps_src.get_info())
        for item in datos:
            contenido += f"{indice}:  {round(item['temperatura'], 2)} grados  el  {item['tiempo']}\n"
            
            indice += 1
        
        self.datos_cargados_preview.insert(tkinter.END, contenido)
        
        

        