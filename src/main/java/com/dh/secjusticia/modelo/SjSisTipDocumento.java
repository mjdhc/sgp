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
@Table(name = "sj_sis_tip_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SjSisTipDocumento.findAll", query = "SELECT s FROM SjSisTipDocumento s")
    , @NamedQuery(name = "SjSisTipDocumento.findByTipdId", query = "SELECT s FROM SjSisTipDocumento s WHERE s.tipdId = :tipdId")
    , @NamedQuery(name = "SjSisTipDocumento.findByTipdNombre", query = "SELECT s FROM SjSisTipDocumento s WHERE s.tipdNombre = :tipdNombre")})
public class SjSisTipDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipd_id")
    private Integer tipdId;
    @Size(max = 50)
    @Column(name = "tipd_nombre")
    private String tipdNombre;
    @OneToMany(mappedBy = "tipdId")
    private Collection<SjSisPersona> sjSisPersonaCollection;

    public SjSisTipDocumento() {
    }

    public SjSisTipDocumento(Integer tipdId) {
        this.tipdId = tipdId;
    }

    public Integer getTipdId() {
        return tipdId;
    }

    public void setTipdId(Integer tipdId) {
        this.tipdId = tipdId;
    }

    public String getTipdNombre() {
        return tipdNombre;
    }

    public void setTipdNombre(String tipdNombre) {
        this.tipdNombre = tipdNombre;
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
        hash += (tipdId != null ? tipdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SjSisTipDocumento)) {
            return false;
        }
        SjSisTipDocumento other = (SjSisTipDocumento) object;
        if ((this.tipdId == null && other.tipdId != null) || (this.tipdId != null && !this.tipdId.equals(other.tipdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dh.secjusticia.modelo.SjSisTipDocumento[ tipdId=" + tipdId + " ]";
    }
    
}
