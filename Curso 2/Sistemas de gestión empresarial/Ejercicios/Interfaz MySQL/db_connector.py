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

class DBConnection:
    def __init__(self, host, user, password):
        self.address = host,
        self.username = user,
        self.password = password,
        
        self.db = mysql.connector.connect(
            host = host,
            user = user,
            password = password,
        )
    
if __name__ == "__main__":
    pass