/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import POJO.Monan;
import POJO.Nhanvien;

import java.util.List;
import javafx.scene.control.Alert;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author cohotech
 */
public class Utils {

    public static List<Monan> getMonAn() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Criteria cr = session.createCriteria(Monan.class);
        List<Monan> MonAns = cr.list();

        session.close();

        return MonAns;
    }

    public static Boolean KiemtraTKandMK(String u, String p) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {

            Criteria cr = session.createCriteria(Nhanvien.class);

            Criterion cr1 = Restrictions.eq("userName", u);
            Criterion cr2 = Restrictions.eq("password", p);
            cr.add(Restrictions.and(cr1, cr2));
            List nv = cr.list();

            if (nv.size() != 0) {

                return true;
            } else {

                return false;
            }

        } catch (Exception ex) {
            System.err.print(ex.getMessage());

        }
        session.close();
        return false;

    }

    public static Alert getAlertTC(String content, Alert.AlertType type) {
        Alert a = new Alert(type);
        a.setContentText(content);

        return a;
    }

}
