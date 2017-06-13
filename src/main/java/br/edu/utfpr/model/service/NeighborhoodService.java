/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.Neighborhood;
import br.edu.utfpr.model.dao.NeighborhoodDAO;

/**
 *
 * @author felipe
 */
public class NeighborhoodService extends AbstractService<Long, Neighborhood>{

    public NeighborhoodService() {
        dao = new NeighborhoodDAO();
    }
    
}
