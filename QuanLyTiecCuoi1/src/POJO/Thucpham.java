/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cohotech
 */
@Entity
@Table(name = "thucpham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thucpham.findAll", query = "SELECT t FROM Thucpham t")
    , @NamedQuery(name = "Thucpham.findByMaTP", query = "SELECT t FROM Thucpham t WHERE t.maTP = :maTP")
    , @NamedQuery(name = "Thucpham.findByTenTP", query = "SELECT t FROM Thucpham t WHERE t.tenTP = :tenTP")
    , @NamedQuery(name = "Thucpham.findByPrice", query = "SELECT t FROM Thucpham t WHERE t.price = :price")
    , @NamedQuery(name = "Thucpham.findByLoaiTP", query = "SELECT t FROM Thucpham t WHERE t.loaiTP = :loaiTP")})
public class Thucpham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaTP")
    private Integer maTP;
    @Basic(optional = false)
    @Column(name = "TenTP")
    private String tenTP;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Price")
    private BigDecimal price;
    @Lob
    @Column(name = "GhiChu")
    private String ghiChu;
    @Column(name = "LoaiTP")
    private String loaiTP;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thucpham")
//    private Set<ThucphamMenu> thucphamMenuSet;

    public Thucpham() {
    }

   
    public Thucpham( String tenTP, String loaiTP,  BigDecimal price, String ghiChu) {
        this.loaiTP = loaiTP;
        this.tenTP = tenTP;
        this.price = price;
        this.ghiChu = ghiChu;
    }

    public Integer getMaTP() {
        return maTP;
    }

    public void setMaTP(Integer maTP) {
        this.maTP = maTP;
    }

    public String getTenTP() {
        return tenTP;
    }

    public void setTenTP(String tenTP) {
        this.tenTP = tenTP;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getLoaiTP() {
        return loaiTP;
    }

    public void setLoaiTP(String loaiTP) {
        this.loaiTP = loaiTP;
    }

//    @XmlTransient
//    public Set<ThucphamMenu> getThucphamMenuSet() {
//        return thucphamMenuSet;
//    }
//
//    public void setThucphamMenuSet(Set<ThucphamMenu> thucphamMenuSet) {
//        this.thucphamMenuSet = thucphamMenuSet;
//    }

   

    
    @Override
    public String toString() {
        return this.getLoaiTP().toString();
    }
    
}
