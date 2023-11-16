'''
Created on 16 dic 2021

python3.9 -m pip install matplotlib

@author: mariosantos
'''

from matplotlib.figure import Figure
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
import tkinter as tk


figura = Figure(figsize=(12, 5), facecolor='white')

ejes = figura.add_subplot(111)

ValoresX = [1,2,3,4]
ValoresY1 = [6, 7.5, 8, 7.5]
ValoresY2 = [5.5, 6.5, 50, 6]
ValoresY3 = [6.5, 7, 8, 7]

ValoresYAll = [ValoresY1, ValoresY2, ValoresY3]

minY = min([y for YValores in ValoresYAll for y in YValores])

CotaSuperior = 51

maxY = max([y for YValores in ValoresYAll for y in YValores if y < CotaSuperior])

ejes.set_xlim(min(ValoresX), max(ValoresX))
ejes.set_ylim(minY, maxY)





t0, = ejes.plot(ValoresX, ValoresY1, color='orange')
t1, = ejes.plot(ValoresX, ValoresY2, color='red')
t2, = ejes.plot(ValoresX, ValoresY3, color='green')

figura.legend((t0, t1, t2), ('Datos 1', 'Datos 2', 'Datos 3'), 'upper right')

ejes.set_ylabel("Valores eje Y")
ejes.set_xlabel("Valores eje X")

ejes.grid(linestyle=':')

def _CerrarVentana():
    vprin.quit()
    vprin.destroy()
    
    
vprin = tk.Tk()
vprin.protocol('WM_DELETE_WINDOWS', _CerrarVentana)

canvas = FigureCanvasTkAgg(figura, master=vprin)
canvas._tkcanvas.pack(side=tk.TOP, fill=tk.BOTH, expand=1)

vprin.mainloop()