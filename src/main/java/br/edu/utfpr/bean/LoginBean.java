/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cabrito
 */
@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {

    private static final String PAGINA_INDEX = "/view/ocorrencias/inicio.xhtml";

    private String usuario;
    private String senha;

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

    public String onClickLogar() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.
                    getCurrentInstance().getExternalContext().getRequest();

            request.login(this.usuario, this.senha);

            return "pretty:occurrences";
        } catch (ServletException e) {
            System.out.println(e);
        } finally {
            //tratar aqui mensagens de segurança que possam ter vindo
            //do Login Module exibindo-as na forma de FacesMessage
        }

        return null;
    }

    public void logoutB() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
