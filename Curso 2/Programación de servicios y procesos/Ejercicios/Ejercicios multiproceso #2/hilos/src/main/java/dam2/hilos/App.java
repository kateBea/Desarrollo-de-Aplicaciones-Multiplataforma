package dam2.hilos;

import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class App 
{
	private static class Worker extends Thread {
		private int mLowerBound;
		private int mUpperBound;
		private int mSum;
		
		public Worker(int low, int up) {
			mLowerBound = low;
			mUpperBound = up;
		}
		
		@Override
		public void run() {
			mSum = IntStream.range(mLowerBound, mUpperBound + 1).sum();
			
			System.out.println(mSum);
		}
		
		public int sum() {
			return mSum;
		}
	}
	
    public static void main( String[] args )
    {
        Worker w1 = new Worker(1, 100);
        Worker w2 = new Worker(101, 200);
        
        w1.start();
        w2.start();
        
        try {
			w1.join();
			w2.join();
			
			System.out.println(w1.sum() + w2.sum());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
