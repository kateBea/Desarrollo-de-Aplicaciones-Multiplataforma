##########################################
# Examen de SGE                          #
#                                        #
# Hugo Pelayo                            #
# 27 nov 2023                            #
##########################################

import customtkinter
import tkinter

import json

from tkinter import PhotoImage
from utilidades import *
from popupinfo import *

class GUI(customtkinter.CTk):
    """ 
    Aplicación principal de ala interfaz de gráficos.
    """
    
    def __init__(self, dbobj):
        super().__init__(fg_color=COLOR_PRINCIPAL)
        
        # variables para la manipulación de datos con la DB
        # datos_json contiene un objeto con los datos de alumnos cargados de los
        # JSON (nimbre, email y password), notas_json contiene un objeto con una lista
        # de los alumnos con sus notas de cada módulo
        self.db = dbobj
        self.datos_json = None
        self.notas_json = None
        
        # constantes internas
        self.height_header_footer = 50
        self.weight_left_block = 150
        
        # fuentes
        self._create_fonts()
        
        # crear la ventana principal
        self.title("E.R.P Villablanca")
        self.geometry("850x600")
        
        # Cajas
        self._create_boxes()
        
        # pre setup
        self.logo = PhotoImage(file="./Logo.png")       
        self._create_widgets()
             
        self._setup_boxes()
        self._setup_labels()
        self._setup_buttons()

    
    
    def _create_widgets(self):
        self.label_left = customtkinter.CTkLabel(self.left_box, image=self.logo, text="")
        self.label_top = customtkinter.CTkLabel(self.top_box, text="Hugo Pelayo", font=self.font_default, text_color="white")
        self.label_bottom = customtkinter.CTkLabel(self.bottom_box, text="Examen 1ª Evaluación - curso 2023 2024", font=self.font_default, text_color="white")
        
        self.left_button_top = customtkinter.CTkButton(self.left_box, text="Migración Datos", fg_color="transparent", border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEAD_FOOT)
        self.left_button_bottom = customtkinter.CTkButton(self.left_box, text="My information", fg_color="transparent",  border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEAD_FOOT)
        
        self.label_right1 = customtkinter.CTkLabel(self.right_box, text="Villablanca\n  E.R.P", font=self.font_welcome_text, text_color="white")
        
        
    def _create_boxes(self):
        self.top_box = customtkinter.CTkFrame(self)
        self.left_box = customtkinter.CTkFrame(self)
        self.right_box = customtkinter.CTkFrame(self, fg_color=COLOR_PRINCIPAL)
        self.bottom_box = customtkinter.CTkFrame(self)
        
        self.data_migration_frame = customtkinter.CTkFrame(self.right_box, fg_color=COLOR_HEAD_FOOT)
        
        
    def _create_fonts(self):
        self.font_default = customtkinter.CTkFont("Roboto", 15)
        self.font_header = customtkinter.CTkFont("Roboto", 25)
        self.font_welcome_text = customtkinter.CTkFont("Roboto", 50)
         
         
    def _setup_buttons(self):
        self.left_button_top.pack(fill=tkinter.X, pady=10)
        self.left_button_bottom.pack(fill=tkinter.X, side=tkinter.BOTTOM)
        
        self.left_button_top.configure(corner_radius=0, command=self._left_button_top_command)
        self.left_button_bottom.configure(corner_radius=0, command=self._left_button_bottom_command)
    
    
    def _left_button_top_command(self):
        print("Iniciando migración de datos")
        
        # quitamos el texto de bienvenida
        # usamos pack_forget() ya que el objeto se está
        # haciendo visible en su lienzo principal a través de pack()
        self.label_right1.pack_forget()
    
        
        # Inicializamos la interfaz de migración de datos    
        self.data_migration_frame.pack(expand = True)
        
        self.data_migration_frame.columnconfigure([0, 1], pad=40, weight=10)
        self.data_migration_frame.rowconfigure([0, 1, 2, 3, 4, 5, 6], pad=10)
         
        # Fila 0
        self.col1_label = customtkinter.CTkLabel(self.data_migration_frame, text="Cargando datos JSON", text_color="white", font=self.font_header)
        self.col1_label.grid(row=0, column=0, columnspan=2)
        
        # Fila 1
        self.col2_label = customtkinter.CTkLabel(self.data_migration_frame, text="Fichero JSON 1", text_color="white", font=self.font_default)
        self.col2_label.grid(row=1, column=0)
        
        self.input1_label = customtkinter.CTkEntry(self.data_migration_frame, width=200, height=25, corner_radius=5, fg_color="transparent", font=self.font_default, text_color="white")
        self.input1_label.grid(row=1, column=1)
        
        # Fila 2
        self.col2_label = customtkinter.CTkLabel(self.data_migration_frame, text="Fichero JSON 2", text_color="white", font=self.font_default)
        self.col2_label.grid(row=2, column=0)
        
        self.input2_label = customtkinter.CTkEntry(self.data_migration_frame, width=200, height=25, corner_radius=5, fg_color="transparent", font=self.font_default, text_color="white")
        self.input2_label.grid(row=2, column=1)
        
        # Fila 3
        self.load_data_button = customtkinter.CTkButton(self.data_migration_frame, font=self.font_default, text="Cargar ficheros", corner_radius=5)
        self.load_data_button.grid(row=3, column=0, columnspan=2)
        self.load_data_button.configure(command=self._load_data_button)
        
        # Fila 4
        self.left_output_text_area1 = customtkinter.CTkTextbox(self.data_migration_frame, font=self.font_default, width=200, height=100, fg_color="transparent", border_color="white", border_width=1, text_color="white")
        self.left_output_text_area1.grid(row=4, column=0)
        
        self.left_output_text_area2 = customtkinter.CTkTextbox(self.data_migration_frame, font=self.font_default, width=200, height=100, fg_color="transparent", border_color="white", border_width=1, text_color="white")
        self.left_output_text_area2.grid(row=4, column=1)
        
        # Fila 5
        self.col5_label = customtkinter.CTkLabel(self.data_migration_frame, text="Salvando datos", text_color="white", font=self.font_header)
        self.col5_label.grid(row=5, column=0, columnspan=2)
        
        # Fila 6
        self.save_data_button = customtkinter.CTkButton(self.data_migration_frame, font=self.font_default, text="Salvar datos", corner_radius=5)
        self.save_data_button.grid(row=6, column=0, columnspan=2)
        self.save_data_button.configure(command=self._save_data_button)
      
        
    def _load_data_button(self):
        print("Cargando datos JSON 1")
        
        file1 = open(self.input1_label.get(), "r")
        file2 = open(self.input2_label.get(), "r")
        
        jsonObject1 = json.load(file1)
        jsonObject2 = json.load(file2)
        
        self.datos_json = jsonObject1
        self.notas_json = jsonObject2
        
        print(f"loaded data: {jsonObject1['usuario']}\n{jsonObject2['notas']}")
        
        # formateamos string datos
        resultadoObj1 = ""
        for elem in jsonObject1["usuario"]:
            resultadoObj1 += f'User: {elem["username"]}\nEmail: {elem["email"]}\nPass: {elem["password"]}\n\n'
        
        #  formateamos string notas
        resultadoObj2 = ""
        for elem in jsonObject2['notas']:
            resultadoObj2 += f'{elem["nombre"]}\n'
            
            modulos_str = ""
            for modulo in elem["modulos"]:
                modulos_str += f'{modulo["nombreModulo"]} {modulo["nota1"]}-{modulo["nota2"]}\n'
                
            resultadoObj2 += modulos_str + "\n"
        
        
        self.left_output_text_area1.insert(customtkinter.END, resultadoObj1)
        self.left_output_text_area2.insert(customtkinter.END, resultadoObj2)
        
        file1.close()
        file2.close()
        
    
    def _save_data_button(self):
        print("Guardando datos en la base de datos")
        
        # Por cada alumno en en la lista de datos,
        # buscamos sus notas e insertamos ese valor en la base de datos.
        for elem in self.datos_json["usuario"]:
            for elem2 in self.notas_json["notas"]:
                if elem["username"] == elem2["nombre"]:
                    for modulodata in elem2["modulos"]:
                        values = f'{quoted_string(elem["username"])}, {quoted_string(elem["email"])}, {quoted_string(elem["password"])}, {quoted_string(modulodata["nombreModulo"])}, {modulodata["nota1"]}, {modulodata["nota2"]}'
                        print(f"query {f'INSERT INTO migrarDatos VALUES ({values})'}")
                        if self.db.execute(
                            f"INSERT INTO migrarDatos VALUES ({values})"
                        ):
                            print("Se han salvado los datos correctamente")
                        else:
                            print("Error al guardar los datos en la tabla migrarDatos")
                    
                    # evitar seguir iterando sobre la colección 
                    # de lista de alumnos con sus notas   
                    break
    
    def _left_button_bottom_command(self):
        print("Mostrando información de alumno")
        InfoForm(self, "Examen 2-DAM", "Hugo Pelayo", "I.E.S Villablanca", "Sistemas de Gestión Empresarial")
        # use protocol, avoid this window poping up once everytime we click the button
    
    
    def _setup_labels(self):
        self.label_top.pack(anchor="center")
        self.label_left.pack(anchor="n")
        self.label_bottom.pack(anchor="w", ipadx=10)
        
        self.label_right1.pack(anchor="center", pady=200)
        
        
    def _setup_boxes(self):
        self.top_box.pack(side=tkinter.TOP, fill=tkinter.X)
        self.bottom_box.pack(side=tkinter.BOTTOM, fill=tkinter.X)
        self.left_box.pack(side=tkinter.LEFT, fill=tkinter.Y, ipadx=20)
        self.right_box.pack(side=tkinter.RIGHT, expand = True, fill=tkinter.BOTH)
        
        self.top_box.configure(fg_color="#A5049E", height=self.height_header_footer, corner_radius=0)
        self.bottom_box.configure(fg_color="#A5049E", height=self.height_header_footer, corner_radius=0)
        self.left_box.configure(fg_color="#B805AF", corner_radius=0, width=self.weight_left_block)
        
    def procesar_dato(self, dato):
        pass
        
        
    def run(self):
        self.mainloop()