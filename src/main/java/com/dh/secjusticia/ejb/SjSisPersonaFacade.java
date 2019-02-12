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

    /**
     * @author cuevaw
     * @Descripcion: Metodo de conlsuta de usuarios
     * @param: usuario y contraseña en un objeto personas 
     * @return: retorna un onbeto personas
     */
    @Override
    public SjSisPersona IniciasSesion(SjSisPersona per) {
        SjSisPersona persona = null;
        String consulta;
        try {
            consulta = "FROM SjSisPersona u WHERE u.perUsuario =?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, per.getPerUsuario());
            List<SjSisPersona> lstUsuario = query.getResultList();
            if (!lstUsuario.isEmpty()) {
                persona = lstUsuario.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return persona;
    }
}
