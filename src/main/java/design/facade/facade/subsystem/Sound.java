package design.facade.facade.subsystem;

/**
 * [家庭影院]音响
 */
public class Sound {
    private static Sound sound = new Sound();

    private Sound() {

    }

    public static Sound getInstance() {
        return sound;
    }

    public void open() {
        System.out.println("音响打开...");
    }

    public void pause() {
        System.out.println("音响暂停...");
    }

    public void close() {
        System.out.println("音响关闭...");
    }
}
