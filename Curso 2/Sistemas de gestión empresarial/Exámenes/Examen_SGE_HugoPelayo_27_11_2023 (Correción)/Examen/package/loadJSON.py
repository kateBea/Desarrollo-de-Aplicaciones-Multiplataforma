

import tkinter as tk
from tkinter import *
from .herramientas import myWindow, coloresAplicacion, miTexto
from .myInformation import myInformation
from customtkinter import *
import json, os
from .BBDD import miBBDD

class LoadJSON():
    def __init__(self, ventana):
        self.colores = coloresAplicacion()
        frame = CTkFrame(ventana, fg_color=self.colores.get_Head_Foot_Color(), border_color='black', corner_radius=12, bg_color=self.colores.get_Principal_Color())
        frame.pack(fill='x', padx=20, pady=20)    
        
        frame.columnconfigure([0,1], weight=1)
        frame.rowconfigure([0,1,2,3,4,5,6], weight=1)
        
        self.lblTitulo = CTkLabel(frame, text="Cargando datos .JSON", font=("Dyuthi", 30), text_color='white', width=450)
        self.lblTitulo.grid(columnspan=2, row=0, pady=10)
        self.lblJson1 = CTkLabel(frame, text="Fichero JSON 1:", font=("Dyuthi", 20), text_color='white', width=450)
        self.lblJson1.grid(row=1, column=0, sticky="e")
        self.TxtJson1 = CTkEntry(frame, font=("Dyuthi", 20), text_color=self.colores.get_Font_Color(), placeholder_text="Json 1", border_color=self.colores.get_Font_Color(), fg_color=self.colores.get_Head_Foot_Color(), width=400)
        self.TxtJson1.grid(column=1, row=1, padx=10, pady=10, sticky="e")
        self.lblJson2 = CTkLabel(frame, text="Fichero JSON 2:", font=("Dyuthi", 20), text_color='white', width=450)
        self.lblJson2.grid(row=2, column=0, sticky="e")
        self.TxtJson2 = CTkEntry(frame, font=("Dyuthi", 20), text_color=self.colores.get_Font_Color(), placeholder_text="Json 2", border_color=self.colores.get_Font_Color(), fg_color=self.colores.get_Head_Foot_Color(), width=400)
        self.TxtJson2.grid(column=1, row=2, padx=10, pady=10, sticky="e")
        btnCargar = CTkButton(frame, text="Cargar Ficheros", font=("Dyuthi", 20), text_color="white", command=self.cargarDatos)
        btnCargar.grid(row=3, columnspan=2, pady=10)
        self.txtDatos1 = CTkTextbox(frame, width=220, height=100, font=("Dyuthi", 11), text_color="white", border_color="white", border_width=2, fg_color=self.colores.get_Head_Foot_Color())
        self.txtDatos1.grid(column=0, row=4, pady=10)
        self.txtDatos2 = CTkTextbox(frame, width=220, height=100, font=("Dyuthi", 11), text_color="white", border_color="white", border_width=2, fg_color=self.colores.get_Head_Foot_Color())
        self.txtDatos2.grid(column=1, row=4, pady=10)
        self.lblTitulo2 = CTkLabel(frame, text="Salvando datos", font=("Dyuthi", 30), text_color='white', width=450)
        self.lblTitulo2.grid(columnspan=2, row=5, pady=10)
        btnSalvar = CTkButton(frame, text="Salvar Datos", font=("Dyuthi", 20), text_color="white", command=self.guardarBBDD)
        btnSalvar.grid(row=6, columnspan=2, pady=10)

    def cargarDatos(self):
        datosPath = os.path.dirname(__file__)
        print(datosPath)
        with open(datosPath + '/' + self.TxtJson1.get()) as Datos1:
            self.misDatos_text = json.load(Datos1)

        with open(datosPath + '/' + self.TxtJson2.get()) as Datos2:
            self.misDatos2_text = json.load(Datos2)

        for i in self.misDatos_text['usuario']:
            linea = i['username'] + '-' + i['email'] + '-' + i['password'] + '\n'
            self.txtDatos1.insert(INSERT, linea)

        for i in self.misDatos2_text['notas']:
            linea1 = i['nombre'] + ":" + '\n'
            self.txtDatos2.insert(INSERT, linea1)
            for j in i['modulos']:
                linea2 = j['nombreModulo'] + '-' + str(j['nota1']) + '-' + str(j['nota2']) + '\n'
                self.txtDatos2.insert(INSERT, linea2)
        
    def guardarBBDD(self):
        mibaseDatos = miBBDD(self.misDatos_text, self.misDatos2_text)