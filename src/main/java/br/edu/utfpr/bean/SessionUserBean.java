/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.MethodsUtil;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jefferson
 */

@ManagedBean
@SessionScoped
public class SessionUserBean {
    private User currentUser;

    public SessionUserBean() {
    }
    
    @PostConstruct
    public void init() {
        currentUser = null;
    }
    
    public User getCurrentUser() {
        if (MethodsUtil.isNull(currentUser)) {
            if(!setCurrentUser()) return null;
        }
        
        return currentUser;
    }
    
    public boolean setCurrentUser() {
        String login = MethodsUtil.getRequest().getRemoteUser();
        if (MethodsUtil.isNull(login)) return  false;
       
        UserService userService = new UserService();
        currentUser = userService.getByProperty("login", login);
        
        return true;
    }
}
