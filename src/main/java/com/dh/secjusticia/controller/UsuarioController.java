/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.controller;

import com.dh.secjusticia.ejb.SjSisCivilFacadeLocal;
import com.dh.secjusticia.ejb.SjSisDivPoliticaFacadeLocal;
import com.dh.secjusticia.ejb.SjSisGeneroFacadeLocal;
import com.dh.secjusticia.ejb.SjSisPersonaFacadeLocal;
import com.dh.secjusticia.ejb.SjSisSexoFacadeLocal;
import com.dh.secjusticia.ejb.SjSisTipDocumentoFacadeLocal;

import com.dh.secjusticia.modelo.SjSisCivil;
import com.dh.secjusticia.modelo.SjSisDivPolitica;
import com.dh.secjusticia.modelo.SjSisGenero;
import com.dh.secjusticia.modelo.SjSisPersona;
import com.dh.secjusticia.modelo.SjSisSexo;
import com.dh.secjusticia.modelo.SjSisTipDocumento;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cuevaw
 */
@Named
@ViewScoped

public class UsuarioController implements Serializable {
    
    private int codProvincia;
    private int codCanton;
    FacesMessage msg;

    @EJB
    private SjSisTipDocumentoFacadeLocal tipoDocuemntoEJB;
    @EJB
    private SjSisCivilFacadeLocal estadoCivilEJB;
    @EJB
    private SjSisSexoFacadeLocal sexoEJB;
    @EJB
    private SjSisGeneroFacadeLocal generoEJB;
    @EJB
    private SjSisDivPoliticaFacadeLocal divpoliticaEJB;
    @EJB
    private SjSisPersonaFacadeLocal personaEJB;
   
    
    
    @Inject
    private SjSisTipDocumento tipoDocumento;
    @Inject
    private SjSisCivil estadoCivil;
    @Inject
    private SjSisSexo sexo;
    @Inject
    private SjSisGenero genero;
    @Inject
    private SjSisDivPolitica divpolitica;
    @Inject
    private SjSisPersona persona;
   
    

    private List<SjSisTipDocumento> allDocumentos;
    private List<SjSisCivil> allEstCivil;
    private List<SjSisSexo> allSexo;
    private List<SjSisGenero> allGenero;

    private List<SjSisDivPolitica> allProvincias;
    private List<SjSisDivPolitica> allCantones;
    private List<SjSisDivPolitica> allParroquias;

    @PostConstruct
    public void init() {
      
        allDocumentos = tipoDocuemntoEJB.findAll();
        allEstCivil = estadoCivilEJB.findAll();
        allSexo = sexoEJB.findAll();
        allGenero = generoEJB.findAll();

        try {
            allProvincias = divpoliticaEJB.findAllProvincias();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
   
    public void llenarProvincias() throws Exception{
        try {
            allProvincias= divpoliticaEJB.findAllProvincias();            
        } catch (Exception e) {
            throw e;
        }        
    }

    public void LlenarCantones() {
       allCantones =divpoliticaEJB.findAllCantones(codProvincia);
    }
    
     public void LlenarParroquias() {
         allParroquias =divpoliticaEJB.findAllParroquias(codProvincia,codCanton);
    }
    
    public void nuevoUsuario(){
        try {
            
            persona.setPolProvincia(codProvincia); 
            persona.setPolCanton(codCanton);
            persona.setTipdId(tipoDocumento);
            persona.setCivId(estadoCivil);
            persona.setSexId(sexo);
            persona.setGenId(genero);
            
            personaEJB.create(persona);            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso","Se ingreso un nuevo usuario"));
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso","NO Se ingreso un nuevo usuario"));
        }
    }
     
    public int getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(int codProvincia) {
        this.codProvincia = codProvincia;
    }

    public int getCodCanton() {
        return codCanton;
    }

    public void setCodCanton(int codCanton) {
        this.codCanton = codCanton;
    }

    public List<SjSisDivPolitica> getAllProvincias() {
        return allProvincias;
    }

    public void setAllProvincias(List<SjSisDivPolitica> allProvincias) {
        this.allProvincias = allProvincias;
    }

    public List<SjSisDivPolitica> getAllCantones() {
        return allCantones;
    }

    public void setAllCantones(List<SjSisDivPolitica> allCantones) {
        this.allCantones = allCantones;
    }

    public List<SjSisDivPolitica> getAllParroquias() {
        return allParroquias;
    }

    public void setAllParroquias(List<SjSisDivPolitica> allParroquias) {
        this.allParroquias = allParroquias;
    }
  
    public SjSisGenero getGenero() {
        return genero;
    }

    public void setGenero(SjSisGenero genero) {
        this.genero = genero;
    }

    public SjSisPersona getPersona() {
        return persona;
    }

    public void setPersona(SjSisPersona persona) {
        this.persona = persona;
    }

    public SjSisDivPolitica getDivpolitica() {
        return divpolitica;
    }

    public void setDivpolitica(SjSisDivPolitica divpolitica) {
        this.divpolitica = divpolitica;
    }

    
    public List<SjSisGenero> getAllGenero() {
        return allGenero;
    }

    public void setAllGenero(List<SjSisGenero> allGenero) {
        this.allGenero = allGenero;
    }

    
    public SjSisSexo getSexo() {
        return sexo;
    }

    public void setSexo(SjSisSexo sexo) {
        this.sexo = sexo;
    }

    public List<SjSisSexo> getAllSexo() {
        return allSexo;
    }

    public void setAllSexo(List<SjSisSexo> allSexo) {
        this.allSexo = allSexo;
    }

    
    public List<SjSisTipDocumento> getAllDocumentos() {
        return allDocumentos;
    }

    public void setAllDocumentos(List<SjSisTipDocumento> allDocumentos) {
        this.allDocumentos = allDocumentos;
    }

    public List<SjSisCivil> getAllEstCivil() {
        return allEstCivil;
    }

    public void setAllEstCivil(List<SjSisCivil> allEstCivil) {
        this.allEstCivil = allEstCivil;
    }

    public SjSisTipDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(SjSisTipDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public SjSisCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(SjSisCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    

}
