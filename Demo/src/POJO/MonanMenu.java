/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cohotech
 */
@Entity
@Table(name = "monan_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MonanMenu.findAll", query = "SELECT m FROM MonanMenu m")
    , @NamedQuery(name = "MonanMenu.findByMaMA", query = "SELECT m FROM MonanMenu m WHERE m.monanMenuPK.maMA = :maMA")
    , @NamedQuery(name = "MonanMenu.findByMaMenu", query = "SELECT m FROM MonanMenu m WHERE m.monanMenuPK.maMenu = :maMenu")
    , @NamedQuery(name = "MonanMenu.findBySoLuong", query = "SELECT m FROM MonanMenu m WHERE m.soLuong = :soLuong")})
public class MonanMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MonanMenuPK monanMenuPK;
    @Basic(optional = false)
    @Column(name = "SoLuong")
    private String soLuong;
    @JoinColumn(name = "MaMenu", referencedColumnName = "MaMenu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menu menu;
    @JoinColumn(name = "MaMA", referencedColumnName = "MaMA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Monan monan;

    public MonanMenu() {
    }

    public MonanMenu(MonanMenuPK monanMenuPK) {
        this.monanMenuPK = monanMenuPK;
    }

    public MonanMenu(MonanMenuPK monanMenuPK, String soLuong) {
        this.monanMenuPK = monanMenuPK;
        this.soLuong = soLuong;
    }

    public MonanMenu(int maMA, int maMenu) {
        this.monanMenuPK = new MonanMenuPK(maMA, maMenu);
    }

    public MonanMenuPK getMonanMenuPK() {
        return monanMenuPK;
    }

    public void setMonanMenuPK(MonanMenuPK monanMenuPK) {
        this.monanMenuPK = monanMenuPK;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Monan getMonan() {
        return monan;
    }

    public void setMonan(Monan monan) {
        this.monan = monan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (monanMenuPK != null ? monanMenuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonanMenu)) {
            return false;
        }
        MonanMenu other = (MonanMenu) object;
        if ((this.monanMenuPK == null && other.monanMenuPK != null) || (this.monanMenuPK != null && !this.monanMenuPK.equals(other.monanMenuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "POJO.MonanMenu[ monanMenuPK=" + monanMenuPK + " ]";
    }
    
}
