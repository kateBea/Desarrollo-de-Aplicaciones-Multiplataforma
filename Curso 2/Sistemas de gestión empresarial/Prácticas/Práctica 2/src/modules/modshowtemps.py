import tkinter
import customtkinter

from utilidades import *
from matplotlib.backends.backend_tkagg import (
    FigureCanvasTkAgg, NavigationToolbar2Tk)
from matplotlib.backend_bases import key_press_handler
from matplotlib import pyplot as plt, animation
import numpy as np

from matplotlib.backends.backend_tkagg import (FigureCanvasTkAgg, NavigationToolbar2Tk) 

from modules.extension import Modulo

MAX_TEMPERATURA = 50.0
MIN_TEMPERATURA = 20

# Módulo para mostrar variación de temperaturas en tiempo real

class ShowTemps(Modulo):
    
    def __init__(self, master, temp_source, on_frame_active):
        super(ShowTemps, self).__init__(master, "Gráfica de temperaturas", on_frame_active)
        self.configure(fg_color=COLOR_PRINCIPAL)
        
        self.temp_src = temp_source
        
        # Parámetros de visualización (opcional)
        plt.rcParams["figure.autolayout"] = True
        plt.rcParams['lines.linewidth'] = 1
        #plt.rcParams['lines.linestyle'] = ':'

        plt.axes(xlim=(0, LIMIT_DATA), ylim=(MIN_TEMPERATURA, MAX_TEMPERATURA))
        self.fig = plt.Figure()
        self.ax = self.fig.add_subplot(xlim=(0, LIMIT_DATA), ylim=(MIN_TEMPERATURA, MAX_TEMPERATURA))
        self.line, = self.ax.plot([], [], lw=2)
        
        self.ax.set_xlabel("Tiempo (s)")
        self.ax.set_ylabel("Temperatura (ºC)")
        self.ax.set_title(f"Variación de temperatura \nen los útltimos {LIMIT_DATA} segundos")
        
        # Create and setup the canvas
        self.canvas = FigureCanvasTkAgg(self.fig, master=self)
        
         # Create and animation by repeatedlly calling animate()
        self.anim = animation.FuncAnimation(self.fig, self._animate, init_func=self._init,frames=200, interval=50, blit=True)

    def action(self):
        super().action()
        
        print("Activo mostrar temperaturas")
        
        self.canvas.draw()
        self.canvas.get_tk_widget().pack(side=tkinter.TOP, fill=tkinter.BOTH, expand=True)
        
    def _init(self):
        self.line.set_data([], [])
        return self.line,

    def _animate(self, i):
        # TODO: should not be a even distribution since temperatures do not arrive at same intervals
        x = np.linspace(0, LIMIT_DATA, len(self.temp_src.get_temps()))
        y = np.array(self.temp_src.get_temps())
        
        self.line.set_data(x, y)
        
        return self.line,