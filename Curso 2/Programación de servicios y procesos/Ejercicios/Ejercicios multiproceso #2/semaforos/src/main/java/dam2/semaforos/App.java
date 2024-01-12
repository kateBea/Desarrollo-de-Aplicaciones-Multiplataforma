package dam2.semaforos;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Semaphore;

/**
 * Hello world!
 *
 */
public class App 
{	
	private static int contadorComun = 0;
	public static class Semaforo {
		private static Optional<Semaphore> semaphore = Optional.empty();
		
		public static Semaphore get() {
			if (semaphore.isEmpty()) {
				semaphore = Optional.of(new Semaphore(10));
			}
			
			return semaphore.get();
		}
	}
	
	public static class Cliente extends Thread {
		
		@Override
		public void run() {
			System.out.println("Accediendo a caja");
			
			try {
				Semaforo.get().acquire();
				++contadorComun;
				
				System.out.println("Contador: " + contadorComun);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			Semaforo.get().release();
		}
	}
	
    public static void main( String[] args )
    {
    	List<Thread> clientes = new LinkedList<Thread>();
    	
        for (int count = 0; count < 100; ++count) {
        	clientes.add(new Cliente());
        }
        
        for (Thread cliente : clientes) {
        	cliente.start();
        }
        
        for (Thread cliente : clientes) {
        	try {
				cliente.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
}
