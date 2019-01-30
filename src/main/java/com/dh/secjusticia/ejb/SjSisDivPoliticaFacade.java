/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisDivPolitica;
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
public class SjSisDivPoliticaFacade extends AbstractFacade<SjSisDivPolitica> implements SjSisDivPoliticaFacadeLocal {

    @PersistenceContext(unitName = "sgpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SjSisDivPoliticaFacade() {
        super(SjSisDivPolitica.class);
    }

    /*
    Descripcio: Metodo para consultar todas las provincias
    parametros: Ninguno
    resultado: Lista de Cantones
     */
    @Override
    public List<SjSisDivPolitica> findAllProvincias() throws Exception {

        List<SjSisDivPolitica> lstProvincias=null;
        String consulta;

        try {
            consulta = " FROM SjSisDivPolitica s WHERE s.polIdCanton=0 AND s.polIdParroquia=0 AND s.polIdProvincia !=0 ORDER BY s.polIdProvincia";
            Query query = em.createQuery(consulta);
            lstProvincias=query.getResultList();
            
        } catch (Exception e) {
            throw e;
        }

        return lstProvincias;
    }

}
