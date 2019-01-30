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
@Table(name = "sj_sis_genero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SjSisGenero.findAll", query = "SELECT s FROM SjSisGenero s")
    , @NamedQuery(name = "SjSisGenero.findByGenId", query = "SELECT s FROM SjSisGenero s WHERE s.genId = :genId")
    , @NamedQuery(name = "SjSisGenero.findByGenNombre", query = "SELECT s FROM SjSisGenero s WHERE s.genNombre = :genNombre")})
public class SjSisGenero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gen_id")
    private Integer genId;
    @Size(max = 20)
    @Column(name = "gen_nombre")
    private String genNombre;
    @OneToMany(mappedBy = "genId")
    private Collection<SjSisPersona> sjSisPersonaCollection;

    public SjSisGenero() {
    }

    public SjSisGenero(Integer genId) {
        this.genId = genId;
    }

    public Integer getGenId() {
        return genId;
    }

    public void setGenId(Integer genId) {
        this.genId = genId;
    }

    public String getGenNombre() {
        return genNombre;
    }

    public void setGenNombre(String genNombre) {
        this.genNombre = genNombre;
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
        hash += (genId != null ? genId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SjSisGenero)) {
            return false;
        }
        SjSisGenero other = (SjSisGenero) object;
        if ((this.genId == null && other.genId != null) || (this.genId != null && !this.genId.equals(other.genId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dh.secjusticia.modelo.SjSisGenero[ genId=" + genId + " ]";
    }
    
}
