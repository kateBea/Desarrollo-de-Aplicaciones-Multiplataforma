
import java.util.*;
public class Competicion {
    
    public static short muestraMenu(){
        short opcion;
        Scanner sc = new Scanner(System.in);
        System.out.println ("1. Nuevo participante");
        System.out.println ("2. Borrar participante");
        System.out.println ("3. Listado participanes");
        System.out.println ("4. Listado participantes ordenados por dorsal");
        System.out.println ("5. Finalizar programa");

        opcion = (short) sc.nextInt();
        return opcion;
    
    }

    public static Jugador dameDatosJugador(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.print("Nº dorsal: ");
        int dorsal = sc.nextInt();
        System.out.println("Posicion: ");
        int posicion = sc.nextInt();

        return new Jugador (dorsal, nombre, posicion);
            
    }

    public static Integer[] keysOrdenadas (Hashtable<Integer, Jugador> ht){
        Enumeration <Integer> lista = ht.keys();
        int cont =0;
        Integer ordenado[] = new Integer[ht.size()];
        while (lista.hasMoreElements()){
            ordenado[cont] = lista.nextElement();
            cont++;
        }
        int aux;
        boolean b = false; //desordenado
        for (int i = ordenado.length -2; i>=0 && b== false; i--){
            b=true;
            for (int j=0; j<=i;j++){
                if (ordenado[j]>ordenado[j+1]){
                    aux = ordenado[j];
                    ordenado[j]= ordenado[j+1];
                    ordenado[j+1]=aux;
                    b=false;
                }
            }

        }
        return ordenado;

    }
    public static void main(String[] args) {
        Hashtable<Integer, Jugador> tabla = new Hashtable();
        Scanner sc = new Scanner(System.in);
        short opcion;

        do{
            opcion = muestraMenu();
            switch (opcion){

                case 1:{
                    //alta nuevo participante
                    Jugador jugador = dameDatosJugador();
                    int clave = jugador.getDorsal();

                    if (!tabla.containsKey(clave)){
                        //no exixte lo damos de alta
                        tabla.put(clave, jugador);
                    }else{
                        System.out.println ("No se ha dado de alta. Dorsal repetido");
                    }
                    break;

                } 
    
    
                case 2:{
                    System.out.print ("Indica el nº dorsal: ");
                    int dorsal = sc.nextInt();
                    if (tabla.containsKey(dorsal)){
                        tabla.remove(dorsal); //si existe lo borro
                        System.out.println ("Jugador borrado");
                    }else {   
                        System.out.println ("No se ha borrado porque no existe");
                    }
                    break;
                }
    
                case 3:
                { //mostrar todos participantes
                    int clave;
                    Jugador valor;
                    System.out.println (tabla);
                    Enumeration<Integer> lista = tabla.keys();
                    System.out.println ("\nJugadores ");
                    while (lista.hasMoreElements()){
                        clave = lista.nextElement();
                        valor = (Jugador) tabla.get(clave);
                        System.out.println(valor.toString());
                    }
                    break;

                }

                case 4:{
                    //mostrar lista ordenada
                    Integer lista[] = keysOrdenadas(tabla);
                    Jugador valor;
                    System.out.println ("Jugadores: ");
                    for (int i=0; i<lista.length;i++){
                        valor = (Jugador) tabla.get(lista[i]);
                        System.out.println (valor.toString());
                    }
                    break;

                }
                default:
                    //lanzar excepcion
                    break;
    

            }
        }while (opcion!=5);
    }
}
