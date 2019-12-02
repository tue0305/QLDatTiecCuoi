/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author cohotech
 */
@Embeddable
public class MonanMenuPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "MaMA")
    private int maMA;
    @Basic(optional = false)
    @Column(name = "MaMenu")
    private int maMenu;

    public MonanMenuPK() {
    }

    public MonanMenuPK(int maMA, int maMenu) {
        this.maMA = maMA;
        this.maMenu = maMenu;
    }

    public int getMaMA() {
        return maMA;
    }

    public void setMaMA(int maMA) {
        this.maMA = maMA;
    }

    public int getMaMenu() {
        return maMenu;
    }

    public void setMaMenu(int maMenu) {
        this.maMenu = maMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maMA;
        hash += (int) maMenu;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonanMenuPK)) {
            return false;
        }
        MonanMenuPK other = (MonanMenuPK) object;
        if (this.maMA != other.maMA) {
            return false;
        }
        if (this.maMenu != other.maMenu) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "POJO.MonanMenuPK[ maMA=" + maMA + ", maMenu=" + maMenu + " ]";
    }
    
}
