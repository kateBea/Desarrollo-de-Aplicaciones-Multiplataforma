import json, os


datosPath = os.path.dirname(__file__)

with open(datosPath + '/notas.json') as misDatos:
    misDatos_texto = json.load(misDatos)

for i in misDatos_texto['notas']:
    print("-------------------------------------------")
    print(i['nombre'])
    print("-------------------------------------------")
    for j in i['modulos']:
        print ("nota media del módulo " + j['nombreModulo'] + ", es: " + str((j['nota1'] + j['nota2'])/2))
