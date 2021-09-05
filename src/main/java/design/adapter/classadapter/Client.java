package design.adapter.classadapter;

/**
 * 【1】类适配器模式：需要继承待适配的类，并且实现适配器的接口
 * 缺点：耦合比较厉害
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        VoltageAdapter4Household adapter = new VoltageAdapter4Household();
        phone.charge(adapter);
    }
}
