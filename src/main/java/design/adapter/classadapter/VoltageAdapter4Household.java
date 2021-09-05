package design.adapter.classadapter;

/**
 * 类适配器
 * 1.继承待适配的类
 * 2.实现适配器接口
 */
public class VoltageAdapter4Household extends HouseholdVoltage implements VoltageAdapter {
    @Override
    public int output5v() {
        int currentVoltage = output();
        System.out.println("电源适配器开始工作，转换成5V电压！");
        return currentVoltage / 44;
    }
}
