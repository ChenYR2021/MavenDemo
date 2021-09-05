package design.observer.observer.impl;

import design.observer.observer.Observer;

/**
 * 观察者实现类1
 * 华为天气
 */
public class HuaweiWeatherSite implements Observer {

    private float temperature;

    private float pressure;

    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    private void display() {
        System.out.println("华为天气信息更新：");
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
