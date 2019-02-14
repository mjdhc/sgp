/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.controller;

import com.dh.secjusticia.ejb.SjSisPersonaFacadeLocal;
import com.dh.secjusticia.modelo.SjSisPersona;
import com.dh.secjusticia.modelo.VarGlobales;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author cuevaw
 */
@Named
@ViewScoped
public class indexController implements Serializable {

    @EJB
    private SjSisPersonaFacadeLocal personaEJB;
    private SjSisPersona personas;
    private VarGlobales varGlobales;

    private String nick;
    private String clave;    
    
    @PostConstruct
    public void init() {
        personas = new SjSisPersona();
        varGlobales = new VarGlobales();
    }

    public SjSisPersona getPersonas() {
        return personas;
    }

    public void setPersonas(SjSisPersona personas) {
        this.personas = personas;
    }

    public VarGlobales getVarGlobales() {
        return varGlobales;
    }

    public void setVarGlobales(VarGlobales varGlobales) {
        this.varGlobales = varGlobales;
    }

    
    
    /**
     * @author cuevaw
     * @Descripcion: Metodo de validacion de usuarios para ingreso de sistema
     * @return: String con direccion a pagina inicial
     */
    public String iniciarSesion() 
    {
        String redireccion = null;
        SjSisPersona per;
        VarGlobales varG = null;
        try 
        {   
            per = personaEJB.IniciasDatos(nick,clave);
            varGlobales.setIdUsuario(per.getPerId());
            varGlobales.setUsuario(per.getPerUsuario());
            if (per != null) 
            {   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", varGlobales);
                redireccion = "/protegido/principal?faces-redirect=true";
            } 
            else 
            {   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
            }
        } 
        catch (Exception e) 
        {   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El Usuario y Contraseña no Corresponden"));
            e.printStackTrace();
        }
        return redireccion;
    }
    
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}    

}
