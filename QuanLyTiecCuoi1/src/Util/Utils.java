/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import POJO.Dichvu;

import POJO.Nhanvien;
import POJO.Sanh;
import POJO.Thucpham;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
 import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author cohotech
 */
public class Utils {

    private static Parent blah;

   
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
    //Hàm chuyển Stage action MouseClick

    public static void switchStageMouseClick(Scene sce,MouseEvent e) {
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
    
    

    
     public static List<Thucpham> getThucPham() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Criteria cr = session.createCriteria(Thucpham.class);
        List<Thucpham> ls = cr.list();

        session.close();

        return ls;
    }
     
     
     

    public static List<Sanh> getSanh() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Criteria cr = session.createCriteria(Sanh.class);
        List<Sanh> ls = cr.list();

        session.close();

        return ls;
    }
    
    public static List<Dichvu> getDichVu() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Criteria cr = session.createCriteria(Dichvu.class);
        List<Dichvu> ls = cr.list();

        session.close();

        return ls;
    }

    public static boolean deleteObject(Object s) {
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

    
    public static boolean addOrUpdate(Object o)
    {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction trans = null;
        try {
            
            trans = session.beginTransaction();
            session.saveOrUpdate(o);
            trans.commit();
        } catch (Exception ex) {
            if (trans != null) {
                trans.rollback();
            }
            System.err.print(ex.getMessage());
            return false;
        } finally {
            session.close();
        }
        return true;
    }
    

    public static boolean ktTrungTenSanh(Sanh s) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        try {

            Criteria cr = session.createCriteria(Sanh.class);

            cr.add(Restrictions.eq("tenSanh", s.getTenSanh()));
            List<Sanh> ls = cr.list();
            if (ls.isEmpty()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
            session.getTransaction().rollback();
            return false;
        }
        
    }
    public static boolean ktTrungTenDichvu(Dichvu s) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        try {

            Criteria cr = session.createCriteria(Dichvu.class);

            cr.add(Restrictions.eq("tenDV", s.getTenDV()));
            List<Dichvu> ls = cr.list();
            if (ls.isEmpty()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
            session.getTransaction().rollback();
            return false;
        }
        
    }
    
    public static boolean ktTrungTenThucPham(Thucpham s) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        try {

            Criteria cr = session.createCriteria(Thucpham.class);

            cr.add(Restrictions.eq("tenTP", s.getTenTP()));
            List<Thucpham> ls = cr.list();
            if (ls.isEmpty()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
            session.getTransaction().rollback();
            return false;
        }
        
    }
    
    
 

  
    
}
