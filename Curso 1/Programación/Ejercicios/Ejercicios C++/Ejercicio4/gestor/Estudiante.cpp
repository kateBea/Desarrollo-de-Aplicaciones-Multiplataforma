#include <iostream>

#include "Estudiante.hh"


void Estudiante::setDni(std::string_view dni) {
        std::string temp{ dni };

        if (temp.empty())
            throw std::runtime_error("El dni está vacío");

        m_Dni = std::move(temp);
}

void Estudiante::setNombre(std::string_view nombre) {
    std::string temp{ nombre };

    if (temp.empty())
        throw std::runtime_error("El nombre está vacío");

    m_Nombre = std::move(temp);
}

void Estudiante::setPrimerApellido(std::string_view ap1) {
    std::string temp{ ap1 };

    if (temp.empty())
        throw std::runtime_error("El appelido está vacío");

    m_PrimerApellido = std::move(temp);
}

void Estudiante::setSegundoApellido(std::string_view ap2) {
    m_SegundoApellido = ap2;
}

void Estudiante::mostrar() {
    std::cout << "DNI:              " << m_Dni << '\n';
    std::cout << "Nombre:           " << m_Nombre << '\n';
    std::cout << "Primer apellido:  " << m_PrimerApellido << '\n';
    std::cout << "Segundo apellido: " << m_SegundoApellido << '\n';

}

void Estudiante::leer() {
    std::cout << "DNI:              "; std::cin >> m_Dni;
    std::cout << "Nombre:           "; std::cin >> m_Nombre;
    std::cout << "Primer apellido:  "; std::cin >> m_PrimerApellido;
    std::cout << "Segundo apellido: "; std::cin >> m_SegundoApellido;
}

void Estudiante::addNota(const Nota& nota) {
    if (!nota.esValida())
        throw std::runtime_error("La nota es inválida o la asignatura es inválida");

    m_Notas.push_back(nota);
}

void Estudiante::addNota(std::string_view asignatura, double punt) {
     if (!asignatura.empty() || punt < 0.0)
        throw std::runtime_error("La nota es inválida o la asignatura es inválida");
        
    m_Notas.emplace_back(asignatura, punt);
}