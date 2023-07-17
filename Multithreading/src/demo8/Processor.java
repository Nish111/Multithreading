package demo8;

import java.util.Scanner;

public class Processor {
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread running");
			wait();// waits resource efficient and can be called in sync block only
			System.out.println("Resumed");
		}
	}
	public void consume() throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		Thread.sleep(2000);
		synchronized (this) {
			System.out.println("Waiting for return key");
			scan.nextLine();
			System.out.println("Return key pressed");
			notify();
			Thread.sleep(5000);
		}
	}

}
