package demo12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Semaphore sem = new Semaphore(1);
		sem.release();// this method increments the permits
		System.out.println("Available permits: "+sem.availablePermits());
		sem.acquire(); // this decrements
		System.out.println("Available permits: "+sem.availablePermits());
		sem.acquire(); 
		System.out.println("Available permits: "+sem.availablePermits());
		//sem.acquire(); 
		System.out.println("Available permits: "+sem.availablePermits());
		
		Connection.getInstance().connect();
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i=0; i<200; i++) {
			executor.submit(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Connection.getInstance().connect();
				}
			});
		}
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
	}

}
