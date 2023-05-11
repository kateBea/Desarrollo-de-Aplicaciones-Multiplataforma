#ifndef HORMIGA_HH
#define HORMIGA_HH

#include <string>

class Hormiga {
public:
    Hormiga(int id, bool viva) : m_id{ id }, m_viva{ viva } {}

    auto getId() const -> int {
        return m_id;
    }

    auto estaViva() const -> bool {
        return m_viva;
    }

private:
    int m_id{};
    bool m_viva{};
};


#endif