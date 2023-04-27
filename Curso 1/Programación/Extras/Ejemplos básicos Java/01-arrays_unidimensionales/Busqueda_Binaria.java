public class Busqueda_Binaria {
    public static void main (String[] argu){
        //vector
        int [] numeros = {1,2,3,4,6,7,8,9,10,15,17,20,45,51,60,68,71,75,89,98};

        int mitad;
        int limiteInferior = 0;
        int limiteSuperior = numeros.length - 1;

        boolean encontrado = false;

        int numeroBusqueda = 102;

        while ((limiteInferior <= limiteSuperior ) && (!encontrado)){
            //calculamos la posición mitad
            mitad = (limiteInferior+limiteSuperior)/2;

            if (numeros[mitad] == numeroBusqueda){ //¡encontrado!
                encontrado = true;

            }else if (numeros[mitad]>numeroBusqueda){
                //buscamos en la primera mitad
                limiteSuperior = mitad -1;
            }else {
                //buscar en segunda mitad
                limiteInferior = mitad +1;
            }
        }

        if (encontrado)
            System.out.println ("Encontrado");
        else
            System.out.println ("No encontrado");



    }
}
