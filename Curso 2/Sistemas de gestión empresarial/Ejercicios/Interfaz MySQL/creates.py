import mysql.connector

mydb = mysql.connector.connect(
    host = 'localhost',
    user = 'root',
    password = '123456',
    
)

cursor = mydb.cursor()

cursor.execute('CREATE DATABASE IF NO EXISTS Alumnos')
cursor.execute('USE Alumnos')
cursor.execute('CREATE TABLE IF NOT EXISTS MediaAlumnos(nombre VARCHAR(256) PRIMARY KEY, mediaNotas REAL)')
cursor.execute('SHOW DATABASES')

for database in cursor:
    print(database)