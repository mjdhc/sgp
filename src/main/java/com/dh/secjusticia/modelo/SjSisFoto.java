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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sj_sis_foto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SjSisFoto.findAll", query = "SELECT s FROM SjSisFoto s")
    , @NamedQuery(name = "SjSisFoto.findByFotosId", query = "SELECT s FROM SjSisFoto s WHERE s.fotosId = :fotosId")
    , @NamedQuery(name = "SjSisFoto.findByFotoUrl", query = "SELECT s FROM SjSisFoto s WHERE s.fotoUrl = :fotoUrl")
    , @NamedQuery(name = "SjSisFoto.findByFotoEstado", query = "SELECT s FROM SjSisFoto s WHERE s.fotoEstado = :fotoEstado")
    , @NamedQuery(name = "SjSisFoto.findByFotoPredefinido", query = "SELECT s FROM SjSisFoto s WHERE s.fotoPredefinido = :fotoPredefinido")})
public class SjSisFoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fotos_id")
    private Integer fotosId;
    @Size(max = 100)
    @Column(name = "foto_url")
    private String fotoUrl;
    @Column(name = "foto_estado")
    private Boolean fotoEstado;
    @Column(name = "foto_predefinido")
    private Integer fotoPredefinido;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id")
    @ManyToOne
    private SjSisPersona perId;

    public SjSisFoto() {
    }

    public SjSisFoto(Integer fotosId) {
        this.fotosId = fotosId;
    }

    public Integer getFotosId() {
        return fotosId;
    }

    public void setFotosId(Integer fotosId) {
        this.fotosId = fotosId;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public Boolean getFotoEstado() {
        return fotoEstado;
    }

    public void setFotoEstado(Boolean fotoEstado) {
        this.fotoEstado = fotoEstado;
    }

    public Integer getFotoPredefinido() {
        return fotoPredefinido;
    }

    public void setFotoPredefinido(Integer fotoPredefinido) {
        this.fotoPredefinido = fotoPredefinido;
    }

    public SjSisPersona getPerId() {
        return perId;
    }

    public void setPerId(SjSisPersona perId) {
        this.perId = perId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fotosId != null ? fotosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SjSisFoto)) {
            return false;
        }
        SjSisFoto other = (SjSisFoto) object;
        if ((this.fotosId == null && other.fotosId != null) || (this.fotosId != null && !this.fotosId.equals(other.fotosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dh.secjusticia.modelo.SjSisFoto[ fotosId=" + fotosId + " ]";
    }
    
}
