/**
 * Gestor básico de estudiante
 * Hugo Pelayo
 * 27 de abril de 2023
 * */

#include <Estudiante.hh>

int main(int, char**) {
    Estudiante est{ "1234567U", "carlos", "ferreira" };

    est.mostrar();
    est.addNota("naturales", -1.0);


    return 0;
}