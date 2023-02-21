/**
 * Clase Ejercicio 1 
 * 
 * Representa una cuenta
 * 
 * @author Hugo Pelayo
 */


import java.time.LocalDate;
import java.util.ArrayList;

public class Cuenta {
    private String numero;
    private double saldo;
    private LocalDate apertura;
    private ArrayList<String> titulares;

    public Cuenta(String numero, ArrayList<String> titulares) {
        this.numero = numero;
        this.saldo = 0.0;
        this.apertura = LocalDate.now();
        this.titulares = (titulares == null) ? new ArrayList<>() : titulares;
    }

    public Cuenta(String numero, double saldo, ArrayList<String> titulares) {
        this.numero = numero;
        // si el saldo es negativo se inicia a 0
        this.saldo = (saldo < 0.0) ? 0.0 : saldo;
        this.apertura = LocalDate.now();
        this.titulares = (titulares == null) ? new ArrayList<>() : titulares;;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public LocalDate getApertura() {
        return apertura;
    }

    public void setApertura(LocalDate apertura) {
        this.apertura = apertura;
    }
    public ArrayList<String> getTitulares() {
        return titulares;
    }

    public void setTitulares(ArrayList<String> titulares) {
        this.titulares = titulares;
    }

    public void ingresar(double cantidad) {
        // comprobar no negativo
        // valores negativos sustrairían saldo de nuestra cuenta
        if (cantidad > 0.0)
            this.saldo += cantidad;
    }

    public boolean sacar(double cantidad) {
        boolean exito = true;
        if (cantidad > 0.0 && cantidad <= this.saldo) {
            
            // cantidad restante en la cuenta
            saldo -= cantidad;
        }
        else if (cantidad > this.saldo) {
            System.out.println("Cantidad a extraer supera el saldo actual.");
            exito = false;
        }

        return exito;
    }

    public double consultar() {
        return this.saldo;
    }
    
}
