class Persona:
    def __init__(self, nombre: str, dni: str, edad: int, sexo: str):
        self.nombre = nombre
        self.dni = dni
        self.edad = edad
        self.sexo = sexo
        
    def __str__(self):
        return f'Nombre: {self.nombre}\nDNI: {self.dni}\nEdad:' + \
            f'{self.edad}\nSexo: {self.sexo}'

    def mayor_de_edad(self):
        return self.edad >= 18



def main():
    p1 = Persona('Javier', '363825641W', 15, 'M')
    p2 = Persona('Clara', '736453983F', 22, 'F')
    print(p1)

    print(f'{p1.nombre} es ' + ('mayor' if p1.mayor_de_edad() else 'menor') + ' de edad.')
    print(f'{p2.nombre} es ' + ('mayor' if p2.mayor_de_edad() else 'menor') + ' de edad.')

if __name__ == '__main__':
    main()