package app.config;

import app.models.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.beans.PropertyVetoException;
import java.util.Properties;

// ещё вариант: https://mkyong.com/spring-mvc/spring-mvc-hello-world-example/

@Configuration
@ComponentScan("app")
@PropertySource("classpath:db.properties")
@EnableWebMvc
@EnableTransactionManagement
public class Config {

    private final Environment env;

    public Config(Environment env) {
        this.env = env;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
//        viewResolver.setSuffix(".html");
        return viewResolver;
    }

    @Bean(destroyMethod = "close")
    public ComboPooledDataSource comboPooledDataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(env.getProperty("db.driver"));
        comboPooledDataSource.setJdbcUrl(env.getProperty("db.url"));
        comboPooledDataSource.setUser(env.getProperty("db.username"));
        comboPooledDataSource.setPassword(env.getProperty("db.password"));
        return comboPooledDataSource;
    }

//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("db.driver"));
//        dataSource.setUrl(env.getProperty("db.url"));
//        dataSource.setUsername(env.getProperty("db.username"));
//        dataSource.setPassword(env.getProperty("db.password"));
//
//        Properties connectionProps = new Properties();
//        connectionProps.put("allowPublicKeyRetrieval", env.getProperty("allowPublicKeyRetrieval"));
//        dataSource.setConnectionProperties(connectionProps);
//        return dataSource;
//    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(comboPooledDataSource());
        factoryBean.setPackagesToScan("app");

        Properties props = new Properties();
        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
//        for (String[] kv : new String[][]{
//                {"hibernate.show_sql", env.getProperty("hibernate.show_sql")},
//                {"hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto")},
//                {"hibernate.dialect", env.getProperty("hibernate.dialect")}
//        }) {
//            props.put(kv[0], kv[1]);
//        }

        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(User.class);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() throws PropertyVetoException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}