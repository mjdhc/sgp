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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cuevaw
 */
@Entity
@Table(name = "sj_sis_rol_men_usu_cen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SjSisRolMenUsuCen.findAll", query = "SELECT s FROM SjSisRolMenUsuCen s")
    , @NamedQuery(name = "SjSisRolMenUsuCen.findByRmucId", query = "SELECT s FROM SjSisRolMenUsuCen s WHERE s.rmucId = :rmucId")
    , @NamedQuery(name = "SjSisRolMenUsuCen.findByRmucEstado", query = "SELECT s FROM SjSisRolMenUsuCen s WHERE s.rmucEstado = :rmucEstado")
    , @NamedQuery(name = "SjSisRolMenUsuCen.findByRmucDeterminado", query = "SELECT s FROM SjSisRolMenUsuCen s WHERE s.rmucDeterminado = :rmucDeterminado")})
public class SjSisRolMenUsuCen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rmuc_id")
    private Integer rmucId;
    @Column(name = "rmuc_estado")
    private Boolean rmucEstado;
    @Column(name = "rmuc_determinado")
    private Integer rmucDeterminado;
    @JoinColumn(name = "cent_id", referencedColumnName = "cent_id")
    @ManyToOne
    private SjSisCentro centId;
    @JoinColumn(name = "men_id", referencedColumnName = "men_id")
    @ManyToOne
    private SjSisMenu menId;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne
    private SjSisRol rolId;
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    @ManyToOne
    private SjSisUsuario usuId;

    public SjSisRolMenUsuCen() {
    }

    public SjSisRolMenUsuCen(Integer rmucId) {
        this.rmucId = rmucId;
    }

    public Integer getRmucId() {
        return rmucId;
    }

    public void setRmucId(Integer rmucId) {
        this.rmucId = rmucId;
    }

    public Boolean getRmucEstado() {
        return rmucEstado;
    }

    public void setRmucEstado(Boolean rmucEstado) {
        this.rmucEstado = rmucEstado;
    }

    public Integer getRmucDeterminado() {
        return rmucDeterminado;
    }

    public void setRmucDeterminado(Integer rmucDeterminado) {
        this.rmucDeterminado = rmucDeterminado;
    }

    public SjSisCentro getCentId() {
        return centId;
    }

    public void setCentId(SjSisCentro centId) {
        this.centId = centId;
    }

    public SjSisMenu getMenId() {
        return menId;
    }

    public void setMenId(SjSisMenu menId) {
        this.menId = menId;
    }

    public SjSisRol getRolId() {
        return rolId;
    }

    public void setRolId(SjSisRol rolId) {
        this.rolId = rolId;
    }

    public SjSisUsuario getUsuId() {
        return usuId;
    }

    public void setUsuId(SjSisUsuario usuId) {
        this.usuId = usuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rmucId != null ? rmucId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SjSisRolMenUsuCen)) {
            return false;
        }
        SjSisRolMenUsuCen other = (SjSisRolMenUsuCen) object;
        if ((this.rmucId == null && other.rmucId != null) || (this.rmucId != null && !this.rmucId.equals(other.rmucId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dh.secjusticia.modelo.SjSisRolMenUsuCen[ rmucId=" + rmucId + " ]";
    }
    
}
