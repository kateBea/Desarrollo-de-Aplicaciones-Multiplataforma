#ifndef CALCULADORA_HH
#define CALCULADORA_HH

#include <iostream>
#include <array>
#include <cstddef>
#include <utility>

namespace kt {

class calculadora {
public:
    // NOTA: de cara a el cálculo del finiquito, vacaciones brutas, vacaciones netas,
    // a indemnizaciones. Las funciones que reciben un fecha_t asumen que el contrato se extingue
    // dentro del mismo año en el cual se empieza. Si no, hay que calcular el total de días
    // que se ha estado en la empresa manualmente y pasarlo como parametro a las correspondientes
    // funciones que reciben el total de dias como 'double'

    // Representa un tipo de indemnizaión
    enum class indemnizacion_t {
        TIPO_1, // 12 días por año realizado
        TIPO_2, // 20 días por año trabajado
        TIPO_3, // 33 días por año trabajado
        NULL_0,   // no corresponde indemnización
    };

    // fecha dentro de un año (día, mes)
    using fecha_t = std::pair<std::int16_t, std::int16_t>;

    calculadora() = default;

    calculadora(std::int16_t    dias,
                double          base,
                double          pl_conv,
                double          pl_transp,
                std::int16_t    extras,
                bool            prorrat,
                bool            causas,
                double          irpf,
                std::int16_t    ultimo,
                bool            cont_indef,
                indemnizacion_t indem = indemnizacion_t::NULL_0) noexcept

            : m_dias_trabajados{ dias }
            , m_salario_base{ base }
            , m_plus_convenio{ pl_conv }
            , m_plus_transporte{ pl_transp }
            , m_extras_prorrateadas{ prorrat }
            , m_num_pagas_extras{ extras }
            , m_ultimo_mes{ ultimo }
            , m_causas_objetivas{ causas }
            // se asume el contrato es indefinido por defecto
            , m_valor_por_desempleo{ cont_indef ? 0.0155 : 0.016 }
            , m_irpf{ irpf / 100.0 }
            , m_tipo_indemnizacion{ causas ? indem : indemnizacion_t::NULL_0 }

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

        return total * salario_diario();
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

    // dias_trabajados indica el total de días trabajados
    auto finiquito(double dias_trabajados) -> double {
        // tener en cuenta si toca indemnización o no
        return calcular_salario_neto() + valor_neto_vacaciones(dias_trabajados) +
        (!m_causas_objetivas ? 0.0 : calcular_indemnizacion(dias_trabajados));
    }

    // anios indica el total de años trabajaados (antigüedad)
    auto finiquito(std::int32_t anios) -> double {
        // tener en cuenta si toca indemnización o no
        return calcular_salario_neto() + valor_neto_vacaciones(calcular_total_dias(fecha_t(31, 1),
            fecha_t(m_dias_trabajados, m_ultimo_mes))) +
        (!m_causas_objetivas ? 0.0 : calcular_indemnizacion(anios));
    }

    // inicio indica la fecha de inicio del contrato
    auto finiquito(fecha_t inicio) -> double {
        // tener en cuenta si toca indemnización o no
        return finiquito(calcular_total_dias(inicio,
            fecha_t(m_dias_trabajados, m_ultimo_mes)));
    }

    // dias_trabajados indica el total de días trabajados
    auto calcular_indemnizacion(double dias_trabajados) -> double {
        constexpr double total_dias_anio{ 365 };
        // NOTA: este valor sólo tiene sentido si
        // corresponde la indemnización, ya dependería del problema descrito por el enunciado
        // (dias_trabajados / total_dias_anio) representa la antigüedad
        return obtener_dias_indeminzacion(m_tipo_indemnizacion) * salario_diario() * (dias_trabajados / total_dias_anio);
    }

    // anios indica el total de años trabajaados (antigüedad)
    auto calcular_indemnizacion(std::int32_t anios) -> double {
        constexpr double total_dias_anio{ 365 };
        // NOTA: este valor sólo tiene sentido si
        // corresponde la indemnización, ya dependería del problema descrito por el enunciado
        // (dias_trabajados / total_dias_anio) representa la antigüedad
        return obtener_dias_indeminzacion(m_tipo_indemnizacion) * salario_diario() * anios;
    }

    // inicio indica la fecha de inicio del contrato
    auto calcular_indemnizacion(fecha_t inicio) -> double {
        // NOTA: este valor sólo tiene sentido si
        // corresponde la indemnización, ya dependería del problema
        return calcular_indemnizacion(calcular_total_dias(inicio,
            fecha_t(m_dias_trabajados, m_ultimo_mes)));
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
        std::cout << "Fin de contrato por causas ojetivas: " << (m_causas_objetivas ?
            "Sí" : "No") << '\n';
    }

private:
    auto obtener_dias_indeminzacion(indemnizacion_t indem) -> double {
        switch (indem) {
            case indemnizacion_t::TIPO_1: return 12;
            case indemnizacion_t::TIPO_2: return 20;
            default: return 33;
        }
    }

    auto salario_diario() -> double {
        constexpr static std::int16_t dias_mes{ 30 };
        return (m_salario_base + m_plus_convenio + obtener_prorrata()) / dias_mes;
    }

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
    // procentaje de irpf, en el rango [0.0, 1.0]
    double m_irpf{};
    // tipo de indemnización
    indemnizacion_t m_tipo_indemnizacion{};


};  // END class calculadora

}   // END NAMESPACE kt

#endif
