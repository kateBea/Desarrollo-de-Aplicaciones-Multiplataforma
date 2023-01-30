class Punto:
    # constructora por defecto. Construye un objeto Punto
    def __init__(self, x, y):
        self.x = x
        self.y = y

    # Definición operador ( *= ). Ejemplo: x *= y
    def __imul__(self, other):
        self.x *= other.x
        self.y *= other.y
        return self

    # Definición operador ( += ). Ejemplo: x += y
    def __iadd__(self, other):
        self.x += other.x
        self.y += other.y
        return self

    # Definición operador ( + ). Ejemplo: x + y
    def __add__(self, other):
        return Punto(self.x + other.x, self.y + other.y)

    # Definición operador ( - ). Ejemplo: x - y
    def __sub__(self, other):
        return Punto(self.x - other.x, self.y - other.y)

    # Definición de la descripción de la clase
    # Permite imprimir con formato nuestra clase usando el método print. Ej: print(p1)
    # Permite también crear un string (objeto str) a partir de nuestra clase. Ej: str(p1)
    def __str__(self):
        return f'[{self.x}, {self.y}]'

def main():
    p1 = Punto(3, 0)
    p2 = Punto(10, 10)
    p3 = Punto(-3, 7)

    print(p1)
    print(p2)
    print(p3)

    print('\nPruebas operadores de asignación:')
    p1 *= p2
    p2 += p3

    print(p1)
    print(p2)
    
    print('\nPruebas operadores no asignación')
    print(p1 + p2)
    print(p2 - p3)

    print(p1)
    print(p2)
    print(p3)

if __name__ == '__main__':
    main()