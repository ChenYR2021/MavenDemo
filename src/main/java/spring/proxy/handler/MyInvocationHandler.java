package spring.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    // 接口的实现类，这里是UsbSellImpl
    private Object target = null;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 调用UsbSellImpl中的函数
        Object result = null;
        result = method.invoke(target, args);

        if (result != null) {
            result = (float)result + 25;
        }

        System.out.println("动态代理已经生效，代理后的价格是：" + result);
        return result;
    }
}
