/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.Status;
import br.edu.utfpr.model.dao.StatusDAO;

/**
 *
 * @author felipe
 */
public class StatusService extends AbstractService<Long, Status>{

    public StatusService() {
        dao = new StatusDAO();
    }
    
}
