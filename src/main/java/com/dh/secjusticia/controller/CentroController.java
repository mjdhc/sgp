/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.controller;

import com.dh.secjusticia.ejb.SjSisCentroFacadeLocal;
import com.dh.secjusticia.modelo.SjSisCentro;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 * clase controla la interfas del centro
 * parametros: ninguno
 * 
 * @author cuevaw
 */

@Named
@ViewScoped
public class CentroController  implements Serializable{
    
    @EJB
    private SjSisCentroFacadeLocal centroEJB;
    private SjSisCentro centro;
    
    /**
     * 
     */
    public void ingresaCentro(){
        try {
            centroEJB.create(centro);
        } catch (Exception e) {
        }
    
    }
    
    
    public SjSisCentro getCentro() {
        return centro;
    }

    public void setCentro(SjSisCentro centro) {
        this.centro = centro;
    }
    
    
    
    
    
    
}
