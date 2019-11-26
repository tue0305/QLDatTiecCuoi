/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cohotech
 */
@Entity
@Table(name = "monan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monan.findAll", query = "SELECT m FROM Monan m")
    , @NamedQuery(name = "Monan.findByMaMA", query = "SELECT m FROM Monan m WHERE m.maMA = :maMA")
    , @NamedQuery(name = "Monan.findByTenMA", query = "SELECT m FROM Monan m WHERE m.tenMA = :tenMA")
    , @NamedQuery(name = "Monan.findByPrice", query = "SELECT m FROM Monan m WHERE m.price = :price")})
public class Monan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaMA")
    private Integer maMA;
    @Basic(optional = false)
    @Column(name = "TenMA")
    private String tenMA;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Price")
    private BigDecimal price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monan")
    private List<MonanMenu> monanMenuList;

    public Monan() {
    }

    public Monan(Integer maMA) {
        this.maMA = maMA;
    }

    public Monan(Integer maMA, String tenMA, BigDecimal price) {
        this.maMA = maMA;
        this.tenMA = tenMA;
        this.price = price;
    }

    public Integer getMaMA() {
        return maMA;
    }

    public void setMaMA(Integer maMA) {
        this.maMA = maMA;
    }

    public String getTenMA() {
        return tenMA;
    }

    public void setTenMA(String tenMA) {
        this.tenMA = tenMA;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @XmlTransient
    public List<MonanMenu> getMonanMenuList() {
        return monanMenuList;
    }

    public void setMonanMenuList(List<MonanMenu> monanMenuList) {
        this.monanMenuList = monanMenuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMA != null ? maMA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monan)) {
            return false;
        }
        Monan other = (Monan) object;
        if ((this.maMA == null && other.maMA != null) || (this.maMA != null && !this.maMA.equals(other.maMA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "POJO.Monan[ maMA=" + maMA + " ]";
    }
    
}
