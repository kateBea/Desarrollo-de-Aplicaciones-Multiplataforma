import tkinter

from utilidades.comunes import *
from customtkinter import *
from utilidades.emergente import *

from modulos.modulorecibirtiempos import ModRecibirTiempos
from modulos.modulografica import ModGrafica
from modulos.moduloguardar import ModGuardar
from modulos.moduloinforme import ModInforme

INTERNAL_PAD_HEADER_FOOTER = 7

class Application(CTk):
    def __init__(self):
        super().__init__(fg_color=COLOR_VENTANA_PRINCIPAL)
        
        # Para controlar la ventana emergente
        self.info_form = None
    
        self._create_fonts()
        self._iniciar_ventana()
        self._create_boxes()
        
        # Inicializar módulos
        self.recibir_tiempos = ModRecibirTiempos(self.right_box, self._on_active_module_change)
        self.mostrar_grafica = ModGrafica(self.right_box, self.recibir_tiempos, self._on_active_module_change)
        self.generar_informe = ModInforme(self.right_box, self.recibir_tiempos, self._on_active_module_change)
        self.guardardb = ModGuardar(self.right_box, self.recibir_tiempos, self._on_active_module_change)
        
        self.modulos = [ self.recibir_tiempos, self.mostrar_grafica,self.guardardb, self.generar_informe ]
        self.active_module_frame = None
        self.active_module = None
        
        self._create_widgets()
        
        self._frame_inicio()

    def _frame_inicio(self):
        self.frame_inicio_holder = CTkFrame(self.right_box, fg_color=COLOR_HEADER_FOOTER)
        self.frame_inicio = CTkFrame(self.frame_inicio_holder, fg_color=COLOR_HEADER_FOOTER)
        
        self.label_corredores = CTkLabel(self.frame_inicio, text="Número de corredores", font=self.font_inicial_label, text_color="white")
        self.label_distancia = CTkLabel(self.frame_inicio, text="Distancia en Km.", font=self.font_inicial_label, text_color="white")
        
        self.input_corredores = CTkEntry(self.frame_inicio, width=200, height=40, corner_radius=5, fg_color="white", placeholder_text="", font=self.font_default, text_color="black")
        self.input_distancia = CTkEntry(self.frame_inicio, width=200, height=40, corner_radius=5, fg_color="white", placeholder_text="", font=self.font_default, text_color="black")
        
        self.label_corredores.grid(row=0, column=0)
        self.input_corredores.grid(row=0, column=1)
        self.label_distancia.grid(row=1, column=0)
        self.input_distancia.grid(row=1, column=1)
        
        self.frame_inicio.columnconfigure([0, 1], weight=20, pad=10)
        
        self.frame_inicio.pack(anchor="center", padx=30, pady=10)
        self.frame_inicio_holder.pack(anchor="center", pady=200)
        
    def _iniciar_ventana(self):
        ruta_assets = parent_path_from_file(__file__)
        self.logo = load_image(f"{ruta_assets}/assets/LogoVillablanca.png")
        
        self.title("E.R.P Villablanca")
        self.geometry("850x600")
        
    def _on_active_module_change(self, module):
        self.frame_inicio_holder.pack_forget()
        
        # Validación para evitar errores en el resto de módulos
        distancia = "10" if self.input_distancia.get() == "" else self.input_distancia.get()
        corredores = "10" if self.input_corredores.get() == "" else self.input_corredores.get() 
        
        self.generar_informe.set_carrera(distancia)
        self.generar_informe.set_corredores(corredores)
        
        if self.active_module == None:
            self.active_module = module
            self.active_module.pack(fill=tkinter.BOTH, expand=True)
            return
        
        if self.active_module != module:
            self.active_module.pack_forget()
            
            self.active_module = module
            self.active_module.pack(fill=tkinter.BOTH, expand=True)
        
    
    def _create_widgets(self):
        self.label_left = CTkLabel(self.left_box, image=self.logo, text="")
        self.label_top = CTkLabel(self.top_box, text="Gestión de carreras", font=self.font_default, text_color="white")
        self.label_bottom = CTkLabel(self.bottom_box, text="Curso 2023 - 2024", font=self.font_default, text_color=COLOR_TEXTO_CURSO)
        
        self.label_top.pack(anchor="center")
        self.label_bottom.pack(anchor="w", ipadx=10)
        self.label_left.pack(anchor="n", pady=10)
        
        # Botones de los módulos
        for modulo in self.modulos:
            print(modulo.get_label())
            self.left_button1 = CTkButton(self.left_box, text=modulo.get_label(), fg_color="transparent", border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEADER_FOOTER)
            self.left_button1.configure(corner_radius=MODULE_BUTTONS_CORNER_RADIUS, command=modulo.action)
            self.left_button1.pack(fill=tkinter.X, pady=2)
        
        self.acerca_de_btn = CTkButton(self.left_box, text="Acerca de...", fg_color="transparent",  border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEADER_FOOTER, anchor="e")
        self.acerca_de_btn.pack(fill=tkinter.X, side=tkinter.BOTTOM)
        self.acerca_de_btn.configure(corner_radius=MODULE_BUTTONS_CORNER_RADIUS, command=self._acerca_de)
    
    def _create_boxes(self):
        self.top_box = CTkFrame(self, fg_color=COLOR_HEADER_FOOTER)
        self.bottom_box = CTkFrame(self, fg_color=COLOR_HEADER_FOOTER)
        self.left_box = CTkFrame(self, fg_color=COLOR_CAJA_LATERAL)
        self.right_box = CTkFrame(self, fg_color=COLOR_VENTANA_PRINCIPAL)
        
        self.top_box.pack(side=tkinter.TOP, fill=tkinter.X)
        self.bottom_box.pack(side=tkinter.BOTTOM, fill=tkinter.X)
        self.left_box.pack(side=tkinter.LEFT, fill=tkinter.Y, ipadx=20)
        self.right_box.pack(side=tkinter.RIGHT, expand = True, fill=tkinter.BOTH)
        
    def _create_fonts(self):
        self.font_default = CTkFont("Dyuthi", 24)
        self.font_inicial_label = CTkFont("Dyuthi", 25)
        self.font_header = CTkFont("Dyuthi", 25)
        self.font_welcome_text = CTkFont("Dyuthi", 50)
    
    def _acerca_de(self):
        print("Mostrando información de la aplicación")
        if self.info_form != None:
            self.info_form.destroy()
        
        self.info_form = Emergente(self, "E.R.P Villablanca", "Hugo Pelayo", "Examen final 2 DAM", "I.E.S Villablanca")
        
    def run(self):
        self.mainloop()