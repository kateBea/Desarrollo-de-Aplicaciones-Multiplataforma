import tkinter as tk
from tkinter import font
from valores import COLOR_BARRA_SUPERIOR, COLOR_FRAME_PRINCIPAL, COLOR_MENU_HOVER
import API.herramientasGUI as tool
from Form.proyecto import FormularioInfo
from Form.RegistroProyecto import registroProyectos


class FormularioBase(tk.Tk):

    def __init__(self):
        super().__init__()
        self.ventana_principal()
        self.logo = tool.cargar_Imagen("./Images/Logo.png")
        self.logo2 = tool.cargar_Imagen("./Images/LogoEmprendedoresTransparente.png")
        self.cajas()
        self.widget_caja_superior()
        self.widget_caja_lateral()
        self.controles_cuerpo()

    def ventana_principal(self):
        self.title("2DAM - 2023 - 2024")
        w, h = 850, 600
        self.geometry("%dx%d+0+0" % (w, h))
        tool.centrar_ventana(self, w, h)

    def cajas(self):
        self.cajaSuperior = tk.Frame(
            self,
            bg=COLOR_BARRA_SUPERIOR,
            height=50
        )
        self.cajaSuperior.pack(side=tk.TOP, fill='both')

        self.cajaLateral = tk.Frame(
            self,
            bg=COLOR_BARRA_SUPERIOR,
            width=150
        )
        self.cajaLateral.pack(side=tk.LEFT, fill='both', expand=False)

        self.cajaPrincipal = tk.Frame(
            self,
            bg=COLOR_FRAME_PRINCIPAL
        )
        self.cajaPrincipal.pack(side=tk.RIGHT, fill='both', expand=True)


    def widget_caja_superior(self):

        self.Titulo = tk.Label(self.cajaSuperior, text="Segundo de DAM 23-24")
        self.Titulo.config(fg="#fff", font=("Caladea", 20), bg=COLOR_BARRA_SUPERIOR, pady=10, width=20)
        self.Titulo.pack(side=tk.RIGHT)


    def widget_caja_lateral(self):
        ancho_menu = 20
        alto_menu = 1
        font_awesome = font.Font(family='FontAwesome', size=15)

        self.LogoVillablanca = tk.Label(
            self.cajaLateral,
            image=self.logo,
            bg=COLOR_BARRA_SUPERIOR
        )
        self.LogoVillablanca.pack(side=tk.TOP, pady=10)

        self.btnOpcion1 = tk.Button(self.cajaLateral)
        self.btnOpcion2 = tk.Button(self.cajaLateral)
        self.btnOpcion3 = tk.Button(self.cajaLateral)
        self.btnOpcion4 = tk.Button(self.cajaLateral)
        self.btnOpcion5 = tk.Button(self.cajaLateral)

        opciones_botones = [
            ("Base de Datos", self.btnOpcion1, self.abrir_panelInfo),
            ("Proyectos", self.btnOpcion2, self.registro_Proyecto),
            ("Buscar", self.btnOpcion3, self.abrir_panelInfo),
            ("Eliminar", self.btnOpcion4, self.abrir_panelInfo),
            ("Actualizar", self.btnOpcion5, self.abrir_panelInfo)
        ]

        for texto, boton, comando in opciones_botones:
            self.configurar_boton_menu(boton, texto, font_awesome, ancho_menu, alto_menu, comando)

    def configurar_boton_menu(self, boton, texto, fuente, ancho, alto, comando):
        boton.config(text=f"{texto}", anchor="w", font=fuente, bd=0, bg=COLOR_BARRA_SUPERIOR, fg="white", width=ancho, height=alto, command = comando)
        boton.pack(side=tk.TOP, pady=10)
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
