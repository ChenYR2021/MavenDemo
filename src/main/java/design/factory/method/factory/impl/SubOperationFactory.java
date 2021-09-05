package design.factory.method.factory.impl;

import design.factory.method.factory.IOperationFactory;
import design.factory.method.operation.Operation;
import design.factory.method.operation.impl.SubOperation;

public class SubOperationFactory implements IOperationFactory {
    @Override
    public Operation generateOperation() {
        return new SubOperation();
    }
}
