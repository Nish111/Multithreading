package multithreaditb;

import java.text.MessageFormat;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message message = new Message("process it");
		Reader reader1 = new Reader(message);
		new Thread(reader1, "READER 1").start();
		
		Reader reader2 = new Reader(message);
		new Thread(reader2, "READER 2").start();
		
		Notifier notifier = new Notifier(message);
		new Thread(notifier, "NOTIFIER").start();
		System.out.println("All threads started");
	}
}
