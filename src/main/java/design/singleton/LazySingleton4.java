package design.singleton;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lazy Singleton: 懒汉式单例
 * 懒汉式单例模式4： 双重检查模式
 * 优点：延迟加载，效率较高，线程安全
 * 缺点：无
 *
 * 【注意】如果实现了Serializable接口，反序列化时会创建新的对象
 *        解决办法：实现readResolve()函数，返回INSTANCE
 *        参考链接：https://blog.csdn.net/weixin_44804750/article/details/106124423
 *
 * 【强烈推荐使用】Double-Check是多线程中常用的概念
 */
public class LazySingleton4 {
    private static final Logger LOGGER =  LoggerFactory.getLogger(LazySingleton4.class);
    // 1.私有构造函数
    private LazySingleton4() {

    }

    // 2.私有静态实例
    //   通过volatile参数保证INSTANCE立刻写入内存中，同时通知其他线程值已变更，其他线程会重新从内存中读取INSTANCE的值
    private static volatile LazySingleton4 INSTANCE;

    // 3.公有静态方法，返回对象实例
    public static synchronized LazySingleton4 getInstance() {
        try {
            LOGGER.info("start!");
            if (INSTANCE == null) {
                LOGGER.info("first check!");
                // Double-Check，多线程进入同步块中会阻塞，并且再次判断INSTANCE是否为空
                synchronized (LazySingleton4.class) {
                    LOGGER.info("second check!");
                    if (INSTANCE == null) {
                        Thread.sleep(5000);
                        LOGGER.info("new instance!");
                        INSTANCE = new LazySingleton4();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return INSTANCE;
    }

    // JVM在反序列时
    // 1.判断readResolve函数是否存在
    // 2.通过反射，调用readResolve获取返回值
    private Object readResolve() {
        return INSTANCE;
    }
}
