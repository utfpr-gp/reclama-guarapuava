/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.State;
import br.edu.utfpr.model.dao.StateDAO;

/**
 *
 * @author felipe
 */
public class StateService extends AbstractService<Long, State>{

    public StateService() {
        dao = new StateDAO();
    }
    
}
