# Ejercicio 1
# Algoritmo: Duplicar valores con lambda
# Fecha: 27.12.2022
# Autor: Hugo Pelayo

mi_lista = [-3, 4, 5, 1, 9]

nueva_lista = list(map(lambda numero: numero * 2, mi_lista))
indice = 0

for elemento in nueva_lista:
    print(f'Elemento en indice [{indice}]: {elemento}')
    indice += 1
