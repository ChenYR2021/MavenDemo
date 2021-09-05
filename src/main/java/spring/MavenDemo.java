package spring;

import com.alibaba.druid.pool.DruidDataSource;
import spring.config.SpringConfiguration;
import spring.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MavenDemo {
    public static void main(String[] args) {
        System.out.println("This is a maven project which support spring.");
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
//        userDao.save();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.save();
        DruidDataSource dateSource = (DruidDataSource) applicationContext.getBean("dataSource");
        System.out.println(dateSource);
    }
}
