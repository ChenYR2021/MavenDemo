package design.adapter.objectadapter;

/**
 * 对象适配器
 * 1.组合待适配的类
 * 2.通过调用待适配的对象的接口，实现适配器接口
 */
public class VoltageAdapter4Household implements VoltageAdapter {

    HouseholdVoltage householdVoltage;

    public VoltageAdapter4Household(HouseholdVoltage householdVoltage) {
        this.householdVoltage = householdVoltage;
    }

    @Override
    public int output5v() {
        int currentVoltage = householdVoltage.output();
        System.out.println("电源适配器开始工作，转换成5V电压！");
        return currentVoltage / 44;
    }
}
