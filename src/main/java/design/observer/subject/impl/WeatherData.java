package design.observer.subject.impl;

import design.observer.observer.Observer;
import design.observer.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private float temperature;

    private float pressure;

    private float humidity;

    // 观察者List，可以同时管理多个观察者
    private List<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("正在通知所有观察者......");
        for (Observer observer : observers) {
            observer.update(temperature, pressure, humidity);
        }
        System.out.println("通知完成");
        System.out.println("---------------------------------");
    }

    /**
     * 【重要】开放给外界调用的接口，当这个接口被触发时，调用noticeObservers，通知所有的观察者
      */
    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyObservers();
    }
}
