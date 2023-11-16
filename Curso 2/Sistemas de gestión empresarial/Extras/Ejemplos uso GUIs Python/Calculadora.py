'''
Created on 24 nov 2022

@author: usertar
'''

import tkinter as tk
from tkinter import ttk


valordisplay="0"
ventana = tk.Tk()
 

ventana.title("Nuestra calculadora")

ventana.geometry("200x200")

def display_text(val):
    global valordisplay
    valor = valordisplay.get() + val
    valordisplay.set(valor)

def limpiar():
    valordisplay.set("")

def sumar(a,b):
    valordisplay.set(a+b)


valordisplay = tk.StringVar()
valordisplay.set("")
#valordisplay.set("0")
display = ttk.Label(ventana, textvariable=valordisplay, background="white", width=25, anchor="e")
display.grid(column=0, row=0, columnspan=5)

#display2 = ttk.Label(ventana, width=25)
#display2.grid(column=0, row=1, columnspan=5)

boton1 = ttk.Button(ventana, text="1", width=3, command= lambda: display_text("1"))
#boton1.grid(column=1, row=2, sticky="w")
boton1.place(x=10, y=40)

boton2 = ttk.Button(ventana, text="2", width=3, command= lambda: display_text("2"))
#boton2.grid(column=2, row=2, sticky="w")
boton2.place(x=50, y=40)

boton3 = ttk.Button(ventana, text="3", width=3, command= lambda: display_text("3"))
#boton3.grid(column=3, row=2, sticky="w")
boton3.place(x=90, y=40)

boton4 = ttk.Button(ventana, text="4", width=3, command= lambda: display_text("4"))
#boton4.grid(column=1, row=3, sticky="w")
boton4.place(x=10, y=80)

boton5 = ttk.Button(ventana, text="5", width=3, command= lambda: display_text("5"))
#boton5.grid(column=2, row=3, sticky="w")
boton5.place(x=50, y=80)

boton6 = ttk.Button(ventana, text="6", width=3, command= lambda: display_text("6"))
#boton6.grid(column=3, row=3, sticky="w")
boton6.place(x=90, y=80)

boton7 = ttk.Button(ventana, text="7", width=3, command= lambda: display_text("7"))
#boton4.grid(column=1, row=3, sticky="w")
boton7.place(x=10, y=120)

boton8 = ttk.Button(ventana, text="8", width=3, command= lambda: display_text("8"))
#boton5.grid(clumn=2, row=3, sticky="w")
boton8.place(x=50, y=120)

boton9 = ttk.Button(ventana, text="9", width=3, command= lambda: display_text("9"))
#boton6.grid(column=3, row=3, sticky="w"8
boton9.place(x=90, y=120)


boton0 = ttk.Button(ventana, text="0", width=3, command= lambda: display_text("0"))
#boton5.grid(clumn=2, row=3, sticky="w")
boton0.place(x=50, y=160)

botonC = ttk.Button(ventana, text="C",width=3,command= lambda: limpiar())

botonC.place(x=90, y=160)

botonM = ttk.Button(ventana, text="+",width=3,command= lambda: sumar(1,2))

botonM.place(x=130, y=160)

ventana.mainloop()
