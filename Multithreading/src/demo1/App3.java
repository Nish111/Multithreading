package demo1;

public class App3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--Thread way---");
		Thread t1 = new Thread(new Runnable() {
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
		});
		t1.start();
	}

}
