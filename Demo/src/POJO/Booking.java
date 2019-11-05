/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cohotech
 */
@Entity
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Booking.findByMaBooking", query = "SELECT b FROM Booking b WHERE b.maBooking = :maBooking")
    , @NamedQuery(name = "Booking.findByNgayDat", query = "SELECT b FROM Booking b WHERE b.ngayDat = :ngayDat")
    , @NamedQuery(name = "Booking.findByNgayThanhToan", query = "SELECT b FROM Booking b WHERE b.ngayThanhToan = :ngayThanhToan")
    , @NamedQuery(name = "Booking.findByPrice", query = "SELECT b FROM Booking b WHERE b.price = :price")
    , @NamedQuery(name = "Booking.findByCa", query = "SELECT b FROM Booking b WHERE b.ca = :ca")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaBooking")
    private Integer maBooking;
    @Basic(optional = false)
    @Column(name = "NgayDat")
    @Temporal(TemporalType.DATE)
    private Date ngayDat;
    @Column(name = "NgayThanhToan")
    @Temporal(TemporalType.DATE)
    private Date ngayThanhToan;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Price")
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "Ca")
    private Character ca;
    @Lob
    @Column(name = "GhiChu")
    private String ghiChu;
    @JoinColumn(name = "MaDV", referencedColumnName = "MaDV")
    @ManyToOne(optional = false)
    private Dichvu maDV;
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH")
    @ManyToOne(optional = false)
    private Khachhang maKH;
    @JoinColumn(name = "MaMenu", referencedColumnName = "MaMenu")
    @ManyToOne(optional = false)
    private Menu maMenu;
    @JoinColumn(name = "MaNV", referencedColumnName = "MaNV")
    @ManyToOne(optional = false)
    private Nhanvien maNV;
    @JoinColumn(name = "MaSanh", referencedColumnName = "MaSanh")
    @ManyToOne(optional = false)
    private Sanh maSanh;

    public Booking() {
    }

    public Booking(Integer maBooking) {
        this.maBooking = maBooking;
    }

    public Booking(Integer maBooking, Date ngayDat, BigDecimal price, Character ca) {
        this.maBooking = maBooking;
        this.ngayDat = ngayDat;
        this.price = price;
        this.ca = ca;
    }

    public Integer getMaBooking() {
        return maBooking;
    }

    public void setMaBooking(Integer maBooking) {
        this.maBooking = maBooking;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Character getCa() {
        return ca;
    }

    public void setCa(Character ca) {
        this.ca = ca;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Dichvu getMaDV() {
        return maDV;
    }

    public void setMaDV(Dichvu maDV) {
        this.maDV = maDV;
    }

    public Khachhang getMaKH() {
        return maKH;
    }

    public void setMaKH(Khachhang maKH) {
        this.maKH = maKH;
    }

    public Menu getMaMenu() {
        return maMenu;
    }

    public void setMaMenu(Menu maMenu) {
        this.maMenu = maMenu;
    }

    public Nhanvien getMaNV() {
        return maNV;
    }

    public void setMaNV(Nhanvien maNV) {
        this.maNV = maNV;
    }

    public Sanh getMaSanh() {
        return maSanh;
    }

    public void setMaSanh(Sanh maSanh) {
        this.maSanh = maSanh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maBooking != null ? maBooking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.maBooking == null && other.maBooking != null) || (this.maBooking != null && !this.maBooking.equals(other.maBooking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "POJO.Booking[ maBooking=" + maBooking + " ]";
    }
    
}
