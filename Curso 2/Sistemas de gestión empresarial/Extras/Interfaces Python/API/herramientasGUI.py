#from PIL import ImageTk, Image
from tkinter import PhotoImage


def cargar_Imagen(path):
    return PhotoImage(file = path)


def centrar_ventana(ventana, aplicacion_ancho, aplicacion_alto):
    resolucion_ancho = ventana.winfo_screenwidth()
    resolucion_alto = ventana.winfo_screenheight()
    x = int((resolucion_ancho / 2) - (aplicacion_ancho / 2))
    y = int((resolucion_alto/2) - (aplicacion_alto/2))
    return ventana.geometry(f"{aplicacion_ancho}x{aplicacion_alto}+{x}+{y}")


__all__ = [ 'cargar_imagen(path, size)', 'centrar_ventana(veneta, aplicacion_ancho, aplicacion_alto)']