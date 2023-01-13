/* 
 * 
 * 
 * @author Hugo
 * @version 1.0
 * @date 13 de enero de 2013
 * 
 * 
 */

public class Ejercicio8 {
    public static void main(String[] args) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 10; ++j) {
                System.out.printf("%d * %d = %d  |  %d * %d = %d  |  %d * %d = %d\n",
                    i + 1, j, ((i + 1) * j), i + 2, j, ((i + 2) * j), i + 3, j, ((i + 3) * j));
            }

            System.out.println();
        }
    }
}
