package design.observer.jdk;


import java.util.Observable;
import java.util.Observer;

/**
 * 观察者实现类1：基于JDK提供的工具类
 * 墨迹天气
 */
public class MojiWeatherSite4JDK implements Observer {

    private float temperature;

    private float pressure;

    private float humidity;
    @Override
    public void update(Observable o, Object arg) {
        this.temperature = ((WeatherData4JDK)o).getTemperature();
        this.pressure = ((WeatherData4JDK)o).getPressure();
        this.humidity = ((WeatherData4JDK)o).getHumidity();
        display();
    }

    private void display() {
        System.out.println("墨迹天气信息更新：");
        System.out.println("          温度：" + temperature);
        System.out.println("          气压：" + pressure);
        System.out.println("          湿度：" + humidity);
        System.out.println();
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
