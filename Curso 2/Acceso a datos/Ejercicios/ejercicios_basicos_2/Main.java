package ejercicios_basicos_2;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.Comparator;
import utilidades.FormattedIO;

/**
 * Este programa muestra por pantalla la referencia y precio de los productos
 * no perecederos más caros que un valor introducido por el usuario. Los productos
 * se muestran en orden ascedente por precio
 * 
 * @author Hugo Pelayo
 * */
public class Main {
    // Mostrar por pantalla la referencia y el precio de los productos
    // más caros de un valor introducido por el usuario no perecederos ordenados por precio
    public static class MostrarProductos implements Consumer<Producto> {
        @Override
        public void accept(Producto producto) {
            System.out.println(producto);
            System.out.println("-----------------\n");
        }
        
    }

    public static class Ordenar implements Comparator<Producto> {
        @Override
        public int compare(Producto arg0, Producto arg1) {
            return Double.compare(arg0.getPrecio(), arg1.getPrecio());
        }
        
    }

    public static class FiltroEliminacion implements Predicate<Producto> {
        private double precioFiltro;

        public FiltroEliminacion(double precio) {
            this.precioFiltro = precio;
        }

        @Override
        public boolean test(Producto arg0) {
            return arg0.getPrecio() > precioFiltro && !arg0.isPerecedero();
        }

    }

    public static void main(String[] args) {
        double precioFiltro;
        final Consumer<Producto> impresora = new MostrarProductos();
        final Comparator<Producto> comparador = new Ordenar();
        Predicate<Producto> filtro;

        List<Producto> productos = new ArrayList<>(); 

        productos.add(new Producto(14.77, false));  
        productos.add(new Producto(5.33, true)); 
        productos.add(new Producto(12.45, false)); 
        productos.add(new Producto(7.44, true)); 
        productos.add(new Producto(22.65, true));
        productos.add(new Producto(8.65, false));  
        
        System.out.println("Lista de productos original");
        productos.forEach(impresora);

        precioFiltro = Double.parseDouble(FormattedIO.leerCadena("Introduce un precio de referencia: "));
        filtro = new FiltroEliminacion(precioFiltro);
        
        System.out.println("\nLista ordenada con filtro");
        productos.removeIf(filtro);
        productos.sort(comparador);
        productos.forEach(
            new Consumer<Producto>() {
                @Override
                public void accept(Producto producto) {
                    System.out.println("Referencia: " + producto.getReferencia());
                    System.out.println("Precio: " + producto.getPrecio());
                    System.out.println("-----------------\n");
                }
            }
        );
        
        // Extra: incrementar 10% el precio de los productos que cuestan menos de 10 euros
        productos.forEach(new Consumer<Producto>() {
            @Override
            public void accept(Producto producto) {
                final float INCREMENTO = 1.1f; // aumento de 10%
                final float PRECIO_FILTRO = 10.0f; // aumento de 10%

                if (producto.getPrecio() < PRECIO_FILTRO) {
                    producto.setPrecio(producto.getPrecio() * INCREMENTO);
                }
            }
        });

        System.out.println("\nProductos después aumento de 10% en el precio");
        productos.forEach(impresora);
    }
}
