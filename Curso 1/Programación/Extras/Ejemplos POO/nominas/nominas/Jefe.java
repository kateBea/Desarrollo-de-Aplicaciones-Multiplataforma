//Jefe.java subclase de Empleado
package nominas;
public final class Jefe extends Empleado{
    private double salarioSemanal;

    /**
     * Método constructor del Empleado tipo Jefe, que crea objetos jefe con 
     * valores para todos sus parámetros
     * @param nombre Nombre del jefe
     * @param apellidos Apellidos del jefe
     * @param identificador Identificador del jefe
     * @param sexo Sexo del Jefe 'H' hombre, 'M' mujer, '?' desconocido
     * @param tfno Tfno del jefe
     * @param email Email del jefe
     * @param salarioSemanal Salario semanal del jefe
     */
    public Jefe (String nombre, String apellidos, 
                String identificador, Character sexo,
                String tfno, String email, double salarioSemanal ){
                    //llamamos a la super clase que es Empleado para inicializar sus valores
                super (nombre, apellidos, identificador, sexo, tfno, email);
                this.salarioSemanal = salarioSemanal;    

    }

    /**
     * Método constructor crea objetos tipo Jefe con los valores
     * de nombre, apellidos, identificador y salario semanal
     * @param nombre Nombre del jefe
     * @param apellidos Apellidos del jefe
     * @param identificador Identificador del jefe
     * @param salarioSemanal Salario semanal del jefe
     */
    public Jefe (String nombre, String apellidos, String identificador,
                double salarioSemanal){
                 super (nombre, apellidos, identificador);
                 this.salarioSemanal=salarioSemanal;
                }

    public double getSalarioSemanal() {
        return salarioSemanal;
    }

    /**
     * 
     * @param salarioSemanal
     */
    public void setSalarioSemanal(double salarioSemanal) {
        this.salarioSemanal = salarioSemanal;
    }

    @Override
    public String toString() {
        return "Jefe [salarioSemanal=" + salarioSemanal + "]";
    }

    @Override
    double sueldo() {
        // TODO Auto-generated method stub
        return salarioSemanal;
    }


    
}
