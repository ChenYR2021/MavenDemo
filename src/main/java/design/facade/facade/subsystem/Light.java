package design.facade.facade.subsystem;

/**
 * [家庭影院]灯光
 */
public class Light {
    private static Light light = new Light();

    private Light() {

    }

    public static Light getInstance() {
        return light;
    }

    public void open() {
        System.out.println("灯光打开...");
    }

    public void close() {
        System.out.println("灯光关闭...");
    }
}
