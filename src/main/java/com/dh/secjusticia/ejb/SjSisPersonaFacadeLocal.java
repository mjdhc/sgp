/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisPersona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cuevaw
 */
@Local
public interface SjSisPersonaFacadeLocal {

    void create(SjSisPersona sjSisPersona);

    void edit(SjSisPersona sjSisPersona);

    void remove(SjSisPersona sjSisPersona);

    SjSisPersona find(Object id);

    List<SjSisPersona> findAll();

    List<SjSisPersona> findRange(int[] range);

    int count();
    
}
