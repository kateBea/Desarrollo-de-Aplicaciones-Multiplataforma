import tkinter

from utilidades import *
from matplotlib.backends.backend_tkagg import (
    FigureCanvasTkAgg, NavigationToolbar2Tk)
from matplotlib.backend_bases import key_press_handler
from matplotlib import pyplot as plt, animation
import numpy as np

from matplotlib.backends.backend_tkagg import (FigureCanvasTkAgg, NavigationToolbar2Tk) 
from customtkinter import *
from modulos.modulobase import Modulo
from utilidades.comunes import *

class ModGrafica(Modulo):
    
    def __init__(self, master, fuentetiempos, on_frame_active):
        super(ModGrafica, self).__init__(master, "Ver gráfica de tiempos", on_frame_active)
        self.configure(fg_color=COLOR_VENTANA_PRINCIPAL)
        
        self.src = fuentetiempos
        
        plt.axes(xlim=(0, LIMIT_DATA), ylim=(TIEMPO_MIN, TIEMPO_MAX))
        self.fig = plt.Figure()
        self.ax = self.fig.add_subplot(xlim=(0, LIMIT_DATA), ylim=(TIEMPO_MIN, TIEMPO_MAX))
        self.line, = self.ax.plot([], [], lw=2)
        
        self.ax.set_xlabel("Puntos (km)")
        self.ax.set_ylabel("Media de tiempos (min)")
        self.ax.set_title(f"Media de los valores obtenidos (mins/punto)")
        
        self.canvas = FigureCanvasTkAgg(self.fig, master=self)
        
        self.anim = animation.FuncAnimation(self.fig, self._animate, init_func=self._init,frames=200, interval=50, blit=True)

    def action(self):
        super().action()
        
        print("Activo mostrar tiempos")
        
        self.canvas.draw()
        self.canvas.get_tk_widget().pack(side=tkinter.TOP, fill=tkinter.BOTH, expand=True)
        
    def _init(self):
        self.line.set_data([], [])
        return self.line,

    def _animate(self, i):
        lista = []
        for item in self.src.get_data():
            lista.append(item["tiempo"])
        
        x = np.linspace(0, LIMIT_DATA, len(self.src.get_data()))
        y = np.array(lista)
        
        self.line.set_data(x, y)
        
        return self.line,