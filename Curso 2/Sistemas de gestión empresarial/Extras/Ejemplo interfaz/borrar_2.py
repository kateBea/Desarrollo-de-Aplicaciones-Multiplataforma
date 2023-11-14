import json

datos = {'dato1':1, 'dato2': 2, 'dato3': [7, 2, 5]}

datos2 = json.dumps(datos)
print(type(datos2))
print(datos2)

datos3 = json.loads(datos2)
print(datos3)

for i in datos3:
    print(datos3['dato3'][1])