package poo;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
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
    }

    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    public static void main(String[] args) {
        int dia = 0;
        int indiceProducto;                     // Índice de un producto dentro del Array
        boolean liquidacionAcabada = false;     // Controla si se han liquidado ya todos los productos
        double totalDiario;                     // Acumula las ventas diarias (ganacias)

        ArrayList<Pair<String, Producto>> productos = setupProductos();

        while (!liquidacionAcabada) {
            System.out.printf("\n--- DIA [%d] ---\n", (dia + 1));

            totalDiario = 0.0;
            indiceProducto = 0;

            // tendremos una cantidad limitada de 
            // productos que podemos vender al dia
            do {
                mostrarArticulos(productos);
                
                try {
                    System.out.printf("\n¿Qué producto desea comprar? (1 - %d)? -> ", productos.size());
                    indiceProducto = Integer.parseInt(reader.readLine());
                    
                    if (indiceProducto != -1) {
                        System.out.printf("Se ha vendido %s %s por %.1f €\n\n",
                            productos.get(indiceProducto - 1).getKey(),
                            productos.get(indiceProducto - 1).getValue().getFabricante(), 
                            productos.get(indiceProducto - 1).getValue().getPrecio());
                        
                        totalDiario += productos.get(indiceProducto - 1).getValue().getPrecio();
                        productos.remove(indiceProducto - 1);
                    }

                } 
                catch (NumberFormatException | IndexOutOfBoundsException | IOException e) {
                    System.out.println("Formato de entero inválido o índice no válido. Inténtelo de nuevo.");
                }
            }
            while (indiceProducto != -1 && !productos.isEmpty());

            System.out.println("\nHoy se ha vendido artículos por un total de " + totalDiario + " €\n");

            mostrarRestantes(productos);

            // incrementamos primero los dias
            // para aplicar el descuento y ya tenerlo
            // en la siguiente iteración
            ++dia;

            if (productos.isEmpty())
                liquidacionAcabada = true;
            else if (dia != 0 && dia % 2 == 0)
                // cada dos dias se aplica descuento
                aplicarDescuento(productos);
        }
    }

    public static void aplicarDescuento(ArrayList<Pair<String, Producto>> productos) {
        final double DESCUENTO = 0.9;
        
        for (Pair<String, Producto> item : productos) {
            item.getValue().setPrecio(item.getValue().getPrecio() * DESCUENTO);
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

        // Localizamos donde tenemos cada tipo de producto en nuestro array
        for (Pair<String, Producto> item : productos) {
            if (item.getKey().equalsIgnoreCase("Televisor"))
                indiceTelevisores.add(indice++);

            if (item.getKey().equalsIgnoreCase("Lavadora"))
                indiceLavadoras.add(indice++);

            if (item.getKey().equalsIgnoreCase("Microondas"))
                indiceMicroondas.add(indice++);
        }

        // Mostramos los televisores pendientes por vender si quedan
        System.out.println();
        if (indiceTelevisores.isEmpty())
            System.out.println("No quedan televisores por vender\n");
        else {
            System.out.printf("Quedan %d televisores\n", indiceTelevisores.size());
            for (Integer index : indiceTelevisores) {
                Televisor temp = (Televisor)productos.get(index).getValue();
                System.out.printf("%s %s %.1f pulgadas %.1f €\n", 
                    temp.getFabricante(), temp.getNumeroSerie(), temp.getPulgadas(), temp.getPrecio());
    
            }
        }

        // Mostramos las lavadoras pendientes por vender si quedan
        System.out.println();
        if (indiceLavadoras.isEmpty()) 
            System.out.println("No quedan lavadoras por vender\n");
        else {
            System.out.printf("Quedan %d lavadoras\n", indiceLavadoras.size());
            for (Integer index : indiceLavadoras) {
                Lavadora temp = (Lavadora)productos.get(index).getValue();
                System.out.printf("%s %s %.1f kg %.1f €\n", 
                    temp.getFabricante(), temp.getNumeroSerie(), temp.getCapacidad(), temp.getPrecio());
    
            }
        }

        // Mostramos los microondas pendientes por vender si quedan
        System.out.println();
        if (indiceMicroondas.isEmpty())
            System.out.println("No quedan microondas por vender\n");
        else {
            System.out.printf("Quedan %d microondas\n", indiceMicroondas.size());
            for (Integer index : indiceMicroondas) {
                Microondas temp = (Microondas)productos.get(index).getValue();
                System.out.printf("%s %s %.1f watts %.1f €\n", 
                    temp.getFabricante(), temp.getNumeroSerie(), temp.getPotencia(), temp.getPrecio());
    
            }
        } 
    }
}