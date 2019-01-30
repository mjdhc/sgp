/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cuevaw
 */
@Entity
@Table(name = "sj_sis_sexo_genero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SjSisSexoGenero.findAll", query = "SELECT s FROM SjSisSexoGenero s")
    , @NamedQuery(name = "SjSisSexoGenero.findBySexgId", query = "SELECT s FROM SjSisSexoGenero s WHERE s.sexgId = :sexgId")
    , @NamedQuery(name = "SjSisSexoGenero.findBySexgNombre", query = "SELECT s FROM SjSisSexoGenero s WHERE s.sexgNombre = :sexgNombre")
    , @NamedQuery(name = "SjSisSexoGenero.findBySexgTipo", query = "SELECT s FROM SjSisSexoGenero s WHERE s.sexgTipo = :sexgTipo")})
public class SjSisSexoGenero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sexg_id")
    private Integer sexgId;
    @Size(max = 255)
    @Column(name = "sexg_nombre")
    private String sexgNombre;
    @Size(max = 255)
    @Column(name = "sexg_tipo")
    private String sexgTipo;

    public SjSisSexoGenero() {
    }

    public SjSisSexoGenero(Integer sexgId) {
        this.sexgId = sexgId;
    }

    public Integer getSexgId() {
        return sexgId;
    }

    public void setSexgId(Integer sexgId) {
        this.sexgId = sexgId;
    }

    public String getSexgNombre() {
        return sexgNombre;
    }

    public void setSexgNombre(String sexgNombre) {
        this.sexgNombre = sexgNombre;
    }

    public String getSexgTipo() {
        return sexgTipo;
    }

    public void setSexgTipo(String sexgTipo) {
        this.sexgTipo = sexgTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sexgId != null ? sexgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SjSisSexoGenero)) {
            return false;
        }
        SjSisSexoGenero other = (SjSisSexoGenero) object;
        if ((this.sexgId == null && other.sexgId != null) || (this.sexgId != null && !this.sexgId.equals(other.sexgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dh.secjusticia.modelo.SjSisSexoGenero[ sexgId=" + sexgId + " ]";
    }
    
}
