/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisDivPolitica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cuevaw
 */
@Local
public interface SjSisDivPoliticaFacadeLocal {

    void create(SjSisDivPolitica sjSisDivPolitica);

    void edit(SjSisDivPolitica sjSisDivPolitica);

    void remove(SjSisDivPolitica sjSisDivPolitica);

    SjSisDivPolitica find(Object id);

    List<SjSisDivPolitica> findAll();
 
    List<SjSisDivPolitica> findRange(int[] range);

    int count();
  
    
    List<SjSisDivPolitica> findAllProvincias() throws Exception;
  
    /*
     metodo para consultar todos los Cantones de una Provincia
    */  
  //List<SjSisDivPolitica> findAllCantones(int codProvincia);
  
    /*
     metodo para consultar todos las parroquias de un Canton
    */  
    //List<SjSisDivPolitica> findAllParroquias(int codCanton);
    
    
}
