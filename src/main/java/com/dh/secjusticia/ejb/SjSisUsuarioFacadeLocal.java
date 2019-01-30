/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cuevaw
 */
@Local
public interface SjSisUsuarioFacadeLocal {

    void create(SjSisUsuario sjSisUsuario);

    void edit(SjSisUsuario sjSisUsuario);

    void remove(SjSisUsuario sjSisUsuario);

    SjSisUsuario find(Object id);

    List<SjSisUsuario> findAll();

    List<SjSisUsuario> findRange(int[] range);

    int count();
    
}
