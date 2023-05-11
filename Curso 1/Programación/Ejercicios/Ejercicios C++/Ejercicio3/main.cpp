#include <iostream>

#include "Pila.hh"
#include "Reina.hh"

int main(int, char**) {
    Pila<Reina> reinas{};
    Reina r1 { "Carla" };
    Reina r2 { "Anna" };
    
    r1.addHormiga(12, false);
    r1.addHormiga(21, true);
    r1.addHormiga(33, false);
    r1.addHormiga(44, true);
    r1.addHormiga(24, true);

    reinas.push(r1);

    std::cout << reinas.peek() << std::endl;

    auto otrasReinas(reinas);
    std::cout << otrasReinas.peek() << std::endl;

    return 0;
}