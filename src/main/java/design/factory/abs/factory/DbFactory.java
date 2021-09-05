package design.factory.abs.factory;

import design.factory.abs.user.UserService;

public interface DbFactory {
    UserService getUserService();
}
