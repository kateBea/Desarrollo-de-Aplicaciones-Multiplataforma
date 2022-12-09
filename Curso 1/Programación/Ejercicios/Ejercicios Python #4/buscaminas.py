#imports
import random

# constantes
NUMERO_FILAS = 0
NUMERO_COLUMNAS = 0
MINA = '*'
CASILLA_INCOGNITO = '.'
CASILLA_LIBRE = '_'
FACTOR_MINAS_NIVEL_FACIL = 0.15    # factor 15%
FACTOR_MINAS_NIVEL_MEDIO = 0.20    # factor 20%
FACTOR_MINAS_NIVEL_EXPERTO = 0.25  # factor 25%
FACTOR_MINAS_NIVEL_MAGO = 0.30     # factor 30%
TOTAL_MINAS = 0


# Crear variables
tablero = list()
tablero_de_minas = list()
input_fila = 0
input_columna = 0
pierdes = False
ganas = False
casillas_abiertas = 0


# definición de funciones
def definir_ajustes():
    """
    Función que lee y establece las dimensiones del tablero
    de juego y la dificultad.
    :return: None
    """

    global NUMERO_FILAS
    global NUMERO_COLUMNAS
    global TOTAL_MINAS
    global tablero
    global tablero_de_minas
    global pierdes
    global ganas

    tablero = list()
    tablero_de_minas = list()
    ganas = False
    pierdes = False

    NUMERO_FILAS = int(input('Por favor, introduzca el número de filas del tablero: '))
    NUMERO_COLUMNAS = int(input('Por favor, introduzca el número de columnas del tablero: '))

    correcto = False
    while not correcto:
        dificultad = input('Introduce la dificultad -> [Fácil, Intermedio, Experto, Mago]: ')
        if dificultad == 'Fácil' or dificultad == 'Facil':
            TOTAL_MINAS = int(FACTOR_MINAS_NIVEL_FACIL * (NUMERO_FILAS * NUMERO_COLUMNAS))
            correcto = True
        elif dificultad == 'Intermedio':
            TOTAL_MINAS = int(FACTOR_MINAS_NIVEL_MEDIO * (NUMERO_FILAS * NUMERO_COLUMNAS))
            correcto = True
        elif dificultad == 'Experto':
            TOTAL_MINAS = int(FACTOR_MINAS_NIVEL_EXPERTO * (NUMERO_FILAS * NUMERO_COLUMNAS))
            correcto = True
        elif dificultad == 'Mago':
            TOTAL_MINAS = int(FACTOR_MINAS_NIVEL_MAGO * (NUMERO_FILAS * NUMERO_COLUMNAS))
            correcto = True
        else:
            print('Dificultad no definida. Por favor inténtalo de nuevo.')

def generar_posicion_aleatoria():
    """
    Función que genera una posición aleatoria dentro
    de un tablero.
    :return: None
    """

    pos = list()
    pos.append(random.randint(0, NUMERO_FILAS - 1))
    pos.append(random.randint(0, NUMERO_COLUMNAS - 1))

    return pos

def inicializar_tablero():
    """
    Función que inicializa las casillas del tablero
    con valores incógnitos.
    :return: None
    """

    global NUMERO_COLUMNAS
    global NUMERO_FILAS
    global CASILLA_INCOGNITO
    global tablero

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
    Función que imprime el tablero con el progreso actual.
    :return: None
    """

    global tablero

    for fila in tablero:
        for columna in fila:
            print(columna, end = ' ')

        print()

def leer_coordenadas():
    """
    Función que lee unas coordenadas por la entrada de datos.
    Si los valores están dentro de los límetes del tablero devuelve Cierto,
    si las coordenadas no son válidas devuelve Falso.
    :return: bool
    """

    global input_fila
    global input_columna
    global NUMERO_FILAS
    global NUMERO_COLUMNAS

    input_fila = int(input("Introduce un valor de fila: "))
    input_columna = int(input("Introduce un valor de columna: "))

    return (0 < input_fila < NUMERO_FILAS + 1) and (0 < input_columna < NUMERO_COLUMNAS + 1)

def encontrar_pistas():
    """
    Dada como coordenada de inicio, esta función revela todas
    las casillas adyacentes sin minas a su alrededor y aquellas que contienen las pistas.
    :return: None
    """

    global tablero_de_minas
    global tablero
    global NUMERO_FILAS
    global NUMERO_COLUMNAS
    global input_fila
    global input_columna
    global MINA
    global CASILLA_LIBRE

    # poner pistas en el tablero de minas
    posiciones_visitadas = list()
    # Las coordenadas del tablero de minas están entre [0, NUMERO_FILAS) para las filas y [0, NUMERO_COLUMNAS)
    # Las coordenadas del tablero de minas están entre [0, NUMERO_FILAS] para las filas y [0, NUMERO_COLUMNAS]
    posicion_inicio = [input_fila - 1, input_columna - 1]
    direcciones = [[0, 1], [1, 1], [1, 0], [1, -1], [0, -1], [-1, -1], [-1, 0], [-1, 1]]
    cola_de_visita = [posicion_inicio]

    # Marcamos todas las posiciones del tablero como no visitadas
    # Esta matriz auxiliar nos indicará cuáles son las casillas adyacentes que hay que visitar
    for _ in range(0, NUMERO_FILAS):
        posiciones_visitadas.append([False] * NUMERO_COLUMNAS)

    # marcar la posición de partida como visitada
    posiciones_visitadas[posicion_inicio[0]][posicion_inicio[1]] = True

    # Si la casilla ya contenía una pista (un número indicando la cantidad de minas alrededor)
    # abrimos la casilla y la dejamos marcada con la pista
    if int(tablero_de_minas[posicion_inicio[0]][posicion_inicio[1]]) > 0:
        tablero[posicion_inicio[0] + 1][posicion_inicio[1] + 1] = tablero_de_minas[posicion_inicio[0]][posicion_inicio[1]]
    else:
        tablero[posicion_inicio[0] + 1][posicion_inicio[1] + 1] = CASILLA_LIBRE

    while len(cola_de_visita) != 0:
        siguiente_posicion = cola_de_visita.pop()

        # visitar posiciones adyacentes a 'siguiente_posicion'
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

                # apuntamos esta casilla adyacente para seguir buscando pistas desde ella en el caso de que no sea una mina
                # y no queremos explorar más allá de las pistas, si no revelaríamos al jugador las minas
                if tablero_de_minas[adyacente[0]][adyacente[1]] != MINA and int(tablero_de_minas[adyacente[0]][adyacente[1]]) == 0:
                    cola_de_visita.append(adyacente)


def generar_minas():
    """
    Función que inicializa el tablero de minas en posiciones aleatorias.
    :return: None
    """

    global tablero_de_minas
    global NUMERO_FILAS
    global NUMERO_COLUMNAS
    global CASILLA_INCOGNITO
    global MINA

    for _ in range(0, NUMERO_FILAS):
        tablero_de_minas.append([CASILLA_INCOGNITO] * NUMERO_COLUMNAS)

    # Controla el número de minas que se han
    # colocado en el tablero de minas
    total = 0

    while total < TOTAL_MINAS:
        posicion = generar_posicion_aleatoria()

        if tablero_de_minas[posicion[0]][posicion[1]] == MINA:
            # si la posición ya contiene una mina
            # generar una posición aleatoria nueva
            continue
        else:
            tablero_de_minas[posicion[0]][posicion[1]] = MINA

        total = total + 1

    # ponemos pistas en el tablero de minas
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
    """
    Función que determina los resultados de una entrada de datos.
    :return:
    """

    global input_fila
    global input_columna
    global tablero
    global tablero_de_minas
    global MINA
    global ganas
    global pierdes

    if tablero_de_minas[input_fila - 1][input_columna - 1] != MINA:
        encontrar_pistas()
        # ganamos si se han abierto todas las casillas que no contienen minas

    else:
        tablero[input_fila][input_columna] = MINA
        pierdes = True

def jugar():
    """
    Función principal. Núcleo del juego.
    :return: None
    """
    print('********** Bienvenido al juego de buscaminas **********')

    # Bucle principal
    while True:
        respuesta_usuario = input('Para iniciar nueva partida introduce [Sí o S]. Para salir introduce [No o N]: ')

        if (respuesta_usuario != 'Sí') and (respuesta_usuario != 'S') and (respuesta_usuario != 'No') and (respuesta_usuario != 'N'):
            # si el usuario no ha entrado ninguna de las opciones válidas
            print('Entrada no válida, por favor, vuelve a intentarlo.')
            continue
        else:
            nueva_partida = True if respuesta_usuario == 'S' or respuesta_usuario == 'Sí' else False

        # empezamos una nueva partida si el usuario quiere seguir jugando
        if nueva_partida:
            # definimos ajustes de una nueva partida y
            # reinicializamos el tablero
            definir_ajustes()
            inicializar_tablero()
            generar_minas()

            # Bucle para empezar una partida nueva
            while True:
                imprimir_tablero()
                if leer_coordenadas():
                    # si las posiciones introducidas son correctas
                    # proceder con el juego, si no, volver a pedir
                    procesar_entrada()
                else:
                    print('La posición introducida no es válida. Vuelve a introducir una posición, por favor.')

                # acabamos la partida si ganamos o perdemos
                if ganas or pierdes:
                    break

            if pierdes:
                print('¡Lástima! Has perdido.')

            if ganas:
                print('¡Felicidades! Has ganado la partida.')
        else:
            break

    print('Programa terminando...')

# Este bloque se ejecuta cuando se invoca este módulo
# directamente (no cuando se importa)
if __name__ == '__main__':
    jugar()