import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/** 
 * Este programa es un simuldor de una calculadora. Pide al usuario por la
 * entrada de datos un operador y tantos operandos como sea necesario. Al acabar un cómputo
 * le pregunta al usuario si éste quiere seguir realizando más operaciones. Las 
 * operaciones admitidas son: suma, resta, multiplicación y división.
 * 
 * @author Hugo
 * @version 1.0
 */
public class EjerExcep2 {
    public static class InvalidOperatorException extends Exception {
        public InvalidOperatorException(String msg) {
            super(msg);
        }
    }
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args) {
        calculadora();
    }

    /**
     * Realiza los operaciones principales de calculadora
     */
    public static void calculadora() {
        double operando1;
        double operando2;
        char operador;

        try {
            mostrarOperaciones();

            System.out.print("Selección: ");
            operador = lector.readLine().charAt(0);

            if (operador != 'Z') {
                if (!isValidOperator(operador))
                    throw new InvalidOperatorException("Operador no válido");
                else {
                    operando1 = leerOperando();
                    operando2 = leerOperando();
    
                    // calcular y mostrar resultados
                    mostrarResultado(operando1, operando2, operador);
                }
            }
            else 
                System.out.println("Finalizando programa.");
        }
        catch (InvalidOperatorException iop) {
            System.out.println(iop.getMessage());
            iop.printStackTrace();
        }
        catch (IOException io) {
            System.out.println(io.getMessage());
            io.printStackTrace();
        } 
    }

    /**
     * Retorna cierto si el carácter representa un operador válido.
     * Falso en caso contrario.
     * @param operador el carácter a ser evaluado
     * @return cierto si el carácter representa un operador, 
     * falso en caso contrario

     */
    public static boolean isValidOperator(char op) {
        return switch(op) {
            case '+', '-', '*', '/' -> true;
            default -> false;
        };
    }

    /**
     * Muestra por pantalla de manera formateada una seria de operaciones.
     */
    public static void mostrarOperaciones() {
        System.out.println("Posibles operaciones:");
        System.out.println("1. Para la suma introduzca ( + )");
        System.out.println("2. Para la resta introduzca ( - )");
        System.out.println("3. Para la multiplicación introduzca ( * )");
        System.out.println("4. Para la división introduzca ( / )");
        System.out.println("5. Finalizar programa (Introuzca la letra Z)");
    }

    /**
     * Lee un número real con doble precisión por la entrada de datos
     * @return double número real leído
     */
    public static double leerOperando() {
        boolean operandoValido;
        double resultado;
        do {
            try {
                System.out.print("Introduzca el operando: ");
                resultado = Double.parseDouble(lector.readLine());
                operandoValido = true;
            }
            catch (IOException io) {
                System.out.println(io.getMessage());
                operandoValido = false;
                resultado = 0.0;
            }
        }
        while (!operandoValido);

        return resultado;
    }

    /**
     * Dados dos número reales y un operador, muestra por pantalla
     * el resultado de realizar la operación indicada por el operador usando
     * los operandos propuestos.
     * @param op1 valor del primer operando
     * @param op2 valor del segundo operando
     * @param op carácter representando un operador binario
     */
    public static void mostrarResultado(double op1, double op2, char op) {
        double resultado = 0;

        if (op2 == 0.0 && op == '/')
            System.out.println("No se puede realizar la operación. Divisor nulo.");
        else {
            switch (op) {
                case '+' -> resultado = op1 + op2;
                case '-' -> resultado = op1 - op2;
                case '*' -> resultado = op1 * op2;
                case '/' -> resultado = op1 / op2;
            }
            System.out.printf("El resultado de [%.3f %c %.3f] es : %.3f\n", op1, op, op2, resultado);
        }
    }
}