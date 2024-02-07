import sys
import mysql.connector

class DBManager:
    """
        Monitoriza una conexión a una base de datos MySQL local (se conecta al localhost),
        por ello no recibe la dirección del servidor.
    """   
    def __init__(self, user, password):
        self.user = user
        self.password = password
        self.connection = None
        self.cursor = None
        
        try:
            self.connection = mysql.connector.connect(
                host="localhost",
                user=self.user,
                password=self.password,
            )
            
            # creamos cursor para las queries si la conexión se hizo con éxito
            self.cursor = self.connection.cursor()
            
            print("conexión establecida con éxito")
        except:
            print("Erro al conectar a la base de datos", file=sys.stderr)
          
          
    def create_db(self, db_name):
        return self.execute(f"CREATE DATABASE IF NOT EXISTS {db_name}") and self.execute(f"USE {db_name}")
        
        
    def execute(self, query):
        try:
            self.cursor.execute(query)
            
            # salvamos los cambios en la bd
            # ya que el commit automático está desactivado por defecto
            self.connection.commit()
            return True
        except Exception as e:
            print(f"Error al ejecutar la query. Cause: '{e}'")
            return False
    
    