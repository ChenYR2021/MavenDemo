package design.factory.method.operation.impl;

import design.factory.method.operation.Operation;

public class MulOperation extends Operation {

    @Override
    public double getResult(double number1, double number2) {
        double result = number1 * number2;
        System.out.println(number1 + " * " + number2 + " = " + result);
        return result;
    }
}
