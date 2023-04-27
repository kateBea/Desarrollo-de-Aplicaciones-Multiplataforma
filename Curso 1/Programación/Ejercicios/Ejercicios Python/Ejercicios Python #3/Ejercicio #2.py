# Ejercicio 2
# Algoritmo: Distancia Hamming entre dos cadenas de caractéres
# Fecha: 19.11.2022
# Auor: Hugo Pelayo

def dist_hamming(c1: str, c2: str):
    """
    Función que retorna la distancia Hamming entre dos cadenas
    Se asume que las dos cadenas tienen la misma longitud
    :param c1:
    :param c2:
    :return: int
    """
    distancia   = 0
    it_c1       = 0
    it_c2       = 0

    for _ in c1:
        if (c1[it_c1] != c2[it_c2]):
            distancia = distancia + 1

        it_c1 = it_c1 + 1
        it_c2 = it_c2 + 1

    return distancia


if __name__ == '__main__':
    cadena1 = input("Introduce una cadena de ADN: ")
    cadena2 = input("Introduce otra cadena de ADN: ")

    print(f"\nLa distancia Hamming entre [{cadena1}] y [{cadena2}] es: {dist_hamming(cadena1, cadena2)}")