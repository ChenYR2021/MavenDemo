package design.singleton;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lazy Singleton: 懒汉式单例
 * 懒汉式单例模式3： getInstance方法加锁，方法中new实例
 * 优点：实例在初次使用时才会被加载，
 * 缺点：依然没有解决多线程的问题！！！
 *
 * 【特别注意】依然没有解决多线程的问题！！！不可用！！！
 */
public class LazySingleton3 {
    private static final Logger LOGGER =  LoggerFactory.getLogger(LazySingleton3.class);
    // 1.私有构造函数
    private LazySingleton3() {

    }

    // 2.私有静态实例
    private static LazySingleton3 INSTANCE;

    // 3.公有静态方法，返回对象实例，但是有多线程问题
    public static synchronized LazySingleton3 getInstance() {
        try {
            if (INSTANCE == null) {
                // 没有解决多线程问题，多线程依然可以进入INSTANCE == null的判断
                synchronized (LazySingleton3.class) {
                    Thread.sleep(5000);
                    INSTANCE = new LazySingleton3();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return INSTANCE;
    }
}
