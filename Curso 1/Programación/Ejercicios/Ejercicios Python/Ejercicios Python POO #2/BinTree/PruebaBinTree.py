from BinaryTree import *

def leer_arbol():
    num = int(input('Entra valor: '))

    if num != 0:
        left = leer_arbol()
        right = leer_arbol()

        return BinTree(num, left, right)
    
    return BinTree()

def main():
    # Ejemplo 1 2 0 0 3 0 0: árbol con nodo raíz 1, subárbol izquierdo con nodo hoja 2 y nodo hoja derecho 3
    arbol = leer_arbol()
    arbol.recorrido_preorden()




if __name__ == '__main__':
    main()