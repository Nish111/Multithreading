package demo10;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	private int count=0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	private void increment() {
		for(int i=0; i<1000; i++)
			count++;

	}
	public void firstThread() throws InterruptedException {
		lock.lock();
		System.out.println("Waiting");
		cond.await();
		System.out.println("Woken up");
		try {
			increment();
		} finally {
			lock.unlock();
		}
		System.out.println("Exiting first thread method");
	}
	public void secondThread() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();
		System.out.println("Press the return key");
		new Scanner(System.in).nextLine();
		System.out.println("Got the return key");
		cond.signal();
		try {
			increment();
		} finally {
			lock.unlock();
		}
		System.out.println("Exiting second thread method");
	}
	public void finished() {
		System.out.println("Count is: "+ count);
	}
}
