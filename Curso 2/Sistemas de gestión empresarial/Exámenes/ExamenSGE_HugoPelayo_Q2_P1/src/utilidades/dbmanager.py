import sys
import mysql.connector

class DBManager:
    def __init__(self, user, password):
        self.user = user
        self.password = password
        self.connection = None
        self.cursor = None
        
        try:
            self.connection = mysql.connector.connect(
                host="localhost",
                user=self.user,
                password=self.password)
            
            self.cursor = self.connection.cursor()
            
            print("conexión establecida con éxito")
        except:
            print("Erro al conectar a la base de datos", file=sys.stderr)
          
    def create_db(self, db_name):
        return self.execute(f"CREATE DATABASE IF NOT EXISTS {db_name}") and self.execute(f"USE {db_name}")
        
    def execute(self, query):
        try:
            self.cursor.execute(query)
            self.connection.commit()
            return True
        except Exception as excep:
            print(f"Error al ejecutyar query. Causa: '{excep}'")
            return False
    
    