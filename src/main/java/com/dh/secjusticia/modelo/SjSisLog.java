/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cuevaw
 */
@Entity
@Table(name = "sj_sis_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SjSisLog.findAll", query = "SELECT s FROM SjSisLog s")
    , @NamedQuery(name = "SjSisLog.findByLogId", query = "SELECT s FROM SjSisLog s WHERE s.logId = :logId")
    , @NamedQuery(name = "SjSisLog.findByLogFecha", query = "SELECT s FROM SjSisLog s WHERE s.logFecha = :logFecha")
    , @NamedQuery(name = "SjSisLog.findByLogUsuario", query = "SELECT s FROM SjSisLog s WHERE s.logUsuario = :logUsuario")
    , @NamedQuery(name = "SjSisLog.findByLogIp", query = "SELECT s FROM SjSisLog s WHERE s.logIp = :logIp")
    , @NamedQuery(name = "SjSisLog.findByLogObservaciones", query = "SELECT s FROM SjSisLog s WHERE s.logObservaciones = :logObservaciones")
    , @NamedQuery(name = "SjSisLog.findByLogAccion", query = "SELECT s FROM SjSisLog s WHERE s.logAccion = :logAccion")
    , @NamedQuery(name = "SjSisLog.findByLogTabla", query = "SELECT s FROM SjSisLog s WHERE s.logTabla = :logTabla")})
public class SjSisLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "log_id")
    private Integer logId;
    @Column(name = "log_fecha")
    @Temporal(TemporalType.DATE)
    private Date logFecha;
    @Size(max = 50)
    @Column(name = "log_usuario")
    private String logUsuario;
    @Size(max = 20)
    @Column(name = "log_ip")
    private String logIp;
    @Size(max = 255)
    @Column(name = "log_observaciones")
    private String logObservaciones;
    @Size(max = 50)
    @Column(name = "log_accion")
    private String logAccion;
    @Size(max = 50)
    @Column(name = "log_tabla")
    private String logTabla;

    public SjSisLog() {
    }

    public SjSisLog(Integer logId) {
        this.logId = logId;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Date getLogFecha() {
        return logFecha;
    }

    public void setLogFecha(Date logFecha) {
        this.logFecha = logFecha;
    }

    public String getLogUsuario() {
        return logUsuario;
    }

    public void setLogUsuario(String logUsuario) {
        this.logUsuario = logUsuario;
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public String getLogObservaciones() {
        return logObservaciones;
    }

    public void setLogObservaciones(String logObservaciones) {
        this.logObservaciones = logObservaciones;
    }

    public String getLogAccion() {
        return logAccion;
    }

    public void setLogAccion(String logAccion) {
        this.logAccion = logAccion;
    }

    public String getLogTabla() {
        return logTabla;
    }

    public void setLogTabla(String logTabla) {
        this.logTabla = logTabla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SjSisLog)) {
            return false;
        }
        SjSisLog other = (SjSisLog) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dh.secjusticia.modelo.SjSisLog[ logId=" + logId + " ]";
    }
    
}
