# Fecha: 12/09/19

# CLASE VARIABLES Y TIPOS DE DATOS

# Una variable es un espacio en memoria donde se alamacena información y a la cual se le asigna un identificador para poder manipular esa información

# Las variables en Python pueden ser de tres Tipos de Datos Básicos: 
#     - Números. Cualquier valor numérico, entero, decimal o complejo
#     - Cadenas. Conjunto de 1 o más caracteres, los cuales se encuentran limitados por comillas dobles " o simples '
#     - Booleanos. Solo puede tener el valor True o False

# En Python, para declarar una variable no es necesario definir el Tipo de Dato previamente. Simplemente, con asignarle el valor el compilador es capaz de reconocerlo

# nombre_identificador = valor


#Asignación de un valor a una variable
numero = 10
print (numero)

#Asignar múltiples valores a múltiples variables
num1, num2, mensaje= 5,89, "hola"
print(num1)
print(num2)
print(mensaje)

salida = continuar = True
print(salida)
print(continuar)

#Para comprobar el tipo de dato que tiene una variable se puede emplear la función type
print("Type")
print(type(salida))
print(type(mensaje))
print(type(num1))

# Todos los lenguajes de programación tienen sus propias palabras, las cuales no podemos utilizar como nombres variables, funciones o clases
# Las palabras reservadas son:
# False               class               from                or
# None                continue            global              pass
# True                def                 if                  raise
# and                 del                 import              return
# as                  elif                in                  try
# assert              else                is                  while
# async               except              lambda              with
# await               finally             nonlocal            yield
# break               for                 not


# Para conocer el listado de las palabras reservadas podemos utilizar el comando help 
help("keywords")


# -------Ejemplo del uso del numero enteros------------

# Entero int
entero = 7
print(entero, type(entero))

# Coma flotante o reales simple
float_1, float_2, float_3 = 0.348, 10.5, 1.5e2
print (float_1, type(float_1))
print (float_2, type(float_2))
print (float_3, type(float_3))

# Este número tiene un exponente en base 10
# es decir, multiplicado por 10 a la N
real = 0.56e-3
print (real, type(real))

# Este número es de tipo Complex
complejo = 3.14j
print (complejo, complejo.imag, complejo.real, type(complejo))

# Para convertir a tipos numéricos debe usar las siguientes funciones integradas en el interprete Python:

#     La función int() devuelve un tipo de datos número entero.
#     La función float() devuelve un tipo de datos número entero float.
#     La función complex() devuelve un tipo de datos número complejo.
print(int(float_2))
print(float(entero))
print(complex(entero))