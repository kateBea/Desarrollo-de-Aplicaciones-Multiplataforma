# Ejercicio 3
# Algoritmo: Pedir un número al usuario hasta que escriba un número par
# Fecha: 14/11/2022
# Autor: Hugo Pelayo
    
numero = 1

print('Escribe números enteros impares ', end = '')
print("cuando te canses escribe un número par.")
while numero % 2 == 1:
    numero = int(input("Introduce un número: "))
    
print("Terminando programa")