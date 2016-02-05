// Doesn't work with more than one thread
public class Singleton1 {
  private Singleton1() {
	}
	
	private static Singleton1 instance = null;
	public static Singleton1 getInstance() {
		if (instance == null)
			instance = new Singleton1();
		return instance;
	}
}

// Works with threads 
// Problem is operations to get and release a lock are time-consuming. 
public class Singleton2 {
	private Singleton2() {
	}
	
	private static Singleton2 instance = null;
	public synchronized Singleton2 getInstance() {
		if (instance == null) 
			instance = new Singleton2();
		return instance;
	} 
}

// Time efficiency is better than Singleton2, it only creates locking 
// when instance is null. 
// IMPORTANT: without double checking, synchronized wouldn't work!!!
// HOWEVER, even with double checking, out-of-order writes still might 
// cause a problem here 
// http://www.ibm.com/developerworks/java/library/j-dcl/
public class Singleton3 {
	private Singleton3(){
	}
	
	private static Singleton3 instance = null;
	// in JDK 5+, we can use volatile to fix the double checking problem
	// private static volatile Singleton3 instance = null
	public static Singleton3 getInstance() {
		if (instance == null) {
			synchronized(Singleton3.class) {
				if (instance == null) // double checking
					instance = new Singleton3();
			}
		} 
		return instance;
	}
	
	protected Object clone() {
		throw new CloneNotSupportedException();
	}
}

// Since the static constructor is called only once by JVM, 
// it is guaranteed that only one instance is created even in 
// a multithreading application.
// But it impairs the space efficiency 
public class Singleton4 {
	private Singleton4() {
	}
	
	private static Singleton4 instance = new Singleton4();
	
	public static Singleton4 getInstance() {
		return instance;
	}
}

