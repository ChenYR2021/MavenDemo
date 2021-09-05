package design.factory.abs.user.impl;

import design.factory.abs.pojo.User;
import design.factory.abs.user.UserService;

public class MysqlUserService implements UserService {
    @Override
    public void insert(User user) {
        System.out.println(user.toString() + " insert to mysql.");
    }
}
