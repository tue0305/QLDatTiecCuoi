package POJO;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Menu.class)
public abstract class Menu_ {

	public static volatile SingularAttribute<Menu, BigDecimal> price;
	public static volatile ListAttribute<Menu, Booking> bookingList;
	public static volatile SingularAttribute<Menu, Integer> maMenu;
	public static volatile ListAttribute<Menu, MonanMenu> monanMenuList;
	public static volatile SingularAttribute<Menu, Date> ngayTao;

}

