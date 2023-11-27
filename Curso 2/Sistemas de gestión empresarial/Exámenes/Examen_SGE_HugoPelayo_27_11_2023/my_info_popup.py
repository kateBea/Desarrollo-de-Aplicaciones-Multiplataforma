##########################################
# Examen de SGE                          #
#                                        #
# Hugo Pelayo                            #
# 27 nov 2023                            #
##########################################

import customtkinter
import tkinter
from tkinter import Toplevel
from utilidades import *

"""
    Formulario que muestra la información del
    autor de esta aplicación, se le indica el título de la ventana,
    nombre de alumno, nombre de centro y nombre de módulo con que se
    va a crear.
"""
class InfoForm(Toplevel):
    def __init__(self, master, titulo, nombre_alumno, nombre_centro, nombre_modulo):
        super().__init__(master)
        
        # configuramos la ventana principal
        self.title(titulo)
        self.config(bg=COLOR_PRINCIPAL, padx=30, pady=5)

        # establecemos la fuente para todos los textos         
        self.font = customtkinter.CTkFont("Dyuthi", 20)
        
        # Texto del alumno
        self.alumno_str = tkinter.StringVar()
        self.alumno_str.set(f"Alumno: {nombre_alumno}")
        self.alumno_label = customtkinter.CTkLabel(self, text=self.alumno_str.get(), text_color="white", font=self.font)
        self.alumno_label.pack(anchor="center")
        
        # Texto del nombre de centro
        self.centro_str = tkinter.StringVar()
        self.centro_str.set(f"Centro: {nombre_centro}")
        self.centro_label = customtkinter.CTkLabel(self, text=self.centro_str.get(), text_color="white", font=self.font)
        self.centro_label.pack(anchor="center")
        
        # Texto del nombre del módulo
        self.modulo_str = tkinter.StringVar()
        self.modulo_str.set(f"Módulo: {nombre_modulo}")
        self.modulo_label = customtkinter.CTkLabel(self, text=self.modulo_str.get(), text_color="white", font=self.font)
        self.modulo_label.pack(anchor="center")
        
    