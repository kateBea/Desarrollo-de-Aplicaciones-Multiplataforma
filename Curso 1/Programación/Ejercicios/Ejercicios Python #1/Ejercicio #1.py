# Ejercicio 1
# Algoritmo: Muestra la tabla de multiplicar de un número
# Fecha: 14/11/2022
# Autor: Hugo Pelayo

numero = int(input("Introduce un número entero por favor: "))
print("Tabla de multiplicar del {0}".format(numero))
for multiplicador in range(0, 11):
    print(f"{multiplicador} * {numero} = {multiplicador * numero}")