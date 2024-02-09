import os
import customtkinter

from modules.extension import Modulo
from utilidades import *
from modules.pdfwriter import PDFTool

class PDFGenerate(Modulo):
    
    def __init__(self, master, temps_src, on_frame_active):
        super().__init__(master, "Generar PDF", on_frame_active)

        self.configure(fg_color=COLOR_PRINCIPAL)

        self.temps_src = temps_src
        
        # Inicializar herramienta PDF
        templates_folder = os.path.join(parent_path_from_file(__file__).parent, "assets/")
        print(f"pdfgenerate templates_folder folder: {templates_folder}")
        
        self.pdf_tool = PDFTool(templates_path=templates_folder)
        
        # Guardar datos a fichero json
        self.guardar_frame = customtkinter.CTkFrame(self, fg_color=self._fg_color)
        self.label_todo = customtkinter.CTkLabel(self.guardar_frame, text="Generar un PDF", font=self.font_default, text_color="white")
        self.label_todo.pack(anchor="center")
        self.ruta_fichero = customtkinter.CTkEntry(self.guardar_frame, width=200, height=40, corner_radius=5, fg_color="transparent", placeholder_text="Nombre del fichero...", font=self.font_default, text_color="white")
        self.ruta_fichero.pack(pady=10)
        self.guardar_todos = customtkinter.CTkButton(self.guardar_frame, text="Generar", fg_color="transparent", border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEAD_FOOT)
        self.guardar_todos.configure(corner_radius=MODULE_BUTTONS_CORNER_RADIUS, command=self._generar_pdf)
        self.guardar_todos.pack(pady=2)
        self.label_error = customtkinter.CTkLabel(self.guardar_frame, text="Introduce un nombre válido", font=self.font_default, text_color="cyan")
        
        self.guardar_frame.pack(pady=20)
        
        
    def _generar_pdf(self):
        print("Generando PDF")
        
        nombre_fichero =  self.ruta_fichero.get()
        datos = self.temps_src.get_info()
        
        if len(nombre_fichero) == 0:
            self.label_error.pack(anchor="center")
            return
        
        self.label_error.pack_forget()
        
        self.pdf_tool.render({ "datos": datos }, "template_1.html")
        self.pdf_tool.generate_output(f"{nombre_fichero}.pdf")