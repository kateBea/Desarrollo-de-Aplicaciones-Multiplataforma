# Ejercicio 1
# Algoritmo: Factorial de un número entero
# Fecha: 12.12.2022
# Auor: Hugo Pelayo

def factorial(num):
    return 1 if num <= 0 else num * factorial(num - 1)

numero = int(input('Introduce un número entero: '))
print(f'El factorial de {numero} es: {factorial(numero)}')