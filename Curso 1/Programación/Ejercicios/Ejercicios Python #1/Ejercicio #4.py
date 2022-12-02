# Ejercicio 4
# Algoritmo: Pedir una secuencia de números y mostrar la suma por pantalla
# Fecha: 2/12/2022
# Autor: Hugo Pelayo

lista_numero = input("Introduce secuencia de números y presiona [Enter]: ")
suma_numeros = 0
for numero in lista_numero.split(' '):
    suma_numeros = suma_numeros + int(numero)

print(f"Total suma: {suma_numeros}")