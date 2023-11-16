'''
Created on 12 dic 2021

@author: mariosantos
'''
from matplotlib.figure import Figure
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
import tkinter as tk
from tkinter import messagebox


xValues = [1,2,3,4]
yValues = [5,7,6,8]

fig = Figure(figsize=(12,8), facecolor='orange', linewidth=50.0, edgecolor="black")

axis1 = fig.add_subplot(221)
axis2 = fig.add_subplot(222, sharex=axis1, sharey=axis1)
axis3 = fig.add_subplot(223, sharex=axis1, sharey=axis1)
axis4 = fig.add_subplot(224, sharex=axis1, sharey=axis1)

axis1.plot(xValues, yValues)
axis1.set_xlabel("Eje X")
axis1.set_ylabel("Eje Y")
axis1.grid(linestyle="-")



axis2.plot(xValues, yValues)
axis2.set_xlabel("Eje X")
axis2.set_ylabel("Eje Y")
axis2.grid(linestyle="-")


axis3.plot(xValues, yValues)
axis3.set_xlabel("Eje X")
axis3.set_ylabel("Eje Y")
axis3.grid(linestyle="-")


axis4.plot(xValues, yValues)
axis4.set_xlabel("Eje X")
axis4.set_ylabel("Eje Y")
axis4.grid(linestyle="-")



def _destroyWindow():
    if messagebox.askquestion("Atención", "Estás seguro?") == 'yes':
        root.quit()
        root.destroy()
    
root = tk.Tk()
root.protocol('WM_DELETE_WINDOW', _destroyWindow)

canvas = FigureCanvasTkAgg(fig, master=root)
canvas._tkcanvas.pack(side=tk.TOP, fill=tk.BOTH, expand=1)

root.mainloop()