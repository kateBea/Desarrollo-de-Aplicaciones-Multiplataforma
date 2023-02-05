#ifndef CALCULADORA_HH
#define CALCULADORA_HH

#include <iostream>
#include <array>
#include <cstddef>
#include <utility>

namespace kt {

class calculadora {
public:
    // fecha dentro de un año (día, mes)
    using fecha_t = std::pair<std::int16_t, std::int16_t>;
    calculadora() = default;

    calculadora(std::int16_t dias, double base, double pl_conv, double pl_transp, std::int16_t extras, bool prorrat, bool causas, double irpf, std::int16_t ultimo) noexcept
            : m_dias_trabajados{ dias }
            , m_salario_base{ base }
            , m_plus_convenio{ pl_conv }
            , m_plus_transporte{ pl_transp }
            , m_extras_prorrateadas{ prorrat }
            , m_num_pagas_extras{ extras }
            , m_ultimo_mes{ ultimo }
            , m_causas_objetivas{ causas }
            // se asume el contrato es indefinido por defecto
            , m_valor_por_desempleo{ 0.016 }
            , m_irpf{ irpf / 100.0 }

    {

    }

    auto set_factor_desempleo() -> void {
        char temp{};
        std::cout << "El contrato es definido?: [S -> Sí | N -> No]: ";
        std::cin >> temp;
        m_valor_por_desempleo = temp == 'S' ? 0.0155 : 0.016;
    }

    auto set_data() -> void {
        std::cout << "Días trabajados último més: ";
        std::cin >> m_dias_trabajados;

        std::cout << "Salario base: ";
        std::cin >> m_salario_base;

        std::cout << "Plus de convenio: ";
        std::cin >> m_plus_convenio;

        std::cout << "Plus de transporte: ";
        std::cin >> m_plus_transporte;

        std::cout << "Número de pagas extras anuales: ";
        std::cin >> m_num_pagas_extras;

        char temp{};
        std::cout << "Las pagas extras son prorrateadas? [S -> Sí | N -> No]: ";
        std::cin >> temp;
        m_extras_prorrateadas = temp == 'S';

        std::cout << "último més de trabajo [1, 12]: ";
        std::cin >> m_ultimo_mes;

        std::cout << "Despido por causas objetivas? [S -> Sí | N -> No]: ";
        std::cin >> temp;
        m_causas_objetivas = temp == 'S';



        std::cout << "Valor de IRFP (porcentaje sobre cien) :";
        std::cin >> m_irpf;
        m_irpf = m_irpf / 100.0;
    }

    auto calcular_salario_bruto() -> double {
        double resultado{};

        // salario base
        resultado += m_salario_base * (static_cast<double>(m_dias_trabajados) / dias_mes[m_ultimo_mes - 1]);
        resultado += m_plus_convenio * (static_cast<double>(m_dias_trabajados) / dias_mes[m_ultimo_mes - 1]);
        resultado += m_plus_transporte * (static_cast<double>(m_dias_trabajados) / dias_mes[m_ultimo_mes - 1]);

        // suma paga extra prorrata (en caso de haber trabjado todo ese més)
        // salario_base * (pagas_extras_por_doce_meses)
        double prorrata{ obtener_prorrata() };

        // si no se ha trabajado todo ese mes
        if (m_dias_trabajados < dias_mes[m_ultimo_mes - 1])
            prorrata = prorrata * (static_cast<double>(m_dias_trabajados) / dias_mes[m_ultimo_mes - 1]);

        resultado += prorrata;

        return resultado;
    }

    auto calcular_salario_neto() -> double {
        return calcular_retencion(calcular_salario_bruto());

    }

    // dias_trabajados indica el total de días trabajados
    auto valor_bruto_vacaciones(double dias_trabajados) -> double {
        // este es el número de dias que se tiene en cuenta para las vacaciones
        // indeferentemente de haber meses con 31 días
        constexpr std::int16_t dias_mes_vacaciones{ 30 };
        constexpr std::int16_t dias_anio{ 365 };

        auto fecha_fin{ fecha_t(m_dias_trabajados, m_ultimo_mes) };
        double total{ dias_trabajados * (dias_mes_vacaciones / static_cast<double>(dias_anio)) };

        // en las vacaciones no tenemos en cuenta el plus de transporte
        double temp{ (m_salario_base + m_plus_convenio + obtener_prorrata()) / dias_mes_vacaciones };

        return total * temp;
    }

    auto valor_bruto_vacaciones(fecha_t fecha_inicio) -> double {
        // trabajo temporal que acaba el mismo año
        return valor_bruto_vacaciones(calcular_total_dias(fecha_inicio,
            fecha_t(m_dias_trabajados, m_ultimo_mes)));
    }

    // inicio indica la fecha de inicio del contrato
    auto valor_neto_vacaciones(fecha_t inicio) -> double {
        // aquí tomamos como base el valor de las vacaciones brutas
        // a partir de ello el resto de cálculos es similar al del salario neto neto
        return calcular_retencion(valor_bruto_vacaciones(inicio));
    }

    // dias_trabajados indica el total de días trabajados
    auto valor_neto_vacaciones(double dias_trabajados) -> double {
        // aquí tomamos como base el valor de las vacaciones brutas
        // a partir de ello el resto de cálculos es similar al del salario neto neto
        return calcular_retencion(valor_bruto_vacaciones(dias_trabajados));
    }

    auto mostrar_datos() -> void {
        static constexpr std::array str_mes {
            "enero", "febreo", "marzo", "abril", "mayo", "junio",
            "agosto", "septiembre", "octubre", "noviembre", "diciembre"
        };

        std::cout << "Días trabajados último més: " << m_dias_trabajados << '\n';
        std::cout << "Salario base: " << m_salario_base << '\n';
        std::cout << "Plus de convenio: " << m_plus_convenio << '\n';
        std::cout << "Plus de transporte: " << m_plus_transporte << '\n';
        std::cout << "Número de pagas extras anuales: " << m_num_pagas_extras << '\n';
        std::cout << "Las pagas extras son prorrateadas: " <<
            (m_extras_prorrateadas ? "Sí" : "No") << '\n';
        std::cout << "Último mes de trabajo: " << str_mes[m_ultimo_mes - 1] << '\n';
    }

private:
    auto calcular_retencion(double bruto) -> double {
        double total_deducciones = (contingencias + fp + m_valor_por_desempleo + m_irpf) *
            bruto;

        return bruto - total_deducciones;
    }

    auto obtener_prorrata() -> double {
        return m_salario_base * (m_num_pagas_extras / static_cast<double>(dias_mes.size()));
    }

    // calcula días transcurridos entre dos fechas de un mismo año
    auto calcular_total_dias(fecha_t inicio, fecha_t fin) -> double {
        double resultado;
        // si la fecha inicio empieza mediados de mes
        resultado = dias_mes[inicio.second - 1] - inicio.first + 1;

        // recorer los meses. Saltamos el mes de inicio porque ya se ha contado
        for (std::int16_t i = inicio.second + 1; i < fin.second; ++i) {
            // sumamos días
            resultado += dias_mes[i - 1];

        }

        // queda por sumar el último mes
        resultado += fin.first;

        return resultado;
    }

    static constexpr std::array dias_mes{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    static constexpr double contingencias{ 0.047 };
    static constexpr double fp{ 0.001 };
    // dias trabajados en el último (cuando finaliza el contrato)
    std::int16_t m_dias_trabajados{};
    // salario base (según lo establecido en el contrato)
    double m_salario_base{};
    // plus de convenio
    double m_plus_convenio{};
    // plus de transporte
    double m_plus_transporte{};
    // vale cierto si si las pagas extras son prorrateadas
    // vale falso en caso contrario
    bool m_extras_prorrateadas{};
    // número de pagas extras anuales
    std::int16_t m_num_pagas_extras{};
    // último més de trabajo
    std::int16_t m_ultimo_mes{};
    // fin por casusas objetivas (decie si tiene derecho a indemnización o no)
    bool m_causas_objetivas{};
    // porcentaje por desempleo (1.6% contrato no indefinido, 1.55% contrato definido)
    double m_valor_por_desempleo{};
    double m_irpf{};


};



}

#endif
