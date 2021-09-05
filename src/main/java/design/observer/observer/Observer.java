package design.observer.observer;

/**
 * 观察者接口类
 * 1.定义update方法，更新天气信息: 温度、压力、湿度
 */
public interface Observer {
    public void update(float temperature, float pressure, float humidity);
}
