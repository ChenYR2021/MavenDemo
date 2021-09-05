package design.adapter.interfaceadapter;

/**
 * 接口适配器模式：创建抽象类实现接口，将所有方法定义出默认方法。
 * 使用时子类继承抽象类，只重写需要重写的方法。
 */
public abstract class AbsVoltageAdapter implements VoltageAdapter{
    @Override
    public int output5v(HouseholdVoltage householdVoltage) {
        return 0;
    }

    @Override
    public int output10v(HouseholdVoltage householdVoltage) {
        return 0;
    }

    @Override
    public int output15v(HouseholdVoltage householdVoltage) {
        return 0;
    }
}
