package coleccion10.clases;

import java.util.HashSet;
import java.util.Random;

public class Boleto {
    private static final int LIMITE_INF = 1;
    private static final int LIMITE_SUP = 49;
    private static final int LIMITE_CASILLAS = 6;

    private static final Random rand = new Random();

    private HashSet<Integer> m_Casillas;

    public Boleto() {
        m_Casillas = new HashSet<>();

        int toAdd;
        for (int i = 0; i < LIMITE_CASILLAS; ) {
            toAdd = rand.nextInt(LIMITE_INF, LIMITE_SUP);
            if (!m_Casillas.contains(toAdd)) {
                m_Casillas.add(toAdd);
                ++i;
            }
        }
    }

    public Boleto(int[] casillas) {
        for (int item : casillas)
            m_Casillas.add(item);
    }

    // retorna falso si no se ha podido añadir una casilla
    public boolean addCasilla(int valor) {
        if (m_Casillas.size() == LIMITE_CASILLAS) 
            System.out.println("Límite de combinaciones alcanzado.");
        else if (valor < LIMITE_INF || valor > LIMITE_SUP)
            System.out.printf("Error los únicos número posibles son %d y %d, pro favor, inténtelo de nuevo", LIMITE_INF, LIMITE_SUP);
        else if (m_Casillas.contains(valor))
            System.out.printf("Error, el número %d ya está en la combinación, no se puede repetir.", valor);
        else {
            m_Casillas.add(valor);
            return true;
        }

        return false;
    }
    
    public static int getLimiteCasilla() {
        return LIMITE_CASILLAS;
    }
}
