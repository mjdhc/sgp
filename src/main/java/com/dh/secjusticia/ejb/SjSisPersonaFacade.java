/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.activedirectory.Conexionad;
import com.dh.secjusticia.activedirectory.Funcionesad;
import com.dh.secjusticia.modelo.SjSisPersona;
import com.dh.secjusticia.servicios.Crud;
import java.util.List;
import java.util.Vector;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
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

    @EJB
    private Crud crud;		
    

    private List<SjSisPersona> vloginList;
    private String sqlvalidarUsr="select per_id,per_usuario,per_nombres,per_apellidos from sj_sis_persona where per_usuario=?";
    
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


    @Override
    public SjSisPersona IniciasDatos(String nick, String clave) 
    {
        SjSisPersona persona = null;
        String consulta;
        try 
        {
            
            String ldap_host    = "192.168.1.21";
            String ldap_port    = "389";
            String base_dn      = "DC=minjusticia-ddhh,DC=int";
            String ldap_dn      =  nick+"@minjusticia-ddhh.int";
            String ldap_nombre  = "riveramf";
            Attributes attrs=null;
        
//System.out.println("ok ldap_dn: "+ldap_dn);        
//System.out.println("ok clave: "+clave);        
                    
            Conexionad ad = new Conexionad(ldap_host,ldap_port,ldap_dn,clave,base_dn);
            DirContext ctx = ad.getConnection();  
            Funcionesad func=new Funcionesad();
            boolean valida=false;
            valida=func.esUsuario(ctx);
            ad.cerrarCon();
        
            if(valida==false) 
            {   System.out.println("no conectado");
                return persona = null;
            }    
            else 
            {
                //System.out.println("ok bien");
                
                Vector v = new Vector();
                v.addElement(new String(nick));
                vloginList=(List<SjSisPersona>) crud.getConsultaAll(SjSisPersona.class,sqlvalidarUsr,v);
	  
                if (!vloginList.isEmpty()) 
                {
                    //System.out.println("carga:"+vloginList.get(0));                    
                    //persona = vloginList.get(0);
                    
                    //String ip=UtilSvrl.getRequestIp(); 
                    for(int j=0;j<vloginList.size();j++)
                    {   persona = (SjSisPersona)vloginList.get(j);
                        /*
                        System.out.println("----"+persona.getPerId());
                        System.out.println("----"+persona.getPerUsuario());
                        System.out.println("----"+persona.getPerNombres());
                        System.out.println("----"+persona.getPerApellidos());
                        */

                    }

                }
                
                             
            }
                                
            /*
            consulta = "FROM SjSisPersona u WHERE u.perUsuario =?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, per.getPerUsuario());
            List<SjSisPersona> lstUsuario = query.getResultList();
            if (!lstUsuario.isEmpty()) {
                persona = lstUsuario.get(0);
            }*/
        } catch (Exception e) {
            throw e;
        }
        return persona;
    }


}
