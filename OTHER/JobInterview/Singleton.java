/**
懒汉式-线程不安全
**/
public class Singleton{
	private static Singleton uniqueInstance;

	private Singleton(){

	}

	public static Singleton getUniqueInstance(){
		if(uniqueInstance==null){
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
}


/**
饿汉式-线程安全
**/
public class Singleton{
	private static Singleton uniqueInstance = new Singleton();

	private Singleton(){

	}

	public static Singleton getUniqueInstance(){
		return uniqueInstance;
	}
}


/**
懒汉式-线程安全
**/
public class Singleton{
	private static Singleton uniqueInstance = new Singleton();

	private Singleton(){

	}

	public static synchronized Singleton getUniqueInstance(){
		if(uniqueInstance==null){
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
}