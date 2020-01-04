package POJO;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Booking.class)
public abstract class Booking_ {

	public static volatile ListAttribute<Booking, Dichvu> dichVu;
	public static volatile SingularAttribute<Booking, String> ghiChu;
	public static volatile SingularAttribute<Booking, Nhanvien> nhanVien;
	public static volatile SingularAttribute<Booking, BigDecimal> price;
	public static volatile SingularAttribute<Booking, Khachhang> khachHang;
	public static volatile SingularAttribute<Booking, Date> ngayThanhToan;
	public static volatile SingularAttribute<Booking, Date> ngayDat;
	public static volatile SingularAttribute<Booking, Integer> soBan;
	public static volatile SingularAttribute<Booking, Menu> menu;
	public static volatile SingularAttribute<Booking, String> maBooking;
	public static volatile SingularAttribute<Booking, Sanh> sanh;
	public static volatile SingularAttribute<Booking, Character> ca;

}

