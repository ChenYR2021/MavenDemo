package design.singleton;

/**
 * Eager: 渴望的、热切的
 * 饿汉式单例模式1： 静态常量饿汉式
 * 优点：没有多线程问题
 * 缺点：类加载时会创建，没有达到懒加载的目的，如果实例没有使用场景，可能会造成内存浪费
 */
public class EagerSingleton1 {
    // 1.私有构造函数
    private EagerSingleton1() {

    }

    // 2.私有静态实例
    private static final EagerSingleton1 INSTANCE = new EagerSingleton1();

    // 3.公有静态方法，返回对象实例
    public static EagerSingleton1 getInstance() {
        return INSTANCE;
    }
}
