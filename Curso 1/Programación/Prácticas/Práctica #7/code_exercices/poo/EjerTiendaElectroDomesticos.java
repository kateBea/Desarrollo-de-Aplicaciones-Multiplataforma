package poo;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;

import poo.electrodomesticos.Producto;
import poo.electrodomesticos.Televisor;
import poo.electrodomesticos.Lavadora;
import poo.electrodomesticos.Microondas;

public class EjerTiendaElectroDomesticos {
    private static class Pair<Key, Value> {
        private Key m_Key;
        private Value m_Value;

        public Pair(Key key, Value val) {
            m_Key = key;
            m_Value = val;
        }

        public Key getKey() { return m_Key; }
        public Value getValue() { return m_Value; }
        public boolean equals(Pair<Key, Value> other) {
            return m_Key.equals(other.getKey()) && m_Value.equals(other.getValue());
        }
    }

    private static final Random rand = new Random();
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    public static void main(String[] args) {
        int dia = 1;
        int indiceProducto;
        int limiVentasPorDia;
        int vendidosPorDia;
        boolean liquidacionAcabada = false;
        double totalDiario;

        ArrayList<Pair<String, Producto>> productos = setupProductos();

        while (!liquidacionAcabada) {
            System.out.printf("--- DIA [%d] ---\n", dia++);

            totalDiario = 0.0;
            vendidosPorDia = 0;
            limiVentasPorDia = rand.nextInt(1, productos.size() + 1);

            // tendremos una cantidad limitada de 
            // productos que podemos vender al dia
            while (vendidosPorDia < limiVentasPorDia) {
                mostrarArticulos(productos);
                
                try {
                    System.out.printf("\n¿Qué producto desea comprar? (1 - %d)? -> ", productos.size());
                    indiceProducto = Integer.parseInt(reader.readLine());
    
                    System.out.printf("Se ha vendido %s %s por %.1f €\n",

                        productos.get(indiceProducto - 1).getKey(),
                        productos.get(indiceProducto - 1).getValue().getFabricante(), 
                        productos.get(indiceProducto - 1).getValue().getPrecio());
                    
                    totalDiario += productos.get(indiceProducto - 1).getValue().getPrecio();
                    productos.remove(indiceProducto - 1);
                    ++vendidosPorDia;

                } 
                catch (NumberFormatException | IndexOutOfBoundsException | IOException e) {
                    System.out.println("Formato de entero inválido o índice no válido. Inténtelo de nuevo.");
                }
            }

            System.out.println("\nHoy se ha vendido artículos por un total de " + totalDiario + " €\n");

            mostrarRestantes(productos);

            if (productos.isEmpty())
                liquidacionAcabada = true;
        }
    }

    public static ArrayList<Pair<String, Producto>> setupProductos() {
        ArrayList<Pair<String, Producto>> resultado = new ArrayList<>();

        resultado.add(new Pair<>("Televisor", new  Televisor("Guldo", "R43J778219GG", 322.5, 32.5f)));
        resultado.add(new Pair<>("Televisor", new  Televisor("Tracer", "T74G645482KL", 768.93, 50.0f)));
        resultado.add(new Pair<>("Televisor", new  Televisor("Vesk", "H45K363262MN", 258.4, 22.5f)));
        resultado.add(new Pair<>("Televisor", new  Televisor("Kryta", "G52V365283PA", 405.4, 40.5f)));

        resultado.add(new Pair<>("Lavadora", new Lavadora("Pimer", "J33V928049GH", 202.7, 15.5)));
        resultado.add(new Pair<>("Lavadora", new Lavadora("Bee", "Y45P426534UI", 225.7, 16.5)));
        resultado.add(new Pair<>("Lavadora", new Lavadora("Electron", "B99C120249FI", 421.7, 25.5)));

        resultado.add(new Pair<>("Microondas", new Microondas("Samsung", "H53C645149IF", 200.0, 500.0)));
        resultado.add(new Pair<>("Microondas", new Microondas("Siemens", "N64L623562GG", 250.0, 575.0)));
        resultado.add(new Pair<>("Microondas", new Microondas("Whirlpool", "O32F115946IF", 275.0, 600.0)));
        resultado.add(new Pair<>("Microondas", new Microondas("Balay", "K93D295009IF", 301.6, 900.0)));

        return resultado;
    }

    public static void mostrarArticulos(ArrayList<Pair<String, Producto>> productos) {
        int indice = 1;
        for (Pair<String, Producto> item : productos) {
            System.out.printf("%d.- %s %s %.1f €\n", 
                indice++, item.getKey(), item.getValue().getFabricante(), item.getValue().getPrecio());
        }
    }

    public static void mostrarRestantes(ArrayList<Pair<String, Producto>> productos) {
        ArrayList<Integer> indiceTelevisores = new ArrayList<>();
        ArrayList<Integer> indiceLavadoras = new ArrayList<>();
        ArrayList<Integer> indiceMicroondas = new ArrayList<>();
        int indice = 0;
        for (Pair<String, Producto> item : productos) {
            if (item.getKey().equalsIgnoreCase("Televisor"))
                indiceTelevisores.add(indice++);

            if (item.getKey().equalsIgnoreCase("Lavadora"))
                indiceLavadoras.add(indice++);

            if (item.getKey().equalsIgnoreCase("Microondas"))
                indiceMicroondas.add(indice++);
        }

        for (Integer index : indiceLavadoras) 
            System.out.printf("%s %s %.1f %.1f €\n", 
                productos.get(index).getValue().getFabricante(),
                productos.get(index).getValue().getPulgadas(),
                )
    }
}