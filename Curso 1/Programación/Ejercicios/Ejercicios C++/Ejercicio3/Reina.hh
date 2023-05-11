#ifndef REINA_HH
#define REINA_HH

#include <string>
#include <stdexcept>
#include <iomanip>
#include <vector>

#include "Hormiga.hh"

class Reina {
public:
    using size_type = std::vector<int>::size_type;

    explicit Reina(const std::string& nombre)
        :   m_nombre{ nombre }, m_feromonas{}, m_hormigas{}
    {};

    Reina(const Reina& otra) 
        :   m_nombre{ otra.getName() }, m_feromonas{ otra.getCantidadFeromonas() }, m_hormigas{ otra.m_hormigas }   
    {}

    auto getName() const -> const std::string& {
        return m_nombre;
    }

    auto getCantidadFeromonas() const -> int {
        return m_feromonas;
    }

    auto getHormigaIdx(size_type index) const -> const Hormiga& {
        if (index >= m_hormigas.size())
            throw std::runtime_error("índice fuera de rango");

        return m_hormigas[index];
    }

    auto addHormiga(const Hormiga& hormiga) -> void {
        m_hormigas.push_back(hormiga);
        m_feromonas = computeFeromonas(contarVivas(m_hormigas));
    }

    auto addHormiga(int id, bool life) -> void {
        m_hormigas.emplace_back(id, life);
        m_feromonas = computeFeromonas(contarVivas(m_hormigas));
    }

    friend std::ostream& operator<<(std::ostream& out, const Reina& reina) {
        out << "Reina: " << reina.getName() << " con hormigas: ";
        for (const auto& it : reina.m_hormigas)
            out << '(' << it.getId() << ',' << std::boolalpha << it.estaViva() << ") ";

        return out;
    }

private:
    static auto computeFeromonas(int count_vivas) -> int {
        if (count_vivas <= 0)
            return 0;

        if (count_vivas == 1)
            return 1;

        return computeFeromonas(count_vivas - 1) + computeFeromonas(count_vivas - 2);
    }

    auto contarVivas(const std::vector<Hormiga>& vec) -> int {
        int total{};

        for (const auto& it : vec)
            total += it.estaViva() ? 1 : 0;

        return total;
    }

    std::string m_nombre{};
    int m_feromonas{};
    std::vector<Hormiga> m_hormigas{};
};


#endif