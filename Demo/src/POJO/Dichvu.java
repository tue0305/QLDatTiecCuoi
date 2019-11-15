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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "dichvu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dichvu.findAll", query = "SELECT d FROM Dichvu d")
    , @NamedQuery(name = "Dichvu.findByMaDV", query = "SELECT d FROM Dichvu d WHERE d.maDV = :maDV")
    , @NamedQuery(name = "Dichvu.findByMc", query = "SELECT d FROM Dichvu d WHERE d.mc = :mc")
    , @NamedQuery(name = "Dichvu.findByCaSi", query = "SELECT d FROM Dichvu d WHERE d.caSi = :caSi")
    , @NamedQuery(name = "Dichvu.findByBanhKem", query = "SELECT d FROM Dichvu d WHERE d.banhKem = :banhKem")})
public class Dichvu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MaDV")
    @GeneratedValue(strategy = GenerationType.AUTO  )
    private Integer maDV;
    @Column(name = "MC")
    private String mc;
    @Column(name = "CaSi")
    private String caSi;
    @Column(name = "BanhKem")
    private String banhKem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maDV")
    private List<Booking> bookingList;

    public Dichvu() {
    }
    public Dichvu(Integer maDV) {
        this.maDV = maDV;
    }

    public Integer getMaDV() {
        return maDV;
    }

    public void setMaDV(Integer maDV) {
        this.maDV = maDV;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getCaSi() {
        return caSi;
    }

    public void setCaSi(String caSi) {
        this.caSi = caSi;
    }

    public String getBanhKem() {
        return banhKem;
    }

    public void setBanhKem(String banhKem) {
        this.banhKem = banhKem;
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
        hash += (maDV != null ? maDV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dichvu)) {
            return false;
        }
        Dichvu other = (Dichvu) object;
        if ((this.maDV == null && other.maDV != null) || (this.maDV != null && !this.maDV.equals(other.maDV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "POJO.Dichvu[ maDV=" + maDV + " ]";
    }
    
}
