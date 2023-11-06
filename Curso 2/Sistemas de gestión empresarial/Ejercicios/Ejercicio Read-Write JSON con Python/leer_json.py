"""
Parseo de datos JSON
"""

import json

datos = { 
    'dato1': 1, 
    'dato2': 'Alumno', 
    'dato3': 5 
}

# Generar string JSON
datos_json = json.dumps(datos)

# Mostrar datos JSON
print(datos_json)

# Cargar datos JSON a datos Python
datos_python = json.loads(datos_json)

# Mostrar datos Python
print(datos_python)

for key in iter(datos_python):
    print(datos_python[key])