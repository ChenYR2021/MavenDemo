package design.singleton;

public class MainClass {

    public static void main(String[] args) {
        testEagerSingleton();
        System.out.println("--------------------------------\n");
        // testLazySingleton();
        System.out.println("--------------------------------\n");
        // testLazySingleton2();
        System.out.println("--------------------------------\n");
        // testLazySingleton3();
        // testLazySingleton4();
        // testLazySingleton5();
        testEnumSingleton1();
    }

    public static void testEagerSingleton() {
        EagerSingleton1 eagerSingleton1 = EagerSingleton1.getInstance();
        EagerSingleton1 eagerSingleton2 = EagerSingleton1.getInstance();
        System.out.println("eagerSingleton1 hashcode = " + eagerSingleton1.hashCode());
        System.out.println("eagerSingleton2 hashcode = " + eagerSingleton2.hashCode());
    }

    public static void testLazySingleton() {
        LazySingleton1 lazySingleton1  = LazySingleton1.getInstance();
        LazySingleton1 lazySingleton2  = LazySingleton1.getInstance();
        System.out.println("lazySingleton1 hashcode = " + lazySingleton1.hashCode());
        System.out.println("lazySingleton2 hashcode = " + lazySingleton2.hashCode());
    }

    public static void testLazySingleton2() {
        new Thread(() -> {
            System.out.println("lazySingleton1 hashcode = " + LazySingleton1.getInstance().hashCode());
        }).start();

        new Thread(() -> {
            System.out.println("lazySingleton2 hashcode = " + LazySingleton1.getInstance().hashCode());
        }).start();
    }

    public static void testLazySingleton3() {
        new Thread(() -> {
            System.out.println("lazySingleton1 hashcode = " + LazySingleton2.getInstance().hashCode());
        }).start();

        new Thread(() -> {
            System.out.println("lazySingleton2 hashcode = " + LazySingleton2.getInstance().hashCode());
        }).start();
    }

    public static void testLazySingleton4() {
        new Thread(() -> {
            System.out.println("lazySingleton1 hashcode = " + LazySingleton4.getInstance().hashCode());
        }).start();

        new Thread(() -> {
            System.out.println("lazySingleton2 hashcode = " + LazySingleton4.getInstance().hashCode());
        }).start();
    }

    public static void testLazySingleton5() {
        new Thread(() -> {
            System.out.println("lazySingleton1 hashcode = " + LazySingleton5.getInstance().hashCode());
        }).start();

        new Thread(() -> {
            System.out.println("lazySingleton2 hashcode = " + LazySingleton5.getInstance().hashCode());
        }).start();
    }

    public static void testEnumSingleton1() {
        new Thread(() -> {
            System.out.println("EnumSingleton1 hashcode = " + EnumSingleton.INSTANCE.hashCode());
        }).start();

        new Thread(() -> {
            System.out.println("EnumSingleton2 hashcode = " + EnumSingleton.INSTANCE.hashCode());
        }).start();
    }
}
