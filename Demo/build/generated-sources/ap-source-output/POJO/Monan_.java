package POJO;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Monan.class)
public abstract class Monan_ {

	public static volatile SingularAttribute<Monan, String> tenMA;
	public static volatile SingularAttribute<Monan, BigDecimal> price;
	public static volatile SingularAttribute<Monan, Integer> maMA;
	public static volatile ListAttribute<Monan, MonanMenu> monanMenuList;

}

