import flet 

def main(page: flet.page):

    def mostrarDatos(e):
        if not entrada_hostname.value:
            entrada_hostname.error_text = "Este campo es obligatorio"
            page.update()
        if not entrada_nombre.value:
            entrada_nombre.error_text = "Este campo es obligatorio."
            page.update()
        if not entrada_password.value:
            entrada_password.error_text = "Este campo es obligatorio."
            page.update()
        else:
            nombre = entrada_nombre.value
            hostname = entrada_hostname.value
            password = entrada_password.value
            page.clean()
            page.add(
                flet.Text(f"Nombre: {nombre}\nHostname: {hostname}\nPassword: {password}")
            )
            pass

    '''def tecla(e: flet.KeyboardEvent):
        page.add(
            flet.Text(f"Tecla pressionada: {e.key}, Shift: {e.shift}, Control: {e.ctrl}")
        )'''

            

    hola = flet.Text(value="Ventana Autenticación - DAM 2 - Villablanca", size=30, text_align="center")
    entrada_nombre = flet.TextField(label="Username")
    entrada_hostname = flet.TextField(label="HostName")
    entrada_password = flet.TextField(label="Password")
    page.controls.append(hola)
    page.add(
        entrada_nombre,
        entrada_hostname,
        entrada_password,
        flet.ElevatedButton("Aceptar", on_click=mostrarDatos)
        )
    
    '''page.on_keyboard_event = tecla'''

    lista = flet.ListView(spacing=2, expand=True)

    for i in range(2 ):
        #lista.controls.append(flet.Text(f'Estamos en la línea {i}'))
        lista.controls.append(flet.TextField(label=f"Hijo {i}"))

    page.add(lista)

    page.update()




flet.app(target=main)