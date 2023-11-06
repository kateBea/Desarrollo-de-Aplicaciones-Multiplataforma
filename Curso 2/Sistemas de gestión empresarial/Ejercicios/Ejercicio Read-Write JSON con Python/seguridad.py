import json, os

def verificar(email, password):
    resultado = { "valido": False, "datos": None }

    ruta_salida = os.path.dirname(__file__)
    with open(ruta_salida + '/datos.json', 'r') as fichero:
        datos = json.load(fichero)

        print(f'Recibido email [{email}] y pass [{password}]')

        for elemento in datos["usuarios"]:
            if elemento["email"] == email and elemento["password"] == password:
                resultado["datos"] = elemento
                resultado["valido"] = True
                break

                
    return resultado