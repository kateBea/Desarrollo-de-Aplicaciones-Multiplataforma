# Fecha 12/09/19

# La extensión de los ficheros Python .py (pero no necesariamente)
# Comentar los programas con símbolo almohadilla #  para una línea 
# OJO las docstrings (" " "") no es forma de comentar. Se utilizan únicamente para documentar el código al inicio de la pieza. Se muestran en la documentación al usar help
# Las instrucciones de programación NO terminan en ; a no ser que pongamos dos instrucciones en la misma línea
# Mostrar un mensaje por pantalla usar print("Mensaje literal a mostrar")
# Solicitar información al usuario puedes utilizar la función input("Mensaje") para ello deberás guardarlo en una variable
# Mostrar mensaje por pantalla con la funcion print


print("*************** Sintaxis básica *******************************************************")
print("Sintaxis básica instrucción 1")
print("Sintaxis básica instrucción 2")
print("Dos instrucciones juntas (1)"); print("instruccion(2)")

print("Cuando el texto a mostrar es demasiado largo podemos dividirlo \
    para que en el editor se visualice mejor")
print("**************************************************************************************")

nombre = input ("Por favor, escribe tu nombre: ") #Estamos utilizando una función propia predefinida en Python para pedir un dato 
print("El nombre que has escrito es ")
print(nombre) #nombre es una variable que contiene el valor que el usuario escribió. Más adelante se explicarán las variables.

print("Bienvenido a Python " + nombre) #Estamos utilizando el operador + que con las cadenas lo que hace es concatenar

print(nombre + " bienvenida " + nombre + " a este curso")
print("Hola %s como estas" %nombre)
print ("Hola ", nombre)


numero = 19 #ejemplo variable int
#print ("El nunmero es"+ numero)
print("El numero es " + str(numero)) # ojo es necesario llamar a str que convierte vble numero a cadena
print("El numero %i es el guardado" %numero) #ojo no hay coma después del mensaje
print ("El numero es ", numero, "bjkjdks dkjdksd j ") #ojo va coma despues del mensaje

altura=1.38 # ejemplo variable float
print("Tiene %f  tura" %altura)
print("%s tiene %.1f altura" %(nombre, altura)) # %.1f indicamos un decimal

nombre="Juan" #ejemplo variable string

#otra forma de mostrar un mensaje:
print("Mi nombre es {} tengo {} años y mido {}".format(nombre,numero, altura))

