package excepciones1;

public class EjerDos {
    private static int metodo() {
        int valor = 0;
        try {
            valor = valor + 1;
            valor = valor + Integer.parseInt("H");
            valor = valor + 1;
            System.out.println("Se acaba el try con valor: " + valor);
        } catch (NumberFormatException e) {
            valor = valor + Integer.parseInt("20");
            System.out.println("Se acaba el catch con valor: " +
                    valor);
        } finally {
            valor = valor + 1;
            System.out.println("Se acaba el finally con valor: " +
                    valor);
        }
        valor = valor + 1;
        System.out.println("Se sale del método con valor: " + valor);
        return valor;
    }

    public static void main(String[] args) {
        try {
            System.out.println(metodo());
        } catch (Exception e) {
            System.err.println("Excepción en metodo()");
            e.printStackTrace();
        }
    }
}
