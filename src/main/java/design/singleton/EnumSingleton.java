package design.singleton;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 枚举单例模式： 通过枚举实现懒加载内部类
 * 优点：线程安全，防止反序列化
 * 缺点：无
 *
 * 【推荐使用】《Effective Java》作者强烈推荐
 */
public enum EnumSingleton {
    INSTANCE;

    public void sayHello() {
        System.out.println("Hello~");
    }
}
