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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "LoaiSanh",length=1, columnDefinition="CHAR")
    private String loaiSanh;
    @Column(name = "GhiChu")
    private String ghiChu;


    public Sanh() {
    }

    

    public Sanh( String tenSanh , BigDecimal gia, String loaiSanh) {
        
        this.gia = gia;
        this.loaiSanh = loaiSanh;
        this.tenSanh = tenSanh;
    }
    public Sanh( String tenSanh , BigDecimal gia, String loaiSanh, String ghiChu ) {
        this.ghiChu = ghiChu;
        this.gia = gia;
        this.loaiSanh = loaiSanh;
        this.tenSanh = tenSanh;
    }

    public Integer getMaSanh() {
        return maSanh;
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

    

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

//   

   

    @Override
    public String toString() {
        return this.getLoaiSanh().toString();
        
    }
    
   

    /**
     * @return the loaiSanh
     */
    public String getLoaiSanh() {
        return loaiSanh;
    }

    /**
     * @param loaiSanh the loaiSanh to set
     */
    public void setLoaiSanh(String loaiSanh) {
        this.loaiSanh = loaiSanh;
    }

    public Object[] getTenSanh(List<Sanh> sanh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
