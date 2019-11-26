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
@Table(name = "sanh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sanh.findAll", query = "SELECT s FROM Sanh s")
    , @NamedQuery(name = "Sanh.findByMaSanh", query = "SELECT s FROM Sanh s WHERE s.maSanh = :maSanh")
    , @NamedQuery(name = "Sanh.findByTenSanh", query = "SELECT s FROM Sanh s WHERE s.tenSanh = :tenSanh")
    , @NamedQuery(name = "Sanh.findByGia", query = "SELECT s FROM Sanh s WHERE s.gia = :gia")
    , @NamedQuery(name = "Sanh.findByLoaiSanh", query = "SELECT s FROM Sanh s WHERE s.loaiSanh = :loaiSanh")
    , @NamedQuery(name = "Sanh.findByGhiChu", query = "SELECT s FROM Sanh s WHERE s.ghiChu = :ghiChu")})
public class Sanh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaSanh")
    private Integer maSanh;
    @Column(name = "TenSanh")
    private String tenSanh;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Gia")
    private BigDecimal gia;
    @Basic(optional = false)
    @Column(name = "LoaiSanh")
    private Character loaiSanh;
    @Column(name = "GhiChu")
    private String ghiChu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maSanh")
    private List<Booking> bookingList;

    public Sanh() {
    }

    public Sanh(Integer maSanh) {
        this.maSanh = maSanh;
    }

    public Sanh(Integer maSanh, BigDecimal gia, Character loaiSanh) {
        this.maSanh = maSanh;
        this.gia = gia;
        this.loaiSanh = loaiSanh;
    }

    public Integer getMaSanh() {
        return maSanh;
    }

    public void setMaSanh(Integer maSanh) {
        this.maSanh = maSanh;
    }

    public String getTenSanh() {
        return tenSanh;
    }

    public void setTenSanh(String tenSanh) {
        this.tenSanh = tenSanh;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public Character getLoaiSanh() {
        return loaiSanh;
    }

    public void setLoaiSanh(Character loaiSanh) {
        this.loaiSanh = loaiSanh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @XmlTransient
    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSanh != null ? maSanh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sanh)) {
            return false;
        }
        Sanh other = (Sanh) object;
        if ((this.maSanh == null && other.maSanh != null) || (this.maSanh != null && !this.maSanh.equals(other.maSanh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "POJO.Sanh[ maSanh=" + maSanh + " ]";
    }
    
}
