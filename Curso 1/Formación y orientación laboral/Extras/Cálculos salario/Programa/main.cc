#include "calculadora.h"

int main(int, char**) {
    kt::calculadora calc1(20, 1080.0, 145.0, 90.0, 2, true, true, 16.0, 5, true, kt::calculadora::indemnizacion_t::TIPO_2);
    calc1.mostrar_datos();

    std::cout << "salario bruto: " << calc1.calcular_salario_bruto() << '\n';
    std::cout << "salario neto: " << calc1.calcular_salario_neto() << '\n';
    std::cout << "Vacaciones brutas: " << calc1.valor_bruto_vacaciones(kt::calculadora::fecha_t(31, 1)) << '\n';
    std::cout << "Vacaciones netas: " << calc1.valor_neto_vacaciones(kt::calculadora::fecha_t(31, 1)) << '\n';
    std::cout << "Finiquito: " << calc1.finiquito(12) << '\n';

    std::cout << "\n---------------------------------------------------\n";

    kt::calculadora calc2(24, 1100.0, 105.0, 100.0, 2, true, true, 2, 4, false, kt::calculadora::indemnizacion_t::TIPO_1);
    calc2.mostrar_datos();

    std::cout << "salario bruto: " << calc2.calcular_salario_bruto() << '\n';
    std::cout << "salario neto: " << calc2.calcular_salario_neto() << '\n';
    std::cout << "Vacaciones brutas: " << calc2.valor_bruto_vacaciones(kt::calculadora::fecha_t(16, 1)) << '\n';
    std::cout << "Vacaciones netas: " << calc2.valor_neto_vacaciones(kt::calculadora::fecha_t(16, 1)) << '\n';
    std::cout << "Finiquito: " << calc2.finiquito(kt::calculadora::fecha_t(16, 1)) << '\n';
    return 0;
}
