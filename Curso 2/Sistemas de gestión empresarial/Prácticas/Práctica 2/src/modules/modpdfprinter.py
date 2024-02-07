from modules.extension import Modulo

class PDFGenerate(Modulo):
    
    def __init__(self, master, temps_src, on_frame_active):
        super().__init__(master, "Generar PDF", on_frame_active)

        self.temps_src = temps_src