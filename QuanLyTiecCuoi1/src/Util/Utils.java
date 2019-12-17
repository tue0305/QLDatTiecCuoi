/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import POJO.Booking;
import POJO.Dichvu;
import POJO.Khachhang;
import POJO.Menu;

import POJO.Nhanvien;
import POJO.Sanh;
import POJO.Thucpham;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.persistence.criteria.CriteriaBuilder;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author cohotech
 */
public final class Utils {

    private Utils(){};
//Lưu thông tin nhân viên xuyên suốt chương trình
    private static String usernameText;
    
    public static String getUsernameText() {
        return usernameText;
    }


    public static void setUsernameText(String usernameText) {
        Utils.usernameText = usernameText;
    }
    
    public static void resetBooking()
    {
        Utils.payingBooking = null;
        Utils.tienDV = 0.0;
        Utils.tienTP = 0.0;
    }
    
   
    private static Booking payingBooking;
    private static Double tienTP = 0.0;
    private static Double tienDV = 0.0;

    
    public static Booking getPayBooking() {
        return payingBooking;
    }
    
    public static Double getPriceOfFoods() {
        return tienTP;
    }
    
    public static Double getPriceOfServices() {
        return tienDV;
    }
    
    public static void setPayBooking(Booking b) {
        Utils.payingBooking = b;
        for (Thucpham t : getFoodsOfBooking(b)) {
            tienTP += t.getPrice().doubleValue() * b.getSoBan();
        }
        for (Dichvu d : getServicesOfBooking(b)) {
            tienDV += d.getGia().doubleValue();
        }

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

            if (!nv.isEmpty()) {

                return true;
            }
            else {
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
        return new Alert(type, content);
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
    public static void switchStageMouseClick(Scene sce, MouseEvent e) {
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

    public static void hideStage(Scene sce, ActionEvent e) {
        try {
            Node source = (Node) e.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();

            stage.hide();

            Stage s = new Stage();
            s.setScene(sce);
            s.show();

        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }

    }

    // Tìm nhần viên
    public static Nhanvien findStaff(String user) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Criteria cr = session.createCriteria(Nhanvien.class);
        cr.add(Restrictions.eq("userName", user));
        Nhanvien k = (Nhanvien) cr.uniqueResult();
        return k;
    }

    public static List<Thucpham> getThucPham() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Criteria cr = session.createCriteria(Thucpham.class);
        List<Thucpham> ls = cr.list();

        session.close();

        return ls;
    }

    public static List<Booking> getBooking() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Criteria cr = session.createCriteria(Booking.class);
        List<Booking> ls = cr.list();

        session.close();

        return ls;
    }
// tìm kiếm theo listener form TracuuVaThanhToan

    public static List<Booking> getBookingSearch(String kw) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Criteria cr = session.createCriteria(Booking.class);
        List<Booking> a = cr.list();
        List<Booking> ls = new ArrayList<>();
        a.forEach((b) -> {
            if (b.getKhachHang().getTenKH().toLowerCase().contains(kw.toLowerCase())
                    || String.format("%s", b.getKhachHang().getSdt()).contains(kw)) {
                ls.add(b);
            }

        });

        session.close();

        return ls;
    }

//    public static List<Object> getBookingDetails() {
//
//        try {
//            SessionFactory factory = HibernateUtil.getSessionFactory();
//            Session session = factory.openSession();
//            CriteriaBuilder builder ;
//            Criteria cr = session.createCriteria(Booking.class);
//            Criterion c1 = Restrictions.List < Booking > ls = cr.list();
//
//            session.close();
//
//            return ls
//        } catch (Exception e) {
//            System.err.print(e.getMessage());
//        }
//
//    }
    public static Khachhang getCusByBooking(Booking q) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Criteria cr = session.createCriteria(Khachhang.class);
        cr.add(Restrictions.eq("maKH", q.getKhachHang().getMaKH()));
        Khachhang k = (Khachhang) cr.uniqueResult();
        return k;
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

    public static boolean addOrUpdate(Object o) {
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

            cr.add(Restrictions.like("loaiDV", s.getLoaiDV()));
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

            cr.add(Restrictions.like("tenTP", s.getTenTP()));
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

    // Hàm trả về true nếu chuỗi không phải là số
    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    //Tìm đơn hàng
    public static Booking findBooking(String q) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Criteria cr = session.createCriteria(Booking.class);
        cr.add(Restrictions.eq("maBooking", q));
        Booking k = (Booking) cr.uniqueResult();
        return k;
    }

    // Công thức tính hóa đơn
    public static BigDecimal calBooking(Double nOfLateDates, BigDecimal originBill, Double charge) {
        return originBill.add(originBill.multiply(BigDecimal.valueOf(nOfLateDates * charge)));
    }
    //Lấy thực phẩm của tiệc đã đặt 

    public static List<Thucpham> getFoodsOfBooking(Booking b) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Criteria cr = session.createCriteria(Menu.class);
        cr.add(Restrictions.eq("maMenu", b.getMenu().getMaMenu()));
        Menu k = (Menu) cr.uniqueResult();
        return k.getThucPham();
    }

    // Lấy dịch vụ đã đặt
    public static List<Dichvu> getServicesOfBooking(Booking b) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Criteria cr = session.createCriteria(Booking.class);
        cr.add(Restrictions.eq("maBooking", b.getMaBooking()));
        Booking k = (Booking) cr.uniqueResult();
        return k.getDichVu();
    }

    //Format Tiền tệ
    public static String formatCurrency(Double d) {
        Locale locale = new Locale("vi", "VN");
        DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
        DecimalFormatSymbols fb = new DecimalFormatSymbols();
        fb.setGroupingSeparator(',');
        fb.setCurrencySymbol("");
        format.setDecimalFormatSymbols(fb);
        format.setRoundingMode(RoundingMode.HALF_UP);

        return format.format(d);
    }

}
