#include <iostream>
#include <algorithm>
#include <random>
#include <vector>

enum class Orden {
    ASCENDENTE,
    DESCENDENTE,
};

std::vector<double>& get_lista_numeros() {
    static std::vector<double> lista{};
    return lista;
}

void mostrar_menu() {
    std::cout << "1. Generar Lista Aleatoria" << std::endl;
    std::cout << "2. Ordenar Ascendentemente" << std::endl;
    std::cout << "3. Ordenar Descendentemente" << std::endl;
    std::cout << "4. Buscar númeero" << std::endl;
    std::cout << "5. Salir" << std::endl << std::endl;
}

double leer_numero(const std::string& prompt) {
    double result;
    std::cout << prompt; 
    std::cin >> result;

    return result;
}

void generar_lista_aleatoria() {
    double cantidad{ leer_numero("Ingresa la cantidad de números: ") };
    double lower_bound{ leer_numero("Ingresa el valor mínimo: ") };
    double upper_bound{ leer_numero("Ingresa el valor máximo: ") };

    thread_local std::random_device rd{};
    thread_local std::mt19937 mt{ rd() };
    std::uniform_real_distribution<double> dist{ lower_bound, upper_bound };

    auto& lista{ get_lista_numeros() };
    
    std::cout << std::endl << "Lista de Números Generada:" << std::endl;
    for (std::vector<double>::size_type count{}; count < static_cast<std::vector<double>::size_type>(cantidad); ++count) {
        lista.emplace_back(static_cast<int>(dist(mt)));
    }

    std::for_each(lista.begin(), lista.end(), 
        [first = true] (double num) mutable -> void { first ? (std::cout << num) : (std::cout << ' ' << num); first = false; } );
}

void ordenar_lista(Orden orden) {
    // Se asume que la lista original se quiere  ordenar (modificar), no simplemente mostrar
    auto& lista{ get_lista_numeros() };

    switch (orden) {
    case Orden::ASCENDENTE:
        std::cout << std::endl << "Lista de números ordenados ascendentemente:" << std::endl;
        std::sort(lista.begin(), lista.end());
        break;
    case Orden::DESCENDENTE:
        std::cout << std::endl << "Lista de números ordenados descendentemente:" << std::endl;
        std::sort(lista.begin(), lista.end(), std::greater<double>{});
        break;
    }

    std::for_each(lista.begin(), lista.end(), 
        [first = true] (double num) mutable -> void { first ? (std::cout << num) : (std::cout << ' ' << num); first = false; } );
}

void buscar_numero() {
    double numero{ leer_numero("Ingresa el número a buscar: ") };

    auto& lista{ get_lista_numeros() };
    auto it{ std::find(lista.begin(), lista.end(), numero) };

    if (it == lista.end()) {
        std::cout << "No se ha encontrado el número " << numero << " en la lista." << std::endl;
    }
    else {
        std::cout << "El número " << numero << " se encuentra en la posición ";
        std::cout << (it - lista.begin()) << std::endl;
    }
}

void procesar_opcion(int opcion) {
    switch (opcion) {
    case 1:
        generar_lista_aleatoria();
        break;
    case 2:
        ordenar_lista(Orden::ASCENDENTE);
        break;
    case 3:
        ordenar_lista(Orden::DESCENDENTE);
        break;
    case 4:
        buscar_numero();
        break;
    case 5:
        std::cout << "Saliendo del programa...";
        break;
    default:
        std::cout << "¡Opción Inválida!";
        break;
    }

    std::cout << std::endl << std::endl;
}

int main(int, char**) {
    int opcion{};

    std::cout << "Ordenamiento y Búsqueda con <algorithm>" << std::endl << std::endl;

    do {
        mostrar_menu();
        opcion = static_cast<int>(leer_numero("Ingresa tu elección: "));

        procesar_opcion(opcion);
    } 
    while (opcion != 5);

    return 0;
}