package design.singleton;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lazy Singleton: 懒汉式单例
 * 懒汉式单例模式5： 通过静态内部类实现单例
 * 优点：延迟加载，效率较高，线程安全
 * 缺点：无
 *
 * 【推荐使用】
 * 原理： 1.静态内部类是懒加载的
 *       2.类的加载是线程安全的
 */
public class LazySingleton5 {
    private static final Logger LOGGER =  LoggerFactory.getLogger(LazySingleton5.class);
    // 1.私有构造函数
    private LazySingleton5() {

    }

    private static class InnerClass {
        // 2.私有静态实例
        //   通过volatile参数保证INSTANCE立刻写入内存中，同时通知其他线程值已变更，其他线程会重新从内存中读取INSTANCE的值
        private static volatile LazySingleton5 INSTANCE = new LazySingleton5();
    }

    // 3.公有静态方法，返回静态内部类的对象实例
    public static synchronized LazySingleton5 getInstance() {
        return InnerClass.INSTANCE;
    }
}
