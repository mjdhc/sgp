/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisSexo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cuevaw
 */
@Local
public interface SjSisSexoFacadeLocal {

    void create(SjSisSexo sjSisSexo);

    void edit(SjSisSexo sjSisSexo);

    void remove(SjSisSexo sjSisSexo);

    SjSisSexo find(Object id);

    List<SjSisSexo> findAll();

    List<SjSisSexo> findRange(int[] range);

    int count();
    
}
