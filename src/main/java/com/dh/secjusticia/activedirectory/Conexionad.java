/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.activedirectory;


import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 *
 * @author root
 */
public class Conexionad {
  public DirContext ctx  = null;
  
  public Conexionad(String ldap_host,String ldap_port,String ldap_dn,String ldap_pw,String base_dn )
  {
    try
    {
        String auth_method  = "simple";
        String ldap_version = "3";

        Hashtable env       = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL,"ldap://" + ldap_host + ":" + ldap_port);
        env.put(Context.SECURITY_AUTHENTICATION, auth_method);
        env.put(Context.SECURITY_PRINCIPAL, ldap_dn);
        env.put(Context.SECURITY_CREDENTIALS, ldap_pw);
        env.put("java.naming.ldap.version", ldap_version);
        
        ctx = new InitialDirContext(env);
        //System.out.println("LDAP authentication successful!");
        //ctx.close();
    } 
    catch (NamingException e) 
    {   ctx=null;
        //System.out.print("Error:Conexionad ");
    }
    
  }
  
  public DirContext getConnection()
  {
    try
    {
      if (this.ctx == null) {
        //System.out.println("Error Conexionad.getConnection: no hay conexiones activas");
      }
    }
    catch (Exception e)
    {
      System.out.println("Error Conexionad.getConnection: no se pueden mostrar los datos");
      e.printStackTrace();
    }
    return this.ctx;
  }
  
  public void cerrarCon()
  {
    try
    {
      if (this.ctx != null) {
        this.ctx.close();
      }
      this.ctx = null;
    }
    catch (Exception e)
    {
      System.out.println("\n Jdbc_sqlec.cerrarCon Error al cerrar la conexion");
    }
  }  
  
  
}