/**
 * Muestra operaciones con operadores
 * Hugo Pelayo
 * 27 de abril de 2023
*/

#include <iostream>

int main(int, char**) {
    constexpr int a{ 4 + 5 };
    constexpr int b{ 2 - 1 };
    constexpr int c{ 6 * 5 };
    constexpr int d{ 9 / 3 };

    std::cout << "Suma con valor: " << a << std::endl;
    std::cout << "Resta con valor: " << b << std::endl;
    std::cout << "Multiplicación con valor: " << c << std::endl;
    std::cout << "División con valor: " << d << std::endl;

    return 0;
}