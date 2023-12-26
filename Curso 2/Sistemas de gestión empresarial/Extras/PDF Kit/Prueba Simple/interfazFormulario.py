import tkinter as tk


class interfaz(tk.Tk):
    def __init__(self):
        super().__init__()
        self.ventana_principal()
        #self.title("2DAM - 2023 - 2024")
        #self.geometry("600x200+150+150")
        self.formulario()
        self.widget_formulario()
        

    def ventana_principal(self):
        self.title("2DAM - 2023 - 2024")
        self.geometry("600x200+150+150")

    def formulario(self):
        self.cajaFormulario = tk.Frame(
            self,
            bg='#2cb67d',
            height=250,
            width=100
        )

        self.cajaFormulario.pack(side=tk.RIGHT,fill='both',expand=False)

    def widget_formulario(self):
        self.boton = tk.Button(self.cajaFormulario)