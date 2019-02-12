/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisPersona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cuevaw
 */
@Stateless
public class SjSisPersonaFacade extends AbstractFacade<SjSisPersona> implements SjSisPersonaFacadeLocal {

    @PersistenceContext(unitName = "sgpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SjSisPersonaFacade() {
        super(SjSisPersona.class);
    }

    /*
    
    */
    @Override
    public SjSisPersona IniciasSesion(SjSisPersona per) {
        SjSisPersona persona = null;
        String consulta;
        
        System.out.println("paso2");
        try {
            System.out.println("paso3 el usuario es "+per.getPerUsuario());
            
            consulta = "FROM SjSisPersona u WHERE u.per_usuario =?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, "cuevaw");
            
            //query.setParameter(1, per.getPerUsuario());
            
            System.out.println("paso4");
            List<SjSisPersona> lstUsuario = query.getResultList();
            System.out.println("paso5");
            
            if (!lstUsuario.isEmpty()) {
                System.out.println("paso6");
                persona = lstUsuario.get(0);
            }
        } catch (Exception e) {
            throw e;
        }

        return persona;
    }
}
