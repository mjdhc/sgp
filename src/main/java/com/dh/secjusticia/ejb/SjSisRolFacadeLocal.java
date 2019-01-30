/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisRol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cuevaw
 */
@Local
public interface SjSisRolFacadeLocal {

    void create(SjSisRol sjSisRol);

    void edit(SjSisRol sjSisRol);

    void remove(SjSisRol sjSisRol);

    SjSisRol find(Object id);

    List<SjSisRol> findAll();

    List<SjSisRol> findRange(int[] range);

    int count();
    
}
