/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cuevaw
 */
@Entity
@Table(name = "sj_sis_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SjSisPersona.findAll", query = "SELECT s FROM SjSisPersona s")
    , @NamedQuery(name = "SjSisPersona.findByPerId", query = "SELECT s FROM SjSisPersona s WHERE s.perId = :perId")
    , @NamedQuery(name = "SjSisPersona.findByPerNombres", query = "SELECT s FROM SjSisPersona s WHERE s.perNombres = :perNombres")
    , @NamedQuery(name = "SjSisPersona.findByPerApellidos", query = "SELECT s FROM SjSisPersona s WHERE s.perApellidos = :perApellidos")
    , @NamedQuery(name = "SjSisPersona.findByPerDireccion", query = "SELECT s FROM SjSisPersona s WHERE s.perDireccion = :perDireccion")
    , @NamedQuery(name = "SjSisPersona.findByPerFecnac", query = "SELECT s FROM SjSisPersona s WHERE s.perFecnac = :perFecnac")
    , @NamedQuery(name = "SjSisPersona.findByPerFono", query = "SELECT s FROM SjSisPersona s WHERE s.perFono = :perFono")
    , @NamedQuery(name = "SjSisPersona.findByPerCelular", query = "SELECT s FROM SjSisPersona s WHERE s.perCelular = :perCelular")
    , @NamedQuery(name = "SjSisPersona.findByPerEmail", query = "SELECT s FROM SjSisPersona s WHERE s.perEmail = :perEmail")
    , @NamedQuery(name = "SjSisPersona.findByPerUsuario", query = "SELECT s FROM SjSisPersona s WHERE s.perUsuario = :perUsuario")
    , @NamedQuery(name = "SjSisPersona.findByPerEstado", query = "SELECT s FROM SjSisPersona s WHERE s.perEstado = :perEstado")
    , @NamedQuery(name = "SjSisPersona.findByPerIdentificador", query = "SELECT s FROM SjSisPersona s WHERE s.perIdentificador = :perIdentificador")
    , @NamedQuery(name = "SjSisPersona.findByPolProvincia", query = "SELECT s FROM SjSisPersona s WHERE s.polProvincia = :polProvincia")
    , @NamedQuery(name = "SjSisPersona.findByPolCanton", query = "SELECT s FROM SjSisPersona s WHERE s.polCanton = :polCanton")
    , @NamedQuery(name = "SjSisPersona.findByPolParroquia", query = "SELECT s FROM SjSisPersona s WHERE s.polParroquia = :polParroquia")})
public class SjSisPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "per_id")
    private Integer perId;
    @Size(max = 100)
    @Column(name = "per_nombres")
    private String perNombres;
    @Size(max = 100)
    @Column(name = "per_apellidos")
    private String perApellidos;
    @Size(max = 150)
    @Column(name = "per_direccion")
    private String perDireccion;
    @Column(name = "per_fecnac")
    @Temporal(TemporalType.DATE)
    private Date perFecnac;
    @Size(max = 13)
    @Column(name = "per_fono")
    private String perFono;
    @Size(max = 13)
    @Column(name = "per_celular")
    private String perCelular;
    @Size(max = 50)
    @Column(name = "per_email")
    private String perEmail;
    @Size(max = 20)
    @Column(name = "per_usuario")
    private String perUsuario;
    @Column(name = "per_estado")
    private Boolean perEstado;
    @Size(max = 15)
    @Column(name = "per_identificador")
    private String perIdentificador;
    @Column(name = "pol_provincia")
    private Integer polProvincia;
    @Column(name = "pol_canton")
    private Integer polCanton;
    @Column(name = "pol_parroquia")
    private Integer polParroquia;
    @JoinColumn(name = "civ_id", referencedColumnName = "civ_id")
    @ManyToOne
    private SjSisCivil civId;
    @JoinColumn(name = "gen_id", referencedColumnName = "gen_id")
    @ManyToOne
    private SjSisGenero genId;
    @JoinColumn(name = "sex_id", referencedColumnName = "sex_id")
    @ManyToOne
    private SjSisSexo sexId;
    @JoinColumn(name = "tipd_id", referencedColumnName = "tipd_id")
    @ManyToOne
    private SjSisTipDocumento tipdId;
    @OneToMany(mappedBy = "perId")
    private Collection<SjSisFoto> sjSisFotoCollection;
    @OneToMany(mappedBy = "perId")
    private Collection<SjSisRolMenUsuCen> sjSisRolMenUsuCenCollection;

    public SjSisPersona() {
    }

    public SjSisPersona(Integer perId) {
        this.perId = perId;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerNombres() {
        return perNombres;
    }

    public void setPerNombres(String perNombres) {
        this.perNombres = perNombres;
    }

    public String getPerApellidos() {
        return perApellidos;
    }

    public void setPerApellidos(String perApellidos) {
        this.perApellidos = perApellidos;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public Date getPerFecnac() {
        return perFecnac;
    }

    public void setPerFecnac(Date perFecnac) {
        this.perFecnac = perFecnac;
    }

    public String getPerFono() {
        return perFono;
    }

    public void setPerFono(String perFono) {
        this.perFono = perFono;
    }

    public String getPerCelular() {
        return perCelular;
    }

    public void setPerCelular(String perCelular) {
        this.perCelular = perCelular;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    public String getPerUsuario() {
        return perUsuario;
    }

    public void setPerUsuario(String perUsuario) {
        this.perUsuario = perUsuario;
    }

    public Boolean getPerEstado() {
        return perEstado;
    }

    public void setPerEstado(Boolean perEstado) {
        this.perEstado = perEstado;
    }

    public String getPerIdentificador() {
        return perIdentificador;
    }

    public void setPerIdentificador(String perIdentificador) {
        this.perIdentificador = perIdentificador;
    }

    public Integer getPolProvincia() {
        return polProvincia;
    }

    public void setPolProvincia(Integer polProvincia) {
        this.polProvincia = polProvincia;
    }

    public Integer getPolCanton() {
        return polCanton;
    }

    public void setPolCanton(Integer polCanton) {
        this.polCanton = polCanton;
    }

    public Integer getPolParroquia() {
        return polParroquia;
    }

    public void setPolParroquia(Integer polParroquia) {
        this.polParroquia = polParroquia;
    }

    public SjSisCivil getCivId() {
        return civId;
    }

    public void setCivId(SjSisCivil civId) {
        this.civId = civId;
    }

    public SjSisGenero getGenId() {
        return genId;
    }

    public void setGenId(SjSisGenero genId) {
        this.genId = genId;
    }

    public SjSisSexo getSexId() {
        return sexId;
    }

    public void setSexId(SjSisSexo sexId) {
        this.sexId = sexId;
    }

    public SjSisTipDocumento getTipdId() {
        return tipdId;
    }

    public void setTipdId(SjSisTipDocumento tipdId) {
        this.tipdId = tipdId;
    }

    @XmlTransient
    public Collection<SjSisFoto> getSjSisFotoCollection() {
        return sjSisFotoCollection;
    }

    public void setSjSisFotoCollection(Collection<SjSisFoto> sjSisFotoCollection) {
        this.sjSisFotoCollection = sjSisFotoCollection;
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
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SjSisPersona)) {
            return false;
        }
        SjSisPersona other = (SjSisPersona) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dh.secjusticia.modelo.SjSisPersona[ perId=" + perId + " ]";
    }
    
}
