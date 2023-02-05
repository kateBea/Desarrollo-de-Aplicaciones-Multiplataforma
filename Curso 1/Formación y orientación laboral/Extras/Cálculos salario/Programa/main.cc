#include "calculadora.h"

int main(int, char**) {
    kt::calculadora calc(24, 1100.0, 105.0, 100.0, 2, true, true, 2, 4);
    calc.mostrar_datos();

    std::cout << "salario bruto: " << calc.calcular_salario_bruto() << '\n';
    std::cout << "salario neto: " << calc.calcular_salario_neto() << '\n';
    std::cout << "Vacaciones brutas: " << calc.valor_bruto_vacaciones(kt::calculadora::fecha_t(16, 1)) << '\n';
    std::cout << "Vacaciones netas: " << calc.valor_neto_vacaciones(kt::calculadora::fecha_t(16, 1)) << '\n';
    return 0;
}
