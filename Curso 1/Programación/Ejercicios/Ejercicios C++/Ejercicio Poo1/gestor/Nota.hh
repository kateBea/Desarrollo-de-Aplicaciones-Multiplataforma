#ifndef NOTA_HH
#define NOTA_HH

#include <string>
#include <string_view>

struct Nota {
    std::string asignatura{};
    double puntuacion{};

    Nota() = default;
    Nota(std::string_view as, double punt)
        :   asignatura{ as }, puntuacion{ punt }
    {}
    ~Nota() = default;

    bool esValida() const {
        return !asignatura.empty() && puntuacion >= 0.0;
    }
};


#endif