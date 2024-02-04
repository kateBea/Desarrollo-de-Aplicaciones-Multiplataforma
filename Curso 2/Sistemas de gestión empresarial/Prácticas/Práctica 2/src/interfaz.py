import os
import tkinter
import customtkinter
import threading
import numpy as np
import datetime

from matplotlib.backends.backend_tkagg import (
    FigureCanvasTkAgg, NavigationToolbar2Tk)
from matplotlib.backend_bases import key_press_handler
from matplotlib import pyplot as plt, animation
import numpy as np
import random 

from matplotlib.figure import Figure 
from matplotlib.backends.backend_tkagg import (FigureCanvasTkAgg, NavigationToolbar2Tk) 

from tkinter import PhotoImage
from utilidades import *
from popupinfo import *
from pathlib import Path

MAX_TEMPERATURA = 50.0
MIN_TEMPERATURA = 20

TIME_INTERVAL = 5

class GUI(customtkinter.CTk):
    """ 
    Aplicación principal de ala interfaz de gráficos.
    """
    
    def __init__(self):
        super().__init__(fg_color=COLOR_PRINCIPAL)
        # constantes internas
        self.height_header_footer = 50
        self.width_left_block = 150
        
        # fuentes
        self._create_fonts()
        
        parent = Path(os.path.dirname(__file__))
        ruta_assets = Path(parent.parent)
        print(ruta_assets.parent.absolute())
        self.logo = PhotoImage(file=f"{ruta_assets}/assets/Logo.png") 
        
        # crear la ventana principal
        self.title("E.R.P Villablanca")
        self.geometry("850x600")
        
        # Cajas
        self._create_boxes()
        
        self._create_widgets()
        self._setup_labels()
        self._setup_buttons()
        
        # Variables necesarias. TODO: explicar mejor
        self.want_tempts = False
        self.dato_temperatura = 0.0

        # Módulo visualizar temperaturas
        # Setup plot look
        #plt.rcParams["figure.figsize"] = [7.00, 3.50]
        plt.rcParams["figure.autolayout"] = True
        plt.rcParams['lines.linewidth'] = 2
        plt.rcParams['lines.linestyle'] = ':'

        self.temperaturas = list()
        plt.axes(xlim=(0, TIME_INTERVAL), ylim=(MIN_TEMPERATURA, MAX_TEMPERATURA))
        self.fig = plt.Figure()
        self.ax = self.fig.add_subplot(xlim=(0, TIME_INTERVAL), ylim=(MIN_TEMPERATURA, MAX_TEMPERATURA))
        self.line, = self.ax.plot([], [], lw=2)
        
        self.ax.set_xlabel("Tiempo (s)")
        self.ax.set_ylabel("Temperatura (ºC)")
        self.ax.set_title("Variación de temperatura \nen los útltimos 5 segundos")
        
        self.temperaturas = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        self.temperaturas_tiempo = list() # tiempo en que llegan las temperaturas
        
        # Create and setup the canvas
        self.canvas = FigureCanvasTkAgg(self.fig, master=self.right_box)
        self.canvas.draw()
        
         # Create and animation by repeatedlly calling animate()
        self.anim = animation.FuncAnimation(self.fig, self.animate, init_func=self.init,frames=500, interval=50, blit=True)

    
    
    def _create_widgets(self):
        self.label_left = customtkinter.CTkLabel(self.left_box, image=self.logo, text="")
        self.label_top = customtkinter.CTkLabel(self.top_box, text="Hugo Pelayo", font=self.font_default, text_color="white")
        self.label_bottom = customtkinter.CTkLabel(self.bottom_box, text="Curso 2023 - 2024", font=self.font_default, text_color="white")
        
        self.left_button1 = customtkinter.CTkButton(self.left_box, text="Recibir temperaturas", fg_color="transparent", border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEAD_FOOT)
        self.left_button2 = customtkinter.CTkButton(self.left_box, text="Ver gráfica de temperaturas", fg_color="transparent", border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEAD_FOOT)
        self.left_button3 = customtkinter.CTkButton(self.left_box, text="Acerca de...", fg_color="transparent",  border_color="white", border_width=1, font=self.font_default, text_color="white", hover_color=COLOR_HEAD_FOOT, anchor="e")
        
        # se usa para centrar label_right1 (que es un grid)
        self.label_right1_container = customtkinter.CTkLabel(self.right_box, fg_color="transparent", text="")
        self.label_right1 = customtkinter.CTkLabel(self.label_right1_container, text="Villablanca\n  E.R.P", font=self.font_welcome_text, text_color="white")
        self.label_right2 = customtkinter.CTkLabel(self.label_right1_container, text="", font=self.font_welcome_text, text_color="white")
        
    def _create_boxes(self):
        self.top_box = customtkinter.CTkFrame(self)
        self.bottom_box = customtkinter.CTkFrame(self)
        self.left_box = customtkinter.CTkFrame(self)
        self.right_box = customtkinter.CTkFrame(self, fg_color=COLOR_PRINCIPAL)
        
        self.top_box.configure(fg_color="#A5049E", height=self.height_header_footer, corner_radius=0)
        self.bottom_box.configure(fg_color="#A5049E", height=self.height_header_footer, corner_radius=0)
        self.left_box.configure(fg_color="#B805AF", corner_radius=0, width=self.width_left_block)
        #self.right_box.configure(fg_color="#FFFFFF")
        
        self.top_box.pack(side=tkinter.TOP, fill=tkinter.X)
        self.bottom_box.pack(side=tkinter.BOTTOM, fill=tkinter.X)
        self.left_box.pack(side=tkinter.LEFT, fill=tkinter.Y, ipadx=20)
        self.right_box.pack(side=tkinter.RIGHT, expand = True, fill=tkinter.BOTH)
        
        
    def _create_fonts(self):
        self.font_default = customtkinter.CTkFont("Dyuthi", 20)
        self.font_header = customtkinter.CTkFont("Dyuthi", 25)
        self.font_welcome_text = customtkinter.CTkFont("Dyuthi", 50)
         
         
    def _setup_buttons(self):
        self.left_button1.pack(fill=tkinter.X, pady=2)
        self.left_button2.pack(fill=tkinter.X)
        self.left_button3.pack(fill=tkinter.X, side=tkinter.BOTTOM)
        
        rounder_border = 5
        
        self.left_button1.configure(corner_radius=rounder_border, command=self._left_button_bottom1)
        self.left_button2.configure(corner_radius=rounder_border, command=self._left_button_bottom2)
        self.left_button3.configure(corner_radius=rounder_border, command=self._left_button_bottom3)
    
    def _left_button_bottom1(self):
        print("Activo recibir temperaturas")
        
        # TODO: cambier arquitectura. Este buleano servirá
        # para indicar que queremos las temperaturas en pantalla
        # Sería ideal poner un frame y cambiar el frame activo del
        # panel central al que corresponde a un botón en concreto.
        # Es una alternative más escalable que la actual. 
        self.want_tempts = True
        
        # Para inmediatamente actualizar la interfaz de temperaturas.
        PRECISION = 2
        self.label_right1_container.pack(anchor="center", pady=200)
        
        self.label_right2.configure(text=f"{round(self.dato_temperatura, PRECISION)} ºC")
        self.label_right1.grid(column=0, row=0)
        self.label_right2.grid(column=0, row=1)
        
        if self.canvas != None:
            self.canvas.get_tk_widget().pack_forget()


    def init(self):
        self.line.set_data([], [])
        return self.line,

    def animate(self, i):
        x = np.linspace(0, TIME_INTERVAL, len(self.temperaturas))
        y = np.array(self.temperaturas)
        
        self.line.set_data(x, y)
        
        return self.line,

    def _left_button_bottom2(self):
        print("Activo mostrar temperaturas")
        
        self.want_tempts = False
        self.label_right1_container.pack_forget()
        
        self.canvas.draw()

        # Make the canvas visible in the frame
        self.canvas.get_tk_widget().pack(side=tkinter.TOP, fill=tkinter.BOTH, expand=True)
    
    def _left_button_bottom3(self):
        print("Mostrando información de la aplicación")
        InfoForm(self, "E.R.P Villablanca", "Hugo Pelayo", "I.E.S Villablanca", "Sistemas de Gestión Empresarial")
        # use protocol, avoid this window poping up once everytime we click the button
    
    
    def _setup_labels(self):
        self.label_top.pack(anchor="center")
        self.label_bottom.pack(anchor="w", ipadx=10)
        self.label_left.pack(anchor="n")
        
        self.label_right1_container.pack(anchor="center", pady=200)
        self.label_right1.grid(column=0, row=0)
        
        
    def procesar_dato(self, dato):
        self.dato_temperatura = float(dato)
        self.temperaturas.append(self.dato_temperatura)
        self.temperaturas = self.temperaturas[-10:]
        
        self.temperaturas_tiempo.append(f"{datetime.datetime.now()}")
        
        print(f"Recibido '{dato} ºC' el '{self.temperaturas_tiempo[-1]}'") 
        
        if self.want_tempts:
            PRECISION = 2
            self.label_right2.configure(text=f"{round(self.dato_temperatura, PRECISION)} ºC")
            self.label_right2.grid(column=0, row=1)
        
    def _mostrar_dato(self, dato):
        print(f"Recibido {dato}")  
        
    def run(self):
        self.mainloop()