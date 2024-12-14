/**
 * Simula el algoritmo de suma con acarreo.
 * Por simplificación se asume que ambos sumandos tienen la misma longitud.
 * Se aplica a cualquier base hasta base 16
 * Hugo Pelayo
 * 7 de mayo de 2023
 * */

#include <iostream>
#include <vector>
#include <algorithm>
#include <cctype>

auto validar_sumando(const std::string& digits) -> bool {
    static auto is_binary{ [](char c) -> bool { return c == '1' || c == '0'; } };

    return std::ranges::all_of(digits, [](const auto& elem) -> bool {
        return std::isdigit(elem) && is_binary(elem);
    });
}

auto construir_sumando(const std::string& nums) -> std::vector<int> {
    std::vector<int> v{};

    for (char c : nums) {
        v.emplace_back(static_cast<int>(c - '0'));
    }

    return v;
}

auto deducir_carry(int resultado) -> int {
    if (resultado == 3 || resultado == 2) {
        return 1;
    }

    return 0;
}

auto deducir_suma(int resultado) -> int {
    if (resultado == 3 || resultado == 1) {
        return 1;
    }

    return 0;
}

auto sumar(const std::vector<int>& nums1, const std::vector<int>& nums2) -> std::vector<int> {
    // requiere como mucho max(n, m) + 1 digitos para representar
    std::vector<int> resultado(std::max(nums1.size(), nums2.size()) + 1);

    int index1{ static_cast<int>(nums1.size() - 1) };
    int index2{ static_cast<int>(nums2.size() - 1) };
    int index_res{ static_cast<int>(resultado.size() - 1) };

    int carry{ 0 };
    int resultado_suma{ 0 };

    while (index1 >= 0 && index2 >= 0) {
        resultado_suma = nums1[index1] + nums2[index2] + carry;

        carry = deducir_carry(resultado_suma);
        resultado_suma = deducir_suma(resultado_suma);

        resultado[index_res--] = resultado_suma;

        --index1;
        --index2;
    }

    if (carry != 0) {
        resultado[0] = 1;
    }

    return resultado;
}

int main(int, char**) {
    std::vector<int> num1{};
    std::vector<int> num2{};


    auto valid_numbers{ false };
    while (!valid_numbers) {
        std::string user_input{};
        std::cout << "Entra el primer sumando: ";
        std::getline(std::cin, user_input);

        if (validar_sumando(user_input)) {
            num1 = construir_sumando(user_input);
        } else {
            std::cout << "El sumando no es un binario válido, por favor vuélvelo a intentar\n";
            continue;
        }

        std::cout << "Entra el segundo sumando: ";
        std::getline(std::cin, user_input);

        if (validar_sumando(user_input)) {
            num2 = construir_sumando(user_input);
        } else {
            std::cout << "El sumando no es un binario válido, por favor vuélvelo a intentar\n";
            continue;
        }

        valid_numbers = true;

        std::cout << "El resultado de la suma es:\n";
        std::ranges::for_each(sumar(num1, num2), [](const auto& elem) { std::cout << elem << ' '; });
    }

    std::cout << std::endl;

    return 0;
}