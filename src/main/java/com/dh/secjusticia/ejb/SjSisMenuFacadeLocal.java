/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisMenu;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cuevaw
 */
@Local
public interface SjSisMenuFacadeLocal {

    void create(SjSisMenu sjSisMenu);

    void edit(SjSisMenu sjSisMenu);

    void remove(SjSisMenu sjSisMenu);

    SjSisMenu find(Object id);

    List<SjSisMenu> findAll();

    List<SjSisMenu> findRange(int[] range);

    int count();
    
}
