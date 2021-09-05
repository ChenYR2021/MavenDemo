package design.singleton;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lazy Singleton: 懒汉式单例
 * 懒汉式单例模式2： getInstance方法加锁，方法中new实例
 * 优点：1)实例在初次使用时才会被加载
 *      2)解决了多线程并发的问题
 * 缺点：加了一把大锁，所有getInstance都会被阻塞
 *
 * 【特别注意】开发效率低，不推荐使用
 */
public class LazySingleton2 {
    private static final Logger LOGGER =  LoggerFactory.getLogger(LazySingleton2.class);
    // 1.私有构造函数
    private LazySingleton2() {

    }

    // 2.私有静态实例
    private static LazySingleton2 INSTANCE;

    // 3.公有静态方法，返回对象实例，但是有多线程问题
    public static synchronized LazySingleton2 getInstance() {
        try {
            LOGGER.info("{} start", Thread.currentThread().getName());
            if (INSTANCE == null) {
                Thread.sleep(5000);  //不好使，没测出来
                LOGGER.info("{} new instance", Thread.currentThread().getName());
                INSTANCE = new LazySingleton2();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return INSTANCE;
    }
}
