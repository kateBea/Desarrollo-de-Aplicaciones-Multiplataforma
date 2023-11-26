from tkinter import *
 
def hija():
 
    ## Crea la ventana hija.
    t1 = Toplevel(root,bg="blue")
 
    ## Establece el tamaño para la ventana.
    t1.geometry('400x200+20+20')
 
    ## Provoca que la ventana tome el focus
    t1.focus_set()
 
    ## Deshabilita todas las otras ventanas hasta que
    ## esta ventana sea destruida.
    t1.grab_set()
 
    ## Indica que la ventana es de tipo transient, lo que significa
    ## que la ventana aparece al frente del padre.
    t1.transient(master=root)
 
    ## Crea un widget Label en la ventana
    Label(t1, text='Ventana hija',bg="blue").pack(padx=10, pady=10)
 
    ## Crea un widget que permite cerrar la ventana,
    ## para ello indica que el comando a ejecutar es el
    ## metodo destroy de la misma ventana.
    Button(t1,text="Cerrar",bg="green", command=t1.destroy).pack()
 
    ## Crea un entry.
    e=Entry(t1,bg="lightyellow")
 
    ## Establece el focus en el entry.
    e.focus()
    e.pack()
 
    ## Pausa el mainloop de la ventana de donde se hizo la invocación.
    t1.wait_window(t1)
 
## Crea la ventana para la aplicación
root = Tk()
 
## Establece un título y un tamaño para la ventana
root.title('Ventana principal')
root.geometry('800x400+10+10')
 
## Crea una etiqueta.
Label(root, text='Esta es la ventana principal').pack(pady=10)
 
## Crea un botón, desde el cual se puede lanzar una
## ventana de tipo modal.
Button(root,text="ventana", command=hija).pack()
 
root.mainloop()