package design.factory.method.operation;

/**
 * 计算器的父类，定义了操作
 */
public abstract class Operation {
    public abstract double getResult(double number1, double number2);
}
