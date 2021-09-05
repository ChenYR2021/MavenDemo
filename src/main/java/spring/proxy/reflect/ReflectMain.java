package spring.proxy.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMain {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HelloService service = new HelloServiceImpl();

        // 1.通过反射获取接口中的方法
        Method method = HelloService.class.getMethod("sayHello", String.class);

        // 2.调用method的invoke方法，可以执行不同的实例的函数
        method.invoke(service, "傻逼");
    }
}
