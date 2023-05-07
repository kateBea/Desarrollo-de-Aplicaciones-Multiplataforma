/**
 * Simula el algoritmo de suma con acarreo
 * adivinar uno de ellos
 * Hugo Pelayo
 * 1 de mayo de 2023
*/
#include <iostream>
#include <algorithm>
#include <string>
#include <list>
#include <sstream>

auto leerNumero() -> std::list<char> {
    std::list<char> result;
    std::string line{};
    std::cout << "Introduce número: ";
    std::getline(std::cin, line);

    char temp{};
    std::istringstream ss{ line };
    while (ss >> temp)
        result.push_back(temp);

    return result;
}

auto digito(char ch) -> int {
    return ch - '0';
}

auto caracter(int digit) -> char {
    return '0' + digit;
}

auto sumaDos(const std::list<char>& num1, const std::list<char>& num2) -> std::list<char> {
    std::list<char> result;
    auto itPrimero{ num1.rbegin() };
    auto itSegundo{ num2.rbegin() };

    // para evitar excepciones al incrementar los iteradores
    const auto endFirst{ num1.rend()-- };
    const auto endSecond{ num2.rend()-- };

    int sumaDigitos{};
    bool hayCarry{ false };

    while (itPrimero != endFirst && itSegundo != endSecond) {
        sumaDigitos = digito(*itPrimero) + digito(*itSegundo) + (hayCarry ? 1 : 0);
        result.insert(result.begin(), caracter(sumaDigitos % 10));
        hayCarry = sumaDigitos > 9;
        ++itPrimero;
        ++itSegundo;
    }

    // si tenemos carry al salir del bucle 
    // pero nos quedan elementos por añadir
    sumaDigitos = hayCarry ? 1 : 0;

    if (itPrimero != num1.rend()) {
        sumaDigitos += digito(*itPrimero);
        hayCarry = false;

        result.insert(result.begin(), caracter(sumaDigitos));
        ++itPrimero;
    }

    if (itSegundo != num2.rend()) {
        sumaDigitos += digito(*itSegundo);
        hayCarry = false;

        result.insert(result.begin(), caracter(sumaDigitos));
        ++itSegundo;
    }


    // insertar elementos restantes si es necesario
    if (itPrimero != num1.rend())
        result.insert(result.begin(), itPrimero, num1.rend());

    if (itSegundo != num2.rend())
        result.insert(result.begin(), itSegundo, num2.rend());


    // si hay carry pero no hay más dígitos de ambos números que insertar
    // esto pasa cuando ambos números tienen la misma longitud
    if (hayCarry)
        result.insert(result.begin(), '1');

    return result;
}


// formatear salida a gusto
auto muestraSuma(std::list<char> num1, std::list<char> num2, std::list<char> res) -> void {
    auto mostrar{
        [](const std::list<char>& num1, const std::list<char>& num2) -> void {
            for (const auto& it : num1)
                std::cout << it << ' ';
            std::cout << std::endl;
            for (const auto& it : num2)
                std::cout << it << ' ';
        }
    };

    if (num1.size() >= num2.size()) {
        if (res.size() == std::max(num1.size(), num2.size()))
            res.insert(res.begin(), ' ');

        for (int i{}; i < num1.size() - num2.size(); ++i)
            num2.insert(num2.begin(), ' ');

        num1.insert(num1.begin(), ' ');
        num2.insert(num2.begin(), '+');


        mostrar(num1, num2);
        std::cout << '\n' << std::string(res.size() * 2, '-') << '\n';

        for (const auto& it : res)
            std::cout << it << ' ';
    }
    else
        muestraSuma(num2, num1, res);
}

int main() {
    auto numero1{ leerNumero() };
    auto numero2{ leerNumero() };
    auto result{ sumaDos(numero1, numero2) };
    muestraSuma(numero1, numero2, result);

    return 0;
}
