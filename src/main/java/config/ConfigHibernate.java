package config;

import model.User;
import org.glassfish.jaxb.runtime.v2.runtime.output.Encoded;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;

import java.io.IOException;
import java.util.Properties;

public class ConfigHibernate {
    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory==null) {
            Properties properties = new Properties();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            try {
                properties.load(classLoader.getResourceAsStream("hibernate.properties"));
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
            sessionFactory = new Configuration()
                    .setProperties(properties)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }



}
