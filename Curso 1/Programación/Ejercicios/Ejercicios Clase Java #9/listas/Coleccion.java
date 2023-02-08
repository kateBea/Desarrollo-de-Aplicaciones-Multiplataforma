package listas;

import java.util.ArrayList;

import productos.Producto;

public class Coleccion {
    private static double AUMENTO = 1.10;

    ArrayList<Producto> productos = new ArrayList<>();

    public int tamanio() {
        return productos.size();
    }

    public void anadir(Producto p) {
        if (!productos.contains(p))
            productos.add(p);
    }

    public void elminar(int indice) {
        if (indice < productos.size())
            productos.remove(indice);
    }

    public Producto obtener(int indice) {
        if (indice < productos.size())
            return productos.get(indice);

        return null;
    } 

    public Producto buscar(String codigo) {
        int indice = -1;
        boolean encotrado = false;

        while (indice < productos.size() && !encotrado)
            encotrado = productos.get(++indice).getCodigo().equalsIgnoreCase(codigo);

        return encotrado ? productos.get(indice) : null;
    }
    
    public void aumentoPrecio() {
        for (Producto p : productos)
            p.setPrecio(p.getPrecio() * AUMENTO);
    }

    public void mostrar_todo() {
        System.out.println("Contenido de la lista:");
        for (Producto prod : productos) {
            System.out.println("codigo=" + prod.getCodigo());
            System.out.println("nombre=" + prod.getNombre());
            System.out.println("tipo=" + prod.getTipo());
            System.out.println("precio=" + prod.getPrecio());
            System.out.println("existencias=" + prod.getExistencias() + '\n');
        }
    }
}
