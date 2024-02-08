import customtkinter
import datetime

from utilidades import *
from modules.extension import Modulo
from modules.dbmanager import DBManager

class SaveToDB(Modulo):
    
    def __init__(self, master, temp_src, on_frame_active):
        super(SaveToDB, self).__init__(master, "Guardar temperaturas", on_frame_active)
        
        self.configure(fg_color=COLOR_PRINCIPAL)
        
        self.temp_src = temp_src
        
        self.guardar_todo_frame = customtkinter.CTkFrame(self, fg_color=self._fg_color)
        self.label_todo = customtkinter.CTkLabel(self.guardar_todo_frame, text="Serializar todos los datos", font=self.font_default, text_color="white")
        self.label_todo.pack(anchor="center")
        self.guardar_todos = customtkinter.CTkButton(self.guardar_todo_frame, text="Guardar", fg_color="transparent", border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEAD_FOOT)
        self.guardar_todos.configure(corner_radius=MODULE_BUTTONS_CORNER_RADIUS, command=self._guardar_todo)
        self.guardar_todos.pack(pady=10)
        
        self.guardar_todo_frame.pack()
        
        self.guardar_por_fechas_frame = customtkinter.CTkFrame(self, fg_color=self._fg_color)
        self.label_por_fechas = customtkinter.CTkLabel(self.guardar_por_fechas_frame, text="Serializar por fechas", font=self.font_default, text_color="white")
        self.label_por_fechas.pack(anchor="center")
       
        self.date_input_frame = customtkinter.CTkFrame(self.guardar_por_fechas_frame, fg_color=self._fg_color)
        self.date_input_frame.grid_columnconfigure([0, 1, 2], pad=10)
        self.label_segundos = customtkinter.CTkLabel(self.date_input_frame, text="Últimos", font=self.font_default, text_color="white")
        self.label_segundos.grid(row=0, column=0)
        self.intervalo = customtkinter.CTkEntry(self.date_input_frame, width=50, height=40, corner_radius=5, fg_color="transparent", font=self.font_default, text_color="white")
        self.intervalo.grid(row=0, column=1)
        self.label_segundos = customtkinter.CTkLabel(self.date_input_frame, text="segundos", font=self.font_default, text_color="white")
        self.label_segundos.grid(row=0, column=2)
        self.date_input_frame.pack(anchor="center")
        
        self.guardar_todos_entre_fecha = customtkinter.CTkButton(self.guardar_por_fechas_frame, text="Guardar", fg_color="transparent", border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEAD_FOOT)
        self.guardar_todos_entre_fecha.configure(corner_radius=MODULE_BUTTONS_CORNER_RADIUS, command=self._guardar_por_fechas)
        self.guardar_todos_entre_fecha.pack(pady=10)
        
        self.guardar_por_fechas_frame.pack(pady=20)
        
        # Inicializar base de datos
        self._crear_base_de_datos()
            
    def _crear_base_de_datos(self):
        
        self.dbmanager = DBManager("root", "daddyWentForCookies6996+")
        
        self.nombredb = "Temperaturas_ERP"
        self.nombredb_table = "TEMPERATURAS_ERP"
        
        # creamos la base de datos
        if self.dbmanager.create_db(self.nombredb):
            print("Base de datos funcionando correctamente")
        else:
            print("Error al incializar la base de datos")
        
        # creamos la tabla
        if self.dbmanager.execute(
            f""" 
                DROP TABLE IF EXISTS {self.nombredb_table}
            """
        ) and \
        self.dbmanager.execute(
            f""" 
                CREATE TABLE {self.nombredb_table}(
                    Temperatura     REAL,
                    Fecha_Registro  VARCHAR(127))
            """):
            print(f"Tabla {self.nombredb} creada correctamente")
        else:
            print(f"Error crear la tabla {self.nombredb}")
        
        
    def _guardar_todo(self):
        print("Guardando todos los datos a la base de datos")
        
        temps_info = self.temp_src.get_info()
        
        for item in temps_info:
            print(item)
            query = f"INSERT INTO {self.nombredb_table} (Temperatura, Fecha_Registro) \
                VALUES ({item['temperatura']}, {quoted_string(item['tiempo'])})"
                
            print(f"Query : {query}")
            self.dbmanager.execute(query)
    
        
    def _guardar_por_fechas(self):
        # Recogemos los datos del campo
        input = self.intervalo.get()
        
        # Recogemos los datos de temperaturas capturados actualmente
        temps_info = self.temp_src.get_info()
        
        # Generamos un intervalo a partir de los datos entrados
        upper_bound = datetime.datetime.strptime(
            datetime.datetime.now().strftime(self.temp_src.get_time_format()), 
            self.temp_src.get_time_format())
        lower_bound = upper_bound - datetime.timedelta(seconds=float(input))
        

        print(f"Guardando los datos de los últimos {input} segundos a la base de datos. \
            [entre {upper_bound.time()} y {lower_bound.time()}]")
        
        for dato in temps_info:            
            parseado = datetime.datetime.strptime(
                dato["tiempo"], 
                self.temp_src.get_time_format())
            
            if lower_bound <= parseado <= upper_bound:
                query = f"INSERT INTO {self.nombredb_table} (Temperatura, Fecha_Registro) \
                VALUES ({dato['temperatura']}, {quoted_string(dato['tiempo'])})"
                
                print(f"Query : {query}")
                self.dbmanager.execute(query)
                
        