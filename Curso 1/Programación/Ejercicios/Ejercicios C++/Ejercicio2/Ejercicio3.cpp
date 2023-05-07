/**
 * Simula el algoritmo de suma con acarreo
 * adivinar uno de ellos
 * Hugo Pelayo
 * 1 de mayo de 2023
*/
#include <iostream>
#include <algorithm>
#include <new>

void rellerArray(char* numero, int size) {
    std::cout << "Introduce número: ";
    for (int index{}; index < size; ++index)
        std::cin >> numero[index];
}

int main(int, char**) {
    int size1{};
    int size2{};

    std::cout << "Introduce tamaño del primer array: "; std::cin >> size1;
    std::cout << "Introduce tamaño del segundo array: "; std::cin >> size2;

    auto numero1{ new (std::nothrow) char[size1]{} };
    auto numero2{ new (std::nothrow) char[size2]{} };
    char* resultado{ nullptr };

    if (numero1 && numero2) {
        rellerArray(numero1, size1);
        rellerArray(numero2, size2);

        int index1{ size1 - 1 };
        int index2{ size2 - 1 };
        int indexRes{ std::max(size1, size2) - 1 };
        bool carry{ false };

        resultado = new (std::nothrow) char[std::max(size1, size2)]{};

        int temp{};
        while (index1 >= 0 && index2 >= 0) {
            temp =  (numero1[index1--] - '0') + (numero2[index2--] - '0') + (carry ? 1 : 0);
            resultado[indexRes--] = '0' + (temp % 10);
            carry = temp > 9;
        }

        std::cout << "carry?" << carry << std::endl;
        // copiamos resto de dígitos del primer número
        // ya no hace falta comprobar carry otra vez
        while (index1 >= 0) {
            if (carry) {
                temp = (1 + numero1[index1--] - '0');
                carry = false;
            }
            else 
                temp = (numero1[index1--] - '0');

            resultado[indexRes--] = '0' + (temp % 10);
        }

        // copiamos resto de dígitos del segundo número
        // ya no hace falta comprobar carry otra vez
        while (index2 >= 0) {
            if (carry) {
                temp = (1 + numero1[index1--] - '0');
                carry = false;
            }
            else 
                temp = (numero1[index1--] - '0');

            resultado[indexRes--] = '0' + (temp % 10);
        }

        std::cout << "Resultado es: ";
        for (int index{}; index < std::max(size1, size2); ++index)
            std::cout << static_cast<int>(resultado[index] - '0') << ' ';
    }

    delete numero1;
    delete numero2;
    delete resultado;

    return 0;
}