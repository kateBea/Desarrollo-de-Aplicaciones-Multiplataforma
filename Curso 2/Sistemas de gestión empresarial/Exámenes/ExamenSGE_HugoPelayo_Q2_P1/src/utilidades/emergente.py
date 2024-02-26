from tkinter import *
from customtkinter import *

from utilidades.comunes import *

class Emergente(Toplevel):
    def __init__(
            self, 
            master, 
            titulo, 
            header_top, 
            header_middle, 
            header_bottom):
        
        super().__init__(master)
        
        self.title(titulo)
        self.config(bg=COLOR_VENTANA_PRINCIPAL, padx=100, pady=5)
        self.font = CTkFont("Dyuthi", 25)
        
        # Texto del primer header
        self.header_top = StringVar()
        self.header_top.set(f"{header_top}")
        self.header_top_label = CTkLabel(self, text=self.header_top.get(), text_color="white", font=self.font)
        self.header_top_label.pack(anchor="center")
        
        # Texto del segundo header
        self.header_middle = StringVar()
        self.header_middle.set(f"{header_middle}")
        self.header_middle_label = CTkLabel(self, text=self.header_middle.get(), text_color="white", font=self.font)
        self.header_middle_label.pack(anchor="center")
        
        # Texto del tercer header
        self.header_bottom = StringVar()
        self.header_bottom.set(f"{header_bottom}")
        self.header_bottom_label = CTkLabel(self, text=self.header_bottom.get(), text_color="white", font=self.font)
        self.header_bottom_label.pack(anchor="center")
        
    