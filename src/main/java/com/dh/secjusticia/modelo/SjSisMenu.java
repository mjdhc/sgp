/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cuevaw
 */
@Entity
@Table(name = "sj_sis_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SjSisMenu.findAll", query = "SELECT s FROM SjSisMenu s")
    , @NamedQuery(name = "SjSisMenu.findByMenId", query = "SELECT s FROM SjSisMenu s WHERE s.menId = :menId")
    , @NamedQuery(name = "SjSisMenu.findByMenNombre", query = "SELECT s FROM SjSisMenu s WHERE s.menNombre = :menNombre")
    , @NamedQuery(name = "SjSisMenu.findByMenUrl", query = "SELECT s FROM SjSisMenu s WHERE s.menUrl = :menUrl")
    , @NamedQuery(name = "SjSisMenu.findByMenPadre", query = "SELECT s FROM SjSisMenu s WHERE s.menPadre = :menPadre")})
public class SjSisMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "men_id")
    private Integer menId;
    @Size(max = 50)
    @Column(name = "men_nombre")
    private String menNombre;
    @Size(max = 100)
    @Column(name = "men_url")
    private String menUrl;
    @Column(name = "men_padre")
    private Integer menPadre;
    @OneToMany(mappedBy = "menId")
    private Collection<SjSisRolMenUsuCen> sjSisRolMenUsuCenCollection;

    public SjSisMenu() {
    }

    public SjSisMenu(Integer menId) {
        this.menId = menId;
    }

    public Integer getMenId() {
        return menId;
    }

    public void setMenId(Integer menId) {
        this.menId = menId;
    }

    public String getMenNombre() {
        return menNombre;
    }

    public void setMenNombre(String menNombre) {
        this.menNombre = menNombre;
    }

    public String getMenUrl() {
        return menUrl;
    }

    public void setMenUrl(String menUrl) {
        this.menUrl = menUrl;
    }

    public Integer getMenPadre() {
        return menPadre;
    }

    public void setMenPadre(Integer menPadre) {
        this.menPadre = menPadre;
    }

    @XmlTransient
    public Collection<SjSisRolMenUsuCen> getSjSisRolMenUsuCenCollection() {
        return sjSisRolMenUsuCenCollection;
    }

    public void setSjSisRolMenUsuCenCollection(Collection<SjSisRolMenUsuCen> sjSisRolMenUsuCenCollection) {
        this.sjSisRolMenUsuCenCollection = sjSisRolMenUsuCenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menId != null ? menId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SjSisMenu)) {
            return false;
        }
        SjSisMenu other = (SjSisMenu) object;
        if ((this.menId == null && other.menId != null) || (this.menId != null && !this.menId.equals(other.menId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dh.secjusticia.modelo.SjSisMenu[ menId=" + menId + " ]";
    }
    
}
