package design.factory.method;

import design.factory.method.factory.IOperationFactory;
import design.factory.method.factory.impl.AddOperationFactory;
import design.factory.method.factory.impl.DivOperationFactory;
import design.factory.method.factory.impl.MulOperationFactory;
import design.factory.method.factory.impl.SubOperationFactory;
import design.factory.method.operation.Operation;

/**
 * 工厂方法模式
 *
 * 工厂方法将简单工厂的内部逻辑判断移到了客户端代码来进行。以前需要改工厂类的，现在需要改客户端。
 * 优点：保留了简单工厂的优点，同时克服了工厂类需要修改的问题
 * 缺点：1.每增加一个产品，就要增加一个工厂。
 *      2.客户端的代码需要修改
 */
public class OperationClient {
    public static void main(String[] args) {

        // 需要在客户端判断用哪个工厂，如果新增一个操作，就要新增1个工厂，并且修改客户端代码
        IOperationFactory factory = new AddOperationFactory();
        Operation operation = factory.generateOperation();
        operation.getResult(200, 100);

        factory = new DivOperationFactory();
        operation = factory.generateOperation();
        operation.getResult(200, 100);

        factory = new MulOperationFactory();
        operation = factory.generateOperation();
        operation.getResult(200, 100);

        factory = new SubOperationFactory();
        operation = factory.generateOperation();
        operation.getResult(200, 100);
    }
}
