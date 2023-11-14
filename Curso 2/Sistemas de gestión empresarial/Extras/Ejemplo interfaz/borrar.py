import json, os

ruta = os.path.dirname(__file__)

with open(ruta + '/datos.json', 'w') as misDatos:
        json.dump(misDatos)


for i in misDatos_texto['usuario']:
        print('usuario: ' + i['username'] + ' email: ' + i['email'])