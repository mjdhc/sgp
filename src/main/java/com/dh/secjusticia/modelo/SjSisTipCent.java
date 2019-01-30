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
@Table(name = "sj_sis_tip_cent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SjSisTipCent.findAll", query = "SELECT s FROM SjSisTipCent s")
    , @NamedQuery(name = "SjSisTipCent.findByTipcId", query = "SELECT s FROM SjSisTipCent s WHERE s.tipcId = :tipcId")
    , @NamedQuery(name = "SjSisTipCent.findByTipcNombre", query = "SELECT s FROM SjSisTipCent s WHERE s.tipcNombre = :tipcNombre")
    , @NamedQuery(name = "SjSisTipCent.findByTipcEstador", query = "SELECT s FROM SjSisTipCent s WHERE s.tipcEstador = :tipcEstador")})
public class SjSisTipCent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipc_id")
    private Integer tipcId;
    @Size(max = 100)
    @Column(name = "tipc_nombre")
    private String tipcNombre;
    @Column(name = "tipc_estador")
    private Boolean tipcEstador;
    @OneToMany(mappedBy = "tipcId")
    private Collection<SjSisCentro> sjSisCentroCollection;

    public SjSisTipCent() {
    }

    public SjSisTipCent(Integer tipcId) {
        this.tipcId = tipcId;
    }

    public Integer getTipcId() {
        return tipcId;
    }

    public void setTipcId(Integer tipcId) {
        this.tipcId = tipcId;
    }

    public String getTipcNombre() {
        return tipcNombre;
    }

    public void setTipcNombre(String tipcNombre) {
        this.tipcNombre = tipcNombre;
    }

    public Boolean getTipcEstador() {
        return tipcEstador;
    }

    public void setTipcEstador(Boolean tipcEstador) {
        this.tipcEstador = tipcEstador;
    }

    @XmlTransient
    public Collection<SjSisCentro> getSjSisCentroCollection() {
        return sjSisCentroCollection;
    }

    public void setSjSisCentroCollection(Collection<SjSisCentro> sjSisCentroCollection) {
        this.sjSisCentroCollection = sjSisCentroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipcId != null ? tipcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SjSisTipCent)) {
            return false;
        }
        SjSisTipCent other = (SjSisTipCent) object;
        if ((this.tipcId == null && other.tipcId != null) || (this.tipcId != null && !this.tipcId.equals(other.tipcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dh.secjusticia.modelo.SjSisTipCent[ tipcId=" + tipcId + " ]";
    }
    
}
