/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cohotech
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
    , @NamedQuery(name = "Menu.findByMaMenu", query = "SELECT m FROM Menu m WHERE m.maMenu = :maMenu")
    , @NamedQuery(name = "Menu.findByPrice", query = "SELECT m FROM Menu m WHERE m.price = :price")
    , @NamedQuery(name = "Menu.findByNgayTao", query = "SELECT m FROM Menu m WHERE m.ngayTao = :ngayTao")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaMenu")
    private Integer maMenu;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Price")
    private BigDecimal price;
    @Column(name = "NgayTao")
    @Temporal(TemporalType.DATE)
    private Date ngayTao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maMenu")
    private Collection<Booking> bookingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private Collection<MonanMenu> monanMenuCollection;

    public Menu() {
    }

    public Menu(Integer maMenu) {
        this.maMenu = maMenu;
    }

    public Menu(Integer maMenu, BigDecimal price) {
        this.maMenu = maMenu;
        this.price = price;
    }

    public Integer getMaMenu() {
        return maMenu;
    }

    public void setMaMenu(Integer maMenu) {
        this.maMenu = maMenu;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @XmlTransient
    public Collection<MonanMenu> getMonanMenuCollection() {
        return monanMenuCollection;
    }

    public void setMonanMenuCollection(Collection<MonanMenu> monanMenuCollection) {
        this.monanMenuCollection = monanMenuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMenu != null ? maMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.maMenu == null && other.maMenu != null) || (this.maMenu != null && !this.maMenu.equals(other.maMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "POJO.Menu[ maMenu=" + maMenu + " ]";
    }
    
}
