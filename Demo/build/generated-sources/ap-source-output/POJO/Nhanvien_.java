package POJO;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Nhanvien.class)
public abstract class Nhanvien_ {

	public static volatile SingularAttribute<Nhanvien, String> password;
	public static volatile ListAttribute<Nhanvien, Booking> bookingList;
	public static volatile SingularAttribute<Nhanvien, String> tenNV;
	public static volatile SingularAttribute<Nhanvien, String> userName;
	public static volatile SingularAttribute<Nhanvien, String> chucVu;
	public static volatile SingularAttribute<Nhanvien, String> maNV;

}

