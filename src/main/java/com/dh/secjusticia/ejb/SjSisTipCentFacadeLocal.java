/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisTipCent;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cuevaw
 */
@Local
public interface SjSisTipCentFacadeLocal {

    void create(SjSisTipCent sjSisTipCent);

    void edit(SjSisTipCent sjSisTipCent);

    void remove(SjSisTipCent sjSisTipCent);

    SjSisTipCent find(Object id);

    List<SjSisTipCent> findAll();

    List<SjSisTipCent> findRange(int[] range);

    int count();
    
}
