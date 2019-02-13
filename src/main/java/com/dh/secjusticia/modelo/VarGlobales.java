package com.dh.secjusticia.modelo;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VarGlobales implements Serializable  {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        @Id
	private Integer idUsuario;
    private String usuario;
    private Integer idCentro;
    private String centro;
    private String tipoCentro;
    private Integer cantRegistros;
    private Integer cantRegred;
    private String ruta;
    private String link;
    private String red;
    
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Integer getIdCentro() {
		return idCentro;
	}
	public void setIdCentro(Integer idCentro) {
		this.idCentro = idCentro;
	}
	public String getCentro() {
		return centro;
	}
	public void setCentro(String centro) {
		this.centro = centro;
	}
	public String getTipoCentro() {
		return tipoCentro;
	}
	public void setTipoCentro(String tipoCentro) {
		this.tipoCentro = tipoCentro;
	}
	public Integer getCantRegistros() {
		return cantRegistros;
	}
	public void setCantRegistros(Integer cantRegistros) {
		this.cantRegistros = cantRegistros;
	}
	public Integer getCantRegred() {
		return cantRegred;
	}
	public void setCantRegred(Integer cantRegred) {
		this.cantRegred = cantRegred;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRed() {
		return red;
	}
	public void setRed(String red) {
		this.red = red;
	}
 
    
       
}