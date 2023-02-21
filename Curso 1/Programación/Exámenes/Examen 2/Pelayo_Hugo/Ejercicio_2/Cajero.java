/**
 * Clase Ejercicio 2
 * 
 * Realiza pruebas sobre la clase Cuenta creada en el ejercicio 1
 * 
 * @author Hugo Pelayo
 */

import java.io.*;
import java.util.ArrayList;

public class Cajero {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args) throws IOException{
        int opcion;
        double cantidadAProcesar;
        Cuenta cuenta = null;

        do {
            mostrarMenu();
            System.out.print("-> ");
            opcion = leerOpcion();

            switch (opcion) {
                case 1 -> cuenta = crearCuentaACero();
                case 2 -> cuenta = crearCuentaNoACero();
                case 3 -> {
                    if (cuenta == null)
                        System.out.println("Necesita crear una cuenta.");
                    else {
                        System.out.print("Introduzca cantidad a ingresar: ");
                        cantidadAProcesar = Double.parseDouble(lector.readLine());
                        cuenta.ingresar(cantidadAProcesar);
                    }
                }
                case 4 -> {
                    if (cuenta == null)
                        System.out.println("Necesita crear una cuenta.");
                    else {
                        System.out.print("Introduzca cantidad a extraer: ");
                        cantidadAProcesar = Double.parseDouble(lector.readLine());

                        if (cuenta.sacar(cantidadAProcesar))
                            System.out.println("Se extrajo: " + cantidadAProcesar);
                            
                    }
                }
                case 5 -> {
                    if (cuenta == null)
                        System.out.println("Necesita crear una cuenta.");
                    else {
                        System.out.println("Saldo restante: " + cuenta.consultar());
                    }
                }
            }
        }
        while (opcion != 6);
    }

    public static void mostrarMenu() {
        System.out.println("1.- Crear cuenta con saldo 0.");
        System.out.println("2.- Crear cuenta con saldo incial.");
        System.out.println("3.- Ingresar dinero.");
        System.out.println("4.- Sacar dinero.");
        System.out.println("5.- Ver saldo");
        System.out.println("6.- Salir.");
    }

    public static int leerOpcion() throws IOException{
        int resultado;

        while ((resultado = Integer.parseInt(lector.readLine())) < 1 || resultado > 6)
            System.out.print("Índice no válido: \n-> ");

        return resultado;
    }

    public static Cuenta crearCuentaACero() throws IOException {
        String numeroCuenta;
        String nombreTitular;
        ArrayList<String> titulares = new ArrayList<>();

        System.out.print("Por favor ingrese un número de cuenta: ");
        numeroCuenta = lector.readLine();

        System.out.println("Por favor introduzca los titulares de la cuenta (acabe lista en '-')");

        do {
            System.out.print("Titular: ");
            nombreTitular = lector.readLine();

            if (!nombreTitular.equals("-"))
                titulares.add(nombreTitular);
        }   
        while (!nombreTitular.equals("-"));


        return new Cuenta(numeroCuenta, titulares);
    }

    public static Cuenta crearCuentaNoACero() throws IOException {
        String numeroCuenta;
        String nombreTitular;
        double saldoInicial;
        ArrayList<String> titulares = new ArrayList<>();

        System.out.print("Por favor ingrese un número de cuenta: ");
        numeroCuenta = lector.readLine();

        System.out.println("Por favor introduzca los titulares de la cuenta (acabe lista en '-')");

        do {
            System.out.print("Titular: ");
            nombreTitular = lector.readLine();

            if (!nombreTitular.equals("-"))
                titulares.add(nombreTitular);
        }   
        while (!nombreTitular.equals("-"));

        System.out.print("Entre el valor de saldo inicial: ");
        saldoInicial = Double.parseDouble(lector.readLine());

        return new Cuenta(numeroCuenta, saldoInicial, titulares);
    }
}
