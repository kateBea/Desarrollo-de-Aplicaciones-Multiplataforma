from tkinter import PhotoImage
import tkinter as tk

class coloresAplicacion():
    def __init__(self):
        self.Head_Foot_Color = "#a5049E" 
        self.Principal_Color = "#D805CD"
        self.Left_Color = '#B805AF'
        self.Font_Color = "#FEFEFE"
        self.Font_Second_Color = '#7A0374'
        
    def get_Left_Color(self):
        return self.Left_Color;
    
    def get_Font_Second_Color(self):
        return self.Font_Second_Color;

    def get_Head_Foot_Color(self):
        return self.Head_Foot_Color;

    def get_Principal_Color(self):
        return self.Principal_Color;

    def get_Font_Color(self):
        return self.Font_Color;

class myImage():
    def __init__():
        pass

    def image_Load(path):
        return PhotoImage(file=path)
    
class miTexto():
    def __init__(self, seccion, texto, fuente, tamanno, posicion, color):
        self.seccion = seccion
        self.texto = texto
        self.fuente = fuente
        self.tamanno = tamanno
        self.posicion = posicion
        self.color = color      
        self.textLoad()
    
    def textLoad(self):
        self.sec = tk.Label(self.seccion, text=self.texto)
        self.colores = coloresAplicacion()
        self.sec.config(fg=self.color, font=(self.fuente, self.tamanno), bg=self.colores.get_Head_Foot_Color(), pady=10, padx=10)
        self.sec.pack(side=self.posicion)
    
class myWindow():
    def __init__(self,wind, aplication_width, aplication_height):
        self.wind = wind
        self.aplication_width = aplication_width
        self.aplication_height = aplication_height
        self.window_center()

    def window_center(self):
        width_resolution = self.wind.winfo_screenwidth()
        print(width_resolution)
        height_resolution = self.wind.winfo_screenheight()
        print(height_resolution)
        x = int((width_resolution / 2) - (self.aplication_width / 2))
        y = int((height_resolution / 2) - (self.aplication_height / 2))
        return self.wind.geometry(f"{self.aplication_width}x{self.aplication_height}+{y}+{x}")