# Ejercicio 1
# Algoritmo: Dice si un número es Armstrong
# Fecha: 19.11.2022
# Auor: Hugo Pelayo


def numero_de_cifras(number: int):
    """
    Función que indica la cantidad de cifras de un número entero
    :param number : int
    :return: int
    """
    if number > -10 and number < 10:
        return 1
    else:
        return 1 + numero_de_cifras(number // 10)

def is_armstrong(number: str):
    """
    Función que indica si un número es Armstrong o no
    :param number : int
    :return: bool
    """
    numero_cifras = numero_de_cifras(int(number))
    suma_potencias = 0

    for digito in number:
        suma_potencias = suma_potencias + int(digito)**numero_cifras

    return suma_potencias == int(number)



if __name__ == '__main__':
    user_input = input("Introduce un número: ")
    if is_armstrong(user_input):
        print(f"\n{user_input} es un número Armstrong.")
    else:
        print(f"\n{user_input} no es un número Armstrong.")