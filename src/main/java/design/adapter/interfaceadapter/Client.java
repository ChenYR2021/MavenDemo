package design.adapter.interfaceadapter;

/**
 * 【3】接口适配器模式
 * 场景：当一个接口中有多个函数，实现类中不想全部实现时，可以通过一个抽象类实现这个接口并给所有函数来一个默认实现
 *      实际使用时
 *      1）创建新类继承这个抽象类，并只实现自己需要的函数
 *      2）直接通过匿名类来创建一个类的实例
 * 缺点：Java8以后接口的函数允许有默认实现......
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        // 写了一个内部类
        VoltageAdapter adapter = new AbsVoltageAdapter() {
            @Override
            public int output5v(HouseholdVoltage householdVoltage) {
                int currentVoltage = householdVoltage.output();
                System.out.println("内部类只实现output5v接口，将电压转到5v！");
                return currentVoltage / 44;
            }
        };
        phone.charge(adapter, new HouseholdVoltage());
    }
}
