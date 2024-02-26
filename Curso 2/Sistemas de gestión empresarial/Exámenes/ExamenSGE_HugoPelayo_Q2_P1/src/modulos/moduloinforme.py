import os
import customtkinter

from utilidades.comunes import *
from modulos.modulobase import Modulo
from utilidades.generadorpdf import PDFTool

class ModInforme(Modulo):
    
    def __init__(self, master, fuentetiempos, on_frame_active):
        super().__init__(master, "Generar informe", on_frame_active)

        self.configure(fg_color=COLOR_VENTANA_PRINCIPAL)

        self.src = fuentetiempos
        self.num_corredores = 0
        self.dist_km_carrera = ""
        
        templates_folder = os.path.join(parent_path_from_file(__file__).parent, "assets/")
        print(f"pdfgenerate templates_folder folder: {templates_folder}")
        
        self.pdf_tool = PDFTool(templates_path=templates_folder)
        
        self.guardar_frame = customtkinter.CTkFrame(self, fg_color=self._fg_color)
        self.label_todo = customtkinter.CTkLabel(self.guardar_frame, text="Generar un PDF", font=self.font_default, text_color="white")
        self.label_todo.pack(anchor="center")
        self.ruta_fichero = customtkinter.CTkEntry(self.guardar_frame, width=200, height=40, corner_radius=5, fg_color="transparent", placeholder_text="Nombre del fichero...", font=self.font_default, text_color="white")
        self.ruta_fichero.pack(pady=10)
        self.guardar_todos = customtkinter.CTkButton(self.guardar_frame, text="Generar", fg_color="transparent", border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEADER_FOOTER)
        self.guardar_todos.configure(corner_radius=MODULE_BUTTONS_CORNER_RADIUS, command=self._generar_pdf)
        self.guardar_todos.pack(pady=2)
        self.label_error = customtkinter.CTkLabel(self.guardar_frame, text="Introduce un nombre válido", font=self.font_default, text_color="cyan")
        
        self.guardar_frame.pack(pady=20)
        
    def set_corredores(self, valor):
        self.num_corredores = int(valor)
        
    def set_carrera(self, valor):
        self.dist_km_carrera = valor
        
    def _generar_pdf(self):
        print("Generando PDF")
        
        nombre_fichero =  self.ruta_fichero.get()
        
        datos_10_km = None
        datos_21_km = None
        datos_32_km = None
        datos_42_km = None
        
        datos = self.src.get_data()
        
        for item in datos:
            if item["punto"] == "10km": datos_10_km = f'{item["tiempo"]}'
            if item["punto"] == "21km": datos_21_km = f'{item["tiempo"]}'
            if item["punto"] == "32km": datos_32_km = f'{item["tiempo"]}'
            if item["punto"] == "42km": datos_42_km = f'{item["tiempo"]}'
        
        datos_render = {
            "numCorredores": f"{self.num_corredores}",
            "distanciaKmCarrera": f"{self.dist_km_carrera}",
            
            # Matrcaremos con un guión aquellos puntos que no se hallan alcanzado
            "media10km": "-" if datos_10_km == None else datos_10_km,
            "media21km": "-" if datos_21_km == None else datos_21_km,
            "media32km": "-" if datos_32_km == None else datos_32_km,
            "media42km": "-" if datos_42_km == None else datos_42_km
        }
        
        if len(nombre_fichero) == 0:
            self.label_error.pack(anchor="center")
            return
        
        self.label_error.pack_forget()
        
        self.pdf_tool.render(datos_render, "template.html")
        self.pdf_tool.generate_output(f"{nombre_fichero}.pdf")