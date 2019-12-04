///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package POJO;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.util.Date;
//import java.util.Set;
//import javax.persistence.Basic;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;
//
///**
// *
// * @author cohotech
// */
//@Entity
//@Table(name = "menu")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
//    , @NamedQuery(name = "Menu.findByMaMenu", query = "SELECT m FROM Menu m WHERE m.maMenu = :maMenu")
//    , @NamedQuery(name = "Menu.findByPrice", query = "SELECT m FROM Menu m WHERE m.price = :price")
//    , @NamedQuery(name = "Menu.findByNgayTao", query = "SELECT m FROM Menu m WHERE m.ngayTao = :ngayTao")
//    , @NamedQuery(name = "Menu.findByTenMenu", query = "SELECT m FROM Menu m WHERE m.tenMenu = :tenMenu")})
//public class Menu implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "MaMenu")
//    private Integer maMenu;
//    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
//    @Basic(optional = false)
//    @Column(name = "Price")
//    private BigDecimal price;
//    @Column(name = "NgayTao")
//    @Temporal(TemporalType.DATE)
//    private Date ngayTao;
//    @Column(name = "TenMenu")
//    private String tenMenu;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
//    private Set<ThucphamMenu> thucphamMenuSet;
//
//    public Menu() {
//    }
//
//    public Menu(Integer maMenu) {
//        this.maMenu = maMenu;
//    }
//
//    public Menu(Integer maMenu, BigDecimal price) {
//        this.maMenu = maMenu;
//        this.price = price;
//    }
//
//    public Integer getMaMenu() {
//        return maMenu;
//    }
//
//    public void setMaMenu(Integer maMenu) {
//        this.maMenu = maMenu;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    public Date getNgayTao() {
//        return ngayTao;
//    }
//
//    public void setNgayTao(Date ngayTao) {
//        this.ngayTao = ngayTao;
//    }
//
//    public String getTenMenu() {
//        return tenMenu;
//    }
//
//    public void setTenMenu(String tenMenu) {
//        this.tenMenu = tenMenu;
//    }
//
//    @XmlTransient
//    public Set<ThucphamMenu> getThucphamMenuSet() {
//        return thucphamMenuSet;
//    }
//
//    public void setThucphamMenuSet(Set<ThucphamMenu> thucphamMenuSet) {
//        this.thucphamMenuSet = thucphamMenuSet;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (maMenu != null ? maMenu.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Menu)) {
//            return false;
//        }
//        Menu other = (Menu) object;
//        if ((this.maMenu == null && other.maMenu != null) || (this.maMenu != null && !this.maMenu.equals(other.maMenu))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "POJO.Menu[ maMenu=" + maMenu + " ]";
//    }
//    
//}
