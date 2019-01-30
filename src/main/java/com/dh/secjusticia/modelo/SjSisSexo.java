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
@Table(name = "sj_sis_sexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SjSisSexo.findAll", query = "SELECT s FROM SjSisSexo s")
    , @NamedQuery(name = "SjSisSexo.findBySexId", query = "SELECT s FROM SjSisSexo s WHERE s.sexId = :sexId")
    , @NamedQuery(name = "SjSisSexo.findBySexNombre", query = "SELECT s FROM SjSisSexo s WHERE s.sexNombre = :sexNombre")})
public class SjSisSexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sex_id")
    private Integer sexId;
    @Size(max = 2147483647)
    @Column(name = "sex_nombre")
    private String sexNombre;
    @OneToMany(mappedBy = "sexId")
    private Collection<SjSisPersona> sjSisPersonaCollection;

    public SjSisSexo() {
    }

    public SjSisSexo(Integer sexId) {
        this.sexId = sexId;
    }

    public Integer getSexId() {
        return sexId;
    }

    public void setSexId(Integer sexId) {
        this.sexId = sexId;
    }

    public String getSexNombre() {
        return sexNombre;
    }

    public void setSexNombre(String sexNombre) {
        this.sexNombre = sexNombre;
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
        hash += (sexId != null ? sexId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SjSisSexo)) {
            return false;
        }
        SjSisSexo other = (SjSisSexo) object;
        if ((this.sexId == null && other.sexId != null) || (this.sexId != null && !this.sexId.equals(other.sexId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dh.secjusticia.modelo.SjSisSexo[ sexId=" + sexId + " ]";
    }
    
}
