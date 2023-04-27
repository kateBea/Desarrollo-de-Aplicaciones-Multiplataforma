/**
 * Muestra el nombre del usuario por pantalla
 * Hugo Pelayo
 * 27 de abril de 2023
*/

#include <iostream>
#include <string>

int main(int, char**) {
    std::string nombre{};
    std::cout << "Entre su nombre: ";

    std::getline(std::cin, nombre);

    std::cout << "¡Hola " << nombre << "!" << std::endl;

    return 0;
}