/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisLog;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cuevaw
 */
@Local
public interface SjSisLogFacadeLocal {

    void create(SjSisLog sjSisLog);

    void edit(SjSisLog sjSisLog);

    void remove(SjSisLog sjSisLog);

    SjSisLog find(Object id);

    List<SjSisLog> findAll();

    List<SjSisLog> findRange(int[] range);

    int count();
    
}
