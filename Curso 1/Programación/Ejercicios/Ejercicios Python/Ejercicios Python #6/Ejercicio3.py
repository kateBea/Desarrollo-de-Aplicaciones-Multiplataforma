# Ejercicio 3
# Algoritmo: Calcular si un número entero es primo o no
# Fecha: 13.12.2022
# Auor: Hugo Pelayo

from math import sqrt

def es_divisible(rhs, lhs):
    # Retorna cierto si rhs es divisible por lhs
    if lhs == 0:
        print('Error division por cero')
        return False

    return rhs % lhs == 0

def es_primo(num):
    if num == 0 or num == 1 or num == -1:
        return True

    for divisor in range(2, int(sqrt(num)) + 1):
        if es_divisible(num, divisor):
            return False

    return True


numero = int(input('Introduce un número entero: '))
if es_primo(numero):
    print(f'{numero} es primo.')
else:
    print(f'{numero} no es primo.')