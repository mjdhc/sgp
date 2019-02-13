package com.dh.secjusticia.servicios;

import com.dh.secjusticia.modelo.Pagina;
import java.util.List;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;




@Stateless
public class Crud<T> {
    @PersistenceContext
	private EntityManager em;	


	public void insertar (T entity){
		em.persist(entity);
	}

	public void actualizar (T entity){
		em.merge(entity);
	}

	public void eliminar (T entity){
		em.remove(em.merge(entity));
	} 
     
    public <T> List<T> getConsultaPag(Class<T> type,String sql,Vector v,String ordenNom,boolean ordeTipo, int pagina, int valores)
    {  List<T> list = null;
       String ordenamiento = ordeTipo ? "ASC" : "DESC";
       String consulta=sql+" order by "+ordenNom+" "+ordenamiento+" limit ? offset ?";
       try 
       {  Query q=em.createNativeQuery(consulta,type);
          if(v.size()>0)
          {   for (int i = 0; i < v.size(); i++) 
              {  q.setParameter( i+1, v.get(i) );
           	  }     
          }
          q.setParameter(v.size()+1, pagina );
          q.setParameter(v.size()+2, valores );
          list= (List<T>) q.getResultList();
       } 
       catch (Exception e) 
       {  e.printStackTrace();
       }       
       return list;
    }      
    
    public <T> List<T> getConsultaAll(Class<T> type,String sql,Vector v)
    {  List<T> list = null;
       String consulta=sql;
       try 
       {  Query q=em.createNativeQuery(consulta,type);
          if(v.size()>0)
          {  for (int i = 0; i < v.size(); i++) 
             {  q.setParameter( i+1, v.get(i) );
//System.out.println(v.get(i));  
           	 }     
          }
          list= (List<T>) q.getResultList();
          } 
       catch (Exception e) 
       {  e.printStackTrace();
       }       
       return list;
    }      
    

    
    public <T>T getConsultaUnoBean(Class<T> type,String sql,Vector v)
    {  String consulta=sql +" limit 1 offset 0 ";
       Query q=em.createNativeQuery(consulta,type);
       try 
       {  if(v.size()>0)
          {  for (int i = 0; i < v.size(); i++) 
             {  q.setParameter( i+1, v.get(i) );
           	 }     
          }
          return (T) q.getSingleResult();
       } 
       catch(NoResultException nre)     { return null;  }
       catch(NonUniqueResultException n){ return null;  }       
    }      
    
    public Pagina getConsultaCont(String sql,Vector v) 
    {  try 
       {  Query q=em.createNativeQuery(sql,Pagina.class);
          if(v.size()>0)
          {   for (int i = 0; i < v.size(); i++) 
              {   q.setParameter( i+1, v.get(i) );
           	  }
          }
          return (Pagina)q.getSingleResult();
   	   }
       catch(NoResultException nre)     { return null;  }
       catch(NonUniqueResultException n){ return null;  }
    }         
    	
  

}