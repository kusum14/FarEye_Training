public class SingletonLazy {
    // volatile makes read and write atomic
    private static volatile SingletonLazy instance = null;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (instance == null) {
            // Once created can't be created again
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    System.out.println("********Creating object of SingletonLazy class");
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
