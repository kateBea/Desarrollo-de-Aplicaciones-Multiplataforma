import datetime

from customtkinter import *

from modulos.modulobase import Modulo
from utilidades.comunes import *
from utilidades.dbmanager import *

class ModGuardar(Modulo):
    
    def __init__(self, master, fuentetiempos, on_frame_active):
        super(ModGuardar, self).__init__(master, "Guardar histórico", on_frame_active)
        
        self.configure(fg_color=COLOR_VENTANA_PRINCIPAL)
        
        self.src = fuentetiempos
        
        self.guardar_todo_frame = CTkFrame(self, fg_color=self._fg_color)
        self.label_todo = CTkLabel(self.guardar_todo_frame, text="Serializar todos los datos", font=self.font_default, text_color="white")
        self.label_todo.pack(anchor="center")
        self.guardar_todos = CTkButton(self.guardar_todo_frame, text="Guardar", fg_color="transparent", border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEADER_FOOTER)
        self.guardar_todos.configure(corner_radius=MODULE_BUTTONS_CORNER_RADIUS, command=self._guardar_todo)
        self.guardar_todos.pack(pady=10)
        self.guardar_todo_frame.pack()
    
        self._crear_base_de_datos()
            
    def _crear_base_de_datos(self):
        
        self.dbmanager = DBManager("root", "1234")
        
        self.nombredb = "Carreras"
        self.nombredb_table = "CarrerasTable"
        
        if self.dbmanager.create_db(self.nombredb):
            print("Base de datos funcionando correctamente")
        else:
            print("Error al incializar la base de datos")
        
        # creamos la tabla (borramos si ya existe para conmsistencia en depuración)
        if self.dbmanager.execute(
            f""" 
                DROP TABLE IF EXISTS {self.nombredb_table}
            """
        ) and \
        self.dbmanager.execute(
            f""" 
                CREATE TABLE {self.nombredb_table}(
                    Tiempo     REAL,
                    Punto  VARCHAR(127))
            """):
            print(f"Tabla {self.nombredb} creada correctamente")
        else:
            print(f"Error crear la tabla {self.nombredb}")
        
        
    def _guardar_todo(self):
        print("Guardando todos los datos a la base de datos")
        
        info_tiempos = self.src.get_data()
        
        for item in info_tiempos:
            print(item)
            query = f"INSERT INTO {self.nombredb_table} (Tiempo, Punto) \
                VALUES ({item['tiempo']}, {quoted_string(item['punto'])})"
                
            print(f"Query : {query}")
            self.dbmanager.execute(query)