/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.controller;

import com.dh.secjusticia.modelo.SjSisPersona;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author cuevaw
 * @see realiza verificaciones para la plantilla
 */
@Named
@ViewScoped
public class PlantillaController implements Serializable{
    public void verificaSesion(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            SjSisPersona per= (SjSisPersona) context.getExternalContext().getSessionMap().get("usuario");
            if(per == null){
               context.getExternalContext().redirect("./../permisos.xhtml");
            }
        } catch (Exception e) {
         // registro de exception
        }
    }
}
