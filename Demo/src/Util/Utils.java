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
        
        try {
      
            Criteria cr = session.createCriteria(Nhanvien.class);

            String user = String.format("%%%s%%", u);
            Criterion c1 = Restrictions.eq("UserName", u);
            String pass = String.format("%%%s%%", p);
            Criterion c2 = Restrictions.eq("Password", p);
            cr.add(Restrictions.and(c1, c2));
            session.close();
            if (cr.list().size() != 0) {
                return true;
            } else            
            {
                return false;
                
            }
            
     
        } catch (Exception ex) {
            System.err.print(ex.getMessage());

        }
        return false;
    }

    public static Alert getAlertTC(String content, Alert.AlertType type) {
        Alert a = new Alert(type);
        a.setContentText(content);

        return a;
    }

}
