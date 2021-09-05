package spring.proxy.reflect;

public class HelloServiceImpl implements HelloService{
    @Override
    public void sayHello(String message) {
        System.out.println("你好啊，" + message);
    }
}
