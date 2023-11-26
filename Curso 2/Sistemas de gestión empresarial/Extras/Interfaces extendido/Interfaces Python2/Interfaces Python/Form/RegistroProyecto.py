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

class registroProyectos():
    #Constructor. Como parámetro de entrada el frame donde dibujamos todos los widgets.
    def __init__(self, ventana):
        #añadimos los widgets en un frame.
        frame = CTkFrame(ventana, fg_color=c_morado, border_color=c_negro, corner_radius=12, bg_color=COLOR_FRAME_PRINCIPAL)
        frame.grid(column = 0, row = 0, padx=50, pady=50)

        frame.columnconfigure([0,1], weight=1)
        frame.rowconfigure([0,1,2,3,4,5], weight=1)

        lblTitulo = CTkLabel(frame, text=" Registro de Proyectos ", font=('Robotopo', 24), text_color='white')
        lblTitulo.grid(columnspan=2, row=0, pady=10)

        lblProyecto = CTkLabel(frame, text="Proyecto", font=('Robotopo', 12), text_color='white', height=alto)
        lblProyecto.grid(row=1, column=0, sticky="w", padx=10)
       

        #Añadimos self para poder trabajar dentro de la instanciación de esta clase.
        self.txtProyecto = CTkEntry(frame, font=('Robotopo', 12), text_color="#FCAC15", placeholder_text="Nombre del proyecto", border_color=c_verde, fg_color=COLOR_FRAME_PRINCIPAL, width=ancho, height=alto)
        self.txtProyecto.grid(column=1, row=1, pady=5, padx=10)

        lblIntegrantes = CTkLabel(frame, text="Integrantes", font=('Robotopo', 12), text_color='white', height=alto)
        lblIntegrantes.grid(row=2, column=0, sticky="w", padx=10)


        self.txtIntegrantes = CTkTextbox(frame, width=220, height=100, font=('Robotopo', 12), text_color="#FCAC15", border_color=c_verde, fg_color=COLOR_FRAME_PRINCIPAL, corner_radius=12, scrollbar_button_color=c_morado, border_width=2)
        self.txtIntegrantes.grid(column=1, row=2, pady=5, padx=10)

        lblFechaInicio = CTkLabel(frame, text="Fecha Inicio", font=('Robotopo', 12), text_color='white', height=alto)
        lblFechaInicio.grid(row=3, column=0, sticky="w", padx=10)

        self.calFechaInicio = Calendar(frame, selectmode="day", showweeknumbers=False, cursor="hand2", date_pattern='y-mm-dd')
        self.calFechaInicio.grid(row=3, column=1, pady=5)
      

        btn = CTkButton(frame, text="Pulsar", font=('Robotopo', 12), text_color='white', height=alto, command=self.activar)
        btn.grid(row=4, column=0, sticky="w", padx=10, pady=5)

    #función de prueba para comprobar como recoger los datos.
    def activar(self):
        print(self.txtProyecto.get())
        self.txtProyecto.delete(0, END)
        self.txtProyecto.insert(INSERT, "Hola, mundo")
        self.txtIntegrantes.insert(INSERT, "Dato\n")
        print(self.calFechaInicio.get_date())