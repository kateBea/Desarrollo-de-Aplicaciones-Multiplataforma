#imports
import random

# constantes
NUMERO_FILAS = 9
NUMERO_COLUMNAS = 9
MINA = '*'
CASILLA_INCOGNITO = '.'
CASILLA_LIBRE = '_'
FACTOR_MINAS = 0.1 # factor 10%
TOTAL_MINAS = int(FACTOR_MINAS * (NUMERO_FILAS * NUMERO_COLUMNAS))


# Crear variables
tablero = list()
tablero_de_minas = list()
input_fila = 0
input_columna = 0
continuar = True
pierdes = False
ganas = False


# definición de funciones
def generar_posicio_aleatoria():
    pos = list()
    pos.append(random.randint(0, NUMERO_FILAS - 1))
    pos.append(random.randint(0, NUMERO_COLUMNAS - 1))

    return pos

def inicializar_tablero():
    """
    Función que inicializa el tablero de juego
    :return: None
    """
    global tablero
    global NUMERO_COLUMNAS
    global NUMERO_FILAS
    global CASILLA_INCOGNITO

    tablero.append([' '])
    for _ in range(1, NUMERO_FILAS + 1):
        tablero.append(list())

    for fila in range(0, NUMERO_FILAS + 1):
        for columna in range(0, NUMERO_COLUMNAS + 1):
            if fila == 0:
                if columna > 0:
                    tablero[fila].append(str(columna))
            else:
                tablero[fila].append(str(fila) if columna == 0 else CASILLA_INCOGNITO)



def imprimir_tablero():
    """
    Función imprime por pantalla el tablero de minas
    :return: None
    """
    global tablero

    for fila in tablero:
        for columna in fila:
            print(columna, end = ' ')

        print()

def leer_datos_usuario():
    global input_fila
    global input_columna
    global NUMERO_FILAS
    global NUMERO_COLUMNAS

    input_fila = int(input("Introduce un valor de fila: "))
    input_columna = int(input("Introduce un valor de columna: "))

    return (0 < input_fila < NUMERO_FILAS + 1) and (0 < input_columna < NUMERO_COLUMNAS + 1)

def encontrar_pistas():
    global tablero_de_minas
    global tablero
    global NUMERO_FILAS
    global NUMERO_COLUMNAS
    global input_fila
    global input_columna
    global MINA
    global CASILLA_LIBRE

    '''Desde una posición en concreto hay que encontrar todas las posiciones adyacentes sin minas
    y todas las adyacentes que contienes pistas, es decir, todas las celdas que a su alrededor 
    contienen al menos una mina. La posicion de partida viene dana por (input_fila - 1) para 
    coordenada de fila y (input_columna - 1) para coordenada de columna sobre el tablero_de_minas.'''

    # poner pistas en el tablero de minas
    posiciones_visitadas = list()
    posicion_inicio = [input_fila, input_columna]
    direcciones = [[0, 1], [1, 1], [1, 0], [1, -1], [0, -1], [-1, -1], [-1, 0], [-1, 1]]
    cola_de_visita = [posicion_inicio]

    for _ in range(0, NUMERO_FILAS):
        posiciones_visitadas.append([False] * NUMERO_COLUMNAS)

    # marcar la posición de partida como visitada
    posiciones_visitadas[posicion_inicio[0]][posicion_inicio[1]] = True
    if int(tablero_de_minas[posicion_inicio[0] - 1][posicion_inicio[1] - 1]) > 0:
        tablero[posicion_inicio[0] + 1][posicion_inicio[1] + 1] = tablero_de_minas[posicion_inicio[0]][
            posicion_inicio[1]]
    else:
        tablero[posicion_inicio[0] + 1][posicion_inicio[1] + 1] = CASILLA_LIBRE

    while len(cola_de_visita) != 0:
        siguiente_posicion = cola_de_visita.pop()

        # visitar posiciones adyacentes a 'siguiente posicion'
        for p in direcciones:
            adyacente = [siguiente_posicion[0] + p[0], siguiente_posicion[1] + p[1]]

            # validar posición (está dentro del tablero) y comprobar que no se ha visitado todavía
            if -1 < adyacente[0] < NUMERO_FILAS and -1 < adyacente[1] < NUMERO_COLUMNAS and not \
            posiciones_visitadas[adyacente[0]][adyacente[1]]:
                # marcar posición como visitada
                posiciones_visitadas[adyacente[0]][adyacente[1]] = True

                if tablero_de_minas[adyacente[0]][adyacente[1]] != MINA:
                    if int(tablero_de_minas[adyacente[0]][adyacente[1]]) > 0:
                        tablero[adyacente[0] + 1][adyacente[1] + 1] = tablero_de_minas[adyacente[0]][adyacente[1]]
                    else:
                        tablero[adyacente[0] + 1][adyacente[1] + 1] = CASILLA_LIBRE

                # apuntamos esta casilla para seguir buscando pistas en el caso de que no tenga minas a su alrededor
                if tablero_de_minas[adyacente[0]][adyacente[1]] != MINA and int(tablero_de_minas[adyacente[0]][adyacente[1]]) == 0:
                    cola_de_visita.append(adyacente)


def generar_minas():
    global tablero_de_minas
    global NUMERO_FILAS
    global NUMERO_COLUMNAS
    global CASILLA_INCOGNITO
    global MINA

    for _ in range(0, NUMERO_FILAS):
        tablero_de_minas.append([CASILLA_INCOGNITO] * NUMERO_COLUMNAS)

    # incrustar minas en el tablero de minas
    total = 0
    while (total < TOTAL_MINAS):
        posicion = generar_posicio_aleatoria()

        if tablero_de_minas[posicion[0]][posicion[1]] == MINA:
            # si la posición ya contiene una mina
            # generar una posición aleatoria nueva
            continue
        else:
            tablero_de_minas[posicion[0]][posicion[1]] = MINA

        total = total + 1

    # poner pistas en el tablero de minas
    posiciones_visitadas = list()
    posicion_inicio = [0, 0]
    direcciones = [[0, 1], [1, 1], [1, 0], [1, -1], [0, -1], [-1, -1], [-1, 0], [-1, 1]]
    cola_de_visita = [posicion_inicio]

    for _ in range(0, NUMERO_FILAS):
        posiciones_visitadas.append([False] * NUMERO_COLUMNAS)

    posiciones_visitadas[posicion_inicio[0]][posicion_inicio[1]] = True
    while len(cola_de_visita) != 0:
        siguiente_posicion = cola_de_visita.pop()
        minas_alrededor = 0 # cuenta las minas alrededor de una celda
        # visitar posiciones adyacentes a 'siguiente posicion'
        for p in direcciones:
            adyacente = [siguiente_posicion[0] + p[0], siguiente_posicion[1] + p[1]]

            # validar posición (está dentro del tablero) y comprobar que no se ha visitado todavía
            if -1 < adyacente[0] < NUMERO_FILAS and -1 < adyacente[1] < NUMERO_COLUMNAS and not posiciones_visitadas[adyacente[0]][adyacente[1]]:
                if tablero_de_minas[adyacente[0]][adyacente[1]] == MINA:
                    minas_alrededor = minas_alrededor + 1
                else:
                    # marcar posición como visitada
                    posiciones_visitadas[adyacente[0]][adyacente[1]] = True
                    cola_de_visita.append(adyacente)

        tablero_de_minas[siguiente_posicion[0]][siguiente_posicion[1]] = str(minas_alrededor)

def procesar_entrada():
    global input_fila
    global input_columna
    global tablero
    global tablero_de_minas
    global CASILLA_LIBRE
    global MINA
    global ganas
    global pierdes
    global NUMERO_FILAS
    global NUMERO_COLUMNAS

    if tablero_de_minas[input_fila - 1][input_columna - 1] != MINA:
        encontrar_pistas()
        # ganamos si se han abierto todas las casillas que no contienen minas

    else:
        tablero[input_fila][input_columna] = MINA
        pierdes = True


# Este bloque se ejecuta cuando se invoca este módulo
# directamente (no cuando se importa)
if __name__ == '__main__':
    # Inicializar juego
    inicializar_tablero()
    generar_minas()
    imprimir_tablero()

    # Ejecutar Juego
    while continuar:

        if leer_datos_usuario():
            # si las posiciones introducidas son correctas
            # proceder con el juego, sino, volver a pedir
            procesar_entrada()
            imprimir_tablero()
        else:
            print('La posición introducida no es válida. Vuelve a introducir una posicón, por favor.')

        if pierdes or ganas:
            continuar = False

    if pierdes:
        print('¡Lástima! Has perdido.')

    if ganas:
        print('¡Felicidades! Has ganado la partida.')