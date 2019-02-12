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

    private String consulta = "";

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
    resultado: Lista de Provincias
     */
    @Override
    public List<SjSisDivPolitica> findAllProvincias() throws Exception {
        List<SjSisDivPolitica> lstProvincias = null;
        try {
            consulta = " FROM SjSisDivPolitica s WHERE s.polIdCanton=0 AND s.polIdParroquia=0 AND s.polIdProvincia !=0 ORDER BY s.polIdProvincia ASC ";
            Query query = em.createQuery(consulta);
            lstProvincias = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lstProvincias;
    }

    /*
    Descripcio: Metodo para consultar todos los cantones en base de provincias
    parametros: identificador de la codigo Provincia
    resultado: Lista de Cantones
     */
    @Override
    public List<SjSisDivPolitica> findAllCantones(int codProvincia) {
        List<SjSisDivPolitica> lstCantones = null;
        try {
            consulta = "FROM SjSisDivPolitica s WHERE s.polIdCanton !=0 AND s.polActivo !=0 AND s.polIdParroquia=0 AND s.polIdProvincia =?1 ORDER BY s.polIdCanton ASC";
            Query query = em.createQuery(consulta);
            query.setParameter(1, codProvincia);
            lstCantones = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lstCantones;
    }

    /*
    Descripcio: Metodo para consultar todos los cantones en base de provincias
    parametros: identificador de la codigo Provincia
    resultado: Lista de Cantones
     */
    public List<SjSisDivPolitica> findAllParroquias(int codProvincia, int codCanton) {
        List<SjSisDivPolitica> lsParroquia = null;
        try {
            consulta = "FROM SjSisDivPolitica s WHERE s.polActivo !=0 AND s.polIdParroquia !=0 AND s.polIdProvincia =?1 AND s.polIdCanton =?2 ORDER BY s.polIdParroquia ASC";
            Query query = em.createQuery(consulta);
            query.setParameter(1, codProvincia);
            query.setParameter(2, codCanton);
            
            lsParroquia = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lsParroquia;
    }

}
