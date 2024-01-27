import os
import tkinter
import customtkinter

from tkinter import PhotoImage
from utilidades import *
from popupinfo import *
from pathlib import Path

class GUI(customtkinter.CTk):
    """ 
    Aplicación principal de ala interfaz de gráficos.
    """
    
    def __init__(self):
        super().__init__(fg_color=COLOR_PRINCIPAL)
        
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
        parent = Path(os.path.dirname(__file__))
        ruta_assets = Path(parent.parent)
        print(ruta_assets.parent.absolute())
        self.logo = PhotoImage(file=f"{ruta_assets}/assets/Logo.png") 
              
        self._create_widgets()
             
        self._setup_boxes()
        self._setup_labels()
        self._setup_buttons()

    
    
    def _create_widgets(self):
        self.label_left = customtkinter.CTkLabel(self.left_box, image=self.logo, text="")
        self.label_top = customtkinter.CTkLabel(self.top_box, text="Hugo Pelayo", font=self.font_default, text_color="white")
        self.label_bottom = customtkinter.CTkLabel(self.bottom_box, text="Curso 2023 - 2024", font=self.font_default, text_color="white")
        
        self.left_button1 = customtkinter.CTkButton(self.left_box, text="Recibir temperaturas", fg_color="transparent", border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEAD_FOOT)
        self.left_button2 = customtkinter.CTkButton(self.left_box, text="Ver gráfica de temperaturas", fg_color="transparent", border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEAD_FOOT)
        self.left_button3 = customtkinter.CTkButton(self.left_box, text="Acerca de...", fg_color="transparent",  border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEAD_FOOT, anchor="e")
        
        # se usa para centrar label_right1 (que es un grid)
        self.label_right1_container = customtkinter.CTkLabel(self.right_box, fg_color="transparent", text="")
        self.label_right1 = customtkinter.CTkLabel(self.label_right1_container, text="Villablanca\n  E.R.P", font=self.font_welcome_text, text_color="white")
        self.label_right2 = customtkinter.CTkLabel(self.label_right1_container, text="", font=self.font_welcome_text, text_color="white")
        
    def _create_boxes(self):
        self.top_box = customtkinter.CTkFrame(self)
        self.bottom_box = customtkinter.CTkFrame(self)
        self.left_box = customtkinter.CTkFrame(self)
        self.right_box = customtkinter.CTkFrame(self, fg_color=COLOR_PRINCIPAL)
        
        self.top_box.configure(height=self.height_header_footer)
        self.bottom_box.configure(height=self.height_header_footer)
        
        self.data_migration_frame = customtkinter.CTkFrame(self.right_box, fg_color=COLOR_HEAD_FOOT)
        
        
    def _create_fonts(self):
        self.font_default = customtkinter.CTkFont("Dyuthi", 20)
        self.font_header = customtkinter.CTkFont("Dyuthi", 25)
        self.font_welcome_text = customtkinter.CTkFont("Dyuthi", 50)
         
         
    def _setup_buttons(self):
        self.left_button1.pack(fill=tkinter.X, pady=2)
        self.left_button2.pack(fill=tkinter.X)
        self.left_button3.pack(fill=tkinter.X, side=tkinter.BOTTOM)
        
        rounder_border = 5
        
        self.left_button1.configure(corner_radius=rounder_border, command=self._left_button_bottom1)
        self.left_button2.configure(corner_radius=rounder_border, command=self._left_button_bottom2)
        self.left_button3.configure(corner_radius=rounder_border, command=self._left_button_bottom3)
    
    def _left_button_bottom1(self):
        print("Activo recibir temperaturas")
        self.mostrar_temperaturas = True
    
    def _left_button_bottom2(self):
        pass
    
    def _left_button_bottom3(self):
        print("Mostrando información de la aplicación")
        InfoForm(self, "E.R.P Villablanca", "Hugo Pelayo", "I.E.S Villablanca", "Sistemas de Gestión Empresarial")
        # use protocol, avoid this window poping up once everytime we click the button
    
    
    def _setup_labels(self):
        self.label_top.pack(anchor="center")
        self.label_left.pack(anchor="n")
        self.label_bottom.pack(anchor="w", ipadx=10)
        
        self.label_right1_container.pack(anchor="center", pady=200)
        
        self.label_right1.grid(column=0, row=0)
        
        
    def _setup_boxes(self):
        self.top_box.pack(side=tkinter.TOP, fill=tkinter.X)
        self.bottom_box.pack(side=tkinter.BOTTOM, fill=tkinter.X)
        self.left_box.pack(side=tkinter.LEFT, fill=tkinter.Y, ipadx=20)
        self.right_box.pack(side=tkinter.RIGHT, expand = True, fill=tkinter.BOTH)
        
        self.top_box.configure(fg_color="#A5049E", height=self.height_header_footer, corner_radius=0)
        self.bottom_box.configure(fg_color="#A5049E", height=self.height_header_footer, corner_radius=0)
        self.left_box.configure(fg_color="#B805AF", corner_radius=0, width=self.weight_left_block)
        
    def procesar_dato(self, dato):
        print(f"Recibido dato {dato}")
        
        if (self.mostrar_temperaturas):
            print(f"Mostrando dato {dato}")
            self.label_right2.configure(text=f"{dato}º")
            self.label_right2.grid(column=0, row=1)
        
        
    def run(self):
        self.mainloop()