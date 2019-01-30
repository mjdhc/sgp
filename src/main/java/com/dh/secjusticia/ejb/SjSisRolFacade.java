/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisRol;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cuevaw
 */
@Stateless
public class SjSisRolFacade extends AbstractFacade<SjSisRol> implements SjSisRolFacadeLocal {

    @PersistenceContext(unitName = "sgpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SjSisRolFacade() {
        super(SjSisRol.class);
    }
    
}
