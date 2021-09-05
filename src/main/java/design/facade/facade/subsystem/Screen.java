package design.facade.facade.subsystem;

/**
 * [家庭影院]荧幕
 */
public class Screen {
    private static Screen screen = new Screen();

    private Screen() {

    }

    public static Screen getInstance() {
        return screen;
    }

    public void down() {
        System.out.println("荧幕打开...");
    }

    public void up() {
        System.out.println("荧幕收起...");
    }
}
