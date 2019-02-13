/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.activedirectory;


import java.util.Enumeration;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

/**
 *
 * @author root
 * Lista de stributos
 */

public class Funcionesad {

    public String detalles(String ldap_nombre, Attributes attrs,DirContext ctx,String base_dn)
    {
       //System.out.println("LLego:"+ldap_nombre+"--"+attrs+"--"+ctx+"--"+base_dn);
       String retorna=""; 
       String dn = "";  
       String[] attrIDs = { "memberOf" };
       try 
       {
          SearchControls ctls = new SearchControls();
          ctls.setReturningAttributes(attrIDs);
          ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);

          // Specify the search filter to match
          String filter = "(&(objectClass=user)(sAMAccountName="+ldap_nombre+"))";
          // Search the subtree for objects using the given filter
          NamingEnumeration answer = ctx.search(base_dn, filter, ctls);
          // Print the answer
          //Search.printSearchEnumeration(answer);

          while (answer.hasMoreElements()) 
          {  
             SearchResult sr = (SearchResult)answer.next();
             dn = sr.getName();
             attrs = sr.getAttributes();

             System.out.println("Found Object: " + dn + "," + base_dn);
             if (attrs != null) 
             {  // we have some attributes for this object
                NamingEnumeration ae = attrs.getAll();
                while (ae.hasMoreElements()) 
                {  Attribute attr = (Attribute)ae.next();
                   String attrId = attr.getID();
                   System.out.println("Found Attribute: " + attrId);
                   Enumeration vals = attr.getAll();
                   while (vals.hasMoreElements()) 
                   {  String attr_val = (String)vals.nextElement();
                      System.out.println(attrId + ": " + attr_val);
                   }
                }
             }
          }        
       }
       catch (NamingException namEx) 
       {   System.out.println("LDAP connection failed!");
           namEx.printStackTrace();
       } 
       catch (Exception e) 
       {   e.printStackTrace();
       }       
       
       return retorna;
       
    }  
    
    public Boolean esUsuario(DirContext ctx)
    {   boolean valida= false;
        
        if(ctx==null) valida= false;
        else valida= true;
            
        return valida;
    }    

    
    public Personaad getUserName(String ldap_nombre,DirContext ctx,String base_dn) {
       String retorna=""; 
       String dn = "";  
       String[] attrIDs = { "memberOf" };
       Personaad pa= new Personaad();
       try 
       {
          SearchControls ctls = new SearchControls();
          ctls.setReturningAttributes(attrIDs);
          ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);

          String filter = "(&(objectClass=user)(sAMAccountName="+ldap_nombre+"))";
          NamingEnumeration answer = ctx.search(base_dn, filter, ctls);

          while (answer.hasMoreElements()) 
          {  
             SearchResult sr = (SearchResult)answer.next();
             dn = sr.getName();
             
            String[] parts = dn.split(",");
            pa.setNombre(parts[0].substring(3));
            pa.setDireccion(parts[1].substring(3));
            pa.setCoordinacion(parts[2].substring(3));
            pa.setSector(parts[3].substring(3));
            pa.setEntidad(parts[4].substring(3));
            System.out.println("Object: " + dn );
          }        
       }
       catch (NamingException namEx) 
       {   System.out.println("LDAP connection failed!");
           namEx.printStackTrace();
       } 
       catch (Exception e) 
       {   e.printStackTrace();
       }       
       return pa;
}


}