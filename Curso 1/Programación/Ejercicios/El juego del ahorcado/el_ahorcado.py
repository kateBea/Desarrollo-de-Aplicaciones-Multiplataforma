import random

# NOTA: pequeño bug, si una letra ya se ha adivinado y se
# vuelve a introducir so considera como fallo. Lo ideal sería indicarle
# usuario que ya está adivinada la letra

PALABRAS = ['almendra', 'cataclismo', 'hibernar', 'aniquilar', 'lectura', 'problema']
LIMITE_FALLOS = 3

def generar_numero_aleatorio():
    """
    Retorna un número aleatorio
    :return: un número aleatorio en el rango [0, len(palabras) - 1]
    """
    limite_inferior = 0
    limite_superior = len(PALABRAS) - 1
    return random.randint(limite_inferior, limite_superior)

def leer_letra():
    """
    Lee una letra y comprueba que se entre sólo una letra
    :return: letra leída
    """
    while True:
        letra = input('Por favor introduce sólo una letra: ')

        # comprobamos si el usuario ha introducido solo una letra
        if len(letra) == 1:
            break

    return letra

def check(letra, palabra):
    """
    Retorna el índice más pequeño donde se encuentra letra en palabra,
    retorna -1 en caso contrario
    :param letra:
    :param palabra:
    :return: índice donde letra se encuentra en palabra, -1 si letra no se encuentra en palabra
    """
    return palabra.find(letra)

def main():
    """
    Módulo principal del programa
    """

    # NOTA: Para sencillez se utiliza listas para la palabra seleccionada
    # y la palabra que indica nuestro progreso porque los objetos string
    # son inmutables y para cambiar sus letras se requiere de reconstrucción

    # booleanos que indican si hemos ganado o perdido
    perdido = False
    ganado = False
    # string a mostrar si perdido == True o ganado == True
    str_out = ''
    # seleccionar una palabra aleatoria que se tendrá que adivinar
    palabra_seleccionada = list(PALABRAS[generar_numero_aleatorio()])

    # tantas casillas incógnitas como caracteres tiene la palabra escogida
    palabra_progreso = list('_' * len(palabra_seleccionada))
    numero_fallos = 0
    letras_adivinadas = 0

    while True:
        # mostrar progreso actual
        print('\nProgreso actual: ' + ''.join(palabra_progreso))

        letra = leer_letra()

        # comprobamos si la letra se encuentra en la palabra a adivinar
        indice = check(letra, ''.join(palabra_seleccionada))
        if indice != -1:
            print('Has acertado una letra :)')
            # hemos adivinado una letra
            palabra_progreso[indice] = palabra_seleccionada[indice]
            # como el carácter se ha adivinado lo marco como tal
            palabra_seleccionada[indice] = '_'

            letras_adivinadas += 1
            if letras_adivinadas == len(palabra_seleccionada):
                ganado = True
                str_out = 'Has ganado!'
        else:
            numero_fallos += 1
            print(f'Has fallado un intento. Te quedan {LIMITE_FALLOS - numero_fallos} intentos')

            if numero_fallos == LIMITE_FALLOS:
                perdido = True
                str_out = 'Has perdido!'

        # comprobamos si hemos ganado o hemos perdido
        if perdido or ganado:
            print(str_out)
            print('----------------------------------')
            break

if  __name__ == '__main__':
    main()