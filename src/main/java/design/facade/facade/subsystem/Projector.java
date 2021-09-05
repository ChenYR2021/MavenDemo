package design.facade.facade.subsystem;

/**
 * [家庭影院]投影仪
 */
public class Projector {
    private static Projector projector = new Projector();

    private Projector() {

    }

    public static Projector getInstance() {
        return projector;
    }

    public void open() {
        System.out.println("投影仪打开...");
    }

    public void pause() {
        System.out.println("投影仪暂停...");
    }

    public void close() {
        System.out.println("投影仪关闭...");
    }
}
