/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jefferson
 */
public class MethodsUtil {

    private MethodsUtil() {}
   
    public static boolean isNull(Object obj) {
        if (obj == null) return true;
        
        return false;
    }
    
    public static HttpServletRequest getRequest(){
        return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
}
