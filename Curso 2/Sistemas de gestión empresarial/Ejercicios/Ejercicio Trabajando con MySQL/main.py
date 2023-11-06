"""
Se conecta al servidor local y muestra la lista de bases de datos.

IMPORTANTE:

Tener configurado MySQL en PC localhost con los controladores adecuados. Visitar Docs de 
MySQL para ver el proceso, luego instalar mediante pip el conector adecuado y el modulo mysql:

    pip install mysql
    pip install mysql-connector-python 
    
Para más detalles:
https://stackoverflow.com/questions/50557234/authentication-plugin-caching-sha2-password-is-not-supported
"""

import mysql.connector

mydb = mysql.connector.connect(
    host = 'localhost',
    user = 'user',
    password = 'password',
    database = 'database',
)

cursor = mydb.cursor()

cursor.execute('SHOW DATABASES')

for database in cursor:
    print(database)