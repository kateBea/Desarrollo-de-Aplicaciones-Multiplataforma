#ifndef HORMIGA_HH
#define HORMIGA_HH

#include <string>

class Hormiga {
public:
    Hormiga(int id, bool viva) : m_id{ id }, m_viva{ viva } {}

    int getId() const { 
        return m_id; 
    }

    bool estaViva() const { 
        return m_viva; 
    }

private:
    int m_id{};
    bool m_viva{};
};


#endif