#ifndef ESTUDIANTE_HH
#define ESTUDIANTE_HH


#include <string>
#include <stdexcept>
#include <utility>
#include <vector>
#include <string_view>

#include <Nota.hh>

class Estudiante {
public:
    Estudiante(std::string_view dni, std::string_view nombre, std::string_view ap1, std::string_view ap2 = "null")
        :   m_Dni{ dni }, m_Nombre{ nombre }, m_PrimerApellido{ ap1 }, m_SegundoApellido{ ap2 }
    {}

    bool equals(const Estudiante& other) const {
        return m_Dni == other.getDni();
    }

    const std::string& getDni() const { return m_Dni; }
    const std::string& getNombre() const { return m_Nombre; }
    const std::string& getPrimerApellido() const { return m_PrimerApellido; }
    const std::string& getSegundoApellido() const { return m_SegundoApellido; }

    void setDni(std::string_view dni);
    void setNombre(std::string_view nombre);
    void setPrimerApellido(std::string_view ap1) ;
    void setSegundoApellido(std::string_view ap2);

    void mostrar();
    void leer();
    void addNota(const Nota& nota);
    void addNota(std::string_view asignatura, double punt);
private:
    std::string m_Dni{};
    std::string m_Nombre{};
    std::string m_PrimerApellido{};
    std::string m_SegundoApellido{};

    int m_Edad{};
    std::vector<Nota> m_Notas;
    std::string m_Curso{};
};

#endif