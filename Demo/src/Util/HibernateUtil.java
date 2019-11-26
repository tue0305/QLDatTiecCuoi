package Util;

import POJO.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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

        configure.configure("Util/hibernate.cfg.xml");
        
        
        configure.addAnnotatedClass(Nhanvien.class);
//        configure.addAnnotatedClass(Booking.class);
//        configure.addAnnotatedClass(Khachhang.class);
//        
//        configure.addAnnotatedClass(Sanh.class);
//        configure.addAnnotatedClass(Dichvu.class);
//        configure.addAnnotatedClass(Monan.class);
//        configure.addAnnotatedClass(Menu.class);

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
