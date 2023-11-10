import json, os, mysql.connector

mydb = mysql.connector.connect(
    host = 'localhost',
    user = 'root',
    password = '123456',
    
)

cursor = mydb.cursor()

# Create db
cursor.execute('CREATE DATABASE IF NOT EXISTS Alumnos')
cursor.execute('USE Alumnos')

# Create table
cursor.execute('CREATE TABLE IF NOT EXISTS MediaAlumnos(nombre VARCHAR(256), Materia VARCHAR(256), mediaNotas REAL)')

ruta = os.path.dirname(__file__)

with open(ruta + '/notas.json') as misDatos:
    misDatos_Texto = json.load(misDatos)
    
    for alumno in misDatos_Texto["notas"]:
        
        # recorrer módulos
        for modulo in alumno["modulos"]:
            nombre_alumno = alumno['nombre']
            nombre_modulo = modulo["nombreModulo"]
            nota1 = float(modulo["nota1"])
            nota2 = float(modulo["nota2"])
            
            print(f"media de {alumno['nombre']} en {nombre_modulo} es { (nota1 + nota2) / 2}")
            print("------------------------------------------------\n")
            
            cursor.execute(f'INSERT INTO MediaAlumnos VALUES ("{nombre_alumno}", "{nombre_modulo}", {(nota1 + nota2) / 2 })')
            
            
mydb.commit()