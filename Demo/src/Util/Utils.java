/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import POJO.Monan;
import POJO.Nhanvien;
import POJO.Sanh;
import static com.sun.javafx.scene.control.skin.Utils.getResource;
import java.lang.Class;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
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
//Hàm kiểm tra đăng nhập

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
//Hàm thông báo Alert

    public static Alert getAlertTC(String content, Alert.AlertType type) {
        Alert a = new Alert(type);
        a.setContentText(content);

        return a;
    }
//Hàm chuyển Stage

    public static void switchStage(Scene sce, ActionEvent e) {
        try {
            Node source = (Node) e.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();

            stage.hide();
            stage.setScene(sce);
            stage.show();

        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }

    }
    
    public static List<Sanh> getSanh() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Criteria cr = session.createCriteria(Sanh.class);
        List<Sanh> sanh = cr.list();

        session.close();

        return sanh;
    }

    public static boolean deleteSanh(Sanh s) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {

            session.beginTransaction();

            session.delete(s);
            session.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
            session.getTransaction().rollback();
            return false;
        }
    }

    public static boolean addOrUpdateSanh(Sanh s) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {

            session.beginTransaction();

            session.saveOrUpdate(s);
            session.getTransaction().commit();
             session.close();
            return true;
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
            session.getTransaction().rollback();
            return false;
        }
    }

    public static Boolean ktTrungTenSanh(Sanh s) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {

            Criteria cr = session.createCriteria(Sanh.class);
           
            
            cr.add(Restrictions.eq("tenSanh", s.getTenSanh()));
            List <Sanh> ls = cr.list();
            if(ls.isEmpty())
                return true;
            else 
                return false;
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
            session.getTransaction().rollback();
            return false;
        }
    }

}
