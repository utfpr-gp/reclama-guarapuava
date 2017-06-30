/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author cabrito
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    public LoginBean() {
    }

    public String gerarHashMD5(String conteudo) {
        byte[] b;
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.reset();
            b = md.digest(conteudo.getBytes());

            return new BigInteger(1, b).toString(16);
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    public String redireciona() {
        System.out.println("hsdfuhsduifhsduifhsdufhisdfusdhfisduf************************");
        return "view/ocorrencias/inicio";
    }

}
