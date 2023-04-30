import java.io.*;

/* Programa haga la media aritmética de notas
  de forma que se controle mediante excepciones 
  si el usuario introduce una letra diferente 
  a A, B, C, D y E o F (para finalizar), 
  imprimiendo un mensaje de “nota introducida no valida.*/


  public class Media {

        public static void main(String[] args) throws IOException{
            double media;
            int contador, total;
            String nota="";

            BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));


            total=0;
            contador=0;
            do{
                   
                try{

                    System.out.print ("Escriba calificación A,B, C,D, E. Teclee F para terminar  ");
                    nota = entrada.readLine().toUpperCase();
                    switch(nota){
                        case "A":
                            total=total+4;
                            contador++;
                            break;
                        case "B":
                            total=total+3;
                            contador++;
                            break;
                        case "C":
                            total=total+2;
                            contador++;
                            break;
    
                        case "D":
                            total=total+1;
                            contador++;
                            break;
                        case "E":
                            total=total+0;
                            contador++;
                            break;
                        case "F":
                            System.out.print ("Fin");
                            break;
                        default: // en caso no escriba una nota de A - F
                            throw new MiExcepcion();
                            
                    }       
                }catch (MiExcepcion me){
                    System.out.println (me.toString());
                }catch (IOException ioe){
                    System.out.println (ioe.toString());
                }


            }while (!nota.equals("F")); //la F finaliza

            if (contador!=0){
                media = (double) total / contador;
                System.out.print ("La media es: " + media);
            }else{
                System.out.print ("No se han introducido notas.");
            }

        }

  }

  class MiExcepcion extends Exception {
    public MiExcepcion (){
        super ("La nota introducida no es válida.");
    }

    public MiExcepcion (String mensaje){
        super (mensaje);
    }
  }