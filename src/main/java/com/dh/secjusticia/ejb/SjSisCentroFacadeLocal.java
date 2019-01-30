/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisCentro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cuevaw
 */
@Local
public interface SjSisCentroFacadeLocal {

    void create(SjSisCentro sjSisCentro);

    void edit(SjSisCentro sjSisCentro);

    void remove(SjSisCentro sjSisCentro);

    SjSisCentro find(Object id);

    List<SjSisCentro> findAll();

    List<SjSisCentro> findRange(int[] range);

    int count();
    
}
