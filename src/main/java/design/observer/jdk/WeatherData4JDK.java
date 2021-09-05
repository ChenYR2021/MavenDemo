package design.observer.jdk;

import java.util.Observable;

/**
 *  主题
 *  1.与自定义主题不同的是，需要继承Observable类
 *  2.观察者Observer要实现java.util.Observer接口
 *  3.调用notifyObservers通知观察者，会将自己传递给ObserverImpl
 *  4.ObserverImpl中强转回当前的类，然后取其中的参数
 *  5.好处：保证了update接口统一
 */
public class WeatherData4JDK extends Observable {

    private float temperature;

    private float pressure;

    private float humidity;

    /**
     * 【重要】开放给外界调用的接口，当这个接口被触发时，
     *  1.先修改Observable的状态，isChanged为true;
     *  2.调用noticeObservers，通知所有的观察者
      */
    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        System.out.println("正在通知所有观察者......");
        setChanged(); // 状态改变后就会生效
        notifyObservers();
        setChanged(); // 状态改变后就会生效
        notifyObservers();
        System.out.println("通知完成");
        System.out.println("---------------------------------");
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
}
