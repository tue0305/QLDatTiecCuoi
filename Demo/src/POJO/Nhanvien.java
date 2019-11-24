/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "nhanvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nhanvien.findAll", query = "SELECT n FROM Nhanvien n")
    , @NamedQuery(name = "Nhanvien.findByMaNV", query = "SELECT n FROM Nhanvien n WHERE n.maNV = :maNV")
    , @NamedQuery(name = "Nhanvien.findByChucVu", query = "SELECT n FROM Nhanvien n WHERE n.chucVu = :chucVu")
    , @NamedQuery(name = "Nhanvien.findByTenNV", query = "SELECT n FROM Nhanvien n WHERE n.tenNV = :tenNV")
    , @NamedQuery(name = "Nhanvien.findByUserName", query = "SELECT n FROM Nhanvien n WHERE n.userName = :userName")
    , @NamedQuery(name = "Nhanvien.findByPassword", query = "SELECT n FROM Nhanvien n WHERE n.password = :password")})
public class Nhanvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaNV")
    private String maNV;
    @Basic(optional = false)
    @Column(name = "ChucVu")
    private String chucVu;
    @Basic(optional = false)
    @Column(name = "TenNV")
    private String tenNV;
    @Basic(optional = false)
    @Column(name = "UserName",unique = true)
    private String userName;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maNV")
    private List<Booking> bookingList;

    public Nhanvien() {
    }

    public Nhanvien(String maNV) {
        this.maNV = maNV;
    }

    public Nhanvien(String maNV, String chucVu, String tenNV, String userName, String password) {
        this.maNV = maNV;
        this.chucVu = chucVu;
        this.tenNV = tenNV;
        this.userName = userName;
        this.password = password;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        hash += (maNV != null ? maNV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nhanvien)) {
            return false;
        }
        Nhanvien other = (Nhanvien) object;
        if ((this.maNV == null && other.maNV != null) || (this.maNV != null && !this.maNV.equals(other.maNV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "POJO.Nhanvien[ maNV=" + maNV + " ]";
    }
    
}
