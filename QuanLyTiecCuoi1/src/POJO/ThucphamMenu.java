///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package POJO;
//
//import java.io.Serializable;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.xml.bind.annotation.XmlRootElement;
//
///**
// *
// * @author cohotech
// */
//@Entity
//@Table(name = "thucpham_menu")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "ThucphamMenu.findAll", query = "SELECT t FROM ThucphamMenu t")
//    , @NamedQuery(name = "ThucphamMenu.findByMaTP", query = "SELECT t FROM ThucphamMenu t WHERE t.thucphamMenuPK.maTP = :maTP")
//    , @NamedQuery(name = "ThucphamMenu.findByMaMenu", query = "SELECT t FROM ThucphamMenu t WHERE t.thucphamMenuPK.maMenu = :maMenu")
//    , @NamedQuery(name = "ThucphamMenu.findBySoLuong", query = "SELECT t FROM ThucphamMenu t WHERE t.soLuong = :soLuong")})
//public class ThucphamMenu implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @EmbeddedId
//    protected ThucphamMenuPK thucphamMenuPK;
//    @Basic(optional = false)
//    @Column(name = "SoLuong")
//    private String soLuong;
//    @JoinColumn(name = "MaMenu", referencedColumnName = "MaMenu", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private Menu menu;
//    @JoinColumn(name = "MaTP", referencedColumnName = "MaTP", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private Thucpham thucpham;
//
//    public ThucphamMenu() {
//    }
//
//    public ThucphamMenu(ThucphamMenuPK thucphamMenuPK) {
//        this.thucphamMenuPK = thucphamMenuPK;
//    }
//
//    public ThucphamMenu(ThucphamMenuPK thucphamMenuPK, String soLuong) {
//        this.thucphamMenuPK = thucphamMenuPK;
//        this.soLuong = soLuong;
//    }
//
//    public ThucphamMenu(int maTP, int maMenu) {
//        this.thucphamMenuPK = new ThucphamMenuPK(maTP, maMenu);
//    }
//
//    public ThucphamMenuPK getThucphamMenuPK() {
//        return thucphamMenuPK;
//    }
//
//    public void setThucphamMenuPK(ThucphamMenuPK thucphamMenuPK) {
//        this.thucphamMenuPK = thucphamMenuPK;
//    }
//
//    public String getSoLuong() {
//        return soLuong;
//    }
//
//    public void setSoLuong(String soLuong) {
//        this.soLuong = soLuong;
//    }
//
//    public Menu getMenu() {
//        return menu;
//    }
//
//    public void setMenu(Menu menu) {
//        this.menu = menu;
//    }
//
//    public Thucpham getThucpham() {
//        return thucpham;
//    }
//
//    public void setThucpham(Thucpham thucpham) {
//        this.thucpham = thucpham;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (thucphamMenuPK != null ? thucphamMenuPK.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof ThucphamMenu)) {
//            return false;
//        }
//        ThucphamMenu other = (ThucphamMenu) object;
//        if ((this.thucphamMenuPK == null && other.thucphamMenuPK != null) || (this.thucphamMenuPK != null && !this.thucphamMenuPK.equals(other.thucphamMenuPK))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "POJO.ThucphamMenu[ thucphamMenuPK=" + thucphamMenuPK + " ]";
//    }
//    
//}
