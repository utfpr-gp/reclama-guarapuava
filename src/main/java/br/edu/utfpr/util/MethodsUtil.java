/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.util;

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
}
