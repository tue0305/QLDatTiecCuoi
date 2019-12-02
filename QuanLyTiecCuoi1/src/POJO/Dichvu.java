/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cohotech
 */
@Entity
@Table(name = "dichvu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dichvu.findAll", query = "SELECT d FROM Dichvu d")
    , @NamedQuery(name = "Dichvu.findByMaDV", query = "SELECT d FROM Dichvu d WHERE d.maDV = :maDV")
    , @NamedQuery(name = "Dichvu.findByTenDV", query = "SELECT d FROM Dichvu d WHERE d.tenDV = :tenDV")
    , @NamedQuery(name = "Dichvu.findByGia", query = "SELECT d FROM Dichvu d WHERE d.gia = :gia")
    , @NamedQuery(name = "Dichvu.findByLoaiDV", query = "SELECT d FROM Dichvu d WHERE d.loaiDV = :loaiDV")})
public class Dichvu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaDV")
    private Integer maDV;
    @Column(name = "TenDV")
    private String tenDV;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Gia")
    private BigDecimal gia;
    @Basic(optional = false)
    @Column(name = "LoaiDV")
    private String loaiDV;
    @Lob
    @Column(name = "GhiChu")
    private String ghiChu;

    public Dichvu() {
    }

    public Dichvu(String tenDV, String loaiDV, BigDecimal gia) {
        this.maDV = maDV;
        this.loaiDV = loaiDV;
        this.gia = gia;

    }

    public Dichvu(String tenDV, String loaiDV, BigDecimal gia, String ghiChu) {
        this.tenDV = tenDV;
        this.loaiDV = loaiDV;
        this.gia = gia;
        this.ghiChu = ghiChu;
    }

    public Integer getMaDV() {
        return maDV;
    }

    public void setMaDV(Integer maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public String getLoaiDV() {
        return loaiDV;
    }

    public void setLoaiDV(String loaiDV) {
        this.loaiDV = loaiDV;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return this.getLoaiDV();
    }

}
