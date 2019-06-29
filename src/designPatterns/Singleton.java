package designPatterns;

/**
 * @author rdmrkl
 * @version 1.0
 * thread-safe, reflection-safe Singleton class.
 * Using Singleton, we limit the number of instances of an object as 1.
 * Database connections, IO operations, Logging etc.
 * 
 * A private static class object variable. A private constructor. A public static get method returning singleton object.
 * Thread safety: Use synchronized block in the method & volatile keyword for the object variable.
 * Using Java Reflection API, one can create more than one instance of an object. To prevent this throw exception in the constructor.
 */
public class Singleton {
	//use volatile for thread-safety.
	private static volatile Singleton singleton;
	
	//private constructor.
	private Singleton() {
		
		//against reflection. 
		if (singleton != null) {
			throw new RuntimeException("Please use getSingletonObject() method.");
		}
	}
	
	//Synchronized block (double-check lock) for thread-safety.
	public static Singleton getSingletonObject() {
		
		if (singleton == null) {
			synchronized (Singleton.class) {
				
				if (singleton == null) 
					singleton = new Singleton();
			}
		}
		
		return singleton;
	}	

}
