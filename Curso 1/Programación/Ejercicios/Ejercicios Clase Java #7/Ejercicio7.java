import java.io.*;

public class Ejercicio7 {
    public static void main(String[] args) throws IOException {
        gestor();
    }

    public static void gestor() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);

        System.out.println("********** BIENVENIDO A GESTOR DE PERSONAS **********");
        System.out.print("¿Cuántas personas deseas registrar? ");
        limitePersonas = Integer.parseInt(lector.readLine());
    }

    public static void ordenar(int[] array) {
        ordenar(array, 0, array.length - 1);
    }

    static void ordenar(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            ordenar(array, left, mid);
            ordenar(array, mid + 1, right);
            ordenar(array, left, mid, right);
        }
    }

    static void ordenar(int[] array, int left, int mid, int right) {
        int newSize = (right - left) + 1;
        int idxSubvectorIzq = left;
        int idxSubvectorDer = mid + 1; 
        int idxArrayAuxiliar = 0;

        int[] arrayAuxiliar = new int[newSize];

        while (idxSubvectorIzq <= mid && idxSubvectorDer <= right) {
            if (array[idxSubvectorIzq] <= array[idxSubvectorDer])
                arrayAuxiliar[idxArrayAuxiliar++] = array[idxSubvectorIzq++];
            else 
                arrayAuxiliar[idxArrayAuxiliar++] = array[idxSubvectorDer++];
        }

        if (idxSubvectorIzq <= mid)
            System.arraycopy(array, idxSubvectorIzq, arrayAuxiliar, idxArrayAuxiliar, (mid - idxSubvectorIzq) + 1);
        if (idxSubvectorDer <= right)
            System.arraycopy(array, idxSubvectorDer, arrayAuxiliar, idxArrayAuxiliar, (right - idxSubvectorDer) + 1);

        System.arraycopy(arrayAuxiliar, 0, array, 0 + left, newSize);
    }

    public static boolean orden() {

    }
}