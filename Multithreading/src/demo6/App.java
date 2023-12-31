package demo6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
	private CountDownLatch latch;
	
	public Processor(CountDownLatch latch) {
		this.latch = latch;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Started");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println("One latch down");
	}
	
}
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService executor = Executors.newFixedThreadPool(1);
		for(int i=0; i<3; i++) {
			executor.submit(new Processor(latch));
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed");
	}

}
