/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisRolMenUsuCen;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuevaw
 */
@Stateless
public class SjSisRolMenUsuCenFacade extends AbstractFacade<SjSisRolMenUsuCen> implements SjSisRolMenUsuCenFacadeLocal {

    @PersistenceContext(unitName = "sgpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SjSisRolMenUsuCenFacade() {
        super(SjSisRolMenUsuCen.class);
    }
    
}
