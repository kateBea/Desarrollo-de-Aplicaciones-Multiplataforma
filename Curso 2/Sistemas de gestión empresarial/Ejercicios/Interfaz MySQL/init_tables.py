def init(cursor):
    cursor.execute('CREATE DATABASE IF NO EXISTS Alumnos')
    
    cursor.execute('USE Alumnos')
    
    cursor.execute('CREATE TABLE IF NOT EXISTS MediaAlumnos(nombre VARCHAR(256) PRIMARY KEY, mediaNotas REAL)')
    cursor.execute('SHOW DATABASES')
    
    for database in cursor:
        print(database)

def shutdown(cursor):
    cursor.execute('DROP DATABASE IF EXISTS Alumnos')
