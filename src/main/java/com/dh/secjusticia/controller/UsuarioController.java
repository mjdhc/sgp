/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.controller;

import com.dh.secjusticia.ejb.SjSisCivilFacadeLocal;
import com.dh.secjusticia.ejb.SjSisDivPoliticaFacadeLocal;
import com.dh.secjusticia.ejb.SjSisGeneroFacadeLocal;
import com.dh.secjusticia.ejb.SjSisSexoFacadeLocal;
import com.dh.secjusticia.ejb.SjSisTipDocumentoFacadeLocal;
import com.dh.secjusticia.modelo.SjSisCivil;
import com.dh.secjusticia.modelo.SjSisDivPolitica;
import com.dh.secjusticia.modelo.SjSisGenero;
import com.dh.secjusticia.modelo.SjSisSexo;
import com.dh.secjusticia.modelo.SjSisTipDocumento;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class UsuarioController implements Serializable{
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
    
    
    
    private  List<SjSisTipDocumento> allDocumentos;
    private  List<SjSisCivil> allEstCivil;
    private List<SjSisSexo> allSexo;
    private List<SjSisGenero> allGenero;
    
    private List<SjSisDivPolitica> allProvincias;
    private List<SjSisDivPolitica> allCantones;
    private List<SjSisDivPolitica> allParroquias;
    
    
    @PostConstruct
    public void init(){
        
      allDocumentos = tipoDocuemntoEJB.findAll();
      allEstCivil = estadoCivilEJB.findAll();
      allSexo= sexoEJB.findAll();
      allGenero= generoEJB.findAll();
        
      try { 
            allProvincias= divpoliticaEJB.findAllProvincias();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }
/*
    public void cambioProvincia() {
        if(country !=null && !country.equals(""))
            cities = data.get(country);
        else
            cities = new HashMap<String, String>();
    }
    
  */  
    public void llenarProvincias() throws Exception{
        try {
            allProvincias= divpoliticaEJB.findAllProvincias();            
        } catch (Exception e) {
            throw e;
        }
        
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
