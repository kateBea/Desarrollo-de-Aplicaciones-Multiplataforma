#if !defined(BIBLIO_LIBRO_HH)
#define BIBLIO_LIBRO_HH

#include <string>
#include <iostream>
#include <string_view>

namespace biblio {
    class libro {
    public:
        libro(std::string_view titulo, std::string_view autor, std::string_view isbn, int anio)
            :   titulo_{ titulo }, autor_{ autor }, isbn_{ isbn }, anio_publicacion_{ anio }
        {

        } 

        [[nodiscard]] const std::string& titulo() const { return titulo_; }
        [[nodiscard]] const std::string& autor() const { return autor_; }
        [[nodiscard]] const std::string& isbn() const { return isbn_; }
        [[nodiscard]] int publicacion() const { return anio_publicacion_; }

        void mostrar() const { std::cout << "titulo: " << titulo_ << " autor: " << autor_ << 
                                " isbn: " << isbn_ << " año publicación: " << anio_publicacion_ << std::endl; }

    private:
        std::string titulo_;
        std::string autor_;
        std::string isbn_;
        int anio_publicacion_;
    };
}

#endif