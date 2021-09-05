package spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:jdbc.property")
public class DataSourceConfiguration {

    @Value("${mysql.driver}")
    public String driver;

    @Value("${mysql.url}")
    public String url;

    @Value("${mysql.username}")
    public String username;

    @Value("${mysql.password}")
    public String password;

    @Bean("dataSource")
    public DruidDataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
