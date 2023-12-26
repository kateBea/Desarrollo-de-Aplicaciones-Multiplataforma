import tkinter as tk
from .herramientas import myWindow, coloresAplicacion
from customtkinter import *


class myInformation(tk.Toplevel):
    def __init__(self):
        super().__init__()
        self.colores = coloresAplicacion()
        self.title="My Information"
        self.geometry("300x1200+0+0")
        self.config(bg=self.colores.get_Head_Foot_Color())
        myWindow(self, 500, 150)
        self.frame = CTkFrame(self, fg_color = self.colores.get_Head_Foot_Color(), border_color=self.colores.get_Left_Color(), corner_radius=12, bg_color=self.colores.get_Head_Foot_Color())
        self.frame.grid(column=0, row=0, pady=20)
        self.frame.columnconfigure([0], weight=1)
        self.frame.rowconfigure([0,1,2], weight=1)
        
        self.lblInformacion = CTkLabel(self.frame, text="Alumno: Mario Santos", font=('Robotopo', 20), text_color='white', width=500)
        self.lblInformacion.grid(column=0, row=0, sticky="nwse")
        self.lblInformacion = CTkLabel(self.frame, text="Centro: I.E.S. Villablanca", font=('Robotopo', 20), text_color='white')
        self.lblInformacion.grid(column=0, row=1, sticky="nwse")
        self.lblInformacion = CTkLabel(self.frame, text="Módulo: Sistemas de Getión Empresarial", font=('Robotopo', 20), text_color='white')
        self.lblInformacion.grid(column=0, row=2, sticky="nwse")
        
        
        
        
        
       
        