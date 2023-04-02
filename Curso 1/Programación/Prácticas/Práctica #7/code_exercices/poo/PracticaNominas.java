package poo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import poo.nomina.Empleado;
import poo.nomina.Directivo;
import poo.nomina.JefePlanta;
import poo.nomina.JefeSeccion;
import poo.nomina.MozoAlmacen;
import poo.nomina.PersonalAdministracion;

public class PracticaNominas {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    public static void main(String[] args) {
        mostrarMenu();
        try {
            reader.readLine();
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void mostrarMenu() {
        System.out.print(
            """
                        MENÚ
                        ====

            1.- Introducir trabajador
            2.- Eliminar trabajador
            3.- Mostrar sueldo e indemnización trabajador
            4.- Ver empleados de una categoría
            5.- Salir

            Elija opción:""" + ' '
        );
    }
}