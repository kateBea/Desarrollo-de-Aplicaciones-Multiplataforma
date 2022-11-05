# Operadores de asignaciones 

a, b, c = 21, 10, 0

print ("Valor de variable 'a': %i"  %a)
print ("Valor de variable 'b': %i"  %b)

c = a + b
print ("Operador = | El valor de variable 'c' es %i" %c)

c += a # equivale a c = c + a = 31 + 21 = 52
print ("Operador += | El valor de variable 'c' es %i" %c)

c *= a #equivale a c = c * a = 52 * 21 = 1092
print ("Operador *= | El valor de variable 'c' es %i " %c)

c /= a  #equivale a c = c / a = 1092 / 21 = 52
print ("Operador /= | El valor de variable 'c' es %i" %c)

c= 5
a= 3
c **= a #calcula el exponente  de 5 elevado a 2
print ("Valor de variable 'a': %i"  %a)
print ("Valor de variable 'b': %i"  %b)
print ("Operador **= | El valor de variable 'c' es %i" %c)

c //= a #calcula la division entera de c entre a
print ("Operador //= | El valor de variable 'c' es %i" %c)
