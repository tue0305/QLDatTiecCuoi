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
//import javax.persistence.Embeddable;
//
///**
// *
// * @author cohotech
// */
//@Embeddable
//public class ThucphamMenuPK implements Serializable {
//
//    @Basic(optional = false)
//    @Column(name = "MaTP")
//    private int maTP;
//    @Basic(optional = false)
//    @Column(name = "MaMenu")
//    private int maMenu;
//
//    public ThucphamMenuPK() {
//    }
//
//    public ThucphamMenuPK(int maTP, int maMenu) {
//        this.maTP = maTP;
//        this.maMenu = maMenu;
//    }
//
//    public int getMaTP() {
//        return maTP;
//    }
//
//    public void setMaTP(int maTP) {
//        this.maTP = maTP;
//    }
//
//    public int getMaMenu() {
//        return maMenu;
//    }
//
//    public void setMaMenu(int maMenu) {
//        this.maMenu = maMenu;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (int) maTP;
//        hash += (int) maMenu;
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof ThucphamMenuPK)) {
//            return false;
//        }
//        ThucphamMenuPK other = (ThucphamMenuPK) object;
//        if (this.maTP != other.maTP) {
//            return false;
//        }
//        if (this.maMenu != other.maMenu) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "POJO.ThucphamMenuPK[ maTP=" + maTP + ", maMenu=" + maMenu + " ]";
//    }
//    
//}
