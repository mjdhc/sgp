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
@Table(name = "sj_sis_div_politica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SjSisDivPolitica.findAll", query = "SELECT s FROM SjSisDivPolitica s")
    //,@NamedQuery(name = "SjSisDivPolitica.findAllProvincias", query = "SELECT s FROM SjSisDivPolitica s WHERE s.pol_id_canton=0 AND s.pol_id_parroquia=0 AND s.pol_id_provincia !=0 ORDER BY s.pol_id_provincia")    
    , @NamedQuery(name = "SjSisDivPolitica.findByPolId", query = "SELECT s FROM SjSisDivPolitica s WHERE s.polId = :polId")
    , @NamedQuery(name = "SjSisDivPolitica.findByPolZona", query = "SELECT s FROM SjSisDivPolitica s WHERE s.polZona = :polZona")
    , @NamedQuery(name = "SjSisDivPolitica.findByPolDistrito", query = "SELECT s FROM SjSisDivPolitica s WHERE s.polDistrito = :polDistrito")
    , @NamedQuery(name = "SjSisDivPolitica.findByPolCircuito", query = "SELECT s FROM SjSisDivPolitica s WHERE s.polCircuito = :polCircuito")
    , @NamedQuery(name = "SjSisDivPolitica.findByPolIdProvincia", query = "SELECT s FROM SjSisDivPolitica s WHERE s.polIdProvincia = :polIdProvincia")
    , @NamedQuery(name = "SjSisDivPolitica.findByPolIdCanton", query = "SELECT s FROM SjSisDivPolitica s WHERE s.polIdCanton = :polIdCanton")
    , @NamedQuery(name = "SjSisDivPolitica.findByPolIdParroquia", query = "SELECT s FROM SjSisDivPolitica s WHERE s.polIdParroquia = :polIdParroquia")
    , @NamedQuery(name = "SjSisDivPolitica.findByPolNombre", query = "SELECT s FROM SjSisDivPolitica s WHERE s.polNombre = :polNombre")
    , @NamedQuery(name = "SjSisDivPolitica.findByPolActivo", query = "SELECT s FROM SjSisDivPolitica s WHERE s.polActivo = :polActivo")})
public class SjSisDivPolitica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pol_id")
    private Integer polId;
    @Column(name = "pol_zona")
    private Integer polZona;
    @Column(name = "pol_distrito")
    private Integer polDistrito;
    @Column(name = "pol_circuito")
    private Integer polCircuito;
    @Column(name = "pol_id_provincia")
    private Integer polIdProvincia;
    @Column(name = "pol_id_canton")
    private Integer polIdCanton;
    @Column(name = "pol_id_parroquia")
    private Integer polIdParroquia;
    @Size(max = 100)
    @Column(name = "pol_nombre")
    private String polNombre;
    @Column(name = "pol_activo")
    private Integer polActivo;
    @OneToMany(mappedBy = "polProvincia")
    private Collection<SjSisCentro> sjSisCentroCollection;
    @OneToMany(mappedBy = "polCaton")
    private Collection<SjSisCentro> sjSisCentroCollection1;
    @OneToMany(mappedBy = "polParroquia")
    private Collection<SjSisCentro> sjSisCentroCollection2;

    public SjSisDivPolitica() {
    }

    public SjSisDivPolitica(Integer polId) {
        this.polId = polId;
    }

    public Integer getPolId() {
        return polId;
    }

    public void setPolId(Integer polId) {
        this.polId = polId;
    }

    public Integer getPolZona() {
        return polZona;
    }

    public void setPolZona(Integer polZona) {
        this.polZona = polZona;
    }

    public Integer getPolDistrito() {
        return polDistrito;
    }

    public void setPolDistrito(Integer polDistrito) {
        this.polDistrito = polDistrito;
    }

    public Integer getPolCircuito() {
        return polCircuito;
    }

    public void setPolCircuito(Integer polCircuito) {
        this.polCircuito = polCircuito;
    }

    public Integer getPolIdProvincia() {
        return polIdProvincia;
    }

    public void setPolIdProvincia(Integer polIdProvincia) {
        this.polIdProvincia = polIdProvincia;
    }

    public Integer getPolIdCanton() {
        return polIdCanton;
    }

    public void setPolIdCanton(Integer polIdCanton) {
        this.polIdCanton = polIdCanton;
    }

    public Integer getPolIdParroquia() {
        return polIdParroquia;
    }

    public void setPolIdParroquia(Integer polIdParroquia) {
        this.polIdParroquia = polIdParroquia;
    }

    public String getPolNombre() {
        return polNombre;
    }

    public void setPolNombre(String polNombre) {
        this.polNombre = polNombre;
    }

    public Integer getPolActivo() {
        return polActivo;
    }

    public void setPolActivo(Integer polActivo) {
        this.polActivo = polActivo;
    }

    @XmlTransient
    public Collection<SjSisCentro> getSjSisCentroCollection() {
        return sjSisCentroCollection;
    }

    public void setSjSisCentroCollection(Collection<SjSisCentro> sjSisCentroCollection) {
        this.sjSisCentroCollection = sjSisCentroCollection;
    }

    @XmlTransient
    public Collection<SjSisCentro> getSjSisCentroCollection1() {
        return sjSisCentroCollection1;
    }

    public void setSjSisCentroCollection1(Collection<SjSisCentro> sjSisCentroCollection1) {
        this.sjSisCentroCollection1 = sjSisCentroCollection1;
    }

    @XmlTransient
    public Collection<SjSisCentro> getSjSisCentroCollection2() {
        return sjSisCentroCollection2;
    }

    public void setSjSisCentroCollection2(Collection<SjSisCentro> sjSisCentroCollection2) {
        this.sjSisCentroCollection2 = sjSisCentroCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (polId != null ? polId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SjSisDivPolitica)) {
            return false;
        }
        SjSisDivPolitica other = (SjSisDivPolitica) object;
        if ((this.polId == null && other.polId != null) || (this.polId != null && !this.polId.equals(other.polId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dh.secjusticia.modelo.SjSisDivPolitica[ polId=" + polId + " ]";
    }

}
