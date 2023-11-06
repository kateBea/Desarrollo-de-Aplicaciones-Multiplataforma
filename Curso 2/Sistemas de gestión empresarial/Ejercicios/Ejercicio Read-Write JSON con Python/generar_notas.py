"""
Genera notas aleatorias de cada módulo para un listado de alumnos
"""

import json, os, random

LISTA_ASIGNATURAS = ['Desarrollo de interfaces', 
                      'Accesso a Datos', 
                      'Programación de Servicios y procesos',
                      'Inglés técnico',
                      'Programación de dispositivos móviles']

usuarios = [ 'Kate Beatriz', 'Sandra', 'Carlos', 'Antonio', 'Roberto' ]

def generar_numero_aleatorio(inf, sup):
    return random.random() * sup + inf
    
def make_entries(alumno: str):
    lista_modulos = []
    for asignatura in LISTA_ASIGNATURAS:
        lista_modulos.append({ "nombreModulo": asignatura, 
                            "nota1": generar_numero_aleatorio(1.3, 9.22), 
                            "nota2": generar_numero_aleatorio(3.2, 8.44)})
    
    return lista_modulos
        

def generateNotas():
    notas = []
    for alumno in usuarios:
        notas.append({ "nombre": alumno, "modulos": make_entries(alumno) })
        
    return notas

datos = { "notas": generateNotas() }

ruta_salida = os.path.dirname(__file__)

with open(ruta_salida + '/notas.json', 'w') as fichero_salida:
    json.dump(datos, fichero_salida, indent=4)