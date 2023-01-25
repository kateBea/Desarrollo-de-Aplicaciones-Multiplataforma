/* UT5: Clases y Objetos
 * Programa que prueba la clase Persona
 * donde nos crearemos varios objetos
 * e invocaremos a sus métodos
 * 
 */
package basico;
public class ProgramaPersonas {
    public static void main (String[] argumentos){
        //Paso 1: Declaro e instancio un objeto

        Persona persona1 = new Persona("Juan", 
                "Pérez", "Ruiz", 
                "123456-A", "Camarero", 28);
        
        //Paso 2: ya puedo usar el objeto persona1
        //con la sintaxis nombre_objeto.metodo_quiero(parámetros)

        System.out.print (persona1.getNombre() + " " + persona1.getApellido1());
        System.out.print (" es " + persona1.getProfesion() + " y tiene ");
        System.out.println (persona1.getEdad() + " años.");

        Persona persona2 = new Persona ("María", "Sanz", "Martín", "987654-A");
        System.out.print (persona2.getNombre() + " " + persona2.getApellido1());
        System.out.print (" es " + persona2.getProfesion() + " y tiene ");
        System.out.println (persona2.getEdad() + " años.");

        persona2.setEdad(45);

        /* OJO NO HACER persona2.edad= 45 porque
         * estaríamos accediendo a los atributos del objeto
         * de una forma directa y no estaríamos cumpliendo con
         * la ENCAPSULACIÓN
         * DEBEMOS DECLARARLOS ATRIBUTOS COMO PRIVADOS Y 
         * USAR SUS MÉTODOS CORRESPONDIENTES GET/SET
         */
        System.out.println (persona2.getEdad() + " años.");

        //Paso 3: liberar memoria
        System.runFinalization(); //cuando lo tacha es pq está desactualziado
        System.gc();


    }
    
}
