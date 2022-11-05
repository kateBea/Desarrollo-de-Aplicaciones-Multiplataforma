# Ejemplo de uso de cadenas
#    Una cadena de caracteres, no es más que varios caracteres 
#    encerrado entre comillas simples ('cadena') o dobles ("cadena").


# Comillas simples
cadena1 = 'Texto entre comillas simples,'
print (cadena1, type(cadena1))

# Comillas dobles
cadena2 = "Texto entre comillas dobles,"
print (cadena2, type(cadena2))

# Cadena con código escapes \n es un salto de línea \t es un tabulador
cadena3 = 'Texto entre \n\tcomillas simples,'
print (cadena3, type(cadena3))

# Cadena varias lineas
cadena4 = """Texto linea 1
linea 2
linea 3
linea 4
.
.
.
.
.
linea N"""
print (cadena4 + ",", type(cadena4))

# Repetición de cadena con el operador de multiplicación
cadena5 = "Cadena" * 3
print (cadena5 + ",", type(cadena5))

# Concatenación de cadena
nombre, apellido = "Leonardo", "Caballero"
nombre_completo = nombre + " " + apellido
print (nombre_completo + ",", type(nombre_completo))

# Función len() devuelve el tamaño de la cadena
print ("El tamaño de la cadena es:", len(nombre_completo))

# Acceder a rango de cadena
print ("Acceso a rango de cadena: '", nombre_completo[3:13])

# Formato de impresión de cadena usando la función format()
print ("El nombre es '{nombre}', con un tamaño de: {tamano} ".format(
	nombre=nombre_completo, tamano=len(nombre_completo)))
