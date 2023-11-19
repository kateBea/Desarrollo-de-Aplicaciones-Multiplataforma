import customtkinter, os
from tkinter import font
from tkinter import PhotoImage

class GUI(customtkinter.CTk):
    def __init__(self, cursor):
        super().__init__()
        ruta = os.path.dirname(__file__)
        

        self.cursor = cursor
        self.title("MySQL CustomTkinter")
        self.geometry("640x480")
        self.grid_columnconfigure((0, 1), weight=1)
        
        # Create a custom font with the desired size
        self.custom_font = customtkinter.CTkFont("Roboto", size=25)
        # print(font.families())
        
        logo = PhotoImage(file = ruta + '/Logo.png')
        customtkinter.CTkLabel(self, image = logo, width=1, height=1, text="").grid(columnspan = 2, row = 0)
        

        self.label = customtkinter.CTkLabel(self, text="Introduce tu consultad", fg_color="transparent", font=self.custom_font, justify="center")
        self.label.grid(row=1, column=0, padx=20, pady=20, sticky="ew")
        
        self.entry = customtkinter.CTkEntry(self, placeholder_text="Consulta", font=self.custom_font)
        self.entry.grid(row=2, column=0, padx=20, pady=20, sticky="ew", columnspan=2)

        self.button = customtkinter.CTkButton(self, text="Connect", command=self._connect, font=self.custom_font)
        self.button.grid(row=3, column=0, padx=20, pady=20, sticky="ew")
        
        self.button = customtkinter.CTkButton(self, text="Execute", command=self._execute_query, font=self.custom_font)
        self.button.grid(row=3, column=1, padx=20, pady=20, sticky="ew")
        
    def _connect(self):
        print("connected")
    
    def _execute_query(self):
        print("executed")