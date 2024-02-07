import customtkinter

class Modulo(customtkinter.CTkFrame):
    def __init__(self, master, label, on_frame_active):
        super(Modulo, self).__init__(master)
        self.label = label
        
        self.on_frame_active = on_frame_active
        
        self._create_fonts()
        
    def get_label(self):
        return self.label
    
    def action(self):
        self.on_frame_active(self)
            
    def _create_fonts(self):
        self.font_default = customtkinter.CTkFont("Dyuthi", 20)
        self.font_header = customtkinter.CTkFont("Dyuthi", 25)
        self.font_welcome_text = customtkinter.CTkFont("Dyuthi", 50)