package design.factory.abs.factory.impl;

import design.factory.abs.factory.DbFactory;
import design.factory.abs.user.UserService;
import design.factory.abs.user.impl.MysqlUserService;

public class MysqlFactory implements DbFactory {
    @Override
    public UserService getUserService() {
        return new MysqlUserService();
    }
}
