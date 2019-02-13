/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.servlets;

import com.dh.secjusticia.modelo.VarGlobales;
import java.io.IOException;
import java.io.PrintWriter;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class UtilSvrl 
{	 
  public static HttpSession getSession() 
  {  return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  }
     
  public static HttpServletRequest getRequest() 
  {  return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
  }
/*
  public static String getUserName()
  {  HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
     return  session.getAttribute("username").toString();
  } */
  public static String getRequestIp() 
  { String ip="";
    HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest() ;
    ip=request.getRemoteAddr()+ "|" +request.getHeader("USER-AGENT");
    return ip;
  
  }
  
  public static VarGlobales getVarGbean()
  {  HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
     return  (VarGlobales)session.getAttribute("varGbean");
  }
  
  
  public static String getUserId()
  {  HttpSession session = getSession();
     if ( session != null )
        return (String) session.getAttribute("userid");
     else
        return null;
  }
}