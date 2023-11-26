"""**************************************
Ejemplo inteface gráfica de python
Author: Mario Santos
Fecha: 17 de noviembre de 2023
*****************************************"""

from customtkinter import *
#Herramientas desarrolladas
import API.herramientasGUI as tool
#variables definidas por nosotros.
from valores import COLOR_FRAME_PRINCIPAL, COLOR_MENU_HOVER, COLOR_BARRA_SUPERIOR
#trabajando con la librería de calendario
from tkcalendar import Calendar

#Colores con los que trabajamos a lo largo de toda la interface
c_negro = '#010101'
c_morado = '#7f5af0'
c_verde = '#2cb67d'
c_gris = '#808080'
c_morado = '#795DF5'
ancho = 275
alto = 40

class conexion():
    #Constructor. Como parámetro de entrada el frame donde dibujamos todos los widgets.
    def __init__(self, ventana):
        #añadimos los widgets en un frame.
        frame = CTkFrame(ventana, fg_color=c_morado, border_color=c_negro, corner_radius=12, bg_color=COLOR_FRAME_PRINCIPAL)
        frame.grid(column = 0, row = 0, padx=50, pady=50)

        frame.columnconfigure([0,1], weight=1)
        frame.rowconfigure([0,1,2,3,4,5], weight=1)

        lblTitulo = CTkLabel(frame, text=" Conexión Base de Datos. ", font=('Robotopo', 24), text_color='white')
        lblTitulo.grid(columnspan=2, row=0, pady=10)

        lblProyecto = CTkLabel(frame, text="username", font=('Robotopo', 12), text_color='white', height=alto)
        lblProyecto.grid(row=1, column=0, sticky="w", padx=10)
       

        