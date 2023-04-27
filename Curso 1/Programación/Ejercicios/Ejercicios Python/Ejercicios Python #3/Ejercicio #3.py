# Ejercicio 3
# Algoritmo: Indica si un código ISBN-10 es válido o no
# Fecha: 19.11.2022
# Auor: Hugo Pelayo

def is_valid_isbn(isbn: str):
    """
    Función que indica si un ISBN-10 es válido o no
    Los códigos ISBN son del formato X-XXX-XXXXX-X
    :param isbn : str
    :return: bool
    """
    acumulador = 0
    indice = 10
    for char in isbn:
        if char != '-':
            acumulador += int(char) * indice
            indice = indice - 1

    return acumulador % 11 == 0


if __name__ == '__main__':
    isbn_input = input("Introduce el código ISBN de 10 cifras: ")
    if is_valid_isbn(isbn_input):
        print("El código ISBN [{isbn_input}] es válido.")
    else:
        print(f"El código ISBN [{isbn_input}] no es válido.")
