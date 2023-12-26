import tkinter as tk
from tkinter import *
from .herramientas import myWindow, coloresAplicacion, miTexto
from .myInformation import myInformation
from .loadJSON import LoadJSON




class ventanaPrincipal(tk.Tk):
    def __init__(self, mywidth, myheight):
        super().__init__()
        self.title("Examen 2-DAM")
        self.geometry("%dx%d+0+0" % (mywidth, myheight))
        myWindow(self, mywidth, myheight)
        self.colores = coloresAplicacion()
        self.makeFrame()
        self.controlesLaterales()
        
        
        
    def makeFrame(self):
        self.head = tk.Frame(
            self,
            bg = self.colores.get_Head_Foot_Color(),
            height = 50,
        )
        self.head.pack(side=tk.TOP, fill='both')
        
        self.Foot = tk.Frame(
            self,
            bg = self.colores.get_Head_Foot_Color(),
            height = 50,
        )
        self.Foot.pack(side=tk.BOTTOM, fill='both')
        
        self.left = tk.Frame(
            self,
            bg = self.colores.get_Left_Color(),
            width = 150,
        )
        self.left.pack(side = tk.LEFT, fill='both', expand=False)
        
        self.main = tk.Frame(
            self,
            bg = self.colores.get_Principal_Color(),
        )
        self.main.pack(side=tk.RIGHT, fill='both', expand=True)
        
        miTexto(self.head, 'Nombre_Alumno', 'Dyuthi', 20, tk.TOP, self.colores.get_Font_Color())
        miTexto(self.Foot, 'Examen 1ª Evaluación - curso 2023 2024', 'Dyuthi', 20, tk.LEFT, self.colores.get_Font_Second_Color())
        
        
        self.sec = tk.Label(self.main, text='Villablanca \n E.R.P.')
        self.colores = coloresAplicacion()
        self.sec.config(fg=self.colores.get_Font_Second_Color(), font=('Dyuthi', 60), bg=self.colores.get_Principal_Color(), pady=10, padx=10)
        self.sec.pack(pady=150)
        
    
    def controlesLaterales(self):
        self.logo = tk.PhotoImage(file="package/Logo2.png")
        tk.Label(self.left, image=self.logo, bg=self.colores.get_Left_Color()).pack(side=tk.TOP, pady=10)
        
        self.btnOpcion1 = tk.Button(self.left)
        self.btnOpcion2 = tk.Button(self.left)
        self.btnOpcion3 = tk.Button(self.left)
        
        Buttons_options=[
            ("Migración Datos", self.btnOpcion1, self.loadJson)
        ]
        
        for texto, boton, comando in Buttons_options:
            self.configurar_boton_menu(boton, texto,comando)
            
        self.btnOpcion3.config(text="My Information", anchor="e", font=("Dyuthi", 15), bd=0, bg="#6B3799", fg=self.colores.get_Font_Color(), width=20, height=1, command=self.miInformacion)
        self.btnOpcion3.pack(side=tk.BOTTOM, pady=10)
            
    def configurar_boton_menu(self, boton, texto, comando):
        boton.config(text=f"{texto}", anchor="w", font=("Dyuthi", 15), bd=0, bg=self.colores.get_Left_Color(), fg=self.colores.get_Font_Color(), width=20, height=1, command=comando)
        boton.pack(side=tk.TOP, pady=10)
        
        
    def limpiarVentanaPrincipal(self, framePrincipal):
            for widget in framePrincipal.winfo_children():
                widget.destroy()
        
        
        
    def miInformacion(self):
        self.miInformacion = myInformation()    
        self.miInformacion.mainloop()
        
    def loadJson(self):
        self.limpiarVentanaPrincipal(self.main)
        LoadJSON(self.main)
    
    def saveMySQL(self):
        pass