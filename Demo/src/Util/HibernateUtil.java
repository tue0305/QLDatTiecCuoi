package Util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author KenhLapTrinh
 */
public class HibernateUtil {

    private static final SessionFactory FACTORY;

    static {
        Configuration configure = new Configuration();
        configure.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder
                = new StandardServiceRegistryBuilder()
                        .applySettings(configure.getProperties());
        FACTORY = configure
                .buildSessionFactory(builder.build());
    }

    public static SessionFactory getSessionFactory() {
        return FACTORY;
    }
    //---------------
   
}
