public class Singleton{
	private Singleton(){}

	private volatile static Singleton instance;//第一层锁🔒保证变量可见性

	public static Singleton getInstance(){
		//第一次判空：无需每次都加第二层锁，提高性能
		if(instance==null){
			//第二层锁🔒保证线程同步
			synchronized (Singleton.class){
				//第二次判空：避免多线程同时执行getInstance，避免多次实例化
				if(instance==null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}