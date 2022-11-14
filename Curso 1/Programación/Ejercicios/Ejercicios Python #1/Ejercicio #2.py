# Ejercicio 2
# Algoritmo: Muestra la tabla de multiplicar de los números pares hasta el N
# Fecha: 14/11/2022
# Autor: Hugo Pelayo

numero = int(input("Introduce el límite por favor: "))
paridad = 3

for tabla_actual in range(paridad, numero + 1, paridad):
    print(f"Tabla de multiplicar del {tabla_actual}:")
    for multiplicador in range(1, 10 + 1):
        print("{0} * {1} = {2}".format(multiplicador,\
            tabla_actual, multiplicador * tabla_actual))
    
    print()