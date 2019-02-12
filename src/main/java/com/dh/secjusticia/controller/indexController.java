/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.controller;

import com.dh.secjusticia.ejb.SjSisPersonaFacadeLocal;
import com.dh.secjusticia.modelo.SjSisPersona;
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

    @PostConstruct
    public void init() {
        personas = new SjSisPersona();
    }

    public SjSisPersona getPersonas() {
        return personas;
    }

    public void setPersonas(SjSisPersona personas) {
        this.personas = personas;
    }

    /**
     * @author cuevaw
     * @Descripcion: Metodo de validacion de usuarios para ingreso de sistema
     * @return: String con direccion a pagina inicial
     */
    public String iniciarSesion() {
        String redireccion = null;
        SjSisPersona per;
        try {
            per = personaEJB.IniciasSesion(personas);
            if (per != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", per);
                redireccion = "/protegido/principal?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "El Usuario y Contraseña no Corresponden"));
        }
        return redireccion;
    }

}
