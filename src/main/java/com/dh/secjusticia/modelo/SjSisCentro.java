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
@Table(name = "sj_sis_centro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SjSisCentro.findAll", query = "SELECT s FROM SjSisCentro s")
    , @NamedQuery(name = "SjSisCentro.findByCentId", query = "SELECT s FROM SjSisCentro s WHERE s.centId = :centId")
    , @NamedQuery(name = "SjSisCentro.findByCentNombre", query = "SELECT s FROM SjSisCentro s WHERE s.centNombre = :centNombre")
    , @NamedQuery(name = "SjSisCentro.findByCentFono", query = "SELECT s FROM SjSisCentro s WHERE s.centFono = :centFono")
    , @NamedQuery(name = "SjSisCentro.findByCentDireccion", query = "SELECT s FROM SjSisCentro s WHERE s.centDireccion = :centDireccion")
    , @NamedQuery(name = "SjSisCentro.findByCentLongitud", query = "SELECT s FROM SjSisCentro s WHERE s.centLongitud = :centLongitud")
    , @NamedQuery(name = "SjSisCentro.findByCentLatitud", query = "SELECT s FROM SjSisCentro s WHERE s.centLatitud = :centLatitud")})
public class SjSisCentro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cent_id")
    private Integer centId;
    @Size(max = 100)
    @Column(name = "cent_nombre")
    private String centNombre;
    @Size(max = 15)
    @Column(name = "cent_fono")
    private String centFono;
    @Size(max = 100)
    @Column(name = "cent_direccion")
    private String centDireccion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cent_longitud")
    private Double centLongitud;
    @Column(name = "cent_latitud")
    private Double centLatitud;
    @JoinColumn(name = "pol_provincia", referencedColumnName = "pol_id")
    @ManyToOne
    private SjSisDivPolitica polProvincia;
    @JoinColumn(name = "pol_caton", referencedColumnName = "pol_id")
    @ManyToOne
    private SjSisDivPolitica polCaton;
    @JoinColumn(name = "pol_parroquia", referencedColumnName = "pol_id")
    @ManyToOne
    private SjSisDivPolitica polParroquia;
    @JoinColumn(name = "tipc_id", referencedColumnName = "tipc_id")
    @ManyToOne
    private SjSisTipCent tipcId;
    @OneToMany(mappedBy = "centId")
    private Collection<SjSisRolMenUsuCen> sjSisRolMenUsuCenCollection;

    public SjSisCentro() {
    }

    public SjSisCentro(Integer centId) {
        this.centId = centId;
    }

    public Integer getCentId() {
        return centId;
    }

    public void setCentId(Integer centId) {
        this.centId = centId;
    }

    public String getCentNombre() {
        return centNombre;
    }

    public void setCentNombre(String centNombre) {
        this.centNombre = centNombre;
    }

    public String getCentFono() {
        return centFono;
    }

    public void setCentFono(String centFono) {
        this.centFono = centFono;
    }

    public String getCentDireccion() {
        return centDireccion;
    }

    public void setCentDireccion(String centDireccion) {
        this.centDireccion = centDireccion;
    }

    public Double getCentLongitud() {
        return centLongitud;
    }

    public void setCentLongitud(Double centLongitud) {
        this.centLongitud = centLongitud;
    }

    public Double getCentLatitud() {
        return centLatitud;
    }

    public void setCentLatitud(Double centLatitud) {
        this.centLatitud = centLatitud;
    }

    public SjSisDivPolitica getPolProvincia() {
        return polProvincia;
    }

    public void setPolProvincia(SjSisDivPolitica polProvincia) {
        this.polProvincia = polProvincia;
    }

    public SjSisDivPolitica getPolCaton() {
        return polCaton;
    }

    public void setPolCaton(SjSisDivPolitica polCaton) {
        this.polCaton = polCaton;
    }

    public SjSisDivPolitica getPolParroquia() {
        return polParroquia;
    }

    public void setPolParroquia(SjSisDivPolitica polParroquia) {
        this.polParroquia = polParroquia;
    }

    public SjSisTipCent getTipcId() {
        return tipcId;
    }

    public void setTipcId(SjSisTipCent tipcId) {
        this.tipcId = tipcId;
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
        hash += (centId != null ? centId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SjSisCentro)) {
            return false;
        }
        SjSisCentro other = (SjSisCentro) object;
        if ((this.centId == null && other.centId != null) || (this.centId != null && !this.centId.equals(other.centId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dh.secjusticia.modelo.SjSisCentro[ centId=" + centId + " ]";
    }
    
}
