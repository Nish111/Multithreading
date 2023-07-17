package demo1;

class Runner1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<5; i++) {
			System.out.println("Hello "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class App2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--Still using Runner1--");
		Runner1 runner1 = new Runner1();
		runner1.run();
		Runner1 runner2 = new Runner1();
		runner2.run();
		System.out.println("--Thread way---");
		Thread t1 = new Thread(new Runner1());
		t1.start();
		Thread t2 = new Thread(new Runner1());
		t2.start();
	}

}
