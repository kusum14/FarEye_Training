public class TestSingleton {

    public static void main(String[] args) {
        testSingletonNormal();
        System.out.println("");
        testSingletonLazy();
    }

    public static void testSingletonNormal() {
        System.out.println("In testSingletonNormal");
//        SingletonNormal singletonNormal = new SingletonNormal() // Not possible as constructor is private
        SingletonNormal singletonNormal = SingletonNormal.getInstance(); // only way to access and always returns same object
        SingletonNormal singletonNormal1 = SingletonNormal.getInstance();

        System.out.println(System.identityHashCode(singletonNormal));
        System.out.println(System.identityHashCode(singletonNormal1));

        System.out.println("Completed testSingletonNormal");
    }

    public static void testSingletonLazy() {
        System.out.println("In testSingletonLazy");
//        SingletonLazy SingletonLazy = new SingletonLazy() // Not possible as constructor is private
        SingletonLazy singletonLazy = SingletonLazy.getInstance(); // only way to access and always returns same object
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy3 = SingletonLazy.getInstance();

        System.out.println(System.identityHashCode(singletonLazy));
        System.out.println(System.identityHashCode(singletonLazy1));
        System.out.println(System.identityHashCode(singletonLazy2));
        System.out.println(System.identityHashCode(singletonLazy3));

        System.out.println("Completed testSingletonLazy");
    }
}
