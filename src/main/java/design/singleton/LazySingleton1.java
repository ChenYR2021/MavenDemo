package design.singleton;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lazy Singleton: 懒汉式单例
 * 懒汉式单例模式1： getInstance中new
 * 优点：实例在初次使用时才会被加载
 * 缺点：没有加锁，有多线程问题
 *      临界资源问题：https://blog.csdn.net/qq_29224201/article/details/103449449
 *
 * 【特别注意】有多线程问题，所以不可用
 */
public class LazySingleton1 {
    private static final Logger LOGGER =  LoggerFactory.getLogger(LazySingleton1.class);
    // 1.私有构造函数
    private LazySingleton1() {

    }

    // 2.私有静态实例
    private static LazySingleton1 INSTANCE;

    // 3.公有静态方法，返回对象实例，但是有多线程问题
    public static LazySingleton1 getInstance() {
        try {
            LOGGER.info("{} start", Thread.currentThread().getName());
            if (INSTANCE == null) {
                Thread.sleep(100);  //sleep 100ms，可以测出多线程的问题
                LOGGER.info("{} new instance", Thread.currentThread().getName());
                INSTANCE = new LazySingleton1();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return INSTANCE;
    }
}
