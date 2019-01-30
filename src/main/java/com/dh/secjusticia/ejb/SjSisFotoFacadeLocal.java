/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisFoto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cuevaw
 */
@Local
public interface SjSisFotoFacadeLocal {

    void create(SjSisFoto sjSisFoto);

    void edit(SjSisFoto sjSisFoto);

    void remove(SjSisFoto sjSisFoto);

    SjSisFoto find(Object id);

    List<SjSisFoto> findAll();

    List<SjSisFoto> findRange(int[] range);

    int count();
    
}
