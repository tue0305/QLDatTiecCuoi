package POJO;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Booking.class)
public abstract class Booking_ {

	public static volatile SingularAttribute<Booking, Khachhang> maKH;
	public static volatile SingularAttribute<Booking, Sanh> maSanh;
	public static volatile SingularAttribute<Booking, String> ghiChu;
	public static volatile SingularAttribute<Booking, Dichvu> maDV;
	public static volatile SingularAttribute<Booking, BigDecimal> price;
	public static volatile SingularAttribute<Booking, Date> ngayThanhToan;
	public static volatile SingularAttribute<Booking, Menu> maMenu;
	public static volatile SingularAttribute<Booking, Date> ngayDat;
	public static volatile SingularAttribute<Booking, Integer> maBooking;
	public static volatile SingularAttribute<Booking, Character> ca;
	public static volatile SingularAttribute<Booking, Nhanvien> maNV;

}

