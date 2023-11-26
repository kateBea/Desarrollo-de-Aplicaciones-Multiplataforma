import tkinter as tk
from tkinter import font
from valores import COLOR_BARRA_SUPERIOR, COLOR_FRAME_PRINCIPAL, COLOR_MENU_HOVER
import API.herramientasGUI as tool
from Form.proyecto import FormularioInfo
from Form.RegistroProyecto import registroProyectos

'''Declaramos una clase principal que es la que vamos a instanciar desde nuestro fichero principal.py.
Como os mencionaba en la clase que estuvimos viendo ayer,  esta clase hereda de tkinter, así que como véis, 
dentro del constructor de la clase, también tenemos referenciada la superclase o la clase de la que heredamos.'''



class FormularioBase(tk.Tk):

    def __init__(self):
        super().__init__()
        self.ventana_principal()
        self.logo = tool.cargar_Imagen("./Images/Logo.png")
        self.logo2 = tool.cargar_Imagen("./Images/LogoEmprendedoresTransparente.png")
        ''' Declaramos la estructura de los iframes o cajas, que no es otra cosa que tener un contenedor en el que vamos a ir cargando diferentes interfaces y que en este caso, los tenemos en diferentes ficheros .py.'''
        self.cajas()
        '''Una vez creadas nuestras secciones en nuestra página principal, empezamos a cargar las diferentes interfaces. La primera interface que cargamos, es la de la parte superior. '''
        self.widget_caja_superior()
        '''Cargamos la interface en la sección de la izquierda'''
        self.widget_caja_lateral()
        self.controles_cuerpo()

    def ventana_principal(self):
        self.title("2DAM - 2023 - 2024")
        w, h = 850, 600
        self.geometry("%dx%d+0+0" % (w, h))
        tool.centrar_ventana(self, w, h)

    '''Creación de las diferentes secciones dentro de la ventana que estamos instanciando desde este clase.
    En este caso, podemos observar que estoy configurando tres partes. Esto lo podéis observar porque configuramos tres tk.Frame(). '''
    def cajas(self):
        '''En esta primera sección creamos una sección en la parte superior tk.TOP y nos va a ocupar toda el espacio de la venteana fill="both". Estos parámetros los pasamos en Self.cajaSuperior.pack(). Además de estos parámetros, les pasamos los parámetros del color de fondo bg=COLOR_BARRA_SUPERIOR y la altura de esta sección height=50'''
        self.cajaSuperior = tk.Frame(
            self,
            bg=COLOR_BARRA_SUPERIOR,
            height=50
        )
        self.cajaSuperior.pack(side=tk.TOP, fill='both')
        '''En esta segunda sección creamos la de la izquierda. En este caso le damos el ancho, o sea, width=150. Le pasamos también el color de fondo. En la parte de en la que llamamos a .pack(), le decimos en que parte queremos colocarlo, en este caso, le decimos que coloque esta sección a la izquierda y no se solapa con la sección superior que hemos declarado antes que esta. Esto lo hacemos mediante side=tk.LEFT. La siguiente instrucción que nos encontramos es en la que decimos que rellene toda la sección a lo alto y a lo ancho, simpre respetando los parámetros width o height que le podemos pasar.Por último, la paso el parámetro expand, en la que le digo que si cambias el tamaño/resolución no se modifique el tamaño explicitado desde los parámetros.'''
        self.cajaLateral = tk.Frame(
            self,
            bg=COLOR_BARRA_SUPERIOR,
            width=150
        )
        self.cajaLateral.pack(side=tk.LEFT, fill='both', expand=False)
        '''Aquí declaramos la sección "principal", es el Frame en el que vamos a ir cargando las diferentes interfaces que vamos a utilizar en nuestra aplicación. En este caso, si que quiero que se reescale si cambio el tamaño/resolución de la ventana, por eso, le pasamos al parámetro "expand" el valor de True.'''
        self.cajaPrincipal = tk.Frame(
            self,
            bg=COLOR_FRAME_PRINCIPAL
        )
        self.cajaPrincipal.pack(side=tk.RIGHT, fill='both', expand=True)

        '''Una vez ejecutado este método "Cajas()", tenemos creada nuestra ventana con las diferentes secciones. Si ejecutamos ahora el desarrollo, debe aparecer la ventana con las secciones, sin ninguna interface cargada pero si con el color de fondo azul, con lo que os podéis hacer una idea de cómo va a quedar vuestra aplicación.'''



    '''Desde este método, cargamos la interface de la parte superior. Esta interface no es nada más que una etiqueta en la que añadimos el texto "Segundo de DAM 23-24".'''
    def widget_caja_superior(self):
        '''Añadimos el tk.Label con el texto que queremos que aparezca en el header de nuestra interface principal. Es importante ver que cuando pasamos el tk.Label() le decimos que nos lo dibuje en el Frame self.cajaSuperior, que lo hemos definido en el módulo anterior. "tk.Label(self.cajaSuperior,...)"'''
        self.Titulo = tk.Label(self.cajaSuperior, text="Segundo de DAM 23-24")
        '''Cuando utilizamos el método config(), le pasamos diferentes parámetros de configuración del widget Label. En este caso, le paso el color del texto, la fuente, el tamaño, el color de fondo y un padding para "y" y para "x".'''
        self.Titulo.config(fg="#fff", font=("Caladea", 20), bg=COLOR_BARRA_SUPERIOR, pady=10, width=20)
        '''Por último, lo que hago es situar el texto a la derecha de la sección creada para cargar esta interface.'''
        self.Titulo.pack(side=tk.RIGHT)

    '''Desde widget_caja_lateral vamos a cargar la interface de la sección de la izquierda. Esta interface'''
    def widget_caja_lateral(self):
        ancho_menu = 20
        alto_menu = 1
        '''tipo de fuente para cargar iconos como si fueran texto.'''
        font_awesome = font.Font(family='FontAwesome', size=15)

        '''Cargamos la imagen  que hemos cargado en la línea 19 de este código. Para visualizar esta imagen utilizo el widget de Label y le paso la variable que contiene el enlace a la imagen en el atributo "image". En este caso y como también os indicaba en el método anterior, debéis fijaros que dibujo esta etiqueta en la sección de la izquierda, es decir en "self.cajaLateral. '''
        self.LogoVillablanca = tk.Label(
            self.cajaLateral,
            image=self.logo,
            bg=COLOR_BARRA_SUPERIOR
        )
        self.LogoVillablanca.pack(side=tk.TOP, pady=10)
        '''Aquí creo los botones que voy a visualizar en esta interface de usuario. En este caso son 5 botones. Observar que únicamente cargo los widget. Si lo dejara así, no se dibujarían en el contenedor, que como podéis ver es "self.cajaLateral.'''
        self.btnOpcion1 = tk.Button(self.cajaLateral)
        self.btnOpcion2 = tk.Button(self.cajaLateral)
        self.btnOpcion3 = tk.Button(self.cajaLateral)
        self.btnOpcion4 = tk.Button(self.cajaLateral)
        self.btnOpcion5 = tk.Button(self.cajaLateral)

        '''Aquí creamos una colección con los diferentes valores que le debemos pasar a cada uno de los atributos del widget tk.button, que son el "Texto que queremos que aparezca en el botón", el "Identificador de cada uno de los botones" y el "método a lanzar" cuando se produzca el evento click.'''
        opciones_botones = [
            ("Base de Datos", self.btnOpcion1, self.abrir_panelInfo),
            ("Proyectos", self.btnOpcion2, self.registro_Proyecto),
            ("Buscar", self.btnOpcion3, self.abrir_panelInfo),
            ("Eliminar", self.btnOpcion4, self.abrir_panelInfo),
            ("Actualizar", self.btnOpcion5, self.abrir_panelInfo)
        ]
        '''En este for vamos recorriendo la colección de datos del paso anterior y se lo pasamos a "configurar_boton_menu()"'''
        for texto, boton, comando in opciones_botones:
            self.configurar_boton_menu(boton, texto, font_awesome, ancho_menu, alto_menu, comando)
    '''Fijaros que para añadir los valores a los diferentes parámetros de configuración de los botones, utilizamos el método config del tkinter.Button() '''
    def configurar_boton_menu(self, boton, texto, fuente, ancho, alto, comando):
        boton.config(text=f"{texto}", anchor="w", font=fuente, bd=0, bg=COLOR_BARRA_SUPERIOR, fg="white", width=ancho, height=alto, command = comando)
        boton.pack(side=tk.TOP, pady=10)
        '''Llamamos al método bind_hover_events para que reaccione al evento de pasar por encima.'''
        self.bind_hover_events(boton)

    def bind_hover_events(self, boton):
        boton.bind("<Enter>", lambda event: self.on_enter(event, boton))
        boton.bind("<Leave>", lambda event: self.on_leave(event, boton))

    def controles_cuerpo(self):
        label = tk.Label(self.cajaPrincipal, image=self.logo2, bg=COLOR_FRAME_PRINCIPAL)
        label.place(x=0, y=0, relwidth=1, relheight=1)

    def on_enter(self, event, boton):
        boton.config(bg=COLOR_MENU_HOVER, fg='white')

    def on_leave(self, event, boton):
        boton.config(bg=COLOR_BARRA_SUPERIOR, fg='white')


    def abrir_panelInfo(self):
        FormularioInfo()


    def registro_Proyecto(self):
        self.limpiarVentanaPrincipal(self.cajaPrincipal)
        registroProyectos(self.cajaPrincipal)


    

    def limpiarVentanaPrincipal(self, framePrincipal):
        for widget in framePrincipal.winfo_children():
            widget.destroy()
