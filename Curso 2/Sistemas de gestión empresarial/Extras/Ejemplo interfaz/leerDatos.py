import json, os

datosPath = os.path.dirname(__file__)

print(datosPath + '/datos.json')

with open(datosPath + '/datos.json') as misDatos:
    misDatos_texto = json.load(misDatos)

for i in misDatos_texto['usuario']:
    print('username: ' + i['username'] + ' email: ' + i['email'] + ' password: ' + i['password'] )