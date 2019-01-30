/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisTipDocumento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cuevaw
 */
@Local
public interface SjSisTipDocumentoFacadeLocal {

    void create(SjSisTipDocumento sjSisTipDocumento);

    void edit(SjSisTipDocumento sjSisTipDocumento);

    void remove(SjSisTipDocumento sjSisTipDocumento);

    SjSisTipDocumento find(Object id);

    List<SjSisTipDocumento> findAll();

    List<SjSisTipDocumento> findRange(int[] range);

    int count();
    
}
