#include <iostream>

#include <biblioteca/libro.hh>
#include <biblioteca/gestor.hh>

void mostrar_menu() {
    std::cout << "Sistema de Gestión de Biblioteca\n" << std::endl;

    std::cout << "1. Agregar Libro" << std::endl;
    std::cout << "2. Mostrar Todos los Libros" << std::endl;
    std::cout << "3. Buscar Libro por ISBN" << std::endl;
    std::cout << "4. Eliminar Libro por ISBN" << std::endl;
    std::cout << "5. Número Total de Libros" << std::endl;
    std::cout << "6. Salir del programa\n" << std::endl;
}

int leer_opcion() {
    int resultado{};

    std::cout << "Ingresa tu elección: ";
    if (std::cin >> resultado) {
        return resultado;
    }

    return -1;
}

void procesar_opcion(int opcion, biblio::gestor&) {
    std::cout << std::endl;

    switch (opcion) {
    case 1:
        break;
    case 2:
        break;
    case 3:
        break;
    case 4:
        break;
    case 5:
        break;
    }
}

int main(int, char**) {
    int opcion{};

    biblio::gestor* gestor_ptr{ new biblio::gestor{} };

    constexpr int FIN{ 6 };

    do {
        mostrar_menu();
        opcion = leer_opcion();

        procesar_opcion(opcion, *gestor_ptr);

        std::cout << std::endl;
    }
    while (opcion != FIN);

    std::cout << "Saliendo del programa..." << std::endl;
}