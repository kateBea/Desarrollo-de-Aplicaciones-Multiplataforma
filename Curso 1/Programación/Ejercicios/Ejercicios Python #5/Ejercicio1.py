# Ejercicio 1
# Algoritmo: Dibujar un rombo
# Fecha: 12.12.2022
# Auor: Hugo Pelayo

def imprimir_rombo(num: int, character: str):
    """
    Función que imprime por pantalla un rombo utilizando 
    el caracter que el carácter indicado
    :param num:
    :return: None
    """
    numero_espacios = num - 1
    numero_caracteres = 1

    for iterador in range(0, num * 2 - 1):
        for _ in range(0, numero_espacios):
            print(' ', end = '')
        for _ in range(0, numero_caracteres):
            print(f'{character} ', end = '')

        print()
        numero_espacios = numero_espacios + 1 if iterador >= (num * 2 - 1) // 2 else numero_espacios - 1
        numero_caracteres = numero_caracteres - 1 if iterador >= (num * 2 - 1) // 2 else numero_caracteres + 1

if __name__ == '__main__':
    tamanio = int(input('Introduce el tamaño del rombo por favor: '))
    caracter = input('Introduce un caracter para el rombo por favor: ')
    imprimir_rombo(tamanio, caracter)