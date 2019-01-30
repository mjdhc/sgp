/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.controller;

import com.dh.secjusticia.ejb.SjSisTipDocumentoFacadeLocal;
import com.dh.secjusticia.modelo.SjSisTipDocumento;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cuevaw
 */
@Named
@ViewScoped
public class TipoDocumentoController implements Serializable {

    @EJB
    private SjSisTipDocumentoFacadeLocal tipoDocumebtoEJB;

    @Inject
    private SjSisTipDocumento documento;

    public SjSisTipDocumento getDocumento() {
        return documento;
    }

    public void setDocumento(SjSisTipDocumento documento) {
        this.documento = documento;
    }

    @PostConstruct
    public void init() {
        // documento = new SjSisTipDocumento();
    }

    public void ingresaTipoDocumento() {
        try {
            tipoDocumebtoEJB.create(documento);
        } catch (Exception e) {
            System.out.println("no se pudo realizar el ingreso" + e.getMessage());
        }
    }
}
