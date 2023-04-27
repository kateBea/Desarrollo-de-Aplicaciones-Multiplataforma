/**
 * Muestra los números del 1 al 10
 * Hugo Pelayo
 * 27 de abril de 2023
*/

#include <iostream>

int main(int, char**) {
    int start{ 1 };
    int end{ 10 };

    for ( ; start != end + 1; ++start)
        std::cout << "Número es: " << start << std::endl;

    return 0;
}