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
@Table(name = "monan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monan.findAll", query = "SELECT m FROM Monan m")
    , @NamedQuery(name = "Monan.findByMaMA", query = "SELECT m FROM Monan m WHERE m.maMA = :maMA")
    , @NamedQuery(name = "Monan.findByTenMA", query = "SELECT m FROM Monan m WHERE m.tenMA = :tenMA")
    , @NamedQuery(name = "Monan.findByPrice", query = "SELECT m FROM Monan m WHERE m.price = :price")})
public class Monan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaMA")
    private Integer maMA;
    @Basic(optional = false)
    @Column(name = "TenMA")
    private String tenMA;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Price")
    private BigDecimal price;
    @Column(name = "GhiChu")
    private String ghiChu;

    public Monan() {
    }

    public Monan(String tenMA, BigDecimal price) {

        this.tenMA = tenMA;
        this.price = price;
    }

    public Monan(String tenMA, BigDecimal price, String ghiChu) {
        this.ghiChu = ghiChu;
        this.tenMA = tenMA;
        this.price = price;
    }

    public Integer getMaMA() {
        return maMA;
    }

    public String getTenMA() {
        return tenMA;
    }

    public void setTenMA(String tenMA) {
        this.tenMA = tenMA;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getTenMA();
    }

    /**
     * @return the ghiChu
     */
    public String getGhiChu() {
        return ghiChu;
    }

    /**
     * @param ghiChu the ghiChu to set
     */
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
