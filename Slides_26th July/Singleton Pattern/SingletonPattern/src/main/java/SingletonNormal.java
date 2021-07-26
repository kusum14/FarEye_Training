public class SingletonNormal {
    // can't modify inside class as final
    private static final SingletonNormal INSTANCE = new SingletonNormal();

    private SingletonNormal() {
    }

    public static SingletonNormal getInstance() {
        return INSTANCE;
    }
}
