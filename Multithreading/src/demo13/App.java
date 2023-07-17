package demo13;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(new Runnable() {
			@Override
			public void run() {
				Random random = new Random();
				int duration = random.nextInt(4000);
				System.out.println("Starting ...");
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Finished ...");
			}
		});
		// another way to do the same
		Future<Integer> future = executor.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				Random random = new Random();
				int duration = random.nextInt(4000);
				if(duration>2000) throw new IOException("Sleeping for too long");
				System.out.println("Starting ...");
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Finished ...");
				return duration;
			}
		});
		
		/*
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		try {
			System.out.println("Result is: "+ future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			IOException ex = (IOException) e.getCause();
			System.out.println(ex.getMessage());;
		}
		Future<?> future1 = executor.submit(new Callable<Void>() {
			@Override
			public Void call() throws Exception {
				// TODO Auto-generated method stub
				Random random = new Random();
				int duration = random.nextInt(4000);
				//if(duration>2000) throw new IOException("Sleeping for too long");
				System.out.println("Starting ...");
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Finished ...");
				return null;
			}
		});
		executor.shutdown();
	}

}
