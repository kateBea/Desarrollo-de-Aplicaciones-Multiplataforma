import tkinter as tk
import API.herramientasGUI as tool

class FormularioInfo(tk.Toplevel):
    #Fijaros que en el constructor hago referencia al constructor de la 
    #clase heredada. Tengo que hacer esto, puesto que si no entra en recursión.
    def __init__(self) -> None:
        super().__init__()
        self.config_window()
        self.construirWidget()

    def config_window(self):
        self.title("Informacion")
        w,h = 400, 100
        tool.centrar_ventana(self, w, h)

    def construirWidget(self):
        self.labelVersion = tk.Label(self, text="Version: 1.0")
        self.labelVersion.config(fg="#000000", font=(
            "Roboto", 15), pady=10, width=20
        )
        self.labelVersion.pack()

        self.labelAutor = tk.Label(self, text="Autor: Mario Santos")
        self.labelAutor.config(fg="#000000", font=("Roboto", 15), pady=10, width=20)
        self.labelAutor.pack()