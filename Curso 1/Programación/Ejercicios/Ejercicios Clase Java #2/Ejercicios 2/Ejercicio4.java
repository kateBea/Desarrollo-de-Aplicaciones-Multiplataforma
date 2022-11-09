/* Título: Ejercicio 4
 * Algoritmo: Uso de enumeradores
 * Fecha: 08.11.2022
 * Autor: Hugo
 */

enum EntradasMuseo {
    ESTUDIANTE,
    NORMAL,
    SENIOR,
    DISCAPACITADO,
    INVESTIGADOR,
};

enum Pizzas {
    MARGARITA,
    BARBACOA,
    CAPRICHOSA,
    CUATRO_QUESOS,
    VEGETAL,
    AL_GUSTO,
};

enum TipoAlcance {
    LOCAL,
    COMARCAL,
    AUTONOMICO,
    NACIONAL,
    INTERNACIONAL,
};

public class Ejercicio4 {
    EntradasMuseo entrada = EntradasMuseo.DISCAPACITADO;
    Pizzas pizza = Pizzas.CUATRO_QUESOS;
    TipoAlcance tipoAlc = TipoAlcance.LOCAL;
}
