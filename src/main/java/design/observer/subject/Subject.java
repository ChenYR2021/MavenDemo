package design.observer.subject;

import design.observer.observer.Observer;

/**
 * 主题，也是被观察者，可以被观察者订阅
 * 定义3个接口
 * 1.registerObserver: 注册观察者
 * 2.removeObserver: 删除观察者
 * 3.noticeObservers: 通知所有的观察者变更了
 */
public interface Subject {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
