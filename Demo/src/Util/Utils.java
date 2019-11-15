/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import POJO.Monan;
import POJO.Nhanvien;
import static java.sql.JDBCType.NULL;


import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author cohotech
 */
public class Utils {

    public static List<Monan> getMonAn() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria cr = session.createCriteria(Monan.class);
        List<Monan> MonAns = cr.list();

        session.close();

        return MonAns;
    }

    public static Boolean KiemtraTKandMK(String u, String p) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction trans = null;
        try {
            trans = session.beginTransaction();

            Criteria cr = session.createCriteria(Nhanvien.class);

            Criterion username = Restrictions.like("UserName", u);
            Criterion password = Restrictions.like("Password", p);
            cr.add(Restrictions.and(username, password));

            if(!cr.list().isEmpty())
                return true;
            trans.commit();

        } catch (HibernateException ex) {
            if (trans != null) {
                trans.rollback();
            }

            return false;
        } finally {
            session.close();
        }

        return false;

    }
    
    public static Alert getAlert(String content, Alert.AlertType type) {
        Alert a = new Alert(type);
        a.setContentText(content);
        
        return a;
    }

}