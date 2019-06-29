package designPatterns;


/**
 * @author User
 * @version 1.0 
 * Singleton design pattern tester class.
 * Using threads and loops, we show that the singleton object is always the same.
 * Objects' hashcodes remain unchanged.
 */
public class Main {

	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() { 
				
				for (int i = 1; i <= 10; i++) {
					Singleton singleton1 = Singleton.getSingletonObject();
					System.out.println("Thread1. " + i  + ". round in loop. Object hashcode is " + singleton1.hashCode() );
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					Singleton singleton2 = Singleton.getSingletonObject();
					System.out.println("Thread2. " + i  + ". round in loop. Object hashcode is " + singleton2.hashCode());
				}
			}
		});
			
		thread1.start();
		thread2.start();

	}

}
