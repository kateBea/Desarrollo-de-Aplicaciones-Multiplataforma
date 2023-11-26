import mysql.connector
import tkinter as tk
from tkinter import ttk

conexion = mysql.connector.connect(
    host = "localhost",
    user = "root",
    password = "123456"
)
cursor = conexion.cursor()
cursor.execute("SHOW DATABASES")
texto = ""

for bd in cursor:
    texto = texto + str(bd) + " "

def conexion():
    print( texto)
    print(tkValor.get())

ventana = tk.Tk()
ventana.title("Segundo DAM")
ventana.geometry("500x200")
ventana.resizable(False, False)

lblEtiqueta = ttk.Label(ventana, text="Mi primer texto")
lblEtiqueta.grid(column=0, row=0, padx=20, pady=10)

btnBoton = ttk.Button(ventana, text="Púlsame", command=conexion)
btnBoton.grid(column=1, row=0, padx=20, pady=10)


tkValor = tk.StringVar
lblNombre = ttk.Entry(ventana, text=tkValor, width="50")
lblNombre.grid(column=0, row=2, columnspan=2, padx=20, pady=10 )



ventana.mainloop() 