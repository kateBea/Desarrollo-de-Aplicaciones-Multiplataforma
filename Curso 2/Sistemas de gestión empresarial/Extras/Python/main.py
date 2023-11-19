
from customtkinter import CTk, CTkFrame, CTkLabel, CTkEntry, CTkButton, CTkCheckBox, CTkImage
from tkinter import PhotoImage

c_negro = '#010101'
c_morado = '#7f5af0'
c_verde = '#2cb67d'
c_gris = '#808080'  



ventana = CTk()
ventana.geometry('500x600+350+20')
ventana.minsize(480, 500)
ventana.config(bg = c_negro)
ventana.title('Segundo de DAM')






logo = PhotoImage(file = 'logo.png')
logo2 = PhotoImage(file = './Logos/logo2.png')
logo3 = PhotoImage(file = './Logos/logo3.png')


frame = CTkFrame(ventana, fg_color = c_gris, border_color=c_negro, corner_radius=12, bg_color=c_negro)
frame.grid(column = 0, row = 0, sticky = 'nsew', padx = 50, pady = 50)

frame.columnconfigure([0,1], weight= 1)
frame.rowconfigure([0,1,2,3,4], weight=1)

ventana.columnconfigure(0, weight = 1)
ventana.rowconfigure(0, weight=1)

CTkLabel(frame, image = logo3, width=5, height=5, text="").grid( columnspan = 2, row = 0)

correo = CTkEntry(frame, font=('sans serif', 18), text_color=(c_morado),  placeholder_text='correo electrónico', border_color = c_verde, fg_color=c_negro, width=220, height=40)

correo.grid(columnspan=2, row=1, column = 0, padx = 4, pady = 4)

passwd = CTkEntry(frame, font=('sans serif', 18), text_color=(c_morado),  placeholder_text='contraseña', border_color = c_verde, fg_color=c_negro, width=220, height=40)

passwd.grid(columnspan=2, row=2, column = 0, padx = 4, pady = 4)

checkbox = CTkCheckBox(frame, text='Recordarme', font=('sans serif', 16), text_color=('white'), hover_color=c_morado, border_color=c_verde, fg_color=c_verde)

checkbox.grid(columnspan = 2, row = 3, padx=4, pady = 4)

bt_iniciar = CTkButton(frame, text="Aceptar", height=40, width=220, font=('sans serif', 16), border_color=c_verde, fg_color=c_negro, hover_color=c_verde, corner_radius=12, border_width=1)
bt_iniciar.grid(columnspan= 2, row=4, pady = 4, padx=4)

ventana.call('wm', 'iconphoto', ventana._w, logo2)
ventana.mainloop()