package design.facade.facade;

import design.facade.facade.subsystem.Light;
import design.facade.facade.subsystem.Projector;
import design.facade.facade.subsystem.Screen;
import design.facade.facade.subsystem.Sound;

/**
 * 外观类，也称为门面类
 */
public class FamilyCinemaFacade {
    // 开始观看
    public void startWatch() {
        System.out.println("======设备准备中======");
        Screen.getInstance().down();
        Projector.getInstance().open();
        Sound.getInstance().open();
        Light.getInstance().close();
        System.out.println("======设备准备完成======");
    }

    // 暂停观看
    public void pauseWatch() {
        System.out.println("======暂停======");
        Projector.getInstance().pause();
        Sound.getInstance().pause();
        System.out.println("======暂停完成======");
    }

    // 结束观看
    public void stopWatch() {
        System.out.println("======设备关闭中======");
        Light.getInstance().open();
        Projector.getInstance().close();
        Sound.getInstance().close();
        Screen.getInstance().up();
        System.out.println("======设备关闭完成======");
    }
}
