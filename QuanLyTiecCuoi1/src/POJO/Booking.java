/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import com.sun.javafx.binding.StringFormatter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
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

    @Basic(optional = false)
    @Column(name = "MaBooking")
    private String maBooking;
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
    @JoinTable(
            name = "booking_dichvu",
            joinColumns = {
                @JoinColumn(name = "maBooking")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "maDV")
            }
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Dichvu> dichVu;
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH")
    @ManyToOne(optional = false)
    private Khachhang khachHang;
    @JoinColumn(name = "MaMenu", referencedColumnName = "MaMenu")
    @ManyToOne(optional = false)
    private Menu menu;
    @JoinColumn(name = "MaNV", referencedColumnName = "MaNV")
    @ManyToOne(optional = false)
    private Nhanvien nhanVien;
    @JoinColumn(name = "MaSanh", referencedColumnName = "MaSanh")
    @ManyToOne(optional = false)
    private Sanh sanh;

    public Booking() {
    }

    public Booking(String maBooking) {
        this.maBooking = maBooking;
    }

    public Booking(Date ngayDat, BigDecimal price, Character ca, Nhanvien nhanVien,
            Khachhang maKH, Sanh sanh, Menu menu, List<Dichvu> dichVu, Date ngayThanhToan,
            String note) {

        this.maBooking = UUID.randomUUID().toString();
        this.ngayDat = ngayDat;
        this.ngayThanhToan = ngayThanhToan;
        this.dichVu = dichVu;
        this.menu = menu;
        this.nhanVien = nhanVien;
        this.khachHang = maKH;
        this.ghiChu = note;
        this.price = price;
        this.ca = ca;
        this.sanh = sanh;
    }
    
    public String getNameCus() {
        return this.khachHang.getTenKH().toString();
    }

    public String getPhoneCus() {
        return String.format("%s", this.khachHang.getSdt());
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

   

    public Khachhang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(Khachhang khachHang) {
        this.khachHang = khachHang;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Nhanvien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(Nhanvien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Sanh getSanh() {
        return sanh;
    }

    public void setSanh(Sanh sanh) {
        this.sanh = sanh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getMaBooking() != null ? getMaBooking().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.getMaBooking() == null && other.getMaBooking() != null) || (this.getMaBooking() != null && !this.maBooking.equals(other.maBooking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.price.toString();
    }

    /**
     * @return the maBooking
     */
    public String getMaBooking() {
        return maBooking;
    }

    /**
     * @param maBooking the maBooking to set
     */
    public void setMaBooking(String maBooking) {
        this.maBooking = maBooking;
    }

    /**
     * @return the dichVu
     */
    public List<Dichvu> getDichVu() {
        return dichVu;
    }

    /**
     * @param dichVu the dichVu to set
     */
    public void setDichVu(List<Dichvu> dichVu) {
        this.dichVu = dichVu;
    }
    public String formatDate(Date t)
    {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        return f.format(t);
    }
    
   
}
