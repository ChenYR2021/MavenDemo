package design.adapter.objectadapter;

/**
 * 【2】对象适配器模式：采用组合的方式，将Adapter类中组合上待适配的类
 * 优点：更解耦一点
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        VoltageAdapter4Household adapter = new VoltageAdapter4Household(new HouseholdVoltage());
        phone.charge(adapter);
    }
}
