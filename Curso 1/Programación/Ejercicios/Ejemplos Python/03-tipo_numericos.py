# Ejemplo del uso del numero enteros

# Entero int
print("---Ejemplo de numeros enteros---")
entero = 7
print(entero, type(entero))

print("\n----Ejemplo de numeros decimales---")
# Coma flotante o reales simple
float_1, float_2, float_3 = 0.348, 10.5, 1.5e2 #1.5*10 elevado2
print (float_1, type(float_1))
print (float_2, type(float_2))
print (float_3, type(float_3))

# Este número tiene un exponente en base 10
# es decir, multiplicado por 10 a la N
real = 0.1e-3 # 0.56*10 elevado -3
print (real, type(real))

print("\n---Ejemplo de números complejos--")
# Este número es de tipo Complex
complejo = 2+ 3.14j
print (complejo, complejo.imag, complejo.real, type(complejo))

# Para convertir a tipos numéricos debe usar las siguientes funciones integradas en el interprete Python:

#     La función int() devuelve un tipo de datos número entero.
#     La función float() devuelve un tipo de datos número entero float.
#     La función complex() devuelve un tipo de datos número complejo.
print(int(float_2))
print(float(entero))
print(complex(entero))