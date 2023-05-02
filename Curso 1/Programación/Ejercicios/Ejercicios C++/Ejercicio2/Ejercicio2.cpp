/**
 * Genera diez números aleatorios y pide al usuario 
 * adivinar uno de ellos
 * Hugo Pelayo
 * 1 de mayo de 2023
*/
#include <array>
#include <random>
#include <iostream>
#include <algorithm>
#include <vector>

static std::array<int, 10> g_Numeros{};
/*
 * Retorna un número aletporio entre 0 y valor
 * que se pasa por parámetro (exclusivo)
*/
int getRandom(int number) {
    int result{};

    static std::mt19937 mt{ std::random_device{}() };
    std::uniform_int_distribution<> dist(0, number); 
    result = dist(mt);

    return result;
}

void rellenarLista() {
    for (auto& item : g_Numeros) {
        item = getRandom(11);
    }
}

bool contains(const std::vector<decltype(g_Numeros)::iterator>& list, decltype(g_Numeros)::iterator target) {
    for (const auto& it : list) {
        if (it == target)
            return true;
    }

    return false;
}

int main(int, char**) {
    rellenarLista();
    std::cout << "Se han generado 10 números. Tu objetivo es adivinar 2\n";
    std::cout << "Tienes 3 intentos\n";
    
    std::vector<decltype(g_Numeros)::iterator> iters{};
    auto target{ g_Numeros.begin() };

    int intentos{ 3 };
    int acertados{};
    int userInput{};

    do {
        std::cout << "Introduce to propuesta: ";
        std::cin >> userInput;

        if ((target = std::find(g_Numeros.begin(), g_Numeros.end(), userInput)) != g_Numeros.end() && !contains(iters, target)) {
            iters.push_back(target);
            ++acertados;
        }

        --intentos;
    }
    while (intentos != 0);

    if (acertados == 0)
        std::cout << "No has acertado ningún número :(\n";
    else 
        std::cout << "Has acertado " << acertados << " valores\n";

    std::cout << "La lista era: ";
    std::for_each(g_Numeros.begin(), g_Numeros.end(), [](int n){ std::cout << n << ' '; });
    return 0;
}