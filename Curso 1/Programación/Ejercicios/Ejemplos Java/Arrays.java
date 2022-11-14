public class Arrays {
    public static void main(String[] args) {
        final int limite =  10;
        char[] letras = new char[limite];

        for (int contador = 0; contador < limite; ++contador)
            letras[contador] = (char)((contador) + 'a');

        for (char c : letras)
            System.out.print(c + " ");

    }
}
