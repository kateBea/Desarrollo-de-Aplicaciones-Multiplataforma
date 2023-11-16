from customtkinter import *
from screeninfo import get_monitors

main_monitor = get_monitors()[0]
print(main_monitor)

ANCHO_VENTANA = 640
ALTO_VENTANA = 480

BG_BLACK = '#010101'
BG_WHITE = '#FFFFFF'
c_negro = '#010101'
c_morado = '#7f5af0'
c_verde = '#2cb67d'
c_gris = '#808080'

POS_Y = main_monitor.width_mm // 2
POS_X = main_monitor.height_mm // 2

def button_event():
    print("Pressed buttons")

ventana = CTk()

ventana.title("Query")
ventana.geometry(f"{ANCHO_VENTANA}x{ALTO_VENTANA}")
ventana.minsize(ANCHO_VENTANA, ALTO_VENTANA)
ventana.config(bg = BG_WHITE)

frame = CTkFrame(ventana, fg_color = c_gris, border_color=c_negro, corner_radius=12, bg_color=c_negro)
frame.grid(column = 0, row = 0, sticky = 'nsew', padx = 50, pady = 50)

frame.columnconfigure([0,1], weight= 1)
frame.rowconfigure([0,1,2,3,4], weight=1)

ventana.columnconfigure(0, weight = 1)
ventana.rowconfigure(0, weight=1)

# Main loop
ventana.mainloop()