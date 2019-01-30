/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisCivil;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cuevaw
 */
@Local
public interface SjSisCivilFacadeLocal {

    void create(SjSisCivil sjSisCivil);

    void edit(SjSisCivil sjSisCivil);

    void remove(SjSisCivil sjSisCivil);

    SjSisCivil find(Object id);

    List<SjSisCivil> findAll();

    List<SjSisCivil> findRange(int[] range);

    int count();
    
}
