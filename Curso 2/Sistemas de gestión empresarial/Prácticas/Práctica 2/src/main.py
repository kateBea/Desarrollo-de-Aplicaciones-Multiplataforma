##########################################
# Examen de SGE                          #
#                                        #
# Hugo Pelayo                            #
# 27 nov 2023                            #
##########################################

from interfaz import *
from db_manager import *

def run():
    # conexión a la base de datos
    db_obj = DBManager("root", "123456")
    
    # creamos la base de datos
    if db_obj.create_db("examenDAM"):
        print("Base de datos funcionando correctamente")
    else:
        print("Error al incializar la base de datos")
    
    # creamos la tabla
    if db_obj.execute(
        """
            CREATE TABLE IF NOT EXISTS migrarDatos(
                Nombre          VARCHAR(255),
                Email           VARCHAR(255),
                Password        VARCHAR(255),
                Nombre_Modulo   VARCHAR(255),
                Nota1           FLOAT,
                Nota2           FLOAT
            )
        """
    ):
        print("Tabla migrarDatos creada correctamente")
    else:
        print("Error crear la tabla migrarDatos")
    
    # inicializamos GUI
    app = Application(db_obj)
    app.run()

if __name__ == "__main__":
    run()