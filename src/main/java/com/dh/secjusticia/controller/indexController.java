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

   
    public String IngresarSistema(){
        
        System.err.println("Ingreso al metodo solicitado");
        return "/protegido/principal";
    }

}
