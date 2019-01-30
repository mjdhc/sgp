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
@Table(name = "sj_sis_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SjSisRol.findAll", query = "SELECT s FROM SjSisRol s")
    , @NamedQuery(name = "SjSisRol.findByRolId", query = "SELECT s FROM SjSisRol s WHERE s.rolId = :rolId")
    , @NamedQuery(name = "SjSisRol.findByRolNombre", query = "SELECT s FROM SjSisRol s WHERE s.rolNombre = :rolNombre")
    , @NamedQuery(name = "SjSisRol.findByRolEstado", query = "SELECT s FROM SjSisRol s WHERE s.rolEstado = :rolEstado")})
public class SjSisRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_id")
    private Integer rolId;
    @Size(max = 50)
    @Column(name = "rol_nombre")
    private String rolNombre;
    @Column(name = "rol_estado")
    private Boolean rolEstado;
    @OneToMany(mappedBy = "rolId")
    private Collection<SjSisRolMenUsuCen> sjSisRolMenUsuCenCollection;

    public SjSisRol() {
    }

    public SjSisRol(Integer rolId) {
        this.rolId = rolId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public Boolean getRolEstado() {
        return rolEstado;
    }

    public void setRolEstado(Boolean rolEstado) {
        this.rolEstado = rolEstado;
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
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SjSisRol)) {
            return false;
        }
        SjSisRol other = (SjSisRol) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dh.secjusticia.modelo.SjSisRol[ rolId=" + rolId + " ]";
    }
    
}
