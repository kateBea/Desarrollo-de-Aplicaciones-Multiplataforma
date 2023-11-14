import json

datos = {} #diccionario.
datos['usuario'] = [] #lista.

datos['usuario'].append({
    "username": "Juan Pablo",
    "email": "juanpablo@odoo.es",
    "password" : "juanpablo123"
})

datos['usuario'].append({
    "username": "Luis Miguel",
    "email": "luismigel@odoo.es",
    "password" : "luismiguel123"
})

datos['usuario'].append({
    "username": "Sofia",
    "email": "sofia@odoo.es",
    "password" : "sofial123"
})

datos['usuario'].append({
    "username": "Lucas",
    "email": "lucas@odoo.es",
    "password" : "lucasl123"
})

datos['usuario'].append({
    "username": "Aarón",
    "email": "aaronl@odoo.es",
    "password" : "aronl123"
})
print(datos)
with open('datos.json', 'w') as archivo:
    json.dump(datos, archivo, indent=4)
