/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.UserRole;
import br.edu.utfpr.model.dao.UserRoleDAO;

/**
 *
 * @author cabrito
 */
public class UserRoleService extends AbstractService<Long, UserRole> {

    public UserRoleService() {
        dao = new UserRoleDAO();
    }

}
