package spring.proxy;

import spring.proxy.handler.MyInvocationHandler;
import spring.proxy.service.UsbSell;
import spring.proxy.service.impl.UsbKingFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyMain {
    public static void main(String[] args) {

        // 1.创建InvocationHandler实例
        UsbSell factory = new UsbKingFactory();
        InvocationHandler handler = new MyInvocationHandler(factory);

        // 2.创建代理
        UsbSell usbSell = (UsbSell) Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(), handler);

        // 3.利用代理调用接口方法
        float price = usbSell.sell(1);
        System.out.println("代理执行成功，代理后的价格是：" + price);
    }
}
