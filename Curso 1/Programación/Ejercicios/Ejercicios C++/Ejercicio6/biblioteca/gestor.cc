#include <cstddef>
#include <string_view>

#include <vector.hh>
#include <biblioteca/libro.hh>
#include <biblioteca/gestor.hh>
#include <biblioteca/utilidades.hh>

namespace biblio {
    gestor::~gestor() {
        for (auto& ptr : libros_) {
            delete ptr;
        }
    }

    void gestor::agregar_libro(libro* libro) {
        if (libro) {
            libros_.emplace_back(libro);
        }
    }

    void gestor::listar_libros() {
        for (const auto& libro : libros_) {
            libro->mostrar();
        }
    }

    bool gestor::buscar(std::string_view isbn) {
        libro* target{ nullptr };
        for (const auto& libro : libros_) {
            if (libro->isbn() == isbn) {
                target = libro;
                break;
            }
        }

        if (target) {
            target->mostrar();
        }

        return false;
    }

    bool gestor::eliminar(std::string_view isbn) {
        libro* target{ nullptr };
        for (const auto& libro : libros_) {
            if (libro->isbn() == isbn) {
                target = libro;
                break;
            }
        }

        // eliminar el libro
        (void)target;

        return false;
    }

    std::size_t gestor::total_libros() const {
        return libros_.size();
    }
}