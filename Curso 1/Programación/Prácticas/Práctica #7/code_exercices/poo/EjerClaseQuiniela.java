package poo;

import poo.quiniela.Quiniela;

public class EjerClaseQuiniela {
    public static void main(String[] args) {
        Quiniela quiniela = new Quiniela();

        // intentamos pedir apuestas sin partidos
        quiniela.pedirApuestas();

        quiniela.mostrarApuestasyPartidos();
        quiniela.pedirPartidos();
        quiniela.mostrarPartidos();

        quiniela.pedirApuestas();
        quiniela.mostrarApuestasyPartidos();

        Quiniela quiniela2 = new Quiniela();
        quiniela2.pedirPartidos();
        quiniela2.generarApuestasAleatorias();
        quiniela2.mostrarApuestasyPartidos();
    }
}