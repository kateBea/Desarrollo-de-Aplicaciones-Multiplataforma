from modules.extension import Modulo
from utilidades import *

class PDFGenerate(Modulo):
    
    def __init__(self, master, temps_src, on_frame_active):
        super().__init__(master, "Generar PDF", on_frame_active)

        self.configure(fg_color=COLOR_PRINCIPAL)

        self.temps_src = temps_src