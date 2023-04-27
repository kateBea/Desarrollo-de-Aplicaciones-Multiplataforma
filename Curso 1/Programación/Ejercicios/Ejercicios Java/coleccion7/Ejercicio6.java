package coleccion7;

/* 
 * Este programa es un simuldor de una calculadora. Pide al usuario por la
 * entrada de datos un operador y tantos operandos como sea necesario. Al acabar un cómputo
 * le pregunta al usuario si éste quiere seguir realizando más operaciones. Las 
 * operaciones admitidas son: suma, resta, multiplicación, división, potencia
 * y raíz cuadrada.
 * 
 * @author Hugo
 * @version 1.0
 * @date 14 de enero de 2023
 */

import java.io.*;

public class Ejercicio6 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);
    public static void main(String[] args) throws IOException {
        calculadora();
    }

    /*
     * Realiza los operaciones principales de calculadora
     * 
     * @param None
     * @return void
     * @author Hugo
     */
    public static void calculadora() throws IOException {
        double operando1 = 0;
        double operando2 = 0;
        char operador = ' ';

        String comando = "";

        do {
            // listar las posibles operaciones
            mostrarOperaciones();

            // leer el operador junto con los operandos
            System.out.print("Selección: ");
            operador = lector.readLine().charAt(0);

            if (!esValido(operador)) {
                System.out.println("El operador no es válido. Inténtelo de nuevo.");
                continue;
            }

            operando1 = leerOperando();

            // raíz cuadrada sólo necesita un operando
            if (operador != 's')
                operando2 = leerOperando();

                // calcular y mostrar resultados
            calcularResultado(operando1, operando2, operador);

            System.out.print("¿Salir? [Sí/No]: ");
            comando = lector.readLine();
        }
        while (!(comando.equals("Sí") || comando.equals("S") || comando.equals("s")));
    }

    /*
     * Muestra por pantalla de manera formateada una seria de operaciones.
     * 
     * @param None
     * @return void
     * @author Hugo
     */
    public static void mostrarOperaciones() {
        System.out.println("Posibles operaciones:");
        System.out.println("1. Para la suma introduzca ( + )");
        System.out.println("2. Para la resta introduzca ( - )");
        System.out.println("3. Para la multiplicación introduzca ( * )");
        System.out.println("4. Para la división introduzca ( / )");
        System.out.println("4. Para la potencia introduzca ( p )");
        System.out.println("4. Para la raíz cuadrada introduzca ( s )");
    }

    /*
     * Lee un número real con doble precisión por la entrada de datos
     * 
     * @param None
     * @return double número real leído
     * @author Hugo
     */
    public static double leerOperando() throws IOException{
        System.out.print("Introduzca el operando: ");
        return Double.parseDouble(lector.readLine());
    }

    /*
     * Dados dos número reales y un operador, muestra por pantalla
     * el resultado de realizar la operación indicada por el operador usando
     * los operandos propuestos.
     * 
     * @param op1 valor del primer operando
     * @param op2 valor del segundo operando
     * @param op carácter representando un operador binario
     * @return void
     * @author Hugo
     */
    public static void calcularResultado(double op1, double op2, char op) {
        double resultado = 0;

        if (op2 == 0.0 && op == '/')
            System.out.println("No se puede realizar la operación. Divisor nulo.");
        else {
            switch (op) {
                case '+' -> resultado = op1 + op2;
                case '-' -> resultado = op1 - op2;
                case '*' -> resultado = op1 * op2;
                case '/' -> resultado = op1 / op2;
                case 'p' -> resultado = Math.pow(op1, op2);

                // se ignora el segundo operando en caso de tratarse de una raíz cuadrada
                case 's' -> resultado = Math.sqrt(op1);
            }

            if (op == 's')
                System.out.printf("El resultado de la raíz cuadrada de [%.3f] es: %.3f\n", op1, resultado);
            else if (op == 'p')
                System.out.printf("El resultado de [%.3f] elevado a [%.3f] es: %.3f\n", op1, op2, resultado);
            else 
                System.out.printf("El resultado de [%.3f] %c [%.3f] es: %.3f\n", op1, op, op2, resultado);
        }
    }

    /*
     * Retorna cierto si el carácter representa un operador válido.
     * Falso en caso contrario.
     * 
     * @param operador el carácter a ser evaluado
     * @return boolean cierto si el carácter representa un operador, falso en caso contrario
     * @author Hugo
     */
    public static boolean esValido(char operador) {
        return switch(operador) {
            case '+', '-', '*', '/', 'p', 's' -> true;
            default -> false;
        };
    }
}