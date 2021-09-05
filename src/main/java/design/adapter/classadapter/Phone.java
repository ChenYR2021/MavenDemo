package design.adapter.classadapter;

/**
 * 1.手机类，会使用VoltageAdapter充电的电压
 */
public class Phone {
    public void charge(VoltageAdapter adapter) {
        if (adapter.output5v() == 5) {
            System.out.println("输入5V电压，手机开始充电！");
        }
    }
}
