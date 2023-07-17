package demo5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
	private int id;
	public Processor(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Starting: "+id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed: "+id);
	}
	
}
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for(int i=0; i<5; i++) {
			executor.submit(new Processor(i));
		}
		executor.shutdown(); // it will wait until all threads are done work and then
		System.out.println("All tasks submitted");
		try {
			executor.awaitTermination(5, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All tasks completed");
	}

}
