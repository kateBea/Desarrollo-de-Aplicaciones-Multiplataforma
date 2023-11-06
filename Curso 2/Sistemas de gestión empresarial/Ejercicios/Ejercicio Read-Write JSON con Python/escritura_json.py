"""
Genera datos de formato Python a formato JSON
3 nov 2023
"""

import json

datos = { 
    'dato1': 1, 
    'dato2': 'Alumno', 
    'dato3': 5 
}

datos_json = json.dumps(datos)

print(datos_json)