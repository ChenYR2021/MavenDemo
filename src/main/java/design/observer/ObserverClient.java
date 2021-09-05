package design.observer;

import design.observer.jdk.HuaweiWeatherSite4JDK;
import design.observer.jdk.MojiWeatherSite4JDK;
import design.observer.jdk.WeatherData4JDK;
import design.observer.observer.Observer;
import design.observer.observer.impl.HuaweiWeatherSite;
import design.observer.observer.impl.MojiWeatherSite;
import design.observer.subject.impl.WeatherData;

/**
 * 【观察者模式】：又被称为发布-订阅（Publish/Subscribe）模式，属于行为型模式的一种，它定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。
 *              这个主题对象在状态变化时，会通知所有的观察者对象，使他们能够自动更新自己。
 *              https://blog.csdn.net/itachi85/article/details/50773358
 *
 * 原始需求：
 * 1)	气象站可以将每天测量到的温度，湿度，气压等等以公告的形式发布出去(比如发布到自己的网站或第三方)。
 * 2)	需要设计开放型 API，便于其他第三方也能接入气象站获取数据。
 * 3)	提供温度、气压和湿度的接口
 * 4)	测量数据更新时，要能实时的通知给第三方
 *
 * 观察者模式的好处：
 * 1)	观察者模式设计后，会以集合的方式来管理用户(Observer)，包括注册，移除和通知。
 *    	这样，我们增加观察者(这里可以理解成一个新的公告板)，就不需要去修改核心类 WeatherData 不会修改代码， 遵守了 ocp 原则。
 *
 * 观察者模式的坏处：
 * 1）  在应用观察者模式时需要考虑一下开发效率和运行效率的问题，程序中包括一个被观察者、多个观察者，开发、调试等内容会比较复杂，
 *      而且在Java中消息的通知一般是顺序执行，那么一个观察者卡顿，会影响整体的执行效率，在这种情况下，一般会采用异步实现。
 */
public class ObserverClient {
    public static void main(String[] args) {
        System.out.println("========自定义的观察者模式开始工作=========");
        excuteMyObserver();
        System.out.println("========JDK定义的观察者模式开始工作=========");
        excuteJdkObserver();
    }

    public static void excuteMyObserver() {
        // 1.创建观察者
        Observer moji = new MojiWeatherSite();
        Observer huawei = new HuaweiWeatherSite();

        // 2.创建主题，也就是被观察者
        WeatherData weatherData = new WeatherData();

        // 3.把观察者注册到主题中
        weatherData.registerObserver(moji);
        weatherData.registerObserver(huawei);

        // 4.触发主题变更
        weatherData.setData(20, 30, 40);

        // 5.删除观察者，触发主题变更
        weatherData.removeObserver(moji);
        weatherData.setData(10,20,30);
    }

    /**
     * 执行JDK的
     * https://www.cnblogs.com/yulinfeng/p/5874015.html
     */
    public static void excuteJdkObserver() {
        // 1.创建观察者，Observer包有冲突，需要使用全路径
        java.util.Observer moji = new MojiWeatherSite4JDK();
        java.util.Observer huawei = new HuaweiWeatherSite4JDK();

        // 2.创建主题，也就是被观察者
        WeatherData4JDK weatherData4JDK= new WeatherData4JDK();

        // 3.把观察者注册到主题中
        weatherData4JDK.addObserver(moji);
        weatherData4JDK.addObserver(huawei);

        // 4.触发主题变更
        weatherData4JDK.setData(20, 30, 40);

        // 5.删除观察者，触发主题变更
        weatherData4JDK.deleteObserver(moji);
        weatherData4JDK.setData(10,20,30);
    }
}
