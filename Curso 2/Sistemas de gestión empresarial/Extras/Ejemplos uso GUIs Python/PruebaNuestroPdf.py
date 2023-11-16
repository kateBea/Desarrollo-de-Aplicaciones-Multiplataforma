'''
Created on 30 ene 2023

@author: mariosantos
'''


import tkinter as tk
from tkinter import ttk
from Curso2023.NuestroPdf import PdfDAM


def Crear():
    fichero = PdfDAM()
    fichero.CrearDocumento('P', 'mm', 'A4')
    fichero.AnnadirPagina()
    fichero.Encabezado()
    
    fichero.ModificarFuente('Arial', 'B', 14)
    fichero.AnnadirLinea(300, 10, "Texto a introducir", 0, 1, 'L')
    fichero.Pie()
    fichero.SalvarDocumento("Prueba.pdf", 'F')

root = tk.Tk()
root.resizable(False, False)
root.geometry("300x200")
root.title("Creador de PDF´s DAM")

boton = ttk.Button(root, text="Generar PDF", command=Crear).grid(column=0, row=0)


root.mainloop()