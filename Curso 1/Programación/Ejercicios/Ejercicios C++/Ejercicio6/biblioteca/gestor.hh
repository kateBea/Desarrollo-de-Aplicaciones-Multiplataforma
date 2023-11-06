#if !defined(BIBLIO_GESTOR_HH)
#define BIBLIO_GESTOR_HH

#include <cstddef>
#include <string_view>

#include <vector.hh>
#include <biblioteca/libro.hh>
#include <biblioteca/utilidades.hh>

namespace biblio {
    class gestor {
    public:
        explicit gestor() = default;
        ~gestor();

        void agregar_libro(libro* libro);
        void listar_libros();
        bool buscar(std::string_view isbn);
        bool eliminar(std::string_view isbn);
        std::size_t total_libros() const;

        // Por simplicidad
        DISABLE_COPY_AND_MOVE_FOR(gestor);

    private:
        kt::vector<libro*> libros_{};

    };
}

#endif