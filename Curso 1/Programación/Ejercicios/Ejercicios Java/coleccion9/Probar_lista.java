package coleccion9;


import java.util.Scanner;

import coleccion9.listas.*;
import coleccion9.productos.Producto;

public class Probar_lista {
    public static void main(String[] args) {
        Coleccion milista = new Coleccion();
        String codigo;
        String nombre;
        String tipo;
        double precio;
        int existencias;
        Producto aux;
        Scanner sc = new Scanner(System.in);
        String cad;
        System.out.println("Introduce productos, un dato por línea. código 0 para FIN: ");

        //Inserta aquí el código necesario para meter los datos desde teclado.
        do {
            System.out.print("\ncodigo=");
            codigo = "";
            cad = sc.nextLine();
            
            if (cad.equalsIgnoreCase("0"))
                break;

            if (!cad.equalsIgnoreCase("0")) {
                codigo = cad;

                System.out.print("nombre=");
                cad = sc.nextLine();
                nombre = cad;

                System.out.print("tipo=");
                cad = sc.nextLine();
                tipo = cad;

                System.out.print("precio=");
                cad = sc.nextLine();
                precio = Double.parseDouble(cad);

                System.out.print("existencias=");
                cad = sc.nextLine();
                existencias = Integer.parseInt(cad);


                aux = new Producto(codigo, nombre, tipo, precio, existencias);
                milista.anadir(aux);
            }
        }
        while (!codigo.equalsIgnoreCase("0"));

        //Inserta aquí las llamadas a los métodos que resuelven los puntos 2,3,4

        System.out.println("\nANTES DE AUMENTO ---------------");
        milista.mostrar_todo();
        milista.aumentoPrecio();

        System.out.println("\nDESPUÉS DE AUMENTO ---------------");
        milista.mostrar_todo();

        sc.close();
    }
}//de la clase