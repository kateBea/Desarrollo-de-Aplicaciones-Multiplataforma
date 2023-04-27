# Ejercicio 2
# Algoritmo: Elevedar una base a un exponente
# Fecha: 13.12.2022
# Auor: Hugo Pelayo

def es_par(num):
    return num % 2 == 0

def exponenciacion(base, exponente):
    if exponente == 0:
        return 1
    
    acumulador = exponenciacion(base, exponente // 2)
    return acumulador * acumulador if es_par(exponente) else acumulador * acumulador * base

base = float(input('Introduce el valor de la base: '))
exponente = int(input('Introduce el valor del exponente: '))
print(f'{base} elevado a {exponente} es: {exponenciacion(base, exponente)}')