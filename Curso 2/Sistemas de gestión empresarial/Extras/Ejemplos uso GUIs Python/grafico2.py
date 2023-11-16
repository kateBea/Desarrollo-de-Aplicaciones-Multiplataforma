'''
Created on 12 dic 2021

@author: mariosantos
'''
from matplotlib.figure import Figure
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
import tkinter as tk


fig = Figure(figsize=(12,8), facecolor='orange')

axis = fig.add_subplot(221)

xValues = [1,2,3,4]
yValues = [5,7,6,8]

axis.plot(xValues, yValues)
axis.set_xlabel('Eje de las X')
axis.set_ylabel('Eje de las Y')

axis.grid(linestyle='-')

def _destroyWindow():
    root.quit()
    root.destroy()
    
root = tk.Tk()
root.protocol('WM_DELETE_WINDOW', _destroyWindow)

canvas = FigureCanvasTkAgg(fig, master=root)
canvas._tkcanvas.pack(side=tk.TOP, fill=tk.BOTH, expand=1)

root.mainloop()