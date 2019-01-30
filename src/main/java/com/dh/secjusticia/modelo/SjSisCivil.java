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
@Table(name = "sj_sis_civil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SjSisCivil.findAll", query = "SELECT s FROM SjSisCivil s")
    , @NamedQuery(name = "SjSisCivil.findByCivId", query = "SELECT s FROM SjSisCivil s WHERE s.civId = :civId")
    , @NamedQuery(name = "SjSisCivil.findByCivNombre", query = "SELECT s FROM SjSisCivil s WHERE s.civNombre = :civNombre")})
public class SjSisCivil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "civ_id")
    private Integer civId;
    @Size(max = 10)
    @Column(name = "civ_nombre")
    private String civNombre;
    @OneToMany(mappedBy = "civId")
    private Collection<SjSisPersona> sjSisPersonaCollection;

    public SjSisCivil() {
    }

    public SjSisCivil(Integer civId) {
        this.civId = civId;
    }

    public Integer getCivId() {
        return civId;
    }

    public void setCivId(Integer civId) {
        this.civId = civId;
    }

    public String getCivNombre() {
        return civNombre;
    }

    public void setCivNombre(String civNombre) {
        this.civNombre = civNombre;
    }

    @XmlTransient
    public Collection<SjSisPersona> getSjSisPersonaCollection() {
        return sjSisPersonaCollection;
    }

    public void setSjSisPersonaCollection(Collection<SjSisPersona> sjSisPersonaCollection) {
        this.sjSisPersonaCollection = sjSisPersonaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (civId != null ? civId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SjSisCivil)) {
            return false;
        }
        SjSisCivil other = (SjSisCivil) object;
        if ((this.civId == null && other.civId != null) || (this.civId != null && !this.civId.equals(other.civId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dh.secjusticia.modelo.SjSisCivil[ civId=" + civId + " ]";
    }
    
}
