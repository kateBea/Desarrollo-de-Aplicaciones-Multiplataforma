# Fecha: 02/11/2022

# Este programa lee dos números muestra operaciones
# por pantalla con ambos

numero1 = int(input("Entra el primer número: "))
numero2 = int(input("Entra el segundo número: "))

print(f"Suma             -> {numero1} + {numero2} = {numero1 + numero2}")
print(f"Resta            -> {numero1} - {numero2} = {numero1 - numero2}")
print(f"Multiplicación   -> {numero1} · {numero2} = {numero1 * numero2}")
print(f"División decimal -> {numero1} / {numero2} = {numero1 / numero2}")
print(f"División entera  -> {numero1} / {numero2} = {numero1 // numero2}")
print(f"Resto            -> {numero1} mod {numero2} = {numero1 % numero2}")
print(f"Exponenciación   -> {numero1}^({numero2}) = {numero1 ** numero2}")