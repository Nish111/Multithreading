package multithreaditb;

import java.util.ArrayList;
import java.util.List;

public class NonSynchronizedIncrement {

	private static int counter;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<Thread> allThreads = new ArrayList<>();
		int numberOfIncrements = 10000;
		for(int i=0; i<numberOfIncrements; i++) {
			var t = new Thread(NonSynchronizedIncrement::increment);
			allThreads.add(t);
			t.start();
		}
		for(Thread thread: allThreads) {
			thread.join();
		}
		System.out.println(counter);
	}
	public static void increment() {
		counter++;
	}
}
