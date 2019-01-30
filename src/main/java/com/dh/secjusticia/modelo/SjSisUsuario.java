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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sj_sis_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SjSisUsuario.findAll", query = "SELECT s FROM SjSisUsuario s")
    , @NamedQuery(name = "SjSisUsuario.findByUsuId", query = "SELECT s FROM SjSisUsuario s WHERE s.usuId = :usuId")
    , @NamedQuery(name = "SjSisUsuario.findByUsuUsuario", query = "SELECT s FROM SjSisUsuario s WHERE s.usuUsuario = :usuUsuario")
    , @NamedQuery(name = "SjSisUsuario.findByUsuClave", query = "SELECT s FROM SjSisUsuario s WHERE s.usuClave = :usuClave")
    , @NamedQuery(name = "SjSisUsuario.findByUsuEstado", query = "SELECT s FROM SjSisUsuario s WHERE s.usuEstado = :usuEstado")})
public class SjSisUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usu_id")
    private Integer usuId;
    @Size(max = 20)
    @Column(name = "usu_usuario")
    private String usuUsuario;
    @Size(max = 200)
    @Column(name = "usu_clave")
    private String usuClave;
    @Column(name = "usu_estado")
    private Boolean usuEstado;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id")
    @ManyToOne
    private SjSisPersona perId;
    @OneToMany(mappedBy = "usuId")
    private Collection<SjSisRolMenUsuCen> sjSisRolMenUsuCenCollection;

    public SjSisUsuario() {
    }

    public SjSisUsuario(Integer usuId) {
        this.usuId = usuId;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public Boolean getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(Boolean usuEstado) {
        this.usuEstado = usuEstado;
    }

    public SjSisPersona getPerId() {
        return perId;
    }

    public void setPerId(SjSisPersona perId) {
        this.perId = perId;
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
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SjSisUsuario)) {
            return false;
        }
        SjSisUsuario other = (SjSisUsuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dh.secjusticia.modelo.SjSisUsuario[ usuId=" + usuId + " ]";
    }
    
}
