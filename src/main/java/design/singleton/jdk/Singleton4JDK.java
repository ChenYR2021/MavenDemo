package design.singleton.jdk;

/**
 * Runtime类就是一个典型的饿汉式的单例类
 */
public class Singleton4JDK {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.maxMemory());
    }
}
