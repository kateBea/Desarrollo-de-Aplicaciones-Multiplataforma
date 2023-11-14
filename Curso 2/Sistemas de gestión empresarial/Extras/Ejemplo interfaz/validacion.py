##################################################
#  Ejemplo para Juan Pablo.                      #
#  Visualizar todo el registro par clave/valor   #
#  de nuestro fichero .json                      #
#                                                #
#  4 de noviembre de 2023                        #
##################################################


import json, os #librerías necesarias para poder trabajar con json y con las librerías del sistema. En este caso, utilizo el dirname.

ruta = os.path.dirname(__file__) #Cojo la ruta donde estoy ejecutando el .py


def comprobar(email, password) -> bool:

    with open(ruta + '/datos.json') as fichero: #Abro el fichero para leer
        misDatos = json.load(fichero)
    

    for i in misDatos["usuario"]:
        print(i)  # Me imprime todos los valores de ese registro de la colección de pares clave/valor
                  # Si no fuera esto lo que me preguntaste ayer, dímelo y te contesto.
    
    return False

    



