#include <iostream>
#include <vector>
#include <string>
#include <cstdint>
#include <algorithm>
#include <utility>

struct Asignatura {
    std::string Nombre{};
    double Nota{};
};

class Estudiante {
public:
    explicit Estudiante() = default;

    auto getDNI() const -> const std::string& { return m_Dni; }
    auto getCurso() const -> std::int32_t { return m_Curso; }

    auto leerDatos() -> void {
        std::int32_t totalAsig{};
        std::cout << "Entra el DNI del estudiante: "; std::cin >> m_Dni;
        std::cout << "Entra el Curso del estudiante (índice entre 1-4 ESO): "; std::cin >> m_Curso;
        std::cout << "Entra el total de asignaturas asignaturas del estudiante: \n"; std::cin >> totalAsig;
        std::cout << "Entra las " << totalAsig << " asignaturas:\n";

        // TODO: still buggy
        for (std::int32_t count{}; count < totalAsig; ++totalAsig) {
            std::string nombre{};
            double nota{};

            std::cout << "Nombre de la asignatura: "; std::cin >> nombre;
            std::cout << "Nota de la asignatura: "; std::cin >> nota;
            m_Asignaturas.emplace_back(Asignatura{ nombre, nota });
        }
    }

    auto mediaAsignaturas() const -> double {
        double media{};
        // C++ 17
        for (auto& [nombre, nota] : m_Asignaturas) {
            media += nota;
        }

        return media / m_Asignaturas.size();
    }

private:
    std::int32_t m_Curso{};
    std::string m_Dni{};
    std::vector<Asignatura> m_Asignaturas{};
};

auto leerEstudiantes(std::vector<Estudiante>& estudiantes) -> void {
    std::int32_t total{};
    std::cout << "Entra número de estudiantes: ";
    std::cin >> total;

    estudiantes = std::vector<Estudiante>(total);

    for (auto& estudiante : estudiantes)
        estudiante.leerDatos();
}

auto mostrarMediaEstudiantes(const std::vector<Estudiante>& estudiantes) -> void {
    for (const auto& estudiante : estudiantes)
        std::cout << "Estudiante con DNI: " << estudiante.getDNI() << " tiene media: " << estudiante.mediaAsignaturas() << std::endl;
}

int main(int, char**) {
    std::vector<Estudiante> estudiantes{};
    leerEstudiantes(estudiantes);
    mostrarMediaEstudiantes(estudiantes);

    return 0;
}
