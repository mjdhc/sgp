/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisGenero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cuevaw
 */
@Local
public interface SjSisGeneroFacadeLocal {

    void create(SjSisGenero sjSisGenero);

    void edit(SjSisGenero sjSisGenero);

    void remove(SjSisGenero sjSisGenero);

    SjSisGenero find(Object id);

    List<SjSisGenero> findAll();

    List<SjSisGenero> findRange(int[] range);

    int count();
    
}
