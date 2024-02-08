import tkinter
import customtkinter

from utilidades import *
from popupinfo import *

from modules.modloadtemps import LoadTemps
from modules.modshowtemps import ShowTemps
from modules.modpdfprinter import PDFGenerate
from modules.moddbserialize import SaveToDB
from modules.modjsonloader import JSONLoader

MAX_TEMPERATURA = 50.0
MIN_TEMPERATURA = 20
TIME_INTERVAL = 5

HEIGHT_HEADER_FOOTER = 50
WIDTH_LEFT_BLOCK = 150

class GUI(customtkinter.CTk):
    """ 
    Aplicación principal de ala interfaz de gráficos.
    """
    
    def __init__(self, server):
        super().__init__(fg_color=COLOR_PRINCIPAL)
    
        
        # Fuentes
        self._create_fonts()
        self._iniciar_ventana()
        
        # Widgets
        self._create_boxes()
        
        # Inicializar módulos
        self.active_module = None
        
        self.mostrar_temperaturas = LoadTemps(self.right_box, self._on_active_module_change)
        self.grafica_temps = ShowTemps(self.right_box, self.mostrar_temperaturas, self._on_active_module_change)
        self.guardar_db = SaveToDB(self.right_box, self.mostrar_temperaturas, self._on_active_module_change)
        self.generar_pdf = PDFGenerate(self.right_box, self.mostrar_temperaturas, self._on_active_module_change)
        self.generar_json = JSONLoader(self.right_box, self.mostrar_temperaturas, self._on_active_module_change)
        
        server.subscribe(self.mostrar_temperaturas.procesar_dato)
        
        self.modulos = [ self.mostrar_temperaturas, self.grafica_temps, self.guardar_db, self.generar_pdf, self.generar_json ]
        self.active_module_frame = None
        
        self._create_widgets()
        

    def _iniciar_ventana(self):
        # Cargar logo
        ruta_assets = parent_path_from_file(__file__)
        self.logo = load_image(f"{ruta_assets}/assets/Logo.png")
        
        # crear la ventana principal
        self.title("E.R.P Villablanca")
        self.geometry("850x600")
        
    def _on_active_module_change(self, module):
        self.label_right1.pack_forget()
        
        if self.active_module == None:
            self.active_module = module
            self.active_module.pack(fill=tkinter.BOTH, expand=True)
            return
        
        if self.active_module != module:
            # Desabilita el módulo actual para mostrar el nuevo
            self.active_module.pack_forget()
            
            self.active_module = module
            self.active_module.pack(fill=tkinter.BOTH, expand=True)
        
    
    def _create_widgets(self):
        # Creación
        self.label_left = customtkinter.CTkLabel(self.left_box, image=self.logo, text="")
        self.label_top = customtkinter.CTkLabel(self.top_box, text="Hugo Pelayo", font=self.font_default, text_color="white")
        self.label_bottom = customtkinter.CTkLabel(self.bottom_box, text="Curso 2023 - 2024", font=self.font_default, text_color="white")
        
        self.label_top.pack(anchor="center")
        self.label_bottom.pack(anchor="w", ipadx=10)
        self.label_left.pack(anchor="n")
        
        # Botones de los módulos
        for modulo in self.modulos:
            print(modulo.get_label())
            self.left_button1 = customtkinter.CTkButton(self.left_box, text=modulo.get_label(), fg_color="transparent", border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEAD_FOOT)
            self.left_button1.configure(corner_radius=MODULE_BUTTONS_CORNER_RADIUS, command=modulo.action)
            self.left_button1.pack(fill=tkinter.X, pady=2)
        
        self.acerca_de_btn = customtkinter.CTkButton(self.left_box, text="Acerca de...", fg_color="transparent",  border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEAD_FOOT, anchor="e")
        self.acerca_de_btn.pack(fill=tkinter.X, side=tkinter.BOTTOM)
        self.acerca_de_btn.configure(corner_radius=MODULE_BUTTONS_CORNER_RADIUS, command=self._acerca_de)

        self.label_right1 = customtkinter.CTkLabel(self.right_box, text="Villablanca\n  E.R.P", font=self.font_welcome_text, text_color="white")
        self.label_right1.pack(anchor="center", pady=200)
    
    def _create_boxes(self):
        # Crear frames principales
        self.top_box = customtkinter.CTkFrame(self)
        self.bottom_box = customtkinter.CTkFrame(self)
        self.left_box = customtkinter.CTkFrame(self)
        self.right_box = customtkinter.CTkFrame(self, fg_color=COLOR_PRINCIPAL)
        
        # Configuramos los frames principales
        self.top_box.configure(fg_color="#A5049E", height=HEIGHT_HEADER_FOOTER, corner_radius=0)
        self.bottom_box.configure(fg_color="#A5049E", height=HEIGHT_HEADER_FOOTER, corner_radius=0)
        self.left_box.configure(fg_color="#B805AF", corner_radius=0, width=WIDTH_LEFT_BLOCK)
        self.right_box.configure(fg_color=COLOR_PRINCIPAL)
        
        # Hacemos visibles los frames principales
        self.top_box.pack(side=tkinter.TOP, fill=tkinter.X)
        self.bottom_box.pack(side=tkinter.BOTTOM, fill=tkinter.X)
        self.left_box.pack(side=tkinter.LEFT, fill=tkinter.Y, ipadx=20)
        self.right_box.pack(side=tkinter.RIGHT, expand = True, fill=tkinter.BOTH)
        
        
    def _create_fonts(self):
        self.font_default = customtkinter.CTkFont("Dyuthi", 20)
        self.font_header = customtkinter.CTkFont("Dyuthi", 25)
        self.font_welcome_text = customtkinter.CTkFont("Dyuthi", 50)
    
    
    def _acerca_de(self):
        print("Mostrando información de la aplicación")
        InfoForm(self, "E.R.P Villablanca", "Hugo Pelayo", "I.E.S Villablanca", "Sistemas de Gestión Empresarial")
        # use protocol, avoid this window poping up once everytime we click the button
        
        
    def run(self):
        self.mainloop()