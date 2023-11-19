'''
Created on 25 nov 2021

@author: mariosantos
'''

import tkinter as tk
from tkinter import ttk, Menu, messagebox as msg, messagebox

'''
    En esta clase definimos los métodos necesarios para mostrar el ToolTip.
    Ver el vídeo 16.
'''

class Tooltip(object):
    '''
        constructor de la clase
    '''
    def __init__(self, widget, tip_text=None):
        self.widget = widget
        self.tip_text = tip_text
        widget.bind('<Enter>', self.mouse_enter)
        widget.bind('<Leave>', self.mouse_leave)
    '''
        con estas dos métodos controlamos el evento de entrar y salir de encima del Widget
    '''
    def mouse_enter(self, _event):
        self.show_tooltip()
        
    def mouse_leave(self, _event):
        self.hide_tooltip()
    
    '''
        Dentro de este método, configuramos la ventana del tooltip e introducimos el texto que queremos que se muestre.
        Este tooltip únicamente se va a mostrar si se ha pasado un texto a la hora de instanciar la clase.
    '''
    
    def show_tooltip(self):
        if self.tip_text:
            x_left = self.widget.winfo_rootx() + 150
            y_top = self.widget.winfo_rooty() - 20
            self.tip_window = tk.Toplevel(self.widget)
            self.tip_window.overrideredirect(True)
            self.tip_window.geometry("+%d+%d" % (x_left, y_top))
            
            label2 = tk.Label(self.tip_window, text=self.tip_text,
                              justify=tk.LEFT, background="#ffffe0", relief=tk.SOLID, borderwidth=1, 
                              font=("tahoma", "15", "normal"), fg="black")
            label2.pack(ipadx=1)
    '''
        Desde este método, cerramos el tooltip si es que ha sido visualizado.
    '''
    def hide_tooltip(self):
        if self.tip_window:
            self.tip_window.destroy()

'''
    desde estas tres primeras líneas, creamos una ventana contenedora principal, le añadimos un título y no dejamos que 
    se reescale ni en el eje x ni en el eje y.
'''
            
miVentana = tk.Tk()
miVentana.title("Segundo de DAM")
miVentana.resizable(False, False)

'''
    Empezamos a crear las pestañas y las relacionamos con los frames que van a contener los distintos widgets.
'''

tabControl = ttk.Notebook(miVentana)
tab1 = ttk.Frame(tabControl)
tab2 = ttk.Frame(tabControl)
tab3 = ttk.Frame(tabControl)

tabControl.add(tab1, text="Datos Personales")
tabControl.add(tab2, text="Datos Profesionales")
tabControl.add(tab3, text="Datos Familiares")

tabControl.pack(expand=True, fill="both")

'''
    Añadimos un marco con una etiqueta, en este caso "Personales". Este marco va a ser el contenedor de los diferentes
    widget´s que insertemos.
'''

frmTab1 = ttk.Labelframe(tab1, text="Personales")
frmTab1.grid(column=0, row=0, padx=0, pady=0)


'''
    A partir de aquí, tenéis que ir introduciendo los diferentes widget e indicar el contenedor, que en este caso es 
    el marco frmTab1
'''

lblTab1 = ttk.Label(frmTab1, text="Nombre: ")
lblTab1.grid(column=0, row=1, padx=10, pady=10, sticky="W")

valNombre = tk.StringVar()

txtNombre = ttk.Entry(frmTab1, width=20, textvariable=valNombre)
txtNombre.grid(column=1, row=1, padx=10, pady=10, sticky="W")

'''
    Desde esta línea, llamamos a la clase Tooltip. Fijaros que pasamos como primer parámetro el nombre de la variable asociada
    al widget y como segundo parámetro el texto.
'''

Tooltip(txtNombre, "Introduzca su nombre")

frmEdad = ttk.Labelframe(frmTab1, text="Edad")
frmEdad.grid(column=2, row=1, padx=10, pady=10, sticky="E")

valoptEdad = tk.IntVar()

optEdad1 = ttk.Radiobutton(frmEdad, text=">16 <25", value=1, variable=valoptEdad)
optEdad1.grid(column=0, row=0, padx=5, pady=5)

optEdad2 = ttk.Radiobutton(frmEdad, text=">26 <35", value=2, variable=valoptEdad)
optEdad2.grid(column=0, row=1, padx=5, pady=5)

optEdad3 = ttk.Radiobutton(frmEdad, text=">36 <45", value=3, variable=valoptEdad)
optEdad3.grid(column=0, row=3, padx=5, pady=5)

'''
    Con estas líneas que se encuentran comentadas, mostraríamos la edad con un ComboBox, en vez de con los
    RadioButton.
'''

# lblEdad= ttk.Label(frmTab1, text="Edad: ")
# lblEdad.grid(column=2, row=1, padx=10, pady=10, sticky="W")

# valedad = tk.StringVar()
# ddnvaledad = ttk.Combobox(frmTab1, width=10, textvariable=valedad, state="readonly")
# ddnvaledad["values"] = (16,17,18,19,20,21,22,23,24,25,26,27,28,29,30)
# ddnvaledad.grid(column=3, row=1, padx=10, pady=10)

lblApellidos = ttk.Label(frmTab1, text="Apellidos: ")
lblApellidos.grid(column=0, row=2, padx=10, pady=10, sticky="W")

valApellido = tk.StringVar()

txtApellido = ttk.Entry(frmTab1, width=45, textvariable=valApellido)
txtApellido.grid(column=1, row=2, padx=10, pady=10, columnspan=3, sticky="W")

Tooltip(txtApellido, "Introduzca sus apellidos")

lblEmail = ttk.Label(frmTab1, text="E-mail: ")
lblEmail.grid(column=0, row=3, padx=10, pady=10, sticky="W")

valEmail = tk.StringVar()

txtEmail = ttk.Entry(frmTab1, width=45, textvariable=valEmail)
txtEmail.grid(column=1, row=3, padx=10, pady=10, columnspan=3, sticky="W")

lblCiudad = ttk.Label(frmTab1, text="Ciudad: ")
lblCiudad.grid(column=0, row=4, padx=10, pady=10, sticky="W")

valCiudad = tk.StringVar()

ddnCiudad = ttk.Combobox(frmTab1, width=45, textvariable=valCiudad, state="readonly")
ddnCiudad["values"] = ("Madrid", "Barcelona", "Cáceres", "Valencia", "Coruña")
ddnCiudad.grid(column=1, row=4, padx=10, pady=10, columnspan=3, sticky="W")

frmTab2 = ttk.Labelframe(tab2, text="Profesionales")
frmTab2.grid(column=0, row=0, padx=0, pady=0)

lblEmpresa = ttk.Label(frmTab2, text="Empresa: ")
lblEmpresa.grid(column=0, row=1, padx=10, pady=10, sticky="W")

varEmpresa = tk.StringVar()

txtEmpresa = ttk.Entry(frmTab2, width=45, textvariable=varEmpresa)
txtEmpresa.grid(column=1, row=1, padx=10, pady=10)

lblEmpresa = ttk.Label(frmTab2, text="Dirección: ")
lblEmpresa.grid(column=0, row=2, padx=10, pady=10, sticky="W")

varDireccion = tk.StringVar()

txtDireccion = ttk.Entry(frmTab2, width=45, textvariable=varDireccion)
txtDireccion.grid(column=1, row=2, padx=10, pady=10)

lblEmailProf = ttk.Label(frmTab2, text="Email: ")
lblEmailProf.grid(column=0, row=3, padx=10, pady=10, sticky="W")

varEmailProf = tk.StringVar()

txtEmailProf = ttk.Entry(frmTab2, width=45, textvariable=varEmailProf)
txtEmailProf.grid(column=1, row=3, padx=10, pady=10)

lblTlfProf = ttk.Label(frmTab2, text="Teléfono: ")
lblTlfProf.grid(column=0, row=4, padx=10, pady=10, sticky="W")

varTelfProf = tk.StringVar()

txtTlfProf = ttk.Entry(frmTab2, width=20, textvariable=varEmailProf)
txtTlfProf.grid(column=1, row=4, padx=10, pady=10, sticky="W")

frmFamilia = ttk.Labelframe(tab3, text="Familiares")
frmFamilia.grid(column=0, row=0, padx=0, pady=0)

frmEstadoCivil = ttk.Labelframe(frmFamilia, text="Estado Civil")
frmEstadoCivil.grid(column=0, row=1, padx=10, pady=10, sticky="W")

valOtro = tk.StringVar()

otros = ttk.Entry(frmFamilia, width=40, textvariable=valOtro)


def EstadoCivil():
    otros.grid(column=1, row=1, padx=10, pady=10, columnspan=2, sticky="s")
    
    
def EstadoCivil2():
    otros.grid_remove()



valoptEstadoCivil = tk.IntVar()

optEC1 = ttk.Radiobutton(frmEstadoCivil, text="Casado", value=1, variable=valoptEstadoCivil, command=EstadoCivil2)
optEC1.grid(column=0, row=0, padx=5, pady=5, sticky="W")

optEC2 = ttk.Radiobutton(frmEstadoCivil, text="Soltero", value=2, variable=valoptEstadoCivil, command=EstadoCivil2)
optEC2.grid(column=0, row=1, padx=5, pady=5, sticky="W")

optEC3 = ttk.Radiobutton(frmEstadoCivil, text="Otros ", value=3, variable=valoptEstadoCivil, command=EstadoCivil)
optEC3.grid(column=0, row=3, padx=5, pady=5, sticky="W")

lblHijos = ttk.Label(frmFamilia, text="Número de Hijos: ")
lblHijos.grid(column=0, row=2, padx=10, pady=10, columnspan=2, sticky="NW")


''' 
    mostrar la selección de hijos con un spinbox en vez de con una lista desplegable

'''

'''

miSpin = ttk.Spinbox(frmFamilia, from_=0, to=5, values=(0,1,2,3,4,5), width=20, state="readonly", command=miSpinValor)
miSpin.grid(column=0, row=3, padx=10, pady=10, columnspan=5, sticky="W")

'''
valNumHijos = tk.IntVar()


ddwHijos = ttk.Combobox(frmFamilia, width=10, textvariable=valNumHijos, state='readonly')
ddwHijos["values"]=(0,1,2,3,4,5)
ddwHijos.grid(column=0, row=3, columnspan=5, sticky="W")



contador = 1

nombre_hijo1 = tk.StringVar()
nombre_hijo2 = tk.StringVar()
nombre_hijo3 = tk.StringVar()
nombre_hijo4 = tk.StringVar()
nombre_hijo5 = tk.StringVar()

''' generamos entradas para los nombres de los hijos cuando pulsamos sobre el botón +
'''

def NombreHijos():
    global contador, nombre_hijo1, nombre_hijo2, nombre_hijo3, nombre_hijo4, nombre_hijo5
    print(contador)
    if (contador != 5):
        if (contador == 1):
            ttk.Entry(frmNombreHijos, width=50, textvariable=nombre_hijo1).grid(column=0, padx=2, pady=2)
        elif (contador == 2):
            ttk.Entry(frmNombreHijos, width=50, textvariable=nombre_hijo2).grid(column=0, padx=2, pady=2)
        elif (contador == 3):
            ttk.Entry(frmNombreHijos, width=50, textvariable=nombre_hijo3).grid(column=0, padx=2, pady=2)
        elif (contador == 4):
            ttk.Entry(frmNombreHijos, width=50, textvariable=nombre_hijo4).grid(column=0, padx=2, pady=2)
        elif(contador == 5):
            ttk.Entry(frmNombreHijos, width=50, textvariable=nombre_hijo5).grid(column=0, padx=2, pady=2)
        contador += 1
    else:
        messagebox.showinfo(message="Solo se pueden introducir un máximo de 5 hij@s", title="DAM")   
        

    
    
    

frmNombreHijos = ttk.Labelframe(frmFamilia, text="Nombre de Hijos ")
frmNombreHijos.grid(column=0, row=4, padx=10, pady=10, columnspan=2, sticky="W")

Hijo1 = tk.StringVar()

ttk.Entry(frmNombreHijos, width=50, textvariable=Hijo1).grid(column=0, row=0, padx=2, pady=2)
ttk.Button(frmNombreHijos, width=1, text="+", command=NombreHijos).grid(column=1, row=0, padx=2, pady=2)

def quit():
    miVentana.quit()
    miVentana.destroy()
    exit()

'''
    Se configuran los diferentes menús y submenús de la barra de menús.
'''


menu_bar = Menu(miVentana)
miVentana.config(menu=menu_bar)

file_menu = Menu(menu_bar)


file_menu.add_command(label='Nuevo')
file_menu.add_command(label='Actualizar')
file_menu.add_separator()
file_menu.add_command(label='Eliminar')
file_menu.add_separator()
file_menu.add_command(label='Cerrar', command=quit)


menu_bar.add_cascade(label="Registro", menu=file_menu)

def NombresHijos():
    messagebox.showinfo(message="Nombre del primer hijo: " + Hijo1.get() +
                        "\nNombre del segundo hijo: " + nombre_hijo1.get() +
                        "\nNombre del tercer hijo: " + nombre_hijo2.get() +
                        "\nNombre del cuarto hijo: " + nombre_hijo3.get() +
                        "\nNombre del quinto hijo: " + nombre_hijo4.get() +
                        "\nNombre del sexto hijo: " + nombre_hijo5.get()
                        , title="DAM")
    
    


file_menu_informe = Menu(menu_bar)

file_menu_informe.add_command(label="Imprimir a PDF", command=NombresHijos)
menu_bar.add_cascade(label="Informes", menu=file_menu_informe)

def msgBox():
    #msg.showinfo("Segundo de DAM", "Una GUI de Python con Tkinter")
    #msg.showwarning("Segundo de DAM", "Una interfaz creada con Tkinter \nen el año 2021")
    msg.showerror("Segundo de DAM", "Una interfaz crada con Tkinter:"
                  "\nError: Los chicos tienen muchos examenes")
    
file_menu_help = Menu(menu_bar)

file_menu_help.add_command(label="About", command=msgBox)
menu_bar.add_cascade(label="Help", menu=file_menu_help)



miVentana.mainloop()
