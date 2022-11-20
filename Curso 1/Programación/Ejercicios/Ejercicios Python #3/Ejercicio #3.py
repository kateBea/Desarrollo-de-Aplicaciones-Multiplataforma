# Ejercicio 3
# Algoritmo: Indica si un código ISBN-10 es válido o no
# Fecha: 19.11.2022
# Auor: Hugo Pelayo

def format_isbn(isbn: str):
    """
    Función que retorna un código ISBN-10 sin los guines
    :param isbn:
    :return:
    """
    result_isbn = ''
    for bloque in isbn.split('-'):
        result_isbn = result_isbn + bloque

    return result_isbn

def is_valid_isbn(isbn: str):
    """
    Función que indica si un ISBN-10 es válido o no
    Los códigos ISBN son del formato X-XXX-XXXXX-X
    :param isbn : str
    :return: bool
    """
    formated_isbn = format_isbn(isbn)
    acumulador = 0
    indice = 10
    while (indice > 0):
        acumulador += int(formated_isbn[len(formated_isbn) - indice]) * indice
        indice = indice - 1

    return indice % 11 == 0


if __name__ == '__main__':
    isbn_input = input("Introduce el código ISBN de 10 cifras: ")
    if is_valid_isbn(isbn_input):
        print("El código ISBN [code] es válido.".format(code = isbn_input))
    else:
        print("El código ISBN [code] es válido.".format(code=isbn_input))
