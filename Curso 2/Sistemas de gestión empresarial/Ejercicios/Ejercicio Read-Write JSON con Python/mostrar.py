import json, os

# Directorio de este fichero python
ruta = os.path.dirname(__file__)

with open(ruta + '/datos.json') as misDatos:
    misDatos_Texto = json.load(misDatos)
    
for usuario in misDatos_Texto["usuarios"]:
    print(usuario)