package design.singleton;

/**
 * Eager: 渴望的、热切的
 * 饿汉式单例模式2： 静态代码块饿汉式
 * 优点：没有多线程问题
 * 缺点：类加载时会创建，没有达到懒加载的目的，如果实例没有使用场景，可能会造成内存浪费
 *
 * 【注意】优缺点和饿汉式单例模式1一样
 */
public class EagerSingleton2 {
    // 1.私有构造函数
    private EagerSingleton2() {

    }

    // 2.私有静态实例
    private static EagerSingleton2 INSTANCE;

    // 3.【不同点】静态代码块
    static {
        INSTANCE = new EagerSingleton2();
    }

    // 4.公有静态方法，返回对象实例
    public static EagerSingleton2 getInstance() {
        return INSTANCE;
    }
}
