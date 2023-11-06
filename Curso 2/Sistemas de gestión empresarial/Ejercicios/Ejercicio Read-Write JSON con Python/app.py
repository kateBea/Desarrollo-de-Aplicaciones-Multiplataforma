"""
Consulta las notas de un usuario
"""

import json, os
from seguridad import verificar

def run():
    email = input('Introduce tu email: ')
    password = input('Introduce to contraseña: ')

    result = verificar(email, password)

    if result['valido']:
        print("El usuario existe")

        # Mostrar las notas del usuario
        # Directorio de este fichero python
        ruta = os.path.dirname(__file__)

        with open(ruta + '/notas.json') as misDatos:
            misDatos_Texto = json.load(misDatos)

            notas = None

            for elemento in misDatos_Texto["notas"]:
                if elemento["nombre"] == result["dato"]["usuario"]:
                    notas = elemento["modulos"]
                    break

            for modulo in notas:
                print(modulo)

if __name__ == '__main__':
    run()