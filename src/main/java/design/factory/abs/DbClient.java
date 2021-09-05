package design.factory.abs;

import design.factory.abs.factory.DbFactory;
import design.factory.abs.factory.impl.MysqlFactory;
import design.factory.abs.factory.impl.OracleFactory;
import design.factory.abs.pojo.User;
import design.factory.abs.user.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象工厂模式
 *
 * 【优点】增加一个产品族比较简单，如再增加一个SqlserverFactory，实现DbFactory和UserServer两个接口即可
 *        【反射】可以使用反射来去除判断条件
 * 【缺点】增加一个产品比较麻烦，如每个Factory要增加一个管理部门的模块，需要在DbFactory里增加一个createDepartment函数，然后所有的Factory都要实现这个接口
 *
 */
public class DbClient {
    public static Map<String, Class<? extends DbFactory>> FACTORY_MAP = new HashMap<>();

    static {
        FACTORY_MAP.put("mysql", MysqlFactory.class);
        FACTORY_MAP.put("oracle", OracleFactory.class);
    }


    public static void main(String[] args) {
        User user = new User("张三", 10);
        // 1.创建一个Mysql工厂
        DbFactory factory = new MysqlFactory();
        UserService userService = factory.getUserService();
        userService.insert(user);

        // 2.创建一个Oracle工厂，只需要改1行代码，即创建工厂的方法即可
        factory = new OracleFactory();
        userService = factory.getUserService();
        userService.insert(user);

        System.out.println("------------------------------\n");
        rejectFactory("mysql");
        rejectFactory("oracle");
        rejectFactory("sqlserver");
    }

    // 模拟使用反射机制来创建一个工厂
    public static void rejectFactory(String factoryName) {
        User user = new User("李四", 12);
        try {
            DbFactory factory = FACTORY_MAP.get(factoryName).newInstance();
            UserService userService = factory.getUserService();
            userService.insert(user);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
