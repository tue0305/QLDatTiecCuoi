/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HPCOMPUTER.VN
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
    , @NamedQuery(name = "Menu.findByMaMenu", query = "SELECT m FROM Menu m WHERE m.maMenu = :maMenu")
   
    , @NamedQuery(name = "Menu.findByNgayTao", query = "SELECT m FROM Menu m WHERE m.ngayTao = :ngayTao")})
   
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaMenu")
    private Integer maMenu;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "NgayTao")
    @Temporal(TemporalType.DATE)
    private Date ngayTao;
    
    @JoinTable(
            name = "thucpham_menu",
            joinColumns = {
                @JoinColumn(name = "maMenu")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "maTP")
            }
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Thucpham> thucPham;
    public Menu() {
    }

    public Menu(List<Thucpham> ls) {
        this.thucPham = ls;
        this.ngayTao = new Date();
    }

    public Integer getMaMenu() {
        return maMenu;
        
    }

    public void setMaMenu(Integer maMenu) {
        this.maMenu = maMenu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

  

   
  
    /**
     * @return the thucPham
     */
    public List<Thucpham> getThucPham() {
        return thucPham;
    }

    /**
     * @param thucPham the thucPham to set
     */
    public void setThucPham(List<Thucpham> thucPham) {
        this.thucPham = thucPham;
    }

}
