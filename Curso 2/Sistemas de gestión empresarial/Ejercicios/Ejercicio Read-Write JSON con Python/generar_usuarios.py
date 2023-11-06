import json, os

usuarios = [
    { 'usuario': 'Kate Beatriz', 'email': 'kateBeatriz@gmail.com', 'password': '1234' },
    { 'usuario': 'Sandra', 'email': 'sandra44@gmail.com', 'password': '2642' },
    { 'usuario': 'Carlos', 'email': 'carlos66@gmail.com', 'password': '3761' },
    { 'usuario': 'Antonio', 'email': 'antonio44@gmail.com', 'password': '2453' },
    { 'usuario': 'Roberto', 'email': 'roberto36@gmail.com', 'password': '2212' },
]

datos = { "usuarios": usuarios }

ruta_salida = os.path.dirname(__file__)

with open(ruta_salida + '/datos.json', 'w') as fichero_salida:
    json.dump(datos, fichero_salida, indent=4)