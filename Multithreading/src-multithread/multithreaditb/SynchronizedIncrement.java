package multithreaditb;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedIncrement {

	private static int counter;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<Thread> allThreads = new ArrayList<>();
		int numberOfIncrements = 10000;
		for(int i=0; i<numberOfIncrements; i++) {
			var t = new Thread(SynchronizedIncrement::increment);
			allThreads.add(t);
			t.start();
		}
		for(Thread thread: allThreads) {
			thread.join();
		}
		System.out.println(counter);
	}
	public synchronized static void increment() {
		counter++;
	}
	public static void incrementWithSyncBlock() {
		synchronized (SynchronizedIncrement.class) {
			counter++;
		}
	}
}
