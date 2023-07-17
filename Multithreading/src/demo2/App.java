package demo2;

import java.util.Scanner;

class Processor extends Thread { // volatile keyword
	private volatile boolean running = true;
	public void run() {
		while(running) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void shutdown() {
		running = false;
	}
}
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Processor proc = new Processor();
		proc.start();
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		proc.shutdown();
	}

}
