package design.adapter.interfaceadapter;

/**
 * 适配器接口类，用来适配各种电压
 */
public interface VoltageAdapter {
    int output5v(HouseholdVoltage householdVoltage);

    int output10v(HouseholdVoltage householdVoltage);

    int output15v(HouseholdVoltage householdVoltage);
}
